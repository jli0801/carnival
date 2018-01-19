package whackAMoleKevinSteph;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class WAMGameKevin extends ClickableScreen {

	private Button moleOne;
	private Button moleTwo;
	private Button moleThree;
	private Button moleFour;
	private Button moleFive;
	private Button moleSix;
	private Button moleSeven;
	private Button moleEight;
	private Button moleNine;
	
	private Button quit;
	
	public WAMGameKevin(int width, int height) {
		super(width, height);
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//Graphic background = new Graphic(0,0, getWidth(), getHeight(), "resources/background.jpg");
		//viewObjects.add(background);
		
		quit = new Button(180,30,210,50,"Quit Game", new Action() {
			
			@Override
			public void act() {
				
				
			}
		});

	}

}
