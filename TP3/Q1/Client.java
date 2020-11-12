import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected...");
            System.out.println("\n Le proverbe du jour est: \n\t" + bufferedReader.readLine());
            socket.close();
            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}