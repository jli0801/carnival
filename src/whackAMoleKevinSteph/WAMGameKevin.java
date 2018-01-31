package whackAMoleKevinSteph;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMGameKevin extends FullFunctionScreen {

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
		
		quitButton = new Button(100,30,100,70,"Quit Game", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
				
			}
		});
		viewObjects.add(quitButton);
		
		moleOne = new Button(250,200,80,80,"One", new Action() {
			
			@Override
			public void act() {
				moleDown(1);
				
			}
		});
		viewObjects.add(moleOne);
		
		moleTwo = new Button(450,200,80,80,"Two", new Action() {
			
			@Override
			public void act() {
				moleDown(2);
				
			}
		});
		viewObjects.add(moleTwo);
		
		moleThree = new Button(650,200,80,80,"Three", new Action() {
			
			@Override
			public void act() {
				moleDown(3);
				
			}
		});
		viewObjects.add(moleThree);
		
		moleFour = new Button(250,400,80,80,"Four", new Action() {
			
			@Override
			public void act() {
				moleDown(4);
				
			}
		});
		viewObjects.add(moleFour);
		
		moleFive = new Button(450,400,80,80,"Five", new Action() {
			
			@Override
			public void act() {
				moleDown(5);
				
			}
		});
		viewObjects.add(moleFive);
		
		moleSix = new Button(650,400,80,80,"Six", new Action() {
			
			@Override
			public void act() {
				moleDown(6);
				
			}
		});
		viewObjects.add(moleSix);
		
		moleSeven = new Button(250,600,80,80,"Seven", new Action() {
			
			@Override
			public void act() {
				moleDown(7);
				
			}
		});
		viewObjects.add(moleSeven);
		
		moleEight = new Button(450,600,80,80,"Eight", new Action() {
			
			@Override
			public void act() {
				moleDown(8);
				
			}
		});
		viewObjects.add(moleEight);
		
		moleNine = new Button(650,600,80,80,"Nine", new Action() {
			
			@Override
			public void act() {
				moleDown(9);
				
			}
		});
		viewObjects.add(moleNine);
		
	}
	
	public void moleDown(int moleNumber) {
		//disable something
		
	}

}
