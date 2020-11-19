import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread {
    private int id;
    Socket socket;
    List<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) {
        new ChatServer().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Welcome to the localhost:8000 chat\n" + "Waiting for clients to join...");
            while (true) {
                try{
                    socket = serverSocket.accept();
                } catch (Exception e){
                    System.out.println("Server process was terminated...");
                    break;
                }
                sockets.add(socket);
                id++;
                new Chat(id, socket, sockets).start();
            }
        } catch (IOException e) {
            System.out.println("[Internal Server Error]: " + e.getMessage() + "\nTry again in a few seconds...");
        }
    }
}
