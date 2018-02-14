package foodJoannaAnnie;

import java.awt.Color;
import java.util.List;

import guiTeacher.interfaces.Visible;

public interface AnnieInstructionInterface {

	Color getBackgroundColor();

	String getGameName();

	Color getButtonColor();

	void getButtonAction();

	String getInstructions();

	void extraButtons(List<Visible> viewObjects);

	boolean hasBackImage();

	String getBackImageLocation();

}
