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
    private ASCIIProvider asciiProvider;

    public ClientHandler (Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        this.asciiProvider = new ASCIIProvider();

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
                    this.handleMessageReceived(server.welcomeMessage());
                } else if (isCommand(inbound)) {
                    handleCommand(inbound);
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

    public boolean isCommand(String message) {
        return message.length() > 0 && message.charAt(0) == '/';
    }

    public void handleCommand(String message) {
        try {
            String command = message.split(" ")[0];

            switch (command) {
                case "/peepz":
                    this.outStream.write(server.userList() + "\n");
                    this.outStream.flush();
                    break;

                case "/username":
                    String oldUsername = this.username;
                    this.username = message.replaceFirst("/username", "");
                    server.broadcast("[" + new Date() + "]: " + oldUsername + " now known as " + this.username + "\n");
                    break;

                case  "/help":
                    this.outStream.write("/peepz list of all users \n/username [username] set a new username \n");
                    this.outStream.flush();
                    break;

                case "/ascii":
                    String payload = message.replaceFirst("/ascii", "");
                    String art = this.asciiProvider.generate(payload);

                    server.broadcast("\n" + art + "\n");
                    break;

                default:
                    this.outStream.write("[" + new Date() + "]: Command [" + command + "] not recognized \n");
                    this.outStream.flush();

            }
        } catch (IOException e) {

        }
    }
}
