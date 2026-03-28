package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.sparrowwallet.drongo.protocol.Script;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.protocol.Sha256Hash;
import com.sparrowwallet.drongo.protocol.Transaction;
import com.sparrowwallet.drongo.wallet.BlockTransaction;
import com.sparrowwallet.drongo.wallet.BlockTransactionHashIndex;
import com.sparrowwallet.drongo.wallet.Wallet;
import com.sparrowwallet.drongo.wallet.WalletNode;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.OpenWalletsEvent;
import com.sparrowwallet.sparrow.event.WalletDataChangedEvent;
import com.sparrowwallet.sparrow.event.WalletHistoryChangedEvent;
import com.sparrowwallet.sparrow.io.Storage;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import com.sparrowwallet.sparrow.mweb.proto.SpentRequest;
import javafx.application.Platform;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
        exec.scheduleAtFixedRate(() -> checkTxns(wallet, storage), 0, 5, TimeUnit.SECONDS);
        exec.scheduleAtFixedRate(() -> checkUtxos(wallet, storage), 0, 10, TimeUnit.SECONDS);
        return exec;
    }

    private void stopChecker(ScheduledExecutorService exec) {
        try {
            exec.shutdown();
            exec.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException _) {
        }
    }

    private void checkTxns(Wallet wallet, Storage storage) {
        Platform.runLater(() -> {
            var walletTxns = wallet.getWalletTransactions();
            var updatedTxns = new HashMap<Sha256Hash, BlockTransaction>();
            outer:
            for (var txn : walletTxns.values()) {
                if (txn.getHeight() > 0 || txn.getTransaction().getInputs().isEmpty()) continue;
                var builder = SpentRequest.newBuilder();
                for (var in : txn.getTransaction().getInputs()) {
                    var txn2 = walletTxns.get(in.getOutpoint().getHash());
                    if (txn2.getHeight() == 0) continue outer;
                    builder.addOutputId(txn2.getTransaction().getOutputs()
                            .get((int)in.getOutpoint().getIndex()).getMwebOutputId().toString());
                }
                var resp = stub.spent(builder.build());
                if (resp.getOutputIdCount() == txn.getTransaction().getInputs().size()) {
                    txn = new BlockTransaction(txn.getHash(), wallet.getStoredBlockHeight(),
                            new Date(), txn.getFee(), txn.getTransaction(), null, txn.getLabel());
                    updatedTxns.put(txn.getHash(), txn);
                }
            }
            if (!updatedTxns.isEmpty()) {
                var nodes = new ArrayList<WalletNode>();
                for (var entry : wallet.getWalletTxos().entrySet()) {
                    if (updatedTxns.containsKey(entry.getKey().getHash())) {
                        nodes.add(entry.getValue());
                    }
                }
                wallet.updateTransactions(updatedTxns);
                EventManager.get().post(new WalletHistoryChangedEvent(wallet, storage, nodes, List.of()));
                EventManager.get().post(new WalletDataChangedEvent(wallet));
            }
        });
    }

    private void checkUtxos(Wallet wallet, Storage storage) {
        Platform.runLater(() -> {
            var utxos = wallet.getWalletUtxos();
            var outputIds = new HashMap<String, BlockTransactionHashIndex>();
            for (var entry : utxos.entrySet()) {
                var txn = wallet.getWalletTransaction(entry.getKey().getHash());
                if (txn.getHeight() == 0) continue;
                var out = txn.getTransaction().getOutputs().get((int)entry.getKey().getIndex());
                outputIds.put(out.getMwebOutputId().toString(), entry.getKey());
            }
            var resp = stub.spent(SpentRequest.newBuilder().addAllOutputId(outputIds.keySet()).build());
            var spentTxos = resp.getOutputIdList().stream().map(outputIds::get).map(BlockTransactionHashIndex::copy).toList();
            if (spentTxos.isEmpty()) return;
            var nodes = spentTxos.stream().collect(Collectors.toMap(utxos::get,
                    txo -> utxos.get(txo).getTransactionOutputs(), (v, _) -> v));
            nodes.replaceAll((_, v) -> new TreeSet<>(v));
            var tx = new Transaction();
            for (var txo : spentTxos) {
                tx.addInput(txo.getHash(), txo.getIndex(), new Script(List.of()));
            }
            var txn = new BlockTransaction(tx.getTxId(), wallet.getStoredBlockHeight(), new Date(), 0L, tx);
            for (int i = 0; i < spentTxos.size(); i++) {
                var txo = spentTxos.get(i);
                var txos = nodes.get(utxos.get(txo));
                txos.remove(txo);
                txo.setId(null);
                txo.setSpentBy(new BlockTransactionHashIndex(txn.getHash(), txn.getHeight(), txn.getDate(), 0L, i, txo.getValue()));
                txos.add(txo);
            }
            nodes.forEach((node, txos) -> node.updateTransactionOutputs(wallet, txos));
            wallet.updateTransactions(Map.of(txn.getHash(), txn));
            EventManager.get().post(new WalletHistoryChangedEvent(wallet, storage, nodes.keySet().stream().toList(), List.of()));
            EventManager.get().post(new WalletDataChangedEvent(wallet));
        });
    }
}
