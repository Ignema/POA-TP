public class Q3{

    public static void main(String[] args){

            System.out.println("Simulation d'une course entre une lievre et une tortue...");

            Thread tortue = new Thread(new Animal("tortue"));
            tortue.start();

            Thread lievre = new Thread(new Animal("lievre"));
            lievre.start();
    }

}