package com.sparrowwallet.sparrow.mweb;

import com.sparrowwallet.drongo.protocol.Script;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.protocol.TransactionOutput;
import com.sparrowwallet.drongo.wallet.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MwebFeeEstimator implements FeeEstimator {
    @Override
    public long calcFee(Wallet wallet, Map<BlockTransactionHashIndex, WalletNode> utxos,
                        List<WalletTransaction.Output> outputs, double feeRate) {
        var outputs2 = outputs.stream().collect(Collectors.partitioningBy(
                output -> output instanceof WalletTransaction.ChangeOutput change &&
                        change.getWalletNode().getAddress().getScriptType() != ScriptType.MWEB));
        var sum = utxos.keySet().stream().mapToLong(BlockTransactionHashIndex::getValue).sum();
        var outs = new ArrayList<TransactionOutput>();
        var sum2 = sum;
        for(var it = outputs2.get(false).iterator(); it.hasNext();) {
            var out = it.next().getTransactionOutput();
            var value = it.hasNext() ? out.getValue() : sum2;
            outs.add(new TransactionOutput(null, value, out.getScript()));
            sum2 -= value;
        }
        var tx = MwebServer.get().create(wallet, utxos, outs, feeRate, true);
        if(tx.getInputs().isEmpty()) sum = 0;
        var fee = tx.getOutputs().stream().mapToLong(TransactionOutput::getValue).sum() - sum;
        if(!tx.getInputs().isEmpty()) {
            if(fee > 0) {
                tx.setSegwitFlag(tx.getSegwitFlag() & ~8);
                tx.addInput(null, 0, new Script(List.of()));
            }
            outputs2.get(true).forEach(output -> {
                var out = output.getTransactionOutput();
                tx.addOutput(out.getValue(), out.getScript());
            });
            fee += (long)Math.ceil(feeRate * tx.getVirtualSize());
        }
        return fee;
    }
}
