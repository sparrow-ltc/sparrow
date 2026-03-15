package com.sparrowwallet.sparrow.mweb;

import com.sparrowwallet.drongo.Network;
import com.sparrowwallet.sparrow.EventManager;
import com.sparrowwallet.sparrow.event.StatusEvent;
import com.sparrowwallet.sparrow.mweb.proto.RpcGrpc;
import com.sparrowwallet.sparrow.mweb.proto.StatusRequest;
import com.sparrowwallet.sparrow.mweb.proto.StatusResponse;
import javafx.application.Platform;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.round;

public class MwebStatusChecker {
    private final ScheduledExecutorService exec;
    private StatusResponse prevStatus;

    public MwebStatusChecker(RpcGrpc.RpcBlockingStub stub) {
        exec = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        exec.scheduleAtFixedRate(() -> {
            var status = stub.status(StatusRequest.newBuilder().build());
            if (status.equals(prevStatus)) return;
            prevStatus = status;

            String text = "";
            try {
                var height = Double.parseDouble(System.getProperty(Network.BLOCK_HEIGHT_PROPERTY));
                if (status.getBlockHeaderHeight() < height) {
                    var pct = round(status.getBlockHeaderHeight() * 100 / height);
                    text = "Synchronizing MWEB... (" + pct + "%)";
                } else if (status.getMwebHeaderHeight() < height) {
                    var pct = round(status.getMwebHeaderHeight() * 100 / height);
                    text = "Synchronizing MWEB... (" + pct + "%)";
                }
            } catch (Exception _) {
            }
            if (text.isEmpty()) return;
            var event = new StatusEvent(text);
            Platform.runLater(() -> EventManager.get().post(event));
        }, 0, 2, TimeUnit.SECONDS);
    }

    public void stop() throws InterruptedException {
        exec.shutdown();
        exec.awaitTermination(5, TimeUnit.SECONDS);
    }
}
