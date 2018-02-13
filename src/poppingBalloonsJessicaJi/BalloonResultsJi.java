package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	public ArrayList<Integer> highScores;
	private Graphic ticket;
	private Color background = new Color(179, 230, 255);

	private TextArea firstPlace;
	private TextArea ticketTxt;
	private TextArea highScoresTxt;
	private TextArea secondPlace;
	private TextArea thirdPlace;

	public BalloonResultsJi(int width, int height) {
		super(width, height);
		setBackground(background);

		setScore();
		score.setText("Final Score: " + scoreNum + "    Rank #" + findCurrentScore(highScores, scoreNum));
		addScores(scoreNum);
		sortScores(highScores);
		firstPlace.setText("#1        " + highScores.get(highScores.size()));
		secondPlace.setText("#2        " + highScores.get(highScores.size() - 1));
		thirdPlace.setText("#3        " + highScores.get(highScores.size() - 2));

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

		highScoresTxt = new TextArea(500, 350, 100, 100, "Best Score");
		viewObjects.add(highScoresTxt);

		firstPlace = new TextArea(500, 400, 150, 200, "#1        " + highScores.get(highScores.size()));
		viewObjects.add(firstPlace);

		secondPlace = new TextArea(500, 450, 150, 200, "#2        " + highScores.get(highScores.size() - 1));
		viewObjects.add(secondPlace);

		thirdPlace = new TextArea(500, 500, 150, 200, "#3        " + highScores.get(highScores.size() - 2));
		viewObjects.add(thirdPlace);

		ticketTxt = new TextArea(500, 100, 200, 100, "Tickets Earned: " + tickets);

	}

	public void sortScores(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size() - i - 1; j++) {
				if (arr.get(j) > arr.get(j + 1)) {
					int temp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, temp);
				}
			}
		}
	}

	public void setScore() {
		scoreNum = BalloonScreenJessica.getScore();
	}

	public void addScores(int currentScore)
	{
		highScores.add(currentScore);
	}

	public int findCurrentScore(ArrayList<Integer> arr, int score) {
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == score) {
				return i + 1;
			}
		}
		return -1;
	}

	public void calculateTickets() {
		tickets = (int) (scoreNum/2);
	}
}
