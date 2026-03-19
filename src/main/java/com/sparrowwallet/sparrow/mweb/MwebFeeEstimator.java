package com.sparrowwallet.sparrow.mweb;

import com.sparrowwallet.drongo.protocol.TransactionInput;
import com.sparrowwallet.drongo.protocol.TransactionOutPoint;
import com.sparrowwallet.drongo.protocol.TransactionOutput;
import com.sparrowwallet.drongo.wallet.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MwebFeeEstimator implements FeeEstimator {
    @Override
    public long calcFeeIncrease(Wallet wallet, Map<BlockTransactionHashIndex, WalletNode> utxos,
                                List<WalletTransaction.Output> outputs, double feeRate) {
        var tx = MwebServer.get().create(wallet, utxos, outputs, feeRate, true);
        var ins = tx.getInputs().stream().map(TransactionInput::getOutpoint).collect(Collectors.toSet());
        long sumIn = 0, mwebIn = 0;
        for (var utxo : utxos.keySet()) {
            if (ins.contains(new TransactionOutPoint(utxo.getHash(), utxo.getIndex()))) {
                sumIn += utxo.getValue();
            } else {
                mwebIn += utxo.getValue();
            }
        }
        long sumOut1 = outputs.stream().mapToLong(out -> out.getTransactionOutput().getValue()).sum();
        long sumOut2 = tx.getOutputs().stream().mapToLong(TransactionOutput::getValue).sum();
        long expectedPegIn = Math.max(0, sumOut1 - mwebIn);
        long feeIncrease = sumOut2 - expectedPegIn;
        if (expectedPegIn > 0) {
            feeIncrease += (long)Math.ceil(feeRate * 41);
        }
        return sumIn < sumOut2 ? feeIncrease : 0;
    }
}
