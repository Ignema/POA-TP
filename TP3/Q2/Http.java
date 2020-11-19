import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Http {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Started a server on port " + serverSocket.getLocalPort());
            while (true){
                Socket socket = serverSocket.accept();
                String index = "<!DOCTYPE html>\n" +
                        "<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\"> <![endif]-->\n" +
                        "<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\"> <![endif]-->\n" +
                        "<!--[if IE 8]>         <html class=\"no-js lt-ie9\"> <![endif]-->\n" +
                        "<!--[if gt IE 8]>      <html class=\"no-js\"> <!--<![endif]-->\n" +
                        "<html>\n" +
                        "    <head>\n" +
                        "        <meta charset=\"utf-8\">\n" +
                        "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "        <title>Server</title>\n" +
                        "        <meta name=\"description\" content=\"\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "        <link rel=\"stylesheet\" href=\"\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <!--[if lt IE 7]>\n" +
                        "            <p class=\"browsehappy\">You are using an <strong>outdated</strong> browser. Please <a href=\"#\">upgrade your browser</a> to improve your experience.</p>\n" +
                        "        <![endif]-->\n" +
                        "\n" +
                        "        <h1>Hello there!</h1>\n" +
                        "        <p>This webpage was sent from your java server.</p>\n" +
                        "        \n" +
                        "        <script src=\"\" async defer></script>\n" +
                        "    </body>\n" +
                        "</html>";

                String response = "HTTP/1.1 200 OK\n\n" + index;
                socket.getOutputStream().write(response.getBytes());
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
