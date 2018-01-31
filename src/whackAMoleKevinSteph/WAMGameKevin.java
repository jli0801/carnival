package whackAMoleKevinSteph;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
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
	
	private int score;
	
	private TextArea scoreText;
	
	private Button quitButton;
	
	public WAMGameKevin(int width, int height) {
		super(width, height);
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//Graphic background = new Graphic(0,0, getWidth(), getHeight(), "resources/background.jpg");
		//viewObjects.add(background);
		score = 0;
		
		quitButton = new Button(100,30,100,70,"Quit Game", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
				
			}
		});
		viewObjects.add(quitButton);
		
		scoreText = new TextArea(950,100,200,200, "Score: " + score);
		viewObjects.add(scoreText);
		
		moleOne = new Button(250,200,80,80,"One", new Action() {
			
			@Override
			public void act() {
				moleOneDown();
				scoreUp();
			}
		});
		viewObjects.add(moleOne);
		
		moleTwo = new Button(450,200,80,80,"Two", new Action() {
			
			@Override
			public void act() {
				moleTwoDown();
				scoreUp();
			}
		});
		viewObjects.add(moleTwo);
		
		moleThree = new Button(650,200,80,80,"Three", new Action() {
			
			@Override
			public void act() {
				moleThreeDown();
				scoreUp();
			}
		});
		viewObjects.add(moleThree);
		
		moleFour = new Button(250,400,80,80,"Four", new Action() {
			
			@Override
			public void act() {
				moleFourDown();
				scoreUp();
			}
		});
		viewObjects.add(moleFour);
		
		moleFive = new Button(450,400,80,80,"Five", new Action() {
			
			@Override
			public void act() {
				moleFiveDown();
				scoreUp();
			}
		});
		viewObjects.add(moleFive);
		
		moleSix = new Button(650,400,80,80,"Six", new Action() {
			
			@Override
			public void act() {
				moleSixDown();
				scoreUp();
			}
		});
		viewObjects.add(moleSix);
		
		moleSeven = new Button(250,600,80,80,"Seven", new Action() {
			
			@Override
			public void act() {
				moleSevenDown();
				scoreUp();
			}
		});
		viewObjects.add(moleSeven);
		
		moleEight = new Button(450,600,80,80,"Eight", new Action() {
			
			@Override
			public void act() {
				moleEightDown();
				scoreUp();
			}
		});
		viewObjects.add(moleEight);
		
		moleNine = new Button(650,600,80,80,"Nine", new Action() {
			
			@Override
			public void act() {
				moleNineDown();
				scoreUp();
			}
		});
		viewObjects.add(moleNine);
		
		
		moleOne.setEnabled(false);
		moleTwo.setEnabled(false);
		moleThree.setEnabled(false);
		moleFour.setEnabled(false);
		moleFive.setEnabled(false);
		moleSix.setEnabled(false);
		moleSeven.setEnabled(false);
		moleEight.setEnabled(false);
		moleNine.setEnabled(false);
	}
	
	
	
	public void moleOneDown() {
		moleOne.setEnabled(false);
	}

	public void moleTwoDown() {
		moleTwo.setEnabled(false);
		
	}

	public void moleThreeDown() {
		moleThree.setEnabled(false);
		
	}

	public void moleFourDown() {
		moleFour.setEnabled(false);		
	}

	public void moleFiveDown() {
		moleFive.setEnabled(false);		
	}

	public void moleSixDown() {
		moleSix.setEnabled(false);		
	}

	public void moleSevenDown() {
		moleSeven.setEnabled(false);		
	}

	public void moleEightDown() {
		moleEight.setEnabled(false);		
	}

	public void moleNineDown() {
		moleNine.setEnabled(false);		
	}

	public void scoreUp() {
		score++;
		scoreText.setText("Score: " + score);
		scoreText.update();
	}

}
