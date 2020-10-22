import java.util.*;

public class MyThread1 extends Thread{

    public void run(){
 
	for (String letter: new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"}){           
    		System.out.println(letter);
	}	
    }

}