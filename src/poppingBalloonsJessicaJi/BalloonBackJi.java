package poppingBalloonsJessicaJi;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import mainMenuAreejVickie.InventoryVickie;

public class BalloonBackJi {

	public static ArrayList<Integer> balloons = new ArrayList<Integer>(); //static b/c jessica needs to use it index tells us what color what's in the index is the strength of balloon
	public static ArrayList<DartJessica> darts = InventoryVickie.darts();
	public int round; //based on time
	
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

	
	
	public static void setDartChosen(int userInput) {
		dartChosenInt = userInput;
	}
	
/*	public static DartJessica findNextDart(int power) {
		int i =0;
			while(i < darts.size())
			{
				if(darts.get(i).getStrength() == power)
				{
					return darts.get(i);
				}
				else
				{
					i++;
				}
			}
			
		
		
	}*/
	
	
	public static int findIndexNextDart(int power)
	{
		for(int i = 0; i < darts.size(); i++)
		{
			if(darts.get(i).getStrength() == power)
			{
				return i;
			}
		
		}
		return -1; //ARRAY INDEX OUT OF BOUNDS 
	}
	
	public static int getTotalDarts(int power)
	{
		int totalNumber = 0;
		for(int i = 0; i < darts.size(); i++)
		{
			if(darts.get(i).getStrength() == power)
			{
				totalNumber++;
			}
			
		}
		return totalNumber;
	}
	
	public static ArrayList<Integer> CreateBalloons() {
		int numBalloons = 6;
		int balloonStrength = 30; //changes as rounds progress
		for(int i = 0; i < numBalloons; i++) {
			balloons.add(i, balloonStrength); 
			
		    //balloonsProperty.add(0); //starts out with 0		
			}		
		
		return balloons; 
	}
	
/*	public static void updateDarts() {
		if(darts[dartChosenInt] > 0) {
			darts[dartChosenInt] = darts[dartChosenInt]-1;
		}else {
			//darts.remove(dartChosenInt);
		
		}
	}*/ //i removed it in balloon screen but we can add the methods here.

	public static boolean isPoppable(int chosenBalloon) {
		if(getDartChosen() * PowerBarJessica.getLength() > balloons.get(chosenBalloon))
		{
			darts.remove(findIndexNextDart(dartChosenInt));
			balloons.remove(chosenBalloon);
			return true;
		}else {
			balloons.set(chosenBalloon, balloons.get(chosenBalloon)-5);
			return false;
		}
		
	}
	
	
	public ArrayList<DartJessica> getNewDart()
	{
		return darts;
	}

	/*
	public static void updateBalloons(int x, int dartProperty) { //needs to be static so Jessica can access it
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
					balloons.set(x , balloons.get(x) - 1);
					//balloon weaker by 1
				}
			}
		}
	}
	*/
}
