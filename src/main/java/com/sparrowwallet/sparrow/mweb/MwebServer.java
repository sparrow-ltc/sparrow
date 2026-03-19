package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.google.protobuf.ByteString;
import com.sparrowwallet.drongo.KeyPurpose;
import com.sparrowwallet.drongo.Network;
import com.sparrowwallet.drongo.protocol.*;
import com.sparrowwallet.drongo.wallet.BlockTransactionHashIndex;
import com.sparrowwallet.drongo.wallet.Wallet;
import com.sparrowwallet.drongo.wallet.WalletNode;
import com.sparrowwallet.drongo.wallet.WalletTransaction;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.ConnectionEvent;
import com.sparrowwallet.sparrow.event.DisconnectionEvent;
import com.sparrowwallet.sparrow.io.Storage;
import com.sparrowwallet.sparrow.mweb.proto.CreateRequest;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.net.Proxy;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class MwebServer {
    public RpcGrpc.RpcBlockingStub stub;
    public RpcGrpc.RpcStub stubAsync;
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
        var channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
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
            var utxo = entry.getKey();
            if (wallet.getScriptType() != ScriptType.MWEB) {
                tx.addInput(utxo.getHash(), utxo.getIndex(), new Script(List.of()));
                continue;
            }
            var prevTx = wallet.getWalletTransaction(utxo.getHash()).getTransaction();
            var prevTxOut = prevTx.getOutputs().get((int)utxo.getIndex());
            var mwebOutputs = prevTx.getOutputs().stream().filter(out ->
                    ScriptType.MWEB.isScriptType(out.getScript())).toList();
            int index = mwebOutputs.indexOf(prevTxOut), addressIndex = 0;
            if (entry.getValue().getKeyPurpose() == KeyPurpose.RECEIVE) {
                addressIndex = entry.getValue().getDerivation().getLast().i() + 1;
            }
            tx.addInput(prevTx.getMwebOutputId(index), addressIndex, new Script(List.of()));
        }
        for (var output : outputs) {
            var out = output.getTransactionOutput();
            if (ScriptType.MWEB.isScriptType(out.getScript())) {
                var pubKeys = ScriptType.MWEB.getHashFromScript(out.getScript());
                out = new TransactionOutput(tx, out.getValue(), pubKeys);
            }
            tx.addOutput(out);
        }
        var keystore = wallet.getKeystores().getFirst();
        var resp = stub.create(CreateRequest.newBuilder()
                .setRawTx(ByteString.copyFrom(tx.bitcoinSerialize()))
                .setScanSecret(ByteString.copyFrom(keystore.getMwebScanPrivateKey().getPrivKeyBytes()))
                .setSpendSecret(ByteString.copyFrom(new byte[32]))
                .setFeeRatePerKb((long)Math.ceil(feeRate * 1000))
                .setDryRun(dryRun)
                .build());
        tx = new Transaction(resp.getRawTx().toByteArray());
        for (var outputId : resp.getOutputIdList()) {
            tx.addMwebOutputId(Sha256Hash.wrap(outputId));
        }
        return tx;
    }
}
