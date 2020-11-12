import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
        try {
            String[] proverbs = {"Quand tout va bien on peut compter sur les autres, quand tout va mal on ne peut compter que sur sa famille.",
            "Le bonheur ne s'acquiert pas, il ne réside pas dans les apparences, chacun d'entre nous le construit à chaque instant de sa vie avec son coeur.",
            "Les larmes qui coulent sont amères mais plus amères encore sont celles qui ne coulent pas.",
            "Offrir l'amitié à qui veut l'amour, c'est donner du pain à qui meurt de soif.",
            "Quand la pauvreté entre par la porte, l'amour s'en va par la fenêtre.",
            "Parmi les hommes, le plus faible est celui qui ne sait pas garder un secret. Le plus fort, celui qui maîtrise sa colère, le plus patient, celui qui cache sa pauvreté, le plus riche, celui qui se contente de la part que dieu lui a faite.",
            "Souviens-toi qu'au moment de ta naissance tout le monde était dans la joie et toi dans les pleurs. Vis de manière qu'au moment de ta mort, tout le monde soit dans les pleurs et toi dans la joie.",
            "Il vaut mieux se disputer avec quelqu'un d'intelligent que parler à un imbécile."
            };
            int random = (int) ((proverbs.length*Math.random())) % proverbs.length;
            String proverb = proverbs[random];
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Waiting for connection...");
            while(true) {
                Socket socket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                System.out.println("Connected...");
                System.out.println("Sending proverb to client...");
                printWriter.println(proverb);
                printWriter.close();
                socket.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}