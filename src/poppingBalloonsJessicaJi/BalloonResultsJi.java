package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class BalloonResultsJi extends FullFunctionScreen {

	private TextArea score;
	
	private int tickets;
	private int scoreNum;
	private int averageRate;
	public ArrayList<Integer> highScores;
	private Graphic ticket;
	private Color background = new Color(179, 230, 255);

	private TextArea firstPlace;

	private TextArea ticketTxt;

	public BalloonResultsJi(int width, int height) {
		super(width, height);
		setScore();
		score.setText("Final Score: " + scoreNum);
		addScores(scoreNum);
		setBackground(background);
		
		calculateTickets();
		ticketTxt.setText("Tickets Earned: " + tickets);
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
		}
		score = new TextArea(500, 200, 300, 50, "Final Score: " + scoreNum);
		viewObjects.add(score);
		
		Button back = new Button(85, 650, 90, 70, "Back", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new mainMenuAreejVickie.MainScreenAreej(getWidth(), getHeight()));
				
			}
		});
		viewObjects.add(back);
		
		ticket = new Graphic (60,650,150,150, "poppingBalloons/ticket.png");
		viewObjects.add(ticket);
		
		Button playAgain = new Button(500, 300, 200, 100, "Play Again", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new BalloonScreenJessica(getWidth(), getHeight()));
			}
		});
		viewObjects.add(playAgain);
		
		firstPlace = new TextArea(500, 350, 150, 200, "(1st Place)");
		viewObjects.add(firstPlace);
		
		ticketTxt = new TextArea(500, 100, 200, 100, "Tickets Earned: " + tickets);
		
	}
	
	public void sortScores() {
		
	}

	public void setScore() {
		scoreNum = BalloonScreenJessica.getScore();
	}
	
	public void addScores(int currentScore)
	{
		highScores.add(currentScore);
	}
	
	public void calculateTickets() {
		tickets = (int) (scoreNum * 0.1);
	}
}
