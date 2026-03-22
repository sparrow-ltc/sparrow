package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.google.protobuf.ByteString;
import com.sparrowwallet.drongo.address.Address;
import com.sparrowwallet.drongo.address.InvalidAddressException;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.protocol.Sha256Hash;
import com.sparrowwallet.drongo.protocol.Transaction;
import com.sparrowwallet.drongo.wallet.*;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.OpenWalletsEvent;
import com.sparrowwallet.sparrow.event.WalletHistoryChangedEvent;
import com.sparrowwallet.sparrow.event.WalletNodeHistoryChangedEvent;
import com.sparrowwallet.sparrow.io.Storage;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import com.sparrowwallet.sparrow.mweb.proto.Utxo;
import com.sparrowwallet.sparrow.mweb.proto.UtxosRequest;
import com.sparrowwallet.sparrow.net.ElectrumServer;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MwebStreamSupervisor {
    private static final Logger log = LoggerFactory.getLogger(MwebStreamSupervisor.class);

    private final RpcGrpc.RpcStub stub;
    private final Map<Wallet, Context.CancellableContext> wallets = new HashMap<>();

    public MwebStreamSupervisor(RpcGrpc.RpcStub stub) {
        this.stub = stub;
        for (var entry : AppServices.get().getOpenWallets().entrySet()) {
            addWallet(entry.getKey(), entry.getValue());
        }
        EventManager.get().register(this);
    }

    public void stop() {
        EventManager.get().unregister(this);
        for (var ctx : wallets.values()) {
            ctx.cancel(null);
        }
    }

    @Subscribe
    public void openWallets(OpenWalletsEvent event) {
        var openWallets = event.getWalletsMap();
        var iterator = wallets.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (!openWallets.containsKey(entry.getKey())) {
                entry.getValue().cancel(null);
                iterator.remove();
            }
        }
        for (var entry : openWallets.entrySet()) {
            addWallet(entry.getKey(), entry.getValue());
        }
    }

    private void addWallet(Wallet wallet, Storage storage) {
        if (wallets.containsKey(wallet)) return;
        if (wallet.getScriptType() != ScriptType.MWEB) return;
        wallets.put(wallet, startStream(wallet, storage));
    }

    private Context.CancellableContext startStream(Wallet wallet, Storage storage) {
        Keystore keystore = wallet.getKeystores().getFirst();
        int height = 0;
        for (var txn : wallet.getTransactions().values()) {
            height = Math.max(height, txn.getHeight());
        }
        UtxosRequest request = UtxosRequest.newBuilder()
                .setScanSecret(ByteString.copyFrom(keystore.getMwebScanPrivateKey().getPrivKeyBytes()))
                .setFromHeight(Math.max(0, height - 100))
                .build();

        var context = Context.current().withCancellation();
        context.run(() -> stub.utxos(request, new StreamObserver<>() {
            private WalletNode getAddressNode(Address address) {
                for (var purposeNode : wallet.getPurposeNodes()) {
                    for (var node : purposeNode.getChildren()) {
                        if (node.getAddress().equals(address)) {
                            return node;
                        }
                    }
                }
                return null;
            }

            @Override
            public void onNext(Utxo utxo) {
                Address address;
                try {
                    address = Address.fromString(utxo.getAddress());
                } catch (InvalidAddressException _) {
                    return;
                }
                var tx = new Transaction();
                tx.addOutput(utxo.getValue(), address);
                tx.addMwebOutputId(Sha256Hash.wrap(utxo.getOutputId()));
                tx.setMwebTxId(Sha256Hash.wrap(utxo.getOutputId()));
                var txn = new BlockTransaction(tx.getTxId(), utxo.getHeight(), new Date(utxo.getBlockTime() * 1000L), 0L, tx);
                Platform.runLater(() -> {
                    var node = getAddressNode(address);
                    if (node == null) return;
                    var txos = new TreeSet<>(node.getTransactionOutputs());
                    txos.removeIf(txo -> txo.getHash().equals(txn.getHash()));
                    txos.add(new BlockTransactionHashIndex(txn.getHash(), txn.getHeight(), txn.getDate(), txn.getFee(), 0, utxo.getValue()));
                    node.updateTransactionOutputs(wallet, txos);
                    wallet.updateTransactions(Map.of(txn.getHash(), txn));
                    EventManager.get().post(new WalletHistoryChangedEvent(wallet, storage, List.of(node), List.of()));
                    EventManager.get().post(new WalletNodeHistoryChangedEvent(ElectrumServer.getScriptHash(node)));
                });
            }

            @Override
            public void onError(Throwable t) {
                Status status = Status.fromThrowable(t);
                if (status.getCode() != Status.Code.CANCELLED) {
                    log.error(status.toString());
                }
            }

            @Override
            public void onCompleted() {
            }
        }));

        return context;
    }
}
