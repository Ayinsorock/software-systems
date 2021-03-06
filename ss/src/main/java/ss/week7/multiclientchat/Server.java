package ss.week7.multiclientchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {
    public static void main (String args[]) {
        Server myServer = new Server();
        myServer.start();
    }


    public static final int PORT = 3000;
    private List<ClientHandler> clientHandlers = new ArrayList();

    public void start () {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Listning on port: " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                ClientHandler handler = new ClientHandler(this, clientSocket);
                clientHandlers.add(handler);
                handler.start();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.exit(0);
        }
    }

    public void broadcast (String message, ClientHandler myHandler) {
        clientHandlers.forEach(handler ->
                handler.handleMessageReceived("[" + new Date() + "]: " + myHandler.username() + ": " + message)
        );
    }

    public void broadcast (String message) {
        clientHandlers.forEach(handler -> handler.handleMessageReceived("[" + new Date() + "]: " + message));
    }

    public void removeHandler(ClientHandler handler) {
        this.clientHandlers.remove(handler);
        this.broadcast(handler.username() + " left the chat.");
    }

    public void log (String message) {
        System.out.println("[" + new Date() + "] " + message);
    }

    public String welcomeMessage() {
        return " _   _       _   \n" +
                "| | | |     (_)  \n" +
                "| |_| | ___  _   \n" +
                "|  _  |/ _ \\| |  \n" +
                "| | | | (_) | |  \n" +
                "\\_| |_/\\___/|_| \n";
    }

    public String userList() {
        StringBuffer usersString = new StringBuffer();

        this.clientHandlers.forEach(handler -> usersString.append(handler.username() + "\n"));

        return usersString.toString();
    }
}
