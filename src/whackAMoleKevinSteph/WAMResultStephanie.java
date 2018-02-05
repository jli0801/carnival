package whackAMoleKevinSteph;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMResultStephanie extends FullFunctionScreen {

	private Button returnMSButton;
	private Button playButton;
	private TextBox resultTitle;
	private TextBox showScores;
	private TextBox totalTickets;
	
	public WAMResultStephanie(int width, int height) {
		super(width, height);
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
		 
		returnMSButton = new Button(30,30,210,50,"RETURN TO MAIN MENU",Color.ORANGE, new Action() {

				public void act() {
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
					GUIApplication.enableCursorChange = true;
				}
			});

		viewObjects.add(returnMSButton);
		 
		playButton = new Button(920,30,210,50,"PLAY AGAIN", Color.ORANGE, new Action() {
			
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
				GUIApplication.enableCursorChange = true;
			}
		});
		
		viewObjects.add(playButton);
		
		resultTitle = new TextBox(250,80,600,270,"RESULTS:");
		viewObjects.add(resultTitle);
		
		showScores = new TextBox(250,180,600,270,"SCORE:" + "\n" + "TICKETS EARNED:");
		viewObjects.add(showScores);
		
		totalTickets = new TextBox(250,280,600,270,"TOTAL TICKETS:");
		viewObjects.add(totalTickets);
		
	}

}
