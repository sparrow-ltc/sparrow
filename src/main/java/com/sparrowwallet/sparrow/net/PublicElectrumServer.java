package com.sparrowwallet.sparrow.net;

import com.google.common.net.HostAndPort;
import com.sparrowwallet.drongo.Network;
import com.sparrowwallet.sparrow.io.Server;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PublicElectrumServer {
    ELECTRUM_LTC_ORG("backup.electrum-ltc.org", "ssl://backup.electrum-ltc.org:443", Network.MAINNET),
    BYSH_ME("electrum-ltc.bysh.me", "ssl://electrum-ltc.bysh.me:50002", Network.MAINNET),
    XURIOUS_COM("electrum.ltc.xurious.com", "ssl://electrum.ltc.xurious.com:50002", Network.MAINNET),
    PRIVATESERVERS_NETWORK("electrum.privateservers.network", "ssl://electrum.privateservers.network:50005", Network.MAINNET),
    CIPIG_NET("electrum1.cipig.net", "ssl://electrum1.cipig.net:20063", Network.MAINNET),
    RENTONISK_COM("ltc.rentonisk.com", "ssl://ltc.rentonisk.com:50002", Network.MAINNET),
    TESTNET_BYSH_ME("electrum-ltc.bysh.me", "ssl://electrum-ltc.bysh.me:51002", Network.TESTNET),
    TESTNET_XURIOUS_COM("electrum.ltc.xurious.com", "ssl://electrum.ltc.xurious.com:51002", Network.TESTNET);

    PublicElectrumServer(String name, String url, Network network) {
        this.server = new Server(url, name);
        this.network = network;
    }

    public static final List<Network> SUPPORTED_NETWORKS = List.of(Network.MAINNET, Network.TESTNET, Network.SIGNET, Network.TESTNET4);

    private final Server server;
    private final Network network;

    public Server getServer() {
        return server;
    }

    public String getUrl() {
        return server.getUrl();
    }

    public Network getNetwork() {
        return network;
    }

    public static List<PublicElectrumServer> getServers() {
        return Arrays.stream(values()).filter(server -> server.network == Network.get()).collect(Collectors.toList());
    }

    public static boolean supportedNetwork() {
        return SUPPORTED_NETWORKS.contains(Network.get());
    }

    public static PublicElectrumServer fromServer(Server server) {
        for(PublicElectrumServer publicServer : values()) {
            if(publicServer.getServer().equals(server)) {
                return publicServer;
            }
        }

        return null;
    }

    public static boolean isPublicServer(HostAndPort hostAndPort) {
        for(PublicElectrumServer publicServer : values()) {
            if(publicServer.getServer().getHostAndPort().equals(hostAndPort)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return server.getAlias();
    }
}
