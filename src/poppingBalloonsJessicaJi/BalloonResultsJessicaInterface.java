package poppingBalloonsJessicaJi;

import java.util.ArrayList;

public interface BalloonResultsJessicaInterface {
	
	void sortScores(ArrayList<Integer> arr);
	//sorts high scores
	
	void setScore();
	//sets score from previous game
	
	void addScores(int currentScore);
	//add score to arraylist from previous game
	
	void calculateTickets();
	//calculate earned tickets from score
	
	void addTicketsInventory();
	//adds tickets to inventory
	
	String checkSecondPlace();
	//sees if second place is applicable, if so adds it
	
	String checkThirdPlace();
	//sees if third place is applicable, if so adds it
}
