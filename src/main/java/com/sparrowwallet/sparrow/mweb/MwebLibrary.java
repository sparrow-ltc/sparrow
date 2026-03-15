package com.sparrowwallet.sparrow.mweb;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface MwebLibrary extends Library {
    MwebLibrary INSTANCE = Native.load("mweb", MwebLibrary.class);

    int start(String chain, String dataDir, String proxy);
    void stop(int port);
}
