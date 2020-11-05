
public class Animal implements Runnable{

    private String name;
    private int distance = 0;

    public Animal(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Name: " + this.getName() + " Distance: " + this.getDistance() + "m");
        while(getDistance() < 30){
            try{
                Thread.sleep(1000);
                if(getName().equals("tortue")){
                    Thread.sleep(1000);
                    setDistance(getDistance() + 2);
                    System.out.println("Name: " + this.getName() + " Distance: " + this.getDistance() + "m");
                }
                else if(getName().equals("lievre")){
                    if(getDistance()<25) {
                        setDistance(getDistance() + 2);
                        System.out.println("Name: " + this.getName() + " Distance: " + this.getDistance() + "m");
                    }else{
                        System.out.println("Lievre est endormi...");
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}