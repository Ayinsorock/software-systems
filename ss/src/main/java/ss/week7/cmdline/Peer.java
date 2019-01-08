package ss.week7.cmdline;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException
    {
        this.name = nameArg;
        this.sock = sockArg;

        this.in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(this.sock.getOutputStream()));
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
        String line;
        try {
            while ((line = this.in.readLine()) != null) {
                if (line.equals(EXIT)) {
                    shutDown();
                }

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
        while (true) {
            String message = readString("*: ");

            // no message received
            if (message == null) {
                return;
            }

            // exit command received
            if (message.equals(EXIT)) {
                shutDown();
                return;
            }

            // default
            try {
                this.out.write(message + "\n");
                this.out.flush();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
