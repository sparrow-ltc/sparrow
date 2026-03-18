package com.sparrowwallet.sparrow.mweb;

import com.google.protobuf.ByteString;
import com.sparrowwallet.drongo.KeyPurpose;
import com.sparrowwallet.drongo.crypto.ECKey;
import com.sparrowwallet.drongo.protocol.*;
import com.sparrowwallet.drongo.wallet.*;
import com.sparrowwallet.sparrow.mweb.proto.CreateRequest;

import java.util.List;
import java.util.Map;

public class MwebFeeEstimator implements FeeEstimator {
    @Override
    public long calcFeeIncrease(Wallet wallet, Map<BlockTransactionHashIndex, WalletNode> selectedUtxos,
                                List<WalletTransaction.Output> outputs, double feeRate) {
        if (wallet.getScriptType() != ScriptType.MWEB) return 0;
        ECKey scanKey = wallet.getKeystores().getFirst().getMwebScanPrivateKey();
        Transaction tx = new Transaction();
        for (var entry : selectedUtxos.entrySet()) {
            var prevTx = wallet.getWalletTransaction(entry.getKey().getHash()).getTransaction();
            int index = prevTx.getOutputs().stream()
                    .filter(out -> ScriptType.MWEB.isScriptType(out.getScript()))
                    .toList().indexOf(prevTx.getOutputs().get((int)entry.getKey().getIndex()));
            int addressIndex = 0;
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
        var resp = MwebServer.get().stub.create(CreateRequest.newBuilder()
                .setRawTx(ByteString.copyFrom(tx.bitcoinSerialize()))
                .setScanSecret(ByteString.copyFrom(scanKey.getPrivKeyBytes()))
                .setSpendSecret(ByteString.copyFrom(new byte[32]))
                .setFeeRatePerKb((long)Math.ceil(feeRate * 1000))
                .setDryRun(true)
                .build());
        var tx2 = new Transaction(resp.getRawTx().toByteArray());
        long sumIn1 = selectedUtxos.keySet().stream().mapToLong(BlockTransactionHashIndex::getValue).sum();
        long sumIn2 = tx2.getInputs().stream().mapToLong(in ->
                wallet.getWalletTransaction(in.getOutpoint().getHash()).getTransaction()
                        .getOutputs().get((int)in.getOutpoint().getIndex()).getValue()).sum();
        long sumOut1 = tx.getOutputs().stream().mapToLong(TransactionOutput::getValue).sum();
        long sumOut2 = tx2.getOutputs().stream().mapToLong(TransactionOutput::getValue).sum();
        long mwebIn = sumIn1 - sumIn2;
        long expectedPegIn = Math.max(0, sumOut1 - mwebIn);
        long feeIncrease = sumOut2 - expectedPegIn;
        if (expectedPegIn > 0) {
            feeIncrease += (long)Math.ceil(feeRate * 41);
        }
        return feeIncrease;
    }
}
