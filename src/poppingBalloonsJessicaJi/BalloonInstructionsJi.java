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

public class BalloonInstructionsJi extends FullFunctionScreen{

	private Button instructions;
	private Button play;
	private TextArea instructionsTxt;
	private Button back;
	private Color background = new Color(179, 230, 255);
	private TextArea welcomeTxt;
	private boolean showInstructions;
	private Graphic ticket;

	public BalloonInstructionsJi(int width, int height) {
		super(width, height);
		setBackground(background);
		showInstructions = false;
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
		
		instructions = new Button(300, 100, 200, 100, "Instructions", new Action() {
			
			@Override
			public void act() {
				if(showInstructions) {
					instructionsTxt.setVisible(false);
				}else {
					instructionsTxt.setVisible(true);
				}
				
			}
		});
		
		play = new Button(500, 100, 200, 100, "Play", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new BalloonScreenJessica(getWidth(), getHeight()));
			}
		});
		
		instructionsTxt = new TextArea(300, 300, 400, 400, "(Instructions placed here)");
		instructionsTxt.setVisible(false);
		
		back = new Button(100, 100, 200, 100, "Back", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new mainMenuAreejVickie.MainScreenAreej(getWidth(), getHeight()));
			}
		});
		
		ticket = new Graphic (100,100,1500,150, "poppingBalloons/ticket.png");
		viewObjects.add(ticket);
		
		welcomeTxt = new TextArea(200, 200, 400, 100, "Welcome to Popping Balloons!");
		
	}

}
