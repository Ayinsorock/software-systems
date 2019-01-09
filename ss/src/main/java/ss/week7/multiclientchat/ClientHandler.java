package ss.week7.multiclientchat;

import java.io.*;
import java.net.Socket;

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
            server.log("Client detected...");
            // Request the client username
            this.outStream.write("Please provide a username... \n");
            this.outStream.flush();

            String inbound;
            while ((inbound = inStream.readLine()) != null) {
                if (this.username == null) {
                    this.username = inbound;
                    server.log("User " + username + " logged on...");
                    server.broadcast(username + " joined the chat"); // null to broadcast to client itself as well
                } else {
                    server.log(this.username + ": " + inbound);
                    server.broadcast(inbound, this);
                }
            }
        } catch (IOException e) {
            server.removeHandler(this);
        }

    }

    public void handleMessageReceived (String message) {
        try {
            this.outStream.write(message + "\n");
            this.outStream.flush();
        } catch (IOException e) {
            server.removeHandler(this);
        }
    }

    public String username () {
        return this.username;
    }
}
