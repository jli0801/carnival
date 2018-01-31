package whackAMoleKevinSteph;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMEndStephanie extends FullFunctionScreen {

	private Button returnMSButton;
	private Button playButton;
	
	public WAMEndStephanie(int width, int height) {
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
		 
		returnMSButton = new Button(180,30,210,50,"RETURN TO MAIN MENU",Color.ORANGE, new Action() {

				public void act() {
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
				}
			});

			viewObjects.add(returnMSButton);
		 
		playButton = new Button(180,30,500,50,"PLAY AGAIN", Color.ORANGE, new Action() {
			
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
			}
		});

	}

}
