package foodJoannaAnnie;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class AnnieInstructionScreen extends ClickableScreen {
	
	private static final long serialVersionUID = 1L;
	
	private AnnieInstructionInterface thing;
	private TextArea instructions;
	private TextArea gameName;

	public AnnieInstructionScreen(int width, int height, AnnieInstructionInterface thing) {
		super(width, height);
		this.thing = thing;
		setBackground(thing.getBackgroundColor());
		addBackground();
		setGameName();
		setUpButtons();
		setInstructions();
	}

	private void addBackground() {
		if(thing.hasBackImage()) {
			Graphic backImage = new Graphic(0, 0, getWidth(), getHeight(), thing.getBackImageLocation());
			getViewObjects().add(0, backImage);
		}
	}

	private void setInstructions() {
		instructions.setText(thing.getInstructions());
	}

	private void setUpButtons() {
		Button menu = new Button(20, 40, 270, 60, "Return to Main Menu", thing.getButtonColor(), new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
		});
		addObject(menu);
		thing.getButtons(getViewObjects());
	}

	private void setGameName() {
		gameName.setText(thing.getGameName());
		gameName.setBodyColor(thing.getButtonColor());
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		TextArea heading = new TextArea(100, 100, 500, 80, "How to Play");
		gameName =  new TextArea(300, 50, 600, 30, "");
		instructions = new TextArea(getWidth() / 2 - 400, 100, 800, 400, "");
		
		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			StyledComponent.setBaseFont(font.deriveFont(30f));
			instructions.setFont(font.deriveFont(40f));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		viewObjects.add(heading);
		viewObjects.add(gameName);
		viewObjects.add(instructions);

	}

}
