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

public class WAMEasyKevin extends FullFunctionScreen {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int score;
	private TextArea scoreText;
	
	private Button quitButton;
	
	public TextArea timeText;
	
	public int time;
	public int moleTime;
	
	public int moleTimerOn;
	
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
	
	
	public WAMEasyKevin(int width, int height) {
		super(width, height);
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic gamebg = new Graphic(0,0, getWidth(), getHeight(), "wam/grass.png");
		viewObjects.add(gamebg);
		
		//Setting Values---------------------------------------------------------------------------------------------------
		
		score = 0;
		time = 20;
		moleTime = 3;
		moleTimerOn = 0;
		
		//Quit Buttons------------------------------------------------------------------------------------------------------
		
//		quitButton = new Button(20,30,210,50,"Quit Game", new Action() {
//			
//			@Override
//			public void act() {
//				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
//				GUIApplication.enableCursorChange = true;
//				
//			}
//		});
//		viewObjects.add(quitButton);
		
		//Creating Text Areas-----------------------------------------------------------------------------------------------
		
		scoreText = new TextArea(950,100,110,100, "Score: " + score);
		viewObjects.add(scoreText);
		
		timeText = new TextArea(950,150,200,200, "Time: " + time + " Seconds");
		viewObjects.add(timeText);
		Timer();
		
		//Creating Mole Buttons---------------------------------------------------------------------------------------------
		//Moles will only start moving once you press one
		
		moleOne = new Button(250,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleOne.setEnabled(false);
				moleSwap(sOne,mOne);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleOne);
		
		moleTwo = new Button(450,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleTwo.setEnabled(false);
				moleSwap(sTwo,mTwo);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleTwo);
		
		moleThree = new Button(650,200,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleThree.setEnabled(false);
				moleSwap(sThree,mThree);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleThree);
		
		moleFour = new Button(250,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleFour.setEnabled(false);
				moleSwap(sFour,mFour);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleFour);
		
		moleFive = new Button(450,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleFive.setEnabled(false);
				moleSwap(sFive,mFive);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleFive);
		
		moleSix = new Button(650,400,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleSix.setEnabled(false);
				moleSwap(sSix,mSix);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleSix);
		
		moleSeven = new Button(250,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleSeven.setEnabled(false);
				moleSwap(sSeven,mSeven);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleSeven);
		
		moleEight = new Button(450,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleEight.setEnabled(false);
				moleSwap(sEight,mEight);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleEight);
		
		moleNine = new Button(650,600,80,80,"", new Action() {
			
			@Override
			public void act() {
				moleNine.setEnabled(false);
				moleSwap(sNine,mNine);
				scoreUp();
				upMole();
			}
		});
		viewObjects.add(moleNine);
		
		//Creating Graphics----------------------------------------------------------------------------------------------------
		
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
		
		sOne = new Graphic(250,200,80,80,"wam/dirt.png");
		//viewObjects.add(sOne);
		
		sTwo = new Graphic(450,200,80,80,"wam/dirt.png");
		//viewObjects.add(sTwo);
		
		sThree = new Graphic(650,200,80,80,"wam/dirt.png");
		//viewObjects.add(sThree);
		
		sFour = new Graphic(250,400,80,80,"wam/dirt.png");
		//viewObjects.add(sFour);
		
		sFive = new Graphic(450,400,80,80,"wam/dirt.png");
		//viewObjects.add(sFive);
		
		sSix = new Graphic(650,400,80,80,"wam/dirt.png");
		//viewObjects.add(sSix);
		
		sSeven = new Graphic(250,600,80,80,"wam/dirt.png");
		//viewObjects.add(sSeven);
		
		sEight = new Graphic(450,600,80,80,"wam/dirt.png");
		//viewObjects.add(sEight);
		
		sNine = new Graphic(650,600,80,80,"wam/dirt.png");
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
		
		//Enabling Mole Buttons---------------------------------------------------------------------------------------------
		
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
	
	//Score Change Methods-------------------------------------------------------------------------------------------------------
	
	public void scoreUp() {
		score++;
		scoreText.setText("Score: " + score);
		scoreText.update();
	}
	
	//End Game Method------------------------------------------------------------------------------------------------------------
	
	public void endGame() {
		GuiLoadingVickie.loading.setScreen(new WAMResultStephanie(getWidth(), getHeight()));
		GUIApplication.enableCursorChange = true;

	}
	
	//Mole Spawn Methods-------------------------------------------------------------------------------------------------------------
	//moleNine.setEnabled(false);
	
	public void moleNineUp() {
		if (moleNine.isEnabled() == false) {
			moleNine.setEnabled(true);		
			moleSwap(mNine,sNine);
			
			moleTimer(sNine,mNine);
			moleTimerOn++;
		}else {
			upMole();
		}
		
	}

	public void moleEightUp() {
		if (moleEight.isEnabled() == false) {
			moleEight.setEnabled(true);		
			moleSwap(mEight,sEight);
			
			moleTimer(sEight,mEight);
			moleTimerOn++;
		}else {
			upMole();
		}
		
		
	}

	public void moleSevenUp() {
		if (moleSeven.isEnabled() == false) {
			moleSeven.setEnabled(true);		
			moleSwap(mSeven,sSeven);
			
			moleTimer(sSeven,mSeven);
			moleTimerOn++;
		}else {
			upMole();
		}
		
	}

	public void moleSixUp() {
		if (moleSix.isEnabled() == false) {
			moleSix.setEnabled(true);		
			moleSwap(mSix,sSix);
			
			moleTimer(sSix,mSix);
			moleTimerOn++;
		}else {
			upMole();
		}
		
	}

	public void moleFiveUp() {
		if (moleFive.isEnabled() == false) {
			moleFive.setEnabled(true);		
			moleSwap(mFive,sFive);
			
			moleTimer(sFive,mFive);
			moleTimerOn++;
		}else {
			upMole();
		}
		
	}

	public void moleFourUp() {
		if (moleFour.isEnabled() == false) {
			moleFour.setEnabled(true);		
			moleSwap(mFour,sFour);
			
			moleTimer(sFour,mFour);
			moleTimerOn++;
		}else {
			upMole();
		}
		
	}

	public void moleThreeUp() {
		if (moleThree.isEnabled() == false) {
			moleThree.setEnabled(true);		
			moleSwap(mThree,sThree);
			
			moleTimer(sThree,mThree);
			moleTimerOn++;
		}else {
			upMole();
		}
		
	}

	public void moleTwoUp() {
		if (moleTwo.isEnabled() == false) {
			moleTwo.setEnabled(true);		
			moleSwap(mTwo,sTwo);
			
			moleTimer(sTwo,mTwo);
			moleTimerOn++;
			}else {
			upMole();
		}
		
	}

	public void moleOneUp() {
		if (moleOne.isEnabled() == false) {
			moleOne.setEnabled(true);	
			moleSwap(mOne,sOne);
			
			moleTimer(sOne,mOne);
			moleTimerOn++;
		}else {
			upMole();
		}
		
	}
	
	//Timers-------------------------------------------------------------------------------------------------------------------
	
	public void moleTimer(Graphic addMole,Graphic removeMole) {
		if (moleTimerOn < 9) {
			Timer mTimer = new Timer();
			TimerTask mTask;
			mTask = new TimerTask() {
				@Override
				public void run() { 
					if (moleTime > 0) {
						moleTime--;
					} else {
						cancel();
						moleTime = 5;
						moleSwap(addMole,removeMole);
						disableMole(removeMole);
						upMole();
					}
				}
			};
			mTimer.schedule(mTask, 0, 1500);
		}
	}

	public void Timer() {
		Timer timer = new Timer();
		TimerTask task;
		task = new TimerTask() {
			@Override
			public void run() { 
				if (time > 0) {
					timeText.setText("Time Left: " + time);
					time--;
				} else {
					cancel();
					endGame();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}

//Helper Methods---------------------------------------------------------------------------------------------------------

	public void moleSwap(Graphic aGraph, Graphic rGraph) {
		viewObjects.add(aGraph);
		viewObjects.remove(rGraph);
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
	
	public void disableMole(Graphic removeMole) {
		if (removeMole == mOne) {
			moleOne.setEnabled(false);
		}
		if (removeMole == mTwo) {
			moleTwo.setEnabled(false);
		}
		if (removeMole == mThree) {
			moleThree.setEnabled(false);
		}
		if (removeMole == mFour) {
			moleFour.setEnabled(false);
		}
		if (removeMole == mFive) {
			moleFive.setEnabled(false);
		}
		if (removeMole == mSix) {
			moleSix.setEnabled(false);
		}
		if (removeMole == mSeven) {
			moleSeven.setEnabled(false);
		}
		if (removeMole == mEight) {
			moleEight.setEnabled(false);
		}
		if (removeMole == mNine) {
			moleNine.setEnabled(false);
		}
		
	}
	
}
