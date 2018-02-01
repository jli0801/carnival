package poppingBalloonsJessicaJi;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class BalloonBack {
	
//	public static ArrayList<String> darts = new ArrayList<String>();  //static b/c jessica needs to use it 
//	public static ArrayList<Integer> dartsProperty = new ArrayList<Integer>(); //static b/c jessica needs to use it 
	public static ArrayList<Integer> balloons = new ArrayList<Integer>(); //static b/c jessica needs to use it index tells us what color what's in the index is the strength of balloon

//	public static ArrayList<Integer> balloonsProperty = new ArrayList<Integer>(); //static b/c jessica needs to use it
	
	public void Timer() { //links to text area
		//thread
		Thread time = new Thread(new Runnable() {
			
			@Override
			public void run() {
					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
	}
	
	public static ArrayList<String> CreateDarts() {
		int numDarts = 10;
		for(int i = 0; i < numDarts; i++) {
			if(i <= 4 ) {
				darts.add(Integer.toString(i));
				dartsProperty.add(0); //blunt
			}else {
				darts.add(Integer.toString(i));
				dartsProperty.add(1); //weak
			}
			
		}		
		
		return darts; 
		//getter from inventory needed 
	}
	
	public static ArrayList<Integer> CreateBalloons() {
		//static because jessica needs to display it
		//for loop make balloons
		int numBalloons = 6;
		for(int i = 0; i < numBalloons; i++) {
			balloons.add(0); // all start w/ weak
		//	balloonsProperty.add(0); //starts out with 0		
			}		
		
		return balloons; 
	}
	
	public static void UpdateBalloons(int x, int dartProperty ) { //needs to be static so Jessica can access it
		//x represents index
		//front end-balloon deleted -> goes to confetti
		//thread for time & disable button  
		//change a balloon at the same position and change strength 
		
		if(balloonsProperty.get(x) == (dartsProperty.get(dartProperty)) || dartsProperty.get(dartProperty) > balloonsProperty.get(x)) 
		{
			//same property/type/level
			balloons.remove(x);
			balloonsProperty.remove(x);
			darts.remove(dartProperty);
			dartsProperty.remove(dartProperty);
		}
		else
		{
			if(dartsProperty.get(dartProperty) < balloonsProperty.get(x))
			{
				if(balloonsProperty.get(x) == 0) {
					balloons.remove(x);
				}
			}
		}
	}
	
	
	
	
	public void EndGame() {
		//disable buttons & switch screen
		
	}
	
}
