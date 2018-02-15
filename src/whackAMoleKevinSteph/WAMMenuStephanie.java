package whackAMoleKevinSteph;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import foodJoannaAnnie.AnnieInstructionInterface;
import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMMenuStephanie extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AnnieInstructionInterface thing;
	private TextArea instructions;
	private TextLabel gameName;

	public WAMMenuStephanie(int width, int height,  AnnieInstructionInterface thing) {
		super(width, height);
		this.thing = thing;
		setBackground(thing.getBackgroundColor());
		setGameName();
		setUpButtons();
		setInstructions();

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
		 
		viewObjects.add(instructions);
	}
}

