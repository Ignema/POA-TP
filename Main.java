public class Main{


    public static void main(String[] args){

            Thread thread1 = new MyThread1();

            thread1.run();

            Thread thread2 = new MyThread2();

            thread2.run();

    }

}