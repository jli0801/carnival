package whackAMoleKevinSteph;

import java.util.List;

import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMGameKevin extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Graphic mOne;
	private Graphic mTwo;
	private Graphic mThree;
	private Graphic mFour;
	private Graphic mFive;
	private Graphic mSix;
	private Graphic mSeven;
	private Graphic mEight;
	private Graphic mNine;
	
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
	
	/*private static int time;
	private static TextArea timeText;
	static Thread timer = new Thread();*/
	
	public WAMGameKevin(int width, int height) {
		super(width, height);
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic gamebg = new Graphic(0,0, getWidth(), getHeight(), "wam/grass.png");
		viewObjects.add(gamebg);
		
		score = 0;
		
		quitButton = new Button(100,30,100,70,"Quit Game", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
				GUIApplication.enableCursorChange = true;
				
			}
		});
		viewObjects.add(quitButton);
		
		scoreText = new TextArea(950,100,100,100, "Score: " + score);
		viewObjects.add(scoreText);
		
		/*timeText = new TextArea(950,250,200,200, "Time: " + time);
		viewObjects.add(timeText);*/
		
		moleOne = new Button(250,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleOneDown();
				scoreUp();
			}
		});
		viewObjects.add(moleOne);
		
		moleTwo = new Button(450,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleTwoDown();
				scoreUp();
			}
		});
		viewObjects.add(moleTwo);
		
		moleThree = new Button(650,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleThreeDown();
				scoreUp();
			}
		});
		viewObjects.add(moleThree);
		
		moleFour = new Button(250,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleFourDown();
				scoreUp();
			}
		});
		viewObjects.add(moleFour);
		
		moleFive = new Button(450,400,80,8, "", new Action() {
			
			@Override
			public void act() {
				moleFiveDown();
				scoreUp();
			}
		});
		viewObjects.add(moleFive);
		
		moleSix = new Button(650,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleSixDown();
				scoreUp();
			}
		});
		viewObjects.add(moleSix);
		
		moleSeven = new Button(250,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleSevenDown();
				scoreUp();
			}
		});
		viewObjects.add(moleSeven);
		
		moleEight = new Button(450,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleEightDown();
				scoreUp();
			}
		});
		viewObjects.add(moleEight);
		
		moleNine = new Button(650,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleNineDown();
				scoreUp();
			} 
		});
		viewObjects.add(moleNine);
		
		
		mOne = new Graphic(250,200,80,80,"wam/mole.png");
		viewObjects.add(mOne);
		
		mTwo = new Graphic(450,200,80,80,"wam/mole.png");
		viewObjects.add(mTwo);
		
		mThree = new Graphic(650,200,80,80,"wam/mole.png");
		viewObjects.add(mThree);
		
		mFour = new Graphic(250,400,80,80,"wam/mole.png");
		viewObjects.add(mFour);
		
		mFive = new Graphic(450,400,80,80,"wam/mole.png");
		viewObjects.add(mFive);
		
		mSix = new Graphic(650,400,80,80,"wam/mole.png");
		viewObjects.add(mSix);
		
		mSeven = new Graphic(250,600,80,80,"wam/mole.png");
		viewObjects.add(mSeven);
		
		mEight = new Graphic(450,600,80,80,"wam/mole.png");
		viewObjects.add(mEight);
		
		mNine = new Graphic(650,600,80,80,"wam/mole.png");
		viewObjects.add(mNine);
		
		
		
		moleOne.setEnabled(true);
		moleTwo.setEnabled(true);
		moleThree.setEnabled(true);
		moleFour.setEnabled(true);
		moleFive.setEnabled(true);
		moleSix.setEnabled(true);
		moleSeven.setEnabled(true);
		moleEight.setEnabled(true);
		moleNine.setEnabled(true);
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		for(int i =20; i>0;i--)
		{
		Thread.sleep(1000);
		time = i;
		
		timeText.setText("Time: " + time);
		timeText.update();
		}
	}*/
	
	public void moleOneDown() {
		moleOne.setEnabled(true);
	}

	public void moleTwoDown() {
		moleTwo.setEnabled(true);
		
	}

	public void moleThreeDown() {
		moleThree.setEnabled(true);
		
	}

	public void moleFourDown() {
		moleFour.setEnabled(true);		
	}

	public void moleFiveDown() {
		moleFive.setEnabled(true);		
	}

	public void moleSixDown() {
		moleSix.setEnabled(true);		
	}

	public void moleSevenDown() {
		moleSeven.setEnabled(true);		
	}

	public void moleEightDown() {
		moleEight.setEnabled(true);		
	}

	public void moleNineDown() {
		moleNine.setEnabled(true);		
	}

	public void scoreUp() {
		score++;
		scoreText.setText("Score: " + score);
		scoreText.update();
	}

}
