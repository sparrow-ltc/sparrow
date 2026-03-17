package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.google.protobuf.ByteString;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.wallet.Keystore;
import com.sparrowwallet.drongo.wallet.Wallet;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.WalletOpenedEvent;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import com.sparrowwallet.sparrow.mweb.proto.Utxo;
import com.sparrowwallet.sparrow.mweb.proto.UtxosRequest;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
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
        for (var ctx : wallets.values()) {
            ctx.cancel(null);
        }
    }

    @Subscribe
    public void walletOpened(WalletOpenedEvent walletOpenedEvent) {
        addWallet(walletOpenedEvent.getWallet());
    }

    public void walletClosed(Wallet wallet) {
        var ctx = wallets.remove(wallet);
        if (ctx != null) ctx.cancel(null);
    }

    private void addWallet(Wallet wallet) {
        if (wallets.containsKey(wallet)) return;
        if (wallet.getScriptType() != ScriptType.MWEB) return;
        wallets.put(wallet, startStream(wallet));
    }

    private Context.CancellableContext startStream(Wallet wallet) {
        Keystore keystore = wallet.getKeystores().getFirst();
        UtxosRequest request = UtxosRequest.newBuilder()
                .setScanSecret(ByteString.copyFrom(keystore.getMwebScanPrivateKey().getPrivKeyBytes()))
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
