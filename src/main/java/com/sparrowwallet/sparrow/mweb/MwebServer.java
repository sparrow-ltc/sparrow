package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.google.protobuf.ByteString;
import com.sparrowwallet.drongo.Network;
import com.sparrowwallet.drongo.crypto.ChildNumber;
import com.sparrowwallet.drongo.protocol.*;
import com.sparrowwallet.drongo.psbt.PSBT;
import com.sparrowwallet.drongo.psbt.PSBTParseException;
import com.sparrowwallet.drongo.wallet.*;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.ConnectionEvent;
import com.sparrowwallet.sparrow.event.DisconnectionEvent;
import com.sparrowwallet.sparrow.io.Storage;
import com.sparrowwallet.sparrow.mweb.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.net.Proxy;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MwebServer {
    private ManagedChannel channel;
    private RpcGrpc.RpcBlockingStub stub;
    private RpcGrpc.RpcStub stubAsync;
    private int port;
    private MwebStatusChecker statusChecker;
    private MwebStreamSupervisor streamSupervisor;

    private static MwebServer INSTANCE;

    public static void initialize() {
        INSTANCE = new MwebServer();
    }

    public static MwebServer get() {
        return INSTANCE;
    }

    private MwebServer() {
        EventManager.get().register(this);
    }

    private void start() {
        var chain = Network.get().getName();
        var dataDir = Storage.getSparrowDir().toPath().resolve("mweb");
        try {
            Files.createDirectories(dataDir);
        } catch (IOException _) {
        }
        var proxyUrl = "";
        var proxy = AppServices.getProxy();
        if (proxy != null && proxy.type() == Proxy.Type.SOCKS) {
            proxyUrl = "socks5:/" + proxy.address().toString();
        }
        port = MwebLibrary.INSTANCE.start(chain, dataDir.toString(), proxyUrl);
        channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        stub = RpcGrpc.newBlockingStub(channel);
        stubAsync = RpcGrpc.newStub(channel);
        statusChecker = new MwebStatusChecker(stub);
        streamSupervisor = new MwebStreamSupervisor(stubAsync);
    }

    private void stop() {
        if (streamSupervisor != null) {
            streamSupervisor.stop();
            streamSupervisor = null;
        }
        if (statusChecker != null) {
            statusChecker.stop();
            statusChecker = null;
        }
        if (channel != null) {
            channel.shutdown();
            channel = null;
        }
        if (port != 0) {
            MwebLibrary.INSTANCE.stop(port);
            port = 0;
        }
    }

    @Subscribe
    public void connection(ConnectionEvent event) {
        start();
    }

    @Subscribe
    public void disconnection(DisconnectionEvent event) {
        stop();
    }

    public Transaction create(Wallet wallet, Map<BlockTransactionHashIndex, WalletNode> utxos,
                              List<WalletTransaction.Output> outputs, double feeRate, boolean dryRun) {
        var tx = new Transaction();
        for (var entry : utxos.entrySet()) {
            var hash = entry.getKey().getHash();
            var index = entry.getKey().getIndex();
            if (wallet.getScriptType() == ScriptType.MWEB) {
                hash = MwebUtils.getOutputId(wallet, entry.getKey());
                index = MwebUtils.getAddressIndex(entry.getValue());
            }
            tx.addInput(hash, index, new Script(List.of()));
        }
        outputs.forEach(out -> tx.addOutput(MwebUtils.adjustScript(out.getTransactionOutput())));
        var keystore = wallet.getKeystores().getFirst();
        var resp = stub.create(CreateRequest.newBuilder()
                .setRawTx(ByteString.copyFrom(tx.bitcoinSerialize()))
                .setScanSecret(ByteString.copyFrom(keystore.getMwebScanPrivateKey().getPrivKeyBytes()))
                .setSpendSecret(ByteString.copyFrom(new byte[32]))
                .setFeeRatePerKb((long)Math.ceil(feeRate * 1000))
                .setDryRun(dryRun)
                .build());
        var tx2 = new Transaction(resp.getRawTx().toByteArray());
        resp.getOutputIdList().forEach(outputId -> tx2.addMwebOutputId(Sha256Hash.wrap(outputId)));
        return tx2;
    }

    public PSBT psbtAddInputs(PSBT psbt, WalletTransaction transaction, double feeRate) {
        for (var entry : transaction.getSelectedUtxos().entrySet()) {
            var wallet = entry.getValue().getWallet();
            if (wallet.getScriptType() == ScriptType.MWEB) {
                var keystore = wallet.getKeystores().getFirst();
                var resp = stub.psbtAddInput(PsbtAddInputRequest.newBuilder()
                        .setPsbtB64(psbt.toBase64String())
                        .setScanSecret(ByteString.copyFrom(keystore.getMwebScanPrivateKey().getPrivKeyBytes()))
                        .setOutputId(MwebUtils.getOutputId(wallet, entry.getKey()).toString())
                        .setAddressIndex(MwebUtils.getAddressIndex(entry.getValue()))
                        .setFeeRatePerKb((long)Math.ceil(feeRate * 1000))
                        .build());
                try {
                    psbt = PSBT.fromString(resp.getPsbtB64());
                } catch (PSBTParseException _) {
                }
                var psbtInput = psbt.getPsbtInputs().getLast();
                psbtInput.setMwebMasterScanPubKey(keystore.getMwebScanPrivateKey());
                psbtInput.setMwebMasterScanKeyDerivation(keystore.getKeyDerivation().extend(new ChildNumber(0, true)));
            }
        }
        return psbt;
    }

    public PSBT psbtAddOutputs(PSBT psbt, WalletTransaction transaction, double feeRate) {
        var inputsAreMweb = transaction.getWallet().getScriptType() == ScriptType.MWEB;
        for (var output : transaction.getOutputs()) {
            var out = output.getTransactionOutput();
            var outputIsMweb = ScriptType.MWEB.isScriptType(out.getScript());
            if (!inputsAreMweb && !outputIsMweb) continue;
            var resp = stub.psbtAddRecipient(PsbtAddRecipientRequest.newBuilder()
                    .setPsbtB64(psbt.toBase64String())
                    .setRecipient(PsbtRecipient.newBuilder()
                            .setAddress(out.getScript().getToAddress().toString())
                            .setValue(out.getValue()))
                    .setFeeRatePerKb((long)Math.ceil(feeRate * 1000))
                    .build());
            try {
                psbt = PSBT.fromString(resp.getPsbtB64());
            } catch (PSBTParseException _) {
            }
        }
        return psbt;
    }

    public PSBT psbtAddIO(PSBT psbt, WalletTransaction transaction, double feeRate) {
        psbt = psbtAddInputs(psbt, transaction, feeRate);
        return psbtAddOutputs(psbt, transaction, feeRate);
    }

    public PSBT psbtSign(PSBT psbt, Keystore keystore) throws MnemonicException, PSBTParseException {
        var der = new ArrayList<>(keystore.getExtendedPrivateKey().getKey().getPath());
        der.add(new ChildNumber(1, true));
        var spendKey = keystore.getExtendedPrivateKey().getKey(der);
        var resp = stub.psbtSign(PsbtSignRequest.newBuilder()
                .setPsbtB64(psbt.toBase64String())
                .setScanSecret(ByteString.copyFrom(keystore.getMwebScanPrivateKey().getPrivKeyBytes()))
                .setSpendSecret(ByteString.copyFrom(spendKey.getPrivKeyBytes()))
                .build());
        var psbt2 = PSBT.fromString(resp.getPsbtB64());
        for (int i = 0; i < psbt.getInputCount(); i++) {
            var psbtInput = psbt.getPsbtInputs().get(i);
            if (psbtInput.isMweb()) {
                psbt2.getPsbtInputs().get(i).setMwebAmount(psbtInput.getMwebAmount());
            }
        }
        for (int i = 0; i < psbt.getOutputCount(); i++) {
            var psbtOutput = psbt.getPsbtOutputs().get(i);
            if (psbtOutput.isMweb()) {
                psbt2.getPsbtOutputs().get(i).setMwebStealthAddress(psbtOutput.getMwebStealthAddress());
            }
        }
        return psbt2;
    }

    public Transaction psbtExtract(PSBT psbt, Transaction tx) {
        var resp = stub.psbtExtract(PsbtExtractRequest.newBuilder()
                .setPsbtB64(psbt.toBase64String())
                .setUnsigned(tx == null)
                .build());
        var tx2 = new Transaction(resp.getRawTx().toByteArray());
        if(tx != null) {
            var txId = Sha256Hash.wrapReversed(psbt.getPsbtKernels().getFirst().getHash().getBytes());
            tx.setMwebTxId(txId);
            tx2.setMwebTxId(txId);
            resp.getOutputIdList().forEach(outputId -> tx.addMwebOutputId(Sha256Hash.wrap(outputId)));
        }
        return tx2;
    }

    public Sha256Hash broadcast(Transaction tx) {
        var resp = stub.broadcast(BroadcastRequest.newBuilder()
                .setRawTx(ByteString.copyFrom(tx.bitcoinSerialize(tx.isSegwit(), true)))
                .build());
        return Sha256Hash.wrap(resp.getTxid());
    }
}
