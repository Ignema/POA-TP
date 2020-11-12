import java.io.IOException;
import java.net.ServerSocket;

public class Http {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
