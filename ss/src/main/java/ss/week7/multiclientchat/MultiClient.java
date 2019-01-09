package ss.week7.multiclientchat;

import ss.week7.cmdline.Peer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * MultiClient class for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class MultiClient {
    public static String name = "Client_";
    public static String host =  "127.0.0.1";
    public static int port = 3000;

    /** Starts a MultiClient application. */
    public static void main(String[] args) {
        InetAddress addr = null;
        Socket sock = null;

        // check args[1] - the IP-adress
        try {
            addr = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            System.out.println("ERROR: host " + args[1] + " unknown");
            System.exit(0);
        }

        // try to open a Socket to the server
        try {
            sock = new Socket(addr, port);
        } catch (IOException e) {
            System.out.println("ERROR: could not create a socket on " + addr
                    + " and port " + port);
        }

        // create Peer object and start the two-way communication
        try {
            Peer client = new Peer(name, sock);
            Thread streamInputHandler = new Thread(client);
            streamInputHandler.start();
            client.handleTerminalInput();
            client.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} // end of class MultiClient
