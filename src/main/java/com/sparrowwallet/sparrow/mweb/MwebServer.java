package com.sparrowwallet.sparrow.mweb;

import com.sparrowwallet.drongo.Network;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.io.Storage;

import java.io.IOException;
import java.net.Proxy;
import java.nio.file.Files;

public class MwebServer {
    public static int start() {
        var chain = Network.get().getName();
        var dataDir = Storage.getSparrowDir().toPath().resolve("mweb");
        try {
            Files.createDirectories(dataDir);
        } catch (IOException e) {
            return 0;
        }
        var proxyUrl = "";
        var proxy = AppServices.getProxy();
        if (proxy != null && proxy.type() == Proxy.Type.SOCKS) {
            proxyUrl = "socks5:/" + proxy.address().toString();
        }
        return MwebLibrary.INSTANCE.start(chain, dataDir.toString(), proxyUrl);
    }
}
