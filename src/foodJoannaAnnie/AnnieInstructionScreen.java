package foodJoannaAnnie;

import java.awt.Font;
import java.awt.Graphics2D;
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
	private TextLabel gameName;

	public AnnieInstructionScreen(int width, int height, AnnieInstructionInterface thing) {
		super(width, height);
		this.thing = thing;
		setBackground(thing.getBackgroundColor());
		addBackground();
		setGameName();
		setUpButtons();
		setInstructions();
	}

	private void addBox() {
		Component box = new Component(getWidth() / 2 - 450, 150, 900, 550) {
			
			@Override
			public void update(Graphics2D g) {
				g.setColor(thing.getBackgroundColor());
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		box.setVisible(true);
		getViewObjects().add(1, box);
	}

	private void addBackground() {
		if(thing.hasBackImage()) {
			Graphic backImage = new Graphic(0, 0, getWidth(), getHeight(), thing.getBackImageLocation());
			getViewObjects().add(0, backImage);
			addBox();
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
		
		if(thing.getNumButtons() != 1)
			for(int i = 1; i <= thing.getNumButtons(); i++)
				addObject(thing.getButton(i));
		else {
			Button play = new Button(getWidth() - 200, 40, 180, 60, "Play Game", thing.getButtonColor(), new Action() {
				
				@Override
				public void act() {
					thing.playButtonAct();
				}
			});
			addObject(play);
		}
		
	}

	private void setGameName() {
		gameName.setCustomTextColor(thing.getTitleColor());
		gameName.setText(thing.getGameName());
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		int x = getWidth() / 2 - 400;
		
		gameName =  new TextLabel(x, 180, 800, 80, "");
		TextArea heading = new TextArea(x, 255, 800, 80, "How to Play");
		instructions = new TextArea(x, 330, 800, 400, "");
		
		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Button.setBaseFont(font.deriveFont(30f));
			gameName.setFont(font.deriveFont(60f));
			heading.setFont(font.deriveFont(40f));
			instructions.setFont(font.deriveFont(30f));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		viewObjects.add(heading);
		viewObjects.add(gameName);
		viewObjects.add(instructions);

	}

}
