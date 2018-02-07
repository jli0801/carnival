package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
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
	private Color background = new Color(179, 230, 255);

	public BalloonResults(int width, int height) {
		super(width, height);
		getScore();
		setBackground(background);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		try {

			File fontFile = new File("resources/Bangers.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font baseFont=font.deriveFont(40f);

			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {

			e.printStackTrace();
			//
		}
		//balloonScreen = new poppingBalloonsJessicaJi.BalloonScreen(getWidth(), getHeight());
		//result = new TextArea(50, 10, 200, 100, "You (win/lose)");
		score = new TextArea(500, 200, 300, 50, "Final score: " + scoreNum);
		//rate  = new TextArea(50, 70, 500, 50, "You popped an average of _ balloons per second");
		
		Button back = new Button(85, 650, 90, 70, "Back", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
				
			}
		});
		
		ticket = new Graphic (60,650,150,150, "poppingBalloons/ticket.png");
		viewObjects.add(ticket);
		
		Button playAgain = new Button(500, 300, 200, 100, "Play Again", new Action() {
			
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
	
	
	public void setScore() {
		scoreNum = BalloonScreen.getScore();
	}
	
}
