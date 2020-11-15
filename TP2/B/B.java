public class B {
    public static void main(String[] args) {
        int size = 100;
        double balance = 1000;
        Banque bank = new Banque(size, balance);
        for(int i=0; i<size; i++){
            Runnable runnable = new Transfer(bank, i,(int)(Math.random()*1000)-1);
            new Thread(runnable).start();
        }
    }
}
