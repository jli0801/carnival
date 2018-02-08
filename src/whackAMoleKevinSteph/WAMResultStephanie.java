package whackAMoleKevinSteph;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMResultStephanie extends FullFunctionScreen {

	private Button returnMSButton;
	private Button playButton;
	private TextArea resultTitle;
	private TextArea ticketA;
	private TextArea scoreA;
	private TextArea totalA;
	private TextBox ticketEarn;
	private TextBox showScores;
	private TextBox totalTickets;
	private Graphic tpic;
	private Graphic mpic;
	private AnimatedComponent confetti;
	public int ticketNum;
	
	public WAMResultStephanie(int width, int height) {
		super(width, height);
	}
	
	public int getTickets() {
		if(WAMGameKevin.score == 0) {
			ticketNum = 0;
		}else {
			ticketNum = (int)(Math.rint((WAMGameKevin.score/2) + 1));
		}
		
		return ticketNum;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		try {

			File fontFile = new File("resources/Bangers.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font baseFont=font.deriveFont(26f);

			StyledComponent.setBaseFont(baseFont);

			} catch (Exception e) {

			e.printStackTrace();

			}
		confetti = new AnimatedComponent(100, 100, 100, 100);
		viewObjects.add(confetti);
		 
		returnMSButton = new Button(30,30,210,50,"RETURN TO MAIN MENU",Color.ORANGE, new Action() {

				public void act() {
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
					GUIApplication.enableCursorChange = true;
					
				}
			});

		viewObjects.add(returnMSButton);
		 
		playButton = new Button(920,30,210,50,"PLAY AGAIN", Color.ORANGE, new Action() {
			
			public void act() {
				GuiLoadingVickie.loading.setScreen(new WAMGameKevin(getWidth(), getHeight()));
				GUIApplication.enableCursorChange = true;
			}
		});
		 
		viewObjects.add(playButton);
		
		resultTitle = new TextArea(530,165,500,270,"RESULTS");
		viewObjects.add(resultTitle);
				
		ticketEarn = new TextBox(330,200,500,150, " ");
		viewObjects.add(ticketEarn);
		
		showScores = new TextBox(330,300,500,150, " ");
		viewObjects.add(showScores);
		
		totalTickets = new TextBox(330,400,500,150, " ");
		viewObjects.add(totalTickets);
		
		ticketA = new TextArea(420,250,500,270, "TICKETS EARNED: " + getTickets());
		viewObjects.add(ticketA);
		
		scoreA = new TextArea(410,350,500,270, "SCORE: " + WAMGameKevin.score);
		viewObjects.add(scoreA);

		totalA = new TextArea(420,450,300,270, "TOTAL NUMBER OF TICKETS: ");
		viewObjects.add(totalA);
		
		tpic = new Graphic(340,220,80,80,"wam/ticket.png");
		viewObjects.add(tpic);
		
		mpic = new Graphic(340,320,80,80,"wam/mouse.jpg");
		viewObjects.add(mpic);
	}
	
}
