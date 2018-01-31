package whackAMoleKevinSteph;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMMenuStephanie extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Button returnMSButton;
	private Button startButton;
	private TextBox instructionsText;

	public WAMMenuStephanie(int width, int height) {
		super(width, height);

	}

	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, getWidth(), getHeight(), "wam/background.jpg");
		
		viewObjects.add(background);
		
		 try {

			 File fontFile = new File("resources/Bangers.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(26f);

			 StyledComponent.setBaseFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }
		
		
		returnMSButton = new Button(20,30,210,50,"RETURN TO MAIN MENU",Color.ORANGE, new Action() {

			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
		});

		viewObjects.add(returnMSButton);

		startButton = new Button(970,30,200,50,"START GAME",Color.ORANGE, new Action() {

			public void act() {
				GuiLoadingVickie.loading.setScreen(new WAMGameKevin(getWidth(), getHeight()));
			}
		});
		
		viewObjects.add(startButton);

		instructionsText = new TextBox(250,80,700,270,"WELCOME TO WHACK-A-MOLE");
		instructionsText.setInactiveBorderColor(Color.RED);
		instructionsText.setReadOnly(true);
		instructionsText.setEditable(false);
		instructionsText.setText("HOW TO PLAY:" + "\n" + "WHACK AS MANY MOLES AS YOU CAN UNDER THE TIME LIMIT. THE HIGHER THE SCORE, THE MORE TICKETS YOU EARN. "
				+ "THERE ARE 3 ROUNDS. ROUND 1 STARTS OFF WITH 20 SECONDS, BUT AS YOU PROGRESS TO THE NEXT ROUNDS, THE TIME LIMIT WILL DECREASE BY 5 SECONDS AND THE MOLES WILL MOVE FASTER. "
				+ "CLICKING ON THE WRONG HOLE WILL RESULT IN A 1 SECOND PENALTY."  + "\n" + "NOW GO WHACK SOME MOLES AND ENJOY THE GAME!!");
		instructionsText.update();
		viewObjects.add(instructionsText);
	}
}
