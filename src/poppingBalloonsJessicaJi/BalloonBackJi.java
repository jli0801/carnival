package poppingBalloonsJessicaJi;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import mainMenuAreejVickie.InventoryVickie;

public class BalloonBackJi {
	
//	public static ArrayList<String> darts = new ArrayList<String>();  //static b/c jessica needs to use it 
//	public static ArrayList<Integer> dartsProperty = new ArrayList<Integer>(); //static b/c jessica needs to use it 
	public static ArrayList<Integer> balloons = new ArrayList<Integer>(); //static b/c jessica needs to use it index tells us what color what's in the index is the strength of balloon
	public static int[] darts = InventoryVickie.darts();
//	public static ArrayList<Integer> balloonsProperty = new ArrayList<Integer>(); //static b/c jessica needs to use it
	
	//***IDEAS***
	//balloons have health 10 - 100 (not just 1 for dull, 3 for strong etc..)
	// ^ easier for power bar implementation (power * dart strength)
	//dart strength = 1,2,3,4 
	//power = PowerBar.getLength() /5;
	
	
	//***TO DOS***
	//*power bar
	//*score formula
	//*result screen (record previous game data)
	//dart status (how many left & ability to choose dart)
	//balloon pop animation
	//when game end, switch to results screen and have restart/replay button there instead
	//*ticket formula
	//if darts run out, game ends 
	
	
	private static int dartChosenInt; //for screen
	
	
	public static int getDartChosen() {
		return dartChosenInt;
	}


	public static int getDartNumber(int num) {
		//updateDarts();
		int dartsNum = darts[num];
		return dartsNum;
	}
	
	public static void setDartChosen(int userInput) {
	
		dartChosenInt = userInput;
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
	
	public static void updateBalloons(int x, int dartProperty ) { //needs to be static so Jessica can access it
		//x represents index
		//front end-balloon deleted -> goes to confetti
		//thread for time & disable button  
		//change a balloon at the same position and change strength 
		
		if(balloons.get(x) == (darts[dartProperty]) || darts[dartProperty] > balloons.get(x)) 
		{
			//same property/type/level
			balloons.remove(x);
		//	darts.set();
			//dartsProperty.remove(dartProperty);
		}
		else
		{
			if(darts[dartProperty] < balloons.get(x))
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
	
	public static void updateDarts() {
		if(darts[dartChosenInt] > 0) {
			darts[dartChosenInt] = darts[dartChosenInt]-1;
		//}else {
		//	darts.remove(index);
		//}
		}
	}
	
	
	public void EndGame() {
		//disable buttons & switch screen
		//GuiLoadingVickie.mainMenuAreejVickie.setScreen(GuiLoadingVickie.BalloonResults);
	}


	public static boolean isPoppable(int i) {
	/*	if(getDartChosen() > balloons.get(1))
		{
			return true;
		}*/
		return true;
	}

}
