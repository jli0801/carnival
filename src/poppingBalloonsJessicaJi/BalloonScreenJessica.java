package poppingBalloonsJessicaJi;

import java.awt.Color;
//import mainMenuAreejiVickie.GuiLoadingVickie;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;
import mainMenuAreejVickie.InventoryVickie;
import mainMenuAreejVickie.MainScreenAreej;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.border.*;

public class BalloonScreenJessica extends FullFunctionScreen  {

	//	public static mainMenuAreejVickie.choseGame menu; Where user chooses games.

	//public static poppingBalloonsJessicaJi.BalloonResultsJi balloonResults;
	public static MainScreenAreej menu;
//	public Graphic background;
	public Graphic ticket;
	public Graphic booth;
	public static Graphic dart1; //ji uses this in her class so it's static
	public static Graphic dart2;
	public static Graphic dart3;
	public static Graphic dart4;
	public Graphic balloon1; //pictures 1-6
	public Graphic balloon2;
	public Graphic balloon3;
	public Graphic balloon4;
	public Graphic balloon5;
	public Graphic balloon6;
	private Button back;
	private Button balloon1B; //buttons for balloons 1-6
	private Button balloon2B;
	private Button balloon3B;
	private Button balloon4B;
	private Button balloon5B;
	private Button balloon6B;
	
	private Button dull;
	private Button blunt;
	private Button sharp;
	private Button dangerous;

//	private int dullValue;
//	private int bluntValue;
//	private int sharpValue;
//	private int dangerousValue;
	
	private static int score; //ji uses this in her class so it's static
	private static int timeLeft;
	private static boolean gameStarted;

	public static int getTimeLeft() { //jessica needs this for power bar 
		return timeLeft;
	}

	private String balloonChosen; //needs to be int later
	private String dartChosen; //for design purposes shows what user chose
	private static int dartChosenInt; //whatever user chose
//	private int numberofDarts; 
	private TextArea balloonDescription;
	
	private TextArea dartDescription;
	private TextArea scoreText;
	
	private TextArea dullDart; //quantity
	private TextArea bluntDart; //quantity
	private TextArea sharpDart;//quantity
	private TextArea dangerousDart; //quantity
	
	private TextArea timeLeftTxt;

	private PowerBarJessica strength;
	private Button play;
	//private boolean playPressed = false;
	private boolean chosenDart;
	private Graphic popEffect1;
	private Graphic popEffect2;
	private Graphic popEffect3;
	private Graphic popEffect4;
	private Graphic popEffect5;
	private Graphic popEffect6;
	private Color background = new Color(179, 230, 255);
	private TextArea allDarts;


	public BalloonScreenJessica(int width, int height) {
		super(width, height);
		setBackground(background);
		// TODO Auto-generated constructor stub
		timeLeft = 30;
		score = 0;
		gameStarted = false;
		chosenDart = false;
		play.setEnabled(true);
		changeQuality("","",0); //FIX LATER
		
		gameStarted = true;
		play.setEnabled(false);
		addObject(strength);
		strength.startTask();
	
		Timer();
	}

/*	public void resizeComponents()
	{
		background.loadImages( "poppingBalloons/background.jpg", getWidth(), getHeight());


	}*/

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//balloonResults = new poppingBalloonsJessicaJi.BalloonResultsJi(getWidth(), getHeight());
		
		strength = new PowerBarJessica(560,475,100,150);
		dartChosenInt = BalloonBackJi.getDartChosen(); //needs to be int later
	//	BalloonBackJi.CreateDarts();
		BalloonBackJi.CreateBalloons();

		try {

			File fontFile = new File("resources/Bangers.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font baseFont=font.deriveFont(40f);

			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {

			e.printStackTrace();
			//
		}

	/*	background = new Graphic(0, 0, getWidth(), getHeight(), "poppingBalloons/background.jpg");
		viewObjects.add(background);*/
		//Button play = new Button()
		

		booth = new Graphic (30,35, 590,590, "poppingBalloons/booth.png");
		viewObjects.add(booth);

	/*	back = new Button(85, 650, 90, 70, "Back", new Action() {

			@Override
			public void act() {

				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
		} );

		viewObjects.add(back);*/

		//startTimerText = new TextArea(700, 250, 300, 300, "");

		//play = new Button(x, y, w, h, text, action)

		scoreText = new TextArea(700, 300, 300, 300, "Score: " + score);
		viewObjects.add(scoreText);
		balloonDescription = new TextArea(700, 350, 400, 400, "Balloon Popped: " ); 
		viewObjects.add(balloonDescription);
		dartDescription = new TextArea(700, 400, 300, 300, "Dart Used: " );
		viewObjects.add(dartDescription);

		ticket = new Graphic (60,650,150,150, "poppingBalloons/ticket.png");
		viewObjects.add(ticket);
		//darts
	/*	dull.setButtonOutline(true);
		blunt.setButtonOutline(true);
		sharp.setButtonOutline(true);
		dangerous.setButtonOutline(true);*/
	/*	allDarts = new TextArea (290,700,100,400, Integer.toString(BalloonBackJi.getDartNumber(0)) + "    " +
				Integer.toString(BalloonBackJi.getDartNumber(1)) +"    " + Integer.toString(BalloonBackJi.getDartNumber(2))
			+	"    " + Integer.toString(BalloonBackJi.getDartNumber(3)));
		viewObjects.add(allDarts);*/
		dart1 = new Graphic (250,650,100,100,"poppingBalloons/dart1.png");
		dullDart = new TextArea(290,700,100,100, Integer.toString(getTotalDarts(1)) );
		viewObjects.add(dart1);
		dull = new Button(250,645,100,70,"", new Action() {
			@Override
			public void act() {
				if(getTotalDarts(1) > 0)
				{
				dartDescription.setText("Dart Used: Dull");
				
				chosenDart = true; //in backend
				findNextDart(1);
				BalloonBackJi.setDartChosen(1); //0 = dull
				dartChosen = "Dull";
			//	dartChosenInt = 0;
				}
				else
				{
					chosenDart = false;
				}
			}
		});
		
		viewObjects.add(dull);
		
		dart2 = new Graphic (350,650,100,100,"poppingBalloons/dart2.png");
		bluntDart = new TextArea(390,700,100,100, Integer.toString(getTotalDarts(2)));
		viewObjects.add(dart2);
		blunt = new Button(350,645,100,70,"", new Action() {
			@Override
			public void act() {
				if(getTotalDarts(2) > 0)
				{
				dartDescription.setText("Dart Used: Blunt");
				chosenDart = true; //in backend
				BalloonBackJi.setDartChosen(2); //0 = dull
				dartChosen = "Blunt";
			//	dartChosenInt = 1;
				}
				else
				{
					chosenDart = false;
				}
			}
		});
		viewObjects.add(blunt);
		
		dart3 = new Graphic (450,650,100,100,"poppingBalloons/dart3.png");
		viewObjects.add(dart3);
		sharpDart = new TextArea(490,700,100,100, Integer.toString(getTotalDarts(3)));
		sharp = new Button(450,645,100,70,"", new Action() {
			@Override
			public void act() {
				if(getTotalDarts(3) > 0)
				{
				dartDescription.setText("Dart Used: Sharp");
				chosenDart = true; //in backend
				BalloonBackJi.setDartChosen(3); //0 = dull
				dartChosen = "Sharp";
			//	dartChosenInt = 2;
				}
				else
				{
					chosenDart = false;
				}
			}
		});
		viewObjects.add(sharp);
		
		
		dart4 = new Graphic (550,650,100,100,"poppingBalloons/dart4.png");
		viewObjects.add(dart4);
		dangerousDart = new TextArea(590,700,100,100, Integer.toString(getTotalDarts(4)));
		dangerous = new Button(550,645,100,70,"", new Action() {
			@Override
			public void act() {
				if(getTotalDarts(4) > 0)
				{
				dartDescription.setText("Dart Used: Dangerous");
				chosenDart = true; //in backend
				BalloonBackJi.setDartChosen(4); //0 = dull
				dartChosen = "Dangerous";
			//	dartChosenInt = 3;
				}
				else
				{
					chosenDart = false;
				}
			}
		});
		viewObjects.add(dangerous);
		
		
		
		viewObjects.add(bluntDart);
		viewObjects.add(dullDart);
		viewObjects.add(sharpDart);
		viewObjects.add(dangerousDart);
		//end darts

		//balloons
		balloon1 = new Graphic(100,200,120,120,"poppingBalloons/balloon1.png");
		balloon2 = new Graphic(240,200,120,120,"poppingBalloons/balloon2.png");
		balloon3 = new Graphic(380,200,120,120,"poppingBalloons/balloon3.png");
		balloon4 = new Graphic(100,360,120,120,"poppingBalloons/balloon4.png");
		balloon5 = new Graphic(240,360,120,120,"poppingBalloons/balloon5.png");
		balloon6 = new Graphic(380,360,120,120,"poppingBalloons/balloon6.png");
		viewObjects.add(balloon1);
		viewObjects.add(balloon2);
		viewObjects.add(balloon3);
		viewObjects.add(balloon4);
		viewObjects.add(balloon5);
		viewObjects.add(balloon6);

		
		//Inventory.getDarts.get(
		balloon1B = new Button(97, 205, 100, 100, "" , new Action() {

			@Override
			public void act() {
				
				if(chosenDart && BalloonBackJi.isPoppable(0))
				{
//					BalloonBack.UpdateBalloons(0, BalloonBack.darts.get(BalloonBack.getDartChosen()));
				changeQuality("Purple", findNextDart(dartChosenInt).getType(), 1); //BalloonBackJi.getDartChosen()
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			
				toggleImage(balloon1, true);
				InventoryVickie.darts().remove(findIndexNextDart(dartChosenInt));
				updateDartField(findNextDart(dartChosenInt));
		//		BalloonBackJi.updateDarts();
		//		changeDartText(numberofDarts, changeInttoString(BalloonBackJi.getDartChosen()));
		//		allDarts.setText(Integer.toString(numberofDarts));
		//		updateDartField(BalloonBackJi.getDartChosen(), 1);
				}
				
			}

			
		} );
		balloon1B.setCurve(100,100);

		//PowerBarJessica.getLength() * getDartChosen() 
		viewObjects.add(balloon1B);
		//	balloon1B.setVisible(false); to delete it 
		balloon2B = new Button(237, 205, 100, 100, "" , new Action() {

			@Override
			public void act() {
				//				BalloonBack.UpdateBalloons(1, BalloonBack.darts.get(BalloonBack.getDartChosen()));
				if(chosenDart && BalloonBackJi.isPoppable(1))
				{
				changeQuality("Mauve", findNextDart(dartChosenInt).getType(), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
				
				InventoryVickie.darts().remove(findIndexNextDart(dartChosenInt));
				updateDartField(findNextDart(dartChosenInt));
			//	BalloonBackJi.updateDarts();
			//	changeDartText(numberofDarts, changeInttoString(BalloonBackJi.darts[BalloonBackJi.getDartChosen()]));
				
			//	updateDartField(BalloonBackJi.getDartChosen(), 1);
				}
			}
		} );
		balloon2B.setCurve(100,100);
		viewObjects.add(balloon2B);
		balloon3B = new Button(377, 205, 100, 100, "" , new Action() {

			@Override
			public void act() {
				if(chosenDart && BalloonBackJi.isPoppable(2))
				{
				//	BalloonBack.UpdateBalloons(2, BalloonBack.darts.get(BalloonBack.getDartChosen()));
				changeQuality("Pink", findNextDart(dartChosenInt).getType(), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			//	BalloonBackJi.updateDarts();
			//	changeDartText(numberofDarts, changeInttoString(BalloonBackJi.darts[BalloonBackJi.getDartChosen()]));
			//	updateDartField(BalloonBackJi.getDartChosen(), 1);
				}
			
			}
		} );
		balloon3B.setCurve(100,100);
		viewObjects.add(balloon3B);
		balloon4B = new Button(97, 365, 100, 100, "" , new Action() {

			@Override
			public void act() {
				if(chosenDart && BalloonBackJi.isPoppable(3))
				{
				//	BalloonBack.UpdateBalloons(3, BalloonBack.darts.get(BalloonBack.getDartChosen()));
				changeQuality("Blue", findNextDart(dartChosenInt).getType(), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
				
				InventoryVickie.darts().remove(findIndexNextDart(dartChosenInt));
				updateDartField(findNextDart(dartChosenInt));
		//		BalloonBackJi.updateDarts();
		//		changeDartText(numberofDarts, changeInttoString(BalloonBackJi.darts[BalloonBackJi.getDartChosen()]));
		//		updateDartField(BalloonBackJi.getDartChosen(), 1);
				}
				
			}
		} );
		balloon4B.setCurve(100,100);
		viewObjects.add(balloon4B);
		balloon5B = new Button(237, 365, 100, 100, "" , new Action() {

			@Override
			public void act() {
				if(chosenDart && BalloonBackJi.isPoppable(4))
				{
				//	BalloonBack.UpdateBalloons(4, BalloonBack.darts.get(BalloonBack.getDartChosen()));
				changeQuality("Green", findNextDart(dartChosenInt).getType(), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
				
				InventoryVickie.darts().remove(findIndexNextDart(dartChosenInt));
				updateDartField(findNextDart(dartChosenInt));
		//		BalloonBackJi.updateDarts();
		//		changeDartText(numberofDarts, changeInttoString(BalloonBackJi.darts[BalloonBackJi.getDartChosen()]));
		//		updateDartField(BalloonBackJi.getDartChosen(), 1);
				}
				
			}
		} );
		balloon5B.setCurve(100,100);
		viewObjects.add(balloon5B);
		balloon6B = new Button(377, 365, 100, 100, "" , new Action() {

			@Override
			public void act() {
				if(chosenDart && BalloonBackJi.isPoppable(5))
				{
				//	BalloonBack.UpdateBalloons(5, BalloonBack.darts.get(BalloonBack.getDartChosen()));

				changeQuality("Gold", findNextDart(dartChosenInt).getType(), 1);

				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
				
				InventoryVickie.darts().remove(findIndexNextDart(dartChosenInt));
				updateDartField(findNextDart(dartChosenInt));
			//	BalloonBackJi.updateDarts();
			//	changeDartText(numberofDarts, changeInttoString(BalloonBackJi.darts[BalloonBackJi.getDartChosen()]));
			//	updateDartField(BalloonBackJi.getDartChosen(), 1);
				}
			
			}
		} );
		balloon6B.setCurve(100,100);
		viewObjects.add(balloon6B);
		//end balloons
		
		timeLeftTxt = new TextArea(700, 250, 300, 300, "Time Left: " + timeLeft);
		viewObjects.add(timeLeftTxt);

		
		
	/*	play = new Button(500, 250, 100, 100, "Play", new Action() {

			@Override
			public void act() {
				
					gameStarted = true;
					play.setEnabled(false);
					addObject(strength);
					strength.startTask();
				
					Timer();
					
			}
		});*/
		viewObjects.add(strength); 
	//	viewObjects.add(play);
		
	/*	
		restart = new Button(500, 200, 150, 100, "Restart", new Action() {
			
			@Override
			public void act() {
				if(timeLeft == 0) {
					play.setEnabled(true);
					timeLeft = 5;
					previousScore = score;
					score = 0;
					timeLeftTxt.setText("Time Left: 5");
				}
				
			}
		});
		
		//adding text
		viewObjects.add(restart);
		*/
		
		popEffect1 = new Graphic (100,220,100,120,"poppingBalloons/test.png");
		viewObjects.add(popEffect1);
		popEffect1.setVisible(false);

		popEffect2 = new Graphic(240,220,100,120,"poppingBalloons/test.png");
		viewObjects.add(popEffect2);
		popEffect2.setVisible(false);
				
		popEffect3 = new Graphic(380,220,100,120,"poppingBalloons/test.png");
		viewObjects.add(popEffect3);
		popEffect3.setVisible(false);
				
		popEffect4 = new Graphic(100,380,100,120,"poppingBalloons/test.png");
		viewObjects.add(popEffect4);
		popEffect4.setVisible(false);
				
		popEffect5 = new Graphic(240,380,100,120,"poppingBalloons/test.png");
		viewObjects.add(popEffect5);
		popEffect5.setVisible(false);
				
		popEffect6 = new Graphic(380,380,100,120,"poppingBalloons/test.png");
		viewObjects.add(popEffect6);
		popEffect6.setVisible(false);

	}



	public DartJessica findNextDart(int power) {
		for(int i = 0; i < InventoryVickie.darts().size(); i++)
		{
			if(InventoryVickie.darts().get(i).getStrength() == power)
			{
				return InventoryVickie.darts().get(i);
			}
			
		}
		return null;
	}
	
	public int findIndexNextDart(int power)
	{
		for(int i = 0; i < InventoryVickie.darts().size(); i++)
		{
			if(InventoryVickie.darts().get(i).getStrength() == power)
			{
				return i;
			}
		
		}
		return -1;
	}
	
	public int getTotalDarts(int power)
	{
		int totalNumber = 0;
		for(int i = 0; i < InventoryVickie.darts().size(); i++)
		{
			if(InventoryVickie.darts().get(i).getStrength() == power)
			{
				totalNumber++;
			}
			
		}
		return totalNumber;
	}

		private void updateDartField(DartJessica dart) {
		if(dart.getStrength() == 1)
		{
			dullDart.setText(Integer.toString(getTotalDarts(1)));
		}
		else if(dart.getStrength() == 2)
		{
			bluntDart.setText(Integer.toString(getTotalDarts(2)));
		}
		else if (dart.getStrength() == 3)
		{
			sharpDart.setText(Integer.toString(getTotalDarts(3)));
		}
		else
		{
			dangerousDart.setText(Integer.toString(getTotalDarts(4)));
		}
		
	}
	
	public static int getDartChosenInt() {
		return dartChosenInt;
	}

	public void setDartChosenInt(int dartChosenInt) {
		this.dartChosenInt = dartChosenInt;
	}

	private void changeDartText(int num, String dartUser) {
		if(dartUser.equals("Dull"))
		{
			dullDart.setText(Integer.toString(num));
		}
		else if (dartUser.equals("Blunt"))
		{
			bluntDart.setText(Integer.toString(num));
		}
		else if (dartUser.equals("Sharp"))
		{
			sharpDart.setText(Integer.toString(num));
		}
		else
		{
			dangerousDart.setText(Integer.toString(num));
		}
		
	}
	private void changeQuality(String string, String dartType, int scoreNum) {
		
	
		if(timeLeft != 0 && chosenDart && gameStarted)
		{
			balloonChosen = string;
			dartChosen = dartType;
			score = score + scoreNum;
			
	
		}
		else
		{
			balloonChosen = "";
		}
	}

	
	private ArrayList<Integer> getBalloons()
	{
		return BalloonBackJi.CreateBalloons();
	}

	private void Timer() {
		Timer timer = new Timer();
		TimerTask task;
		task = new TimerTask() {
			@Override
			public void run() { 
				if (timeLeft > 0) {
					timeLeftTxt.setText("Time Left: " + timeLeft);
					timeLeft--;
				} else {
					cancel();
					endRound();
					gameStarted = false;
					getScore();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}

	//what do we use this for?
	private void changeButtonDesign (Button button1, int dartNum, boolean input)
	{
		if(getTotalDarts(dartNum) > 0)
		{
			button1.setVisible(input);
			button1.setEnabled(input);
		}
	}
	private void endRound() {
		timeLeftTxt.setText("GAME OVER");
		GuiLoadingVickie.loading.setScreen(new BalloonResultsJi(getWidth(), getHeight()));
	}
	
	public static int getScore() {
		return score;
	}
	
	public void toggleImage(Graphic balloon, boolean popped) {
		if(popped) {
			balloon.setVisible(false);
		}else {
			balloon.setVisible(true);
		}
	}
}
