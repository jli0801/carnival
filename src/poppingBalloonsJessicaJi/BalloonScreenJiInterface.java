package poppingBalloonsJessicaJi;

import java.util.ArrayList;

import guiTeacher.components.Button;
import guiTeacher.components.Graphic;

public interface BalloonScreenJiInterface {

	void changeDartText(int num, String dartUser);
	//displays dart description depending on dart strength
	
	void changeQuality(String string, String dartType, int scoreNum);
	//displays balloon being popped, dart being used, and score
	
	ArrayList<Integer> getBalloons();
	//gets balloons that are created
	
	void Timer();
	//timer for game
	
	void timerB(Button b, Graphic image, Graphic pop);
	//timer for balloons
	
	void endRound();
	//ends game
	
	void toggleImage(Graphic balloon, Button button1, Graphic popping, boolean popped);
	//change image when balloon pops or another one replaces it
}

