package com.sparrowwallet.sparrow.mweb;

import com.google.common.eventbus.Subscribe;
import com.sparrowwallet.drongo.Network;
import com.sparrowwallet.sparrow.AppServices;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.ConnectionEvent;
import com.sparrowwallet.sparrow.event.DisconnectionEvent;
import com.sparrowwallet.sparrow.io.Storage;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.net.Proxy;
import java.nio.file.Files;

public class MwebServer {
    public RpcGrpc.RpcBlockingStub stub;
    public RpcGrpc.RpcStub stubAsync;
    private int port;
    private MwebStatusChecker statusChecker;

    private static MwebServer INSTANCE;

    public static void initialize() {
        INSTANCE = new MwebServer();
    }

    public static MwebServer get() {
        return INSTANCE;
    }

    private MwebServer() {
        EventManager.get().register(this);
    }

    private void start() {
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
        port = MwebLibrary.INSTANCE.start(chain, dataDir.toString(), proxyUrl);
        var channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        stub = RpcGrpc.newBlockingStub(channel);
        stubAsync = RpcGrpc.newStub(channel);
        statusChecker = new MwebStatusChecker(stub);
    }

    private void stop() {
        statusChecker.stop();
        MwebLibrary.INSTANCE.stop(port);
    }

    @Subscribe
    public void connection(ConnectionEvent event) {
        start();
    }

    @Subscribe
    public void disconnection(DisconnectionEvent event) {
        stop();
    }
}
