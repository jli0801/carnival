package poppingBalloonsJessicaJi;

import java.util.ArrayList;

public interface BalloonResultsJessicaInterface {
	
	void sortScores(ArrayList<Integer> arr);
	
	void setScore();
	
	void addScores(int currentScore);
	
	void calculateTickets();
	
	void addTicketsInventory();
	
	String checkSecondPlace();
	
	String checkThirdPlace();
}
