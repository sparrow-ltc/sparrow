package com.sparrowwallet.sparrow.mweb;

import com.sparrowwallet.drongo.Network;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.io.Storage;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.net.Proxy;
import java.nio.file.Files;

public class MwebServer {
    public static RpcGrpc.RpcBlockingStub stub;
    public static RpcGrpc.RpcStub stubAsync;

    public static void start() {
        var chain = Network.get().getName();
        var dataDir = Storage.getSparrowDir().toPath().resolve("mweb");
        try {
            Files.createDirectories(dataDir);
        } catch (IOException _) {
        }
        var proxyUrl = "";
        var proxy = AppServices.getProxy();
        if (proxy != null && proxy.type() == Proxy.Type.SOCKS) {
            proxyUrl = "socks5:/" + proxy.address().toString();
        }
        int port = MwebLibrary.INSTANCE.start(chain, dataDir.toString(), proxyUrl);
        var channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        stub = RpcGrpc.newBlockingStub(channel);
        stubAsync = RpcGrpc.newStub(channel);
    }
}
