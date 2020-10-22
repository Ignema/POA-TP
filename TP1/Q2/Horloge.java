import javax.swing.*;

public class Horloge implements Runnable{

	private JLabel label;

	public Horloge(JLabel label){

		this.label = label;

	}

    public void run(){
 
		int numSec=0;
		int numMin=0;

		String sec = "";
		String min = "";
		String clock = "00:00";

		label.setText(clock);

		while(true){

			try{

				Thread.sleep(1000);
				numSec++;

				if(numSec < 60){
					if (numSec < 10 ){
						sec = "0" + numSec;
					}
					else{
						sec = "" + numSec;
					}
				}
				else{
					numSec = 0;
					numMin++;
					sec = "0" + numSec;
				}
				if(numMin < 10){
					min = "0" + numMin + ":";
				}
				else if(numMin > 9 || numMin < 60){
					min = "" + numMin + ":";
				}

				clock = min + sec;
				label.setText(clock);
			}
			catch(Exception e){

				System.out.println(e.toString());

			}


		}


    }

}