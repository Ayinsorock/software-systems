package ss.week7.multiclientchat;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread {
    private Server server;
    private Socket socket;
    private String username;
    private BufferedReader inStream;
    private BufferedWriter outStream;

    public ClientHandler (Server server, Socket socket) {
        this.server = server;
        this.socket = socket;

        try {
            this.inStream = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.outStream = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run () {
        try {
            System.out.println("MultiClient connected..");
            // Request the client username
            this.outStream.write("Please provide a username... \n");
            this.outStream.flush();

            String inbound;
            while ((inbound = inStream.readLine()) != null && this.username == null) {
                this.username = inbound;
                System.out.println("User " + username + " logged on...");
            }

            while ((inbound = inStream.readLine()) != null && !inbound.equals("exit")) {
                System.out.println("[" + new Date() + "] " + this.username + ": " + inbound);
                server.broadcast(inbound, this);
            }

        } catch (IOException e) {

        }

    }

    public void handleMessageReceived (String message) {
        try {
            this.outStream.write(message + "\n");
            this.outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String username () {
        return this.username;
    }
}
