package com.sparrowwallet.sparrow.mweb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MwebServer {
    public static int start(String chain, Path dataDir) {
        try {
            Files.createDirectories(dataDir);
        } catch (IOException e) {
            return 0;
        }
        return MwebLibrary.INSTANCE.start(chain, dataDir.toString(), "");
    }
}
