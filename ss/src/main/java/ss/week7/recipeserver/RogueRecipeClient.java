package ss.week7.recipeserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A client for a sloppily programmed recipe server.
 *
 */
public class RogueRecipeClient {
    private static final String USAGE = "usage: <address> <port>";

    private static final String IP_ADDRESS_FIXED_KARIG = "127.0.0.1";
    private static final int PORT_FIXED_KARIG = 3000;

    /**
     * @param args
     */
    public static void main(String[] args) {


        InetAddress addr = null;
        int port = PORT_FIXED_KARIG;
        Socket sock = null;

        // check args[1] - the IP-adress
        try {
            addr = InetAddress.getByName(IP_ADDRESS_FIXED_KARIG);
        } catch (UnknownHostException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: host " + args[0] + " unknown");
            System.exit(0);
        }

        // try to open a Socket to the server
        try {
            sock = new Socket(addr, port);
        } catch (IOException e) {
            System.out.println("ERROR: could not create a socket on " + addr
                    + " and port " + port);
        }

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

            String file =  "";
            Scanner userIn = new Scanner(System.in);

            do {
                System.out.println("What file would you like?:");

                if (userIn.hasNextLine()) {
                    file = userIn.nextLine();
                } else {
                    System.out.println("Invalid input, try again.");
                    userIn.next();
                }
                if (file != "") {
                    out.write("GET " + file);
                    out.newLine();
                    out.flush();
                    System.out.println("File: ");

                    String line;
                    line = in.readLine();
                    while (line != null && !line.equals("--EOT--")) {
                        System.out.println(line);
                        line = in.readLine();
                    }
                } else {
                    System.out.println("Invalid recipe number, try again.");
                }
            } while (file != "exit");
            System.out.println("Exiting.");
            userIn.close();
        } catch (IOException e) {
            System.out.println("ERROR: unable to communicate to server");
            e.printStackTrace();
        }
    }

    private static void command (BufferedWriter out, String command) throws IOException {
        out.write(command);
        out.newLine();
        out.flush();
    }
}
