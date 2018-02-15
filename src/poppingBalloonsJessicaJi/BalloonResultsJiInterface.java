package poppingBalloonsJessicaJi;

import java.util.ArrayList;

public interface BalloonResultsJiInterface {
	
	void sortScores(ArrayList<Integer> arr);
	
	void setScore();
	
	void addScores(int currentScore);
	
	void calculateTickets();
	
	void addTicketsInventory();
	
	String checkSecondPlace();
	
	String checkThirdPlace();
}
