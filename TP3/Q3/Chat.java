import java.io.*;
import java.net.Socket;
import java.util.List;

public class Chat extends Thread{
    private int id;
    private Socket socket;
    private List<Socket> sockets;

    public Chat(int id, Socket socket, List<Socket> sockets){
        super();
        this.id = id;
        this.socket = socket;
        this.sockets = sockets;
    }

    public void run(){
        System.out.print("[Client #" + id + "] has joined.\n");
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Welcome to the localhost chatroom!\nYour ID is: " + id + "\nFeel free to type anything to be part of the conversation...");
            String message;
            while(true){
                try {
                    message = bufferedReader.readLine();
                } catch (Exception e){
                    System.out.println("[Client #" + id + "] has left the chat.\n");
                    break;
                }
                if (message != null){
                    for (Socket socket1 : sockets){
                        if (socket1 != this.socket){
                            OutputStream uniqueOutputStream = socket1.getOutputStream();
                            PrintWriter uniquePrintWriter = new PrintWriter(uniqueOutputStream, true);
                            int senderId= 1;
                            for (Socket socket2 : sockets){
                                if (this.socket == socket2){
                                    break;
                                } else {
                                    senderId++;
                                }
                            }
                            uniquePrintWriter.println("[Client #" + senderId + "]: " + message);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
