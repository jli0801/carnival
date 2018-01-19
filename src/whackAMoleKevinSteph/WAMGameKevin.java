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
	
	private Button quitButton;
	
	public WAMGameKevin(int width, int height) {
		super(width, height);
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//Graphic background = new Graphic(0,0, getWidth(), getHeight(), "resources/background.jpg");
		//viewObjects.add(background);
		
		quitButton = new Button(100,30,210,50,"Quit Game", new Action() {
			
			@Override
			public void act() {
				//WAMMainKevin.gameScreen.setScreen(WAMMainKevin.mainScreen);
				
			}
		});
		viewObjects.add(quitButton);
		
		moleOne = new Button(300,200,80,80,"Juan", new Action() {
			
			@Override
			public void act() {
				moleDown(1);
				
			}
		});
		viewObjects.add(moleOne);
		
		moleTwo = new Button(400,200,80,80,"Who", new Action() {
			
			@Override
			public void act() {
				moleDown(2);
				
			}
		});
		viewObjects.add(moleTwo);
		
		moleThree = new Button(500,200,80,80,"Tree", new Action() {
			
			@Override
			public void act() {
				moleDown(3);
				
			}
		});
		viewObjects.add(moleThree);
		
	}

	public void moleDown(int moleNumber) {
		
		
	}

}
