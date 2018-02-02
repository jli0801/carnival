package poppingBalloonsJessicaJi;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class BalloonBack {
	
//	public static ArrayList<String> darts = new ArrayList<String>();  //static b/c jessica needs to use it 
//	public static ArrayList<Integer> dartsProperty = new ArrayList<Integer>(); //static b/c jessica needs to use it 
	public static ArrayList<Integer> balloons = new ArrayList<Integer>(); //static b/c jessica needs to use it index tells us what color what's in the index is the strength of balloon
	public static ArrayList<Integer> darts = new ArrayList<Integer>();//Inventory.getDarts();
//	public static ArrayList<Integer> balloonsProperty = new ArrayList<Integer>(); //static b/c jessica needs to use it
	
	//***IDEAS***
	//balloons have health 10 - 100 (not just 1 for dull, 3 for strong etc..)
	// ^ easier for power bar implementation (power + dart strength)
	
	
	//***TO DOS***
	//power bar
	//score formula
	//result screen (record previous game data)
	//dart status (how many left & ability to choose dart)
	//balloon pop animation
	
	private static int dartChosen; //for screen
	
	
	public static int getDartChosen() {
		return dartChosen;
	}

	public static void setDartChosen(int dartChosen) {
		BalloonBack.dartChosen = dartChosen;
	}

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
	
	public static ArrayList<Integer> CreateDarts() {
		int numDarts = 10;
		for(int i = 0; i < numDarts; i++) {
			if(i <= 4 ) {
				
				darts.add(i, 0); //blunt
			}else {
				darts.add(i, 1); //weak
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
			balloons.add(i,0); // all start w/ weak
		//	balloonsProperty.add(0); //starts out with 0		
			}		
		
		return balloons; 
	}
	
	public static void UpdateBalloons(int x, int dartProperty ) { //needs to be static so Jessica can access it
		//x represents index
		//front end-balloon deleted -> goes to confetti
		//thread for time & disable button  
		//change a balloon at the same position and change strength 
		
		if(balloons.get(x) == (darts.get(dartProperty)) || darts.get(dartProperty) > balloons.get(x)) 
		{
			//same property/type/level
			balloons.remove(x);
			darts.set();
			//dartsProperty.remove(dartProperty);
		}
		else
		{
			if(darts.get(dartProperty) < balloons.get(x))
			{
				if(balloons.get(x) == 0) {
					balloons.remove(x);
				}else {
					//balloon weaker by 1
					balloons.set(x , balloons.get(x) - 1);
					
				}
			}
		}
	}
	
	
	
	
	public void EndGame() {
		//disable buttons & switch screen
		
	}

}
