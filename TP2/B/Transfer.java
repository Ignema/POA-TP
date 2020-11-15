public class Transfer implements Runnable{

    Banque bank;
    int source;
    double balance;

    public Transfer(Banque bank, int source, double balance){
        this.bank = bank;
        this.source = source;
        this.balance = balance;
    }

    @Override
    public void run() {
        int target = (int) ((Math.random()*100)-1);
        System.out.println("Transfering " + balance + "DH from account #" + source + " to account #" + target);
        try{
            bank.transfer0(source, target, balance);
            System.out.println("Balance: " + bank.getBalanceTotal());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
