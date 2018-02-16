package poppingBalloonsJessicaJi;

import java.util.ArrayList;

import guiTeacher.components.Button;
import guiTeacher.components.Graphic;

public interface BalloonScreenJiInterface {

	void changeDartText(int num, String dartUser);
	
	void changeQuality(String string, String dartType, int scoreNum);
	
	ArrayList<Integer> getBalloons();
	
	void Timer();
	
	void timerB(Button b, Graphic image, Graphic pop);
	
	void endRound();
	
	void toggleImage(Graphic balloon, Button button1, Graphic popping, boolean popped);
}
