package poppingBalloonsJessicaJi;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import mainMenuAreejVickie.GuiLoadingVickie;
import mainMenuAreejVickie.InventoryVickie;

public class BalloonBackJi {

	public static ArrayList<Integer> balloons = new ArrayList<Integer>(); //static b/c jessica needs to use it index tells us what color what's in the index is the strength of balloon
	public static ArrayList<DartJessica> darts = GuiLoadingVickie.inventory.darts();
	public int round; //based on time
	
	private static int dartChosenInt; //for screen
	
	public static int getDartChosen() {
		return dartChosenInt;
	}

	public BalloonBackJi(int round) {
		super();
		createBalloons();
		this.round = round;
	}

	public static void etDartChosen(int userInput) {
		dartChosenInt = userInput;
	}
	
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
	
	public static ArrayList<Integer> createBalloons() {
		int numBalloons = 6;
		int balloonStrength = 30; //changes as rounds progress
		for(int i = 0; i < numBalloons; i++) {
			balloons.add(i, balloonStrength); 	
			}		
		return balloons; 
	}
	
	public static boolean isPoppable(int chosenBalloon) {
		if((getDartChosen() * PowerBarJessica.getLength()) > balloons.get(chosenBalloon))
		{
			return true;
		}else {
			balloons.set(chosenBalloon, balloons.get(chosenBalloon)-25);
			return false;
		}	
	}
	
	public ArrayList<DartJessica> getNewDart()
	{
		return darts;
	}
	
	public static void increaseStrength(int balloonIndex) {
		balloons.set(balloonIndex, (balloons.get(balloonIndex) + 150));
	}
}
