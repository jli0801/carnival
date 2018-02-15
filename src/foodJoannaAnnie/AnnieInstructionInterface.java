package foodJoannaAnnie;

import java.awt.Color;

import guiTeacher.components.*;

public interface AnnieInstructionInterface {

	Color getBackgroundColor();

	String getGameName();

	Color getButtonColor();

	String getInstructions();

	String getBackImageLocation();

	int getNumButtons();

	Button getButton(int i);

	void playButtonAct();

	Color getTitleColor();

}
