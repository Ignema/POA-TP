public class MyThread2 extends Thread{

    public void run(){

        for(int i = 0; i<=60; i++){

            if(i%2!=0){

                System.out.println(i);

            }

        }

    }

}