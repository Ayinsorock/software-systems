package ss.week7.multiclientchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main (String args[]) {
        Server myServer = new Server();
        myServer.start();
    }


    public static final int PORT = 8080;
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
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void broadcast (String message, ClientHandler myHandler) {
        clientHandlers.forEach(handler -> {
            if (myHandler != handler) {
                handler.handleMessageReceived(myHandler.username() + ": " + message);
            }
        });
    }
}
