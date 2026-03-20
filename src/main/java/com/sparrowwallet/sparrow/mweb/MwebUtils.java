package com.sparrowwallet.sparrow.mweb;

import com.sparrowwallet.drongo.KeyPurpose;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.protocol.Sha256Hash;
import com.sparrowwallet.drongo.protocol.TransactionOutput;
import com.sparrowwallet.drongo.wallet.BlockTransactionHashIndex;
import com.sparrowwallet.drongo.wallet.Wallet;
import com.sparrowwallet.drongo.wallet.WalletNode;

public class MwebUtils {
    public static Sha256Hash getOutputId(Wallet wallet, BlockTransactionHashIndex utxo) {
        var tx = wallet.getWalletTransaction(utxo.getHash()).getTransaction();
        var txOut = tx.getOutputs().get((int)utxo.getIndex());
        var mwOuts = tx.getOutputs().stream().filter(out ->
                ScriptType.MWEB.isScriptType(out.getScript())).toList();
        return tx.getMwebOutputId(mwOuts.indexOf(txOut));
    }

    public static int getAddressIndex(WalletNode node) {
        if (node.getKeyPurpose() == KeyPurpose.CHANGE) return 0;
        return node.getDerivation().getLast().i() + 1;
    }

    public static TransactionOutput adjustScript(TransactionOutput out) {
        if (!ScriptType.MWEB.isScriptType(out.getScript())) return out;
        var pubKeys = ScriptType.MWEB.getHashFromScript(out.getScript());
        return new TransactionOutput(null, out.getValue(), pubKeys);
    }
}
