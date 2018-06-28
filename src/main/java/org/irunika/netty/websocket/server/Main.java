package org.irunika.netty.websocket.server;

/**
 * Main class to run the server.
 */
public class Main {

    public static void main(String[] args) {
        String host = "0.0.0.0";
        int port = 9090;
        String subProtocols = null;

        if (args.length >= 3) {
            port = getPort(args);
            host = getHost(args);
            subProtocols = getSubProtocols(args);
        } else if (args.length == 2) {
            port = getPort(args);
            host = getHost(args);
        } else if (args.length == 1) {
            port = getPort(args);
        }

        WebSocketServer webSocketServer = new WebSocketServer(host, port, subProtocols);
        try {
            webSocketServer.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getSubProtocols(String[] args) {
        String subProtocols;
        subProtocols = "";
        for (int i = 2; i < args.length; i++) {
            subProtocols = subProtocols.concat(args[i] + ",");
        }
        subProtocols = subProtocols.substring(0, subProtocols.length() - 1);
        return subProtocols;
    }

    private static int getPort(String[] args) {
        return Integer.parseInt(args[0]);
    }

    private static String getHost(String[] args) {
        return args[1];
    }
}
