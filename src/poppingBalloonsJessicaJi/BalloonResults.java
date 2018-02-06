package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class BalloonResults extends FullFunctionScreen {

	//public static poppingBalloonsJessicaJi.BalloonScreen balloonScreen;
	//private TextArea result;
	private TextArea score;
	//private TextArea rate;
	
	private int tickets;
	private int scoreNum;
	private int averageRate;
	private Graphic ticket;

	public BalloonResults(int width, int height) {
		super(width, height);
		getScore();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//balloonScreen = new poppingBalloonsJessicaJi.BalloonScreen(getWidth(), getHeight());
		//result = new TextArea(50, 10, 200, 100, "You (win/lose)");
		score = new TextArea(200, 100, 100, 50, "Final score: " + scoreNum);
		//rate  = new TextArea(50, 70, 500, 50, "You popped an average of _ balloons per second");
		
		Button back = new Button(85, 650, 90, 70, "Back", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
				
			}
		});
		
		ticket = new Graphic (60,650,150,150, "poppingBalloons/ticket.png");
		viewObjects.add(ticket);
		
		Button playAgain = new Button(100, 700, 100, 100, "Play Again", new Action() {
			
			@Override
			public void act() {
				//GuiLoadingVickie.loading.setScreen(balloonScreen);
			}
		});
		viewObjects.add(playAgain);
		
		//viewObjects.add(result);
		viewObjects.add(score);
		//viewObjects.add(rate);
		viewObjects.add(back);
	}
	
	public void setStats() {
		//get previous score
		//calculate number of tickets based on score; 1:10
		//calculate average rate
	}
	
	
	public void getScore() {
		scoreNum = BalloonScreen.setScore();
	}
	
}
