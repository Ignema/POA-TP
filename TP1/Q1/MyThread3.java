public class MyThread3 implements Runnable{

    public void run(){

        for(int i = 0; i<=60; i++){

            if(i%2==0){

                System.out.println(i);

            }

        }

    }

}