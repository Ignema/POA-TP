public class Main{

    public static void main(String[] args){

            System.out.println("Simulation d'une course entre une lievre et une tortue.../n/n");

            Thread tortue = new Thread(new animal("tortue"));
            tortue.start();

            Thread lievre = new Thread(new animal("lievre"));
            lievre.start();
    }

}