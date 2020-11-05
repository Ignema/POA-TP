public class Q1{


    public static void main(String[] args){

            Thread thread1 = new MyThread1();
            Thread thread2 = new MyThread2();
            Thread thread3 = new Thread(new MyThread3());

            thread1.start();
            thread2.start();
            thread3.start();

    }

}