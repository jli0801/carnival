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
import mainMenuAreejVickie.MainScreenAreej;

import javax.swing.border.*;

public class BalloonScreen extends FullFunctionScreen  {
	
//	public static mainMenuAreejVickie.choseGame menu; Where user chooses games.

	public static MainScreenAreej menu;
	public Graphic background;
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
	
	private static int score; //ji uses this in her class so it's static
	
	private String balloonChosen; //needs to be int later
	private int dartChosen; //needs to be int later
	private TextArea balloonDescription;
	private TextArea dartDescription;
	private TextArea scoreText;
	private TextArea dullDart;
	private TextArea bluntDart;
	private TextArea sharpDart;
	private TextArea dangerousDart;
	
	
	public BalloonScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void resizeComponents()
	{
		background.loadImages( "poppingBalloons/background.jpg", getWidth(), getHeight());
	
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		score = 0;
		BalloonBack.CreateDarts();
		BalloonBack.CreateBalloons();
		
		 try {

			 File fontFile = new File("poppingBalloons//Bangers.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(40f);

			 StyledComponent.setBaseFont(baseFont);
			 } catch (Exception e) {

			 e.printStackTrace();
//
			 }
		
		
		background = new Graphic(0, 0, getWidth(), getHeight(), "poppingBalloons/background.jpg");
		viewObjects.add(background);
		//Button play = new Button()
		
		booth = new Graphic (30,35, 590,590, "poppingBalloons/booth.png");
		viewObjects.add(booth);
		
		back = new Button(85, 650, 90, 70, "Back", new Action() {
			
			@Override
			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
		} );
		
		viewObjects.add(back);
		
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
		dart1 = new Graphic (250,650,100,100,"poppingBalloons/dart1.png");
		dullDart = new TextArea(250,750,100,100, Integer.toString(Inventory.getDarts.get(0)));
		viewObjects.add(dart1);
		dart2 = new Graphic (350,650,100,100,"poppingBalloons/dart2.png");
		viewObjects.add(dart2);
		dart3 = new Graphic (450,650,100,100,"poppingBalloons/dart3.png");
		viewObjects.add(dart3);
		dart4 = new Graphic (550,650,100,100,"poppingBalloons/dart4.png");
		viewObjects.add(dart4);
		
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

	balloon1B = new Button(97, 205, 100, 100, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(0, 0);
				changeQuality("Purple", BalloonBack.dartsProperty.get(0), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + Integer.toString(dartChosen));
			}
		} );
		balloon1B.setCurve(100,100);
		
		viewObjects.add(balloon1B);
	//	balloon1B.setVisible(false); to delete it 
		balloon2B = new Button(237, 205, 100, 100, "" , new Action() {
			
			@Override
			public void act() {
//				BalloonBack.UpdateBalloons(1, 1);
				changeQuality("Mauve", BalloonBack.dartsProperty.get(1), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + Integer.toString(dartChosen));
			}
		} );
		balloon2B.setCurve(100,100);
		viewObjects.add(balloon2B);
		balloon3B = new Button(377, 205, 100, 100, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(2, 2);
				changeQuality("Pink", BalloonBack.dartsProperty.get(2), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + Integer.toString(dartChosen));
			}
		} );
		balloon3B.setCurve(100,100);
		viewObjects.add(balloon3B);
		balloon4B = new Button(97, 365, 100, 100, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(3, 3);
				changeQuality("Blue", BalloonBack.dartsProperty.get(3), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + Integer.toString(dartChosen));
			}
		} );
		balloon4B.setCurve(100,100);
		viewObjects.add(balloon4B);
		balloon5B = new Button(237, 365, 100, 100, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(4, 4);
				changeQuality("Green", BalloonBack.dartsProperty.get(4), 1);
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + Integer.toString(dartChosen));
			}
		} );
		balloon5B.setCurve(100,100);
		viewObjects.add(balloon5B);
		balloon6B = new Button(377, 365, 100, 100, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(5, 5);
				
				changeQuality("Gold", BalloonBack.dartsProperty.get(5), 1);
				
				scoreText.setText("Score: " + Integer.toString(score));
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + Integer.toString(dartChosen));
			}
		} );
		balloon6B.setCurve(100,100);
		viewObjects.add(balloon6B);
		
		
		
		
	}
	
	private void changeQuality(String string, Integer integer, int i) {
		balloonChosen = string;
		dartChosen = integer;
		score = score + i;
		
	}

	private ArrayList<String> getBalloons()
	{
		return BalloonBack.CreateBalloons();
	}

	private void changeTimer(int time, String text) {
		Thread blink = new Thread(new Runnable() {

			@Override
			public void run() {
				//.setText(string);
				try {
					Thread.sleep(time*1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		blink.start();
		try {
			blink.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
