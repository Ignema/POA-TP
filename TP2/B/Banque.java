import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banque {
    private final Lock bankLock = new ReentrantLock();
    private final Condition isBalanceAvailable = bankLock.newCondition();
    private final double[] accounts;

    public Banque(int size, double balance) {
        accounts = new double[size];
        for (int i=0; i<size; i++){
            accounts[i] = balance;
        }
    }

    void transfer0(int source, int target, double balance) throws InterruptedException {
        if (accounts[source] < balance){
            System.out.println("Transfer0");
            Thread.sleep(1000);
            accounts[target] -= balance;
            Thread.sleep(1000);
            accounts[source] += balance;
        }
    }


    synchronized void transfer(int source, int target, double balance) throws InterruptedException {
        while(accounts[source] < balance){
            System.out.println("Balance depleted...\nWaiting for changes...");
            wait();
        }
        accounts[source] -= balance;
        accounts[target] += balance;
        notifyAll();
    }

    public void transferer(int source, int target, double balance) throws InterruptedException {
        bankLock.lock();
        try{
            if (accounts[source] < balance){
                isBalanceAvailable.await();
            }
            accounts[source] -= balance;
            accounts[target] += balance;
            isBalanceAvailable.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public double getBalanceTotal() {
        bankLock.lock();
        try{
            double total = 0;
            for (double account : accounts){
                total += account;
            }
            return total;
        } finally {
            bankLock.unlock();
        }
    }
}
