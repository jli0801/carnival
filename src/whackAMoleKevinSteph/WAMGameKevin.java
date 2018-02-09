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

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

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
	
	private Graphic sOne;
	private Graphic sTwo;
	private Graphic sThree;
	private Graphic sFour;
	private Graphic sFive;
	private Graphic sSix;
	private Graphic sSeven;
	private Graphic sEight;
	private Graphic sNine;
	
	private Graphic dOne;
	private Graphic dTwo;
	private Graphic dThree;
	private Graphic dFour;
	private Graphic dFive;
	private Graphic dSix;
	private Graphic dSeven;
	private Graphic dEight;
	private Graphic dNine;
	
	private Button moleOne;
	private Button moleTwo;
	private Button moleThree;
	private Button moleFour;
	private Button moleFive;
	private Button moleSix;
	private Button moleSeven;
	private Button moleEight;
	private Button moleNine;
	
	public static int score;
	private TextArea scoreText;
	
	private Button quitButton;
	
	private static TextArea timeText;
	private static int time;
	
	public WAMGameKevin(int width, int height) {
		super(width, height);
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic gamebg = new Graphic(0,0, getWidth(), getHeight(), "wam/grass.png");
		viewObjects.add(gamebg);
		
		score = 0;
		
		//Timer();
		
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
		
		timeText = new TextArea(950,150,200,200, "Time: " + time + " Seconds Remaining");
		viewObjects.add(timeText);
		
		moleOne = new Button(250,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleOneDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleOne);
		
		moleTwo = new Button(450,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleTwoDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleTwo);
		
		moleThree = new Button(650,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleThreeDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleThree);
		
		moleFour = new Button(250,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleFourDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleFour);
		
		moleFive = new Button(450,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleFiveDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleFive);
		
		moleSix = new Button(650,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleSixDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleSix);
		
		moleSeven = new Button(250,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleSevenDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleSeven);
		
		moleEight = new Button(450,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleEightDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleEight);
		
		moleNine = new Button(650,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleNineDown();
				scoreUp();
				upMole();
				endGame();
			}
		});
		viewObjects.add(moleNine);
		
		
		mOne = new Graphic(250,200,80,80,"wam/mole.png");
		//viewObjects.add(mOne);
		
		mTwo = new Graphic(450,200,80,80,"wam/mole.png");
		//viewObjects.add(mTwo);
		
		mThree = new Graphic(650,200,80,80,"wam/mole.png");
		viewObjects.add(mThree);
		
		mFour = new Graphic(250,400,80,80,"wam/mole.png");
		//viewObjects.add(mFour);
		
		mFive = new Graphic(450,400,80,80,"wam/mole.png");
		viewObjects.add(mFive);
		
		mSix = new Graphic(650,400,80,80,"wam/mole.png");
		//viewObjects.add(mSix);
		
		mSeven = new Graphic(250,600,80,80,"wam/mole.png");
		//viewObjects.add(mSeven);
		
		mEight = new Graphic(450,600,80,80,"wam/mole.png");
		viewObjects.add(mEight);
		
		mNine = new Graphic(650,600,80,80,"wam/mole.png");
		//viewObjects.add(mNine);
		
		sOne = new Graphic(250,200,80,80,"wam/squish.png");
		//viewObjects.add(sOne);
		
		sTwo = new Graphic(450,200,80,80,"wam/squish.png");
		//viewObjects.add(sTwo);
		
		sThree = new Graphic(650,200,80,80,"wam/squish.png");
		//viewObjects.add(sThree);
		
		sFour = new Graphic(250,400,80,80,"wam/squish.png");
		//viewObjects.add(sFour);
		
		sFive = new Graphic(450,400,80,80,"wam/squish.png");
		//viewObjects.add(sFive);
		
		sSix = new Graphic(650,400,80,80,"wam/squish.png");
		//viewObjects.add(sSix);
		
		sSeven = new Graphic(250,600,80,80,"wam/squish.png");
		//viewObjects.add(sSeven);
		
		sEight = new Graphic(450,600,80,80,"wam/squish.png");
		//viewObjects.add(sEight);
		
		sNine = new Graphic(650,600,80,80,"wam/squish.png");
		//viewObjects.add(sNine);
		
		dOne = new Graphic(250,200,80,80,"wam/dirt.png");
		viewObjects.add(dOne);
		
		dTwo = new Graphic(450,200,80,80,"wam/dirt.png");
		viewObjects.add(dTwo);
		
		dThree = new Graphic(650,200,80,80,"wam/dirt.png");
		//viewObjects.add(dThree);
		
		dFour = new Graphic(250,400,80,80,"wam/dirt.png");
		viewObjects.add(dFour);
		
		dFive = new Graphic(450,400,80,80,"wam/dirt.png");
		//viewObjects.add(dFive);
		
		dSix = new Graphic(650,400,80,80,"wam/dirt.png");
		viewObjects.add(dSix);
		
		dSeven = new Graphic(250,600,80,80,"wam/dirt.png");
		viewObjects.add(dSeven);
		
		dEight = new Graphic(450,600,80,80,"wam/dirt.png");
		//viewObjects.add(dEight);
		
		dNine = new Graphic(650,600,80,80,"wam/dirt.png");
		viewObjects.add(dNine);
		
		moleOne.setEnabled(false);
		moleTwo.setEnabled(false);
		moleThree.setEnabled(true);
		moleFour.setEnabled(false);
		moleFive.setEnabled(true);
		moleSix.setEnabled(false);
		moleSeven.setEnabled(false);
		moleEight.setEnabled(true);
		moleNine.setEnabled(false);
	}
	
	
	public void moleOneDown() {
		moleOne.setEnabled(false);
		viewObjects.add(sOne);
		viewObjects.remove(mOne);
	}

	public void moleTwoDown() {
		moleTwo.setEnabled(false);
		viewObjects.add(sTwo);
		viewObjects.remove(mTwo);
	}

	public void moleThreeDown() {
		moleThree.setEnabled(false);
		viewObjects.add(sThree);
		viewObjects.remove(mThree);
	}

	public void moleFourDown() {
		moleFour.setEnabled(false);		
		viewObjects.add(sFour);
		viewObjects.remove(mFour);
	}

	public void moleFiveDown() {
		moleFive.setEnabled(false);	
		viewObjects.add(sFive);
		viewObjects.remove(mFive);
	}

	public void moleSixDown() {
		moleSix.setEnabled(false);		
		viewObjects.add(sSix);
		viewObjects.remove(mSix);
	}

	public void moleSevenDown() {
		moleSeven.setEnabled(false);		
		viewObjects.add(sSeven);
		viewObjects.remove(mSeven);
	}

	public void moleEightDown() {
		moleEight.setEnabled(false);	
		viewObjects.add(sEight);
		viewObjects.remove(mEight);
	}

	public void moleNineDown() {
		moleNine.setEnabled(false);		
		viewObjects.add(sNine);
		viewObjects.remove(mNine);
	}

	public void scoreUp() {
		score++;
		scoreText.setText("Score: " + score);
		scoreText.update();
	}
	
	public void endGame() {
		if (score == 25) {
		moleOne.setEnabled(false);
		moleTwo.setEnabled(false);
		moleThree.setEnabled(false);
		moleFour.setEnabled(false);
		moleFive.setEnabled(false);
		moleSix.setEnabled(false);
		moleSeven.setEnabled(false);
		moleEight.setEnabled(false);
		moleNine.setEnabled(false);
			
		quitButton.setEnabled(false);
		GuiLoadingVickie.loading.setScreen(new WAMResultStephanie(getWidth(), getHeight()));
		GUIApplication.enableCursorChange = true;
		}
	}
	
	public void upMole() {
		Random rand = new Random();
		int  n = rand.nextInt(9) + 1;
		
		if (n==1) {
			moleOneUp();
		}
		if (n==2) {
			moleTwoUp();
		}
		if (n==3) {
			moleThreeUp();
		}
		if (n==4) {
			moleFourUp();
		}
		if (n==5) {
			moleFiveUp();
		}
		if (n==6) {
			moleSixUp();
		}
		if (n==7) {
			moleSevenUp();
		}
		if (n==8) {
			moleEightUp();
		}
		if (n==9) {
			moleNineUp();
		}
	}

	private void moleNineUp() {
		if (moleNine.isEnabled() == false) {
			moleNine.setEnabled(true);		
			viewObjects.add(mNine);
			viewObjects.remove(sNine);
		}else {
			upMole();
		}
		
	}

	private void moleEightUp() {
		if (moleEight.isEnabled() == false) {
			moleEight.setEnabled(true);		
			viewObjects.add(mEight);
			viewObjects.remove(sEight);
		}else {
			upMole();
		}
		
		
	}

	private void moleSevenUp() {
		if (moleSeven.isEnabled() == false) {
			moleSeven.setEnabled(true);		
			viewObjects.add(mSeven);
			viewObjects.remove(sSeven);
		}else {
			upMole();
		}
		
	}

	private void moleSixUp() {
		if (moleSix.isEnabled() == false) {
			moleSix.setEnabled(true);		
			viewObjects.add(mSix);
			viewObjects.remove(sSix);
		}else {
			upMole();
		}
		
	}

	private void moleFiveUp() {
		if (moleFive.isEnabled() == false) {
			moleFive.setEnabled(true);		
			viewObjects.add(mFive);
			viewObjects.remove(sFive);
		}else {
			upMole();
		}
		
	}

	private void moleFourUp() {
		if (moleFour.isEnabled() == false) {
			moleFour.setEnabled(true);		
			viewObjects.add(mFour);
			viewObjects.remove(sFour);
		}else {
			upMole();
		}
		
	}

	private void moleThreeUp() {
		if (moleThree.isEnabled() == false) {
			moleThree.setEnabled(true);		
			viewObjects.add(mThree);
			viewObjects.remove(sThree);
		}else {
			upMole();
		}
		
	}

	private void moleTwoUp() {
		if (moleTwo.isEnabled() == false) {
			moleTwo.setEnabled(true);		
			viewObjects.add(mTwo);
			viewObjects.remove(sTwo);
		}else {
			upMole();
		}
		
	}

	private void moleOneUp() {
		if (moleOne.isEnabled() == false) {
			moleOne.setEnabled(true);		
			viewObjects.add(mOne);
			viewObjects.remove(sOne);
		}else {
			upMole();
		}
		
	}
	
	/*
	private void Timer() {
		Timer timer = new Timer();
		TimerTask task;
		task = new TimerTask() {
			@Override
			public void run() { 
				if (time > 0) {
					timeText.setText("Time: " + time + " Seconds Remaining");
					time--;
				} else {
					cancel();
					endGame();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}
*/
}
