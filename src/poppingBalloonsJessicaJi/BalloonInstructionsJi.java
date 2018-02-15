package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import foodJoannaAnnie.AnnieInstructionInterface;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class BalloonInstructionsJi extends FullFunctionScreen{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Button instructions;
	private Button play;
	private TextArea instructionsTxt;
	private Button back;

	private TextArea welcomeTxt;
	private boolean showInstructions;
	private Graphic clown;

	public BalloonInstructionsJi(int width, int height) {
		super(width, height);
		//setBackground(getBackgroundColor());
		showInstructions = false;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		try {

			File fontFile = new File("resources/Bangers.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font baseFont=font.deriveFont(33f);

			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
		instructions = new Button(500, 150, 200, 100, "Instructions", new Action() {
			
			@Override
			public void act() {
					
					if(!showInstructions)
					{
					instructionsTxt.setVisible(true);
					showInstructions = true;
					}
					else
					{
						instructionsTxt.setVisible(false);
						showInstructions = false;
					}
			}
		});
		viewObjects.add(instructions);
		
		instructionsTxt = new TextArea(250, 250, 800, 400, "When time starts, Try to pop as many as you can "
				+ "but not all of them will pop "
				+ "according to which dart you’re using and how much strength you have. The balloons will "
				+ "pop up again but stronger each time."
				+ " You are given four darts of each type, dull, blunt, strong, dangerous. It is listed "
				+ "from weakest to strongest."
				+ " Be sure to use them wisely! Good Luck!"
				+ "                                                                         "
				+ "Click on the clown to go back!"
				+ " Proceed with the game by clicking 'Play.'");
		viewObjects.add(instructionsTxt);
		instructionsTxt.setVisible(false);
		
		
		play = new Button(1000, 150, 200, 100, "Play", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new poppingBalloonsJessicaJi.BalloonScreenJessica(getWidth(), getHeight())); //doesn't work
			}
		});
		viewObjects.add(play);
		

		clown = new Graphic(50,50,150,150,"resources/clown.png");
		viewObjects.add(clown);
		
		
		back = new Button(50, 50, 150, 150, "", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new mainMenuAreejVickie.MainScreenAreej(getWidth(), getHeight()));
			}
		});
		viewObjects.add(back);
		back.setCurve(150,150);
	
		
		welcomeTxt = new TextArea(420, 100, 400, 100, "Welcome to Popping Balloons!");
		viewObjects.add(welcomeTxt);
	}



}
