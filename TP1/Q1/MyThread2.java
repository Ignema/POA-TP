import java.util.*;

public class MyThread2 extends Thread{

    public void run(){
 
	for (String letter: new String[]{"r","s","t","u","v","w","x","y","z"}){           
    		System.out.println(letter);
	}	
    }

}