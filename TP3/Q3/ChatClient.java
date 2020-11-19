import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    static Socket socket;

    public static void main(String[] args) throws IOException {
        try {
            socket = new Socket("localhost", 8000);
        } catch (Exception e){
            System.out.println("Server is not available...");
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

        Thread reception = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                while (true){
                    try {
                        message = bufferedReader.readLine();
                        if (message != null){
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        System.out.println("Server crash...");
                        break;
                    }
                }

            }
        });

        Thread emission = new Thread(new Runnable() {
            Scanner scanner;
            @Override
            public void run() {
                while(true){
                    scanner = new Scanner(System.in);
                    printWriter.println(scanner.nextLine());
                }
            }
        });

        emission.start();
        reception.start();
    }
}
