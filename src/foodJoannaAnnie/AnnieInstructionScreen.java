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
	
	private AnnieInstructionInterface caller;
	private TextArea instructions;
	private TextArea gameName;

	public AnnieInstructionScreen(int width, int height, AnnieInstructionInterface caller) {
		super(width, height);
		this.caller = caller;
		setBackground(caller.getBackgroundColor());
		setGameName();
		setUpButtons();
		setInstructions();
	}

	private void setInstructions() {
		instructions.setText(caller.getInstructions());
	}

	private void setUpButtons() {
		Button menu = new Button(20, 40, 270, 60, "Return to Main Menu", caller.getButtonColor(), new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
		});
		Button start = new Button(getWidth() - 200, 40, 180, 60, "Start Game", caller.getButtonColor(), new Action() {
			
			@Override
			public void act() {
				caller.getButtonAction();
			}
		});
		addObject(menu);
		addObject(start);
	}

	private void setGameName() {
		gameName.setText(caller.getGameName());
		gameName.setBodyColor(caller.getButtonColor());
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		TextArea heading = new TextArea(100, 100, 500, 80, "How to Play");
		gameName =  new TextArea(300, 50, 600, 30, "");
		instructions = new TextArea(getWidth() / 2 - 400, 100, 800, 400, "");
		
		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Button.setBaseFont(font.deriveFont(30f));
			instructions.setFont(font.deriveFont(40f));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		viewObjects.add(heading);
		viewObjects.add(gameName);
		viewObjects.add(instructions);

	}

}
