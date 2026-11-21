package com.sparrowwallet.sparrow.mweb;

import com.sparrowwallet.drongo.protocol.Script;
import com.sparrowwallet.drongo.protocol.TransactionOutput;
import com.sparrowwallet.drongo.wallet.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MwebFeeEstimator implements FeeEstimator {
    @Override
    public long calcFee(Wallet wallet, Map<BlockTransactionHashIndex, WalletNode> utxos,
                        List<WalletTransaction.Output> outputs, double feeRate) {
        var sum = utxos.keySet().stream().mapToLong(BlockTransactionHashIndex::getValue).sum();
        var outs = new ArrayList<TransactionOutput>();
        var sum2 = sum;
        for(var it = outputs.iterator(); it.hasNext();) {
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
            fee += (long)Math.ceil(feeRate * tx.getVirtualSize());
        }
        return fee;
    }
}
