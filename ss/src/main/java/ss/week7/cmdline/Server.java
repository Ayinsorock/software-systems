
package ss.week7.cmdline;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }

        // Get the server name
        String serverName = args[0];
        int port = 0;

        // Get the port
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[1]
                    + " is not an integer");
            System.exit(0);
        }

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Listening on port: " + port);
            Socket clientSocket = serverSocket.accept();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("Client connected");
            outputStream.write("Hello client, nice to meet you \n");
            outputStream.flush();

            String message;

            while ((message = inputStream.readLine()) != null) {
                System.out.println("Message received: " + message);

                outputStream.write("Message received. Supermooi.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

} // end of class Server
