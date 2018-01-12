package foodJoannaAnnie;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import simon.MoveInterfaceJoanna;

public class JoannaResultScreen extends ClickableScreen {

	private Button home;
	private Button work;
	private TextLabel description;
	private ArrayList<> orders;
	private int amt;
	private int earned;
	
	
	public JoannaResultScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

	}

}
