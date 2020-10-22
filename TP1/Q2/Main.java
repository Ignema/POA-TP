import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args){

            JFrame window = new JFrame("Horloge Graphique");
            JPanel main = new JPanel();
            JLabel clock = new JLabel();

            main.add(clock);
            window.add(main);

            window.setSize(new Dimension(320,200));
            window.setVisible(true);

            Thread horloge = new Thread(new Horloge(clock));
            horloge.start();

            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}