package com.sparrowwallet.sparrow.io;

import com.google.common.io.CharStreams;
import com.sparrowwallet.drongo.ExtendedKey;
import com.sparrowwallet.drongo.KeyDerivation;
import com.sparrowwallet.drongo.Utils;
import com.sparrowwallet.drongo.crypto.ECKey;
import com.sparrowwallet.drongo.protocol.ScriptType;
import com.sparrowwallet.drongo.uri.BitcoinURI;
import com.sparrowwallet.drongo.uri.BitcoinURIParseException;
import com.sparrowwallet.drongo.wallet.Keystore;
import com.sparrowwallet.drongo.wallet.KeystoreSource;
import com.sparrowwallet.drongo.wallet.WalletModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Cupcake extends SpecterDIY {
    @Override
    public Keystore getKeystore(ScriptType scriptType, InputStream inputStream, String password) throws ImportException {
        try {
            var uri = new BitcoinURI(CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
            var label = (String)uri.getParameterByName("label");
            if(label.length() > Keystore.MAX_LABEL_LENGTH) {
                label = label.substring(0, Keystore.MAX_LABEL_LENGTH);
            }
            var keystore = new Keystore(label);
            keystore.setExtendedPublicKey(ExtendedKey.fromDescriptor((String)uri.getParameterByName("xpub")));
            keystore.setMwebScanPrivateKey(ECKey.fromPrivate(Utils.hexToBytes((String)uri.getParameterByName("scan_secret"))));
            keystore.setMwebSpendPublicKey(ECKey.fromPublicOnly(Utils.hexToBytes((String)uri.getParameterByName("spend_pubkey"))));
            keystore.setWalletModel(getWalletModel());
            keystore.setSource(KeystoreSource.HW_AIRGAPPED);
            keystore.setKeyDerivation(new KeyDerivation(KeyDerivation.DEFAULT_WATCH_ONLY_FINGERPRINT, scriptType.getDefaultDerivationPath()));
            return keystore;
        } catch(IOException | BitcoinURIParseException e) {
            throw new ImportException("Error getting " + getName() + " keystore", e);
        }
    }

    @Override
    public String getName() {
        return "Cupcake";
    }

    @Override
    public String getKeystoreImportDescription(int account) {
        return "Import QR created on the Cupcake app by selecting Link to Cake Wallet in the hamburger menu.";
    }

    @Override
    public WalletModel getWalletModel() {
        return WalletModel.CUPCAKE;
    }

    @Override
    public boolean isFileFormatAvailable() {
        return false;
    }
}
