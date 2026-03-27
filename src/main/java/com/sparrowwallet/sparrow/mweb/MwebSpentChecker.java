package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.wallet.BlockTransaction;
import com.sparrowwallet.drongo.wallet.Wallet;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.OpenWalletsEvent;
import com.sparrowwallet.sparrow.io.Storage;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import com.sparrowwallet.sparrow.mweb.proto.SpentRequest;
import javafx.application.Platform;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MwebSpentChecker {
    private final RpcGrpc.RpcBlockingStub stub;
    private final Map<Wallet, ScheduledExecutorService> wallets = new HashMap<>();

    public MwebSpentChecker(RpcGrpc.RpcBlockingStub stub) {
        this.stub = stub;
        for (var entry : AppServices.get().getOpenWallets().entrySet()) {
            addWallet(entry.getKey(), entry.getValue());
        }
        EventManager.get().register(this);
    }

    public void stop() {
        EventManager.get().unregister(this);
        for (var exec : wallets.values()) {
            stopChecker(exec);
        }
    }

    @Subscribe
    public void openWallets(OpenWalletsEvent event) {
        var openWallets = event.getWalletsMap();
        var iterator = wallets.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (!openWallets.containsKey(entry.getKey())) {
                stopChecker(entry.getValue());
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
        wallets.put(wallet, startChecker(wallet, storage));
    }

    private ScheduledExecutorService startChecker(Wallet wallet, Storage storage) {
        var exec = Executors.newSingleThreadScheduledExecutor(r -> {
            var t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        exec.scheduleAtFixedRate(() -> check(wallet, storage), 0, 10, TimeUnit.SECONDS);
        return exec;
    }

    private void stopChecker(ScheduledExecutorService exec) {
        try {
            exec.shutdown();
            exec.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException _) {
        }
    }

    private void check(Wallet wallet, Storage storage) {
        Platform.runLater(() -> {
            for (var txn : wallet.getWalletTransactions().values()) {
                if (txn.getHeight() > 0) continue;
                var builder = SpentRequest.newBuilder();
                for (var in : txn.getTransaction().getInputs()) {
                    builder.addOutputId(wallet.getWalletTransaction(in.getOutpoint().getHash()).getTransaction()
                            .getOutputs().get((int)in.getOutpoint().getIndex()).getMwebOutputId().toString());
                }
                var resp = stub.spent(builder.build());
                if (resp.getOutputIdCount() == txn.getTransaction().getInputs().size()) {
                    txn = new BlockTransaction(txn.getHash(), wallet.getStoredBlockHeight(),
                            new Date(), txn.getFee(), txn.getTransaction(), null, txn.getLabel());
                    wallet.updateTransactions(Map.of(txn.getHash(), txn));
                }
            }
        });
    }
}
