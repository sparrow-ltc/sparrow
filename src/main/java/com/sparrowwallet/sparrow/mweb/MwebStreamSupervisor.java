package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.google.protobuf.ByteString;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.wallet.Keystore;
import com.sparrowwallet.drongo.wallet.Wallet;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.OpenWalletsEvent;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import com.sparrowwallet.sparrow.mweb.proto.Utxo;
import com.sparrowwallet.sparrow.mweb.proto.UtxosRequest;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MwebStreamSupervisor {
    private static final Logger log = LoggerFactory.getLogger(MwebStreamSupervisor.class);

    private final RpcGrpc.RpcStub stub;
    private final Map<Wallet, Context.CancellableContext> wallets = new HashMap<>();

    public MwebStreamSupervisor(RpcGrpc.RpcStub stub) {
        this.stub = stub;
        for (var wallet : AppServices.get().getOpenWallets().keySet()) {
            addWallet(wallet);
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
        var openWallets = new HashSet<>(event.getWallets());
        var iterator = wallets.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (!openWallets.contains(entry.getKey())) {
                entry.getValue().cancel(null);
                iterator.remove();
            }
        }
        for (var wallet : openWallets) {
            addWallet(wallet);
        }
    }

    private void addWallet(Wallet wallet) {
        if (wallets.containsKey(wallet)) return;
        if (wallet.getScriptType() != ScriptType.MWEB) return;
        wallets.put(wallet, startStream(wallet));
    }

    private Context.CancellableContext startStream(Wallet wallet) {
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
            @Override
            public void onNext(Utxo utxo) {
                System.out.println(utxo);
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
