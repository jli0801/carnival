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
import javax.swing.border.*;

public class BalloonScreen extends FullFunctionScreen  {
	
//	public static mainMenuAreejVickie.choseGame menu; Where user chooses games.

<<<<<<< HEAD
	//public static MainScreenAreej menu;
=======
//	public static MainScreenAreej menu;
>>>>>>> branch 'balloonJessicaJi' of https://github.com/jli0801/carnival.git
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
	static private int score = 0; //ji uses this in her class so it's static
	private TextArea description;
	private String balloonChosen; //needs to be int later
	private int dartChosen; //needs to be int later
	private TextArea balloonDescription;
	private TextArea dartDescription;
	
	
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
		
		 try {

			 File fontFile = new File("poppingBalloons//Bangers.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(40f);

			 StyledComponent.setBaseFont(baseFont);
			 //mole.setFont(baseFont);
			 //food.setFont(baseFont);

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
<<<<<<< HEAD
				//menu = new MainScreenAreej(getWidth(), getHeight());
=======
		//		menu = new MainScreenAreej(getWidth(), getHeight());
>>>>>>> branch 'balloonJessicaJi' of https://github.com/jli0801/carnival.git
		//		setScreen(menu);
			}
		} );
		
		viewObjects.add(back);
		
		description = new TextArea(700, 200, 600, 600, "Score: " + score + "/nBalloon Popped: " +
		balloonChosen + "/nDart Used: " + dartChosen );
		
		
		balloonDescription = new TextArea(700, 350, 300, 300, "Balloon Popped: ");
		viewObjects.add(balloonDescription);
		
		dartDescription = new TextArea(700, 400, 300, 300, "Dart Used: ");
		viewObjects.add(dartDescription);
		
		balloon1B = new Button(100, 200, 120, 120, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(1, 1);
				balloonChosen = "Purple";
				dartChosen = BalloonBack.dartsProperty.get(0);
				description.setText("Score: " + score + "/nBalloon Popped: "+
		balloonChosen + "/nDart Used: " + dartChosen );
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			}
		} );
		balloon1B.setCurve(50,50);
		viewObjects.add(balloon1B);
	//	balloon1B.setVisible(false); to delete it 
		balloon2B = new Button(240, 200, 120, 120, "" , new Action() {
			
			@Override
			public void act() {
//				BalloonBack.UpdateBalloons(1, 1);
				balloonChosen = "Mauve";
				dartChosen = BalloonBack.dartsProperty.get(1);
				description.setText("Score: " + score + "/nBalloon Popped: "+
		balloonChosen + "/nDart Used: " + dartChosen );
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			}
		} );
		balloon2B.setCurve(50,50);
		viewObjects.add(balloon2B);
		balloon3B = new Button(380, 200, 120, 120, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(2, 2);
				balloonChosen = "Pink";
				dartChosen = BalloonBack.dartsProperty.get(2);
				description.setText("Score: " + score + "/nBalloon Popped: "+
		balloonChosen + "/nDart Used: " + dartChosen );
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			}
		} );
		balloon3B.setCurve(50,50);
		viewObjects.add(balloon3B);
		balloon4B = new Button(100, 360, 120, 120, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(3, 3);
				balloonChosen = "Blue";
				dartChosen = BalloonBack.dartsProperty.get(3);
				description.setText("Score: " + score + "/nBalloon Popped: "+
		balloonChosen + "/nDart Used: " + dartChosen );
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			}
		} );
		balloon4B.setCurve(50,50);
		viewObjects.add(balloon4B);
		balloon5B = new Button(240, 360, 120, 120, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(4, 4);
				balloonChosen = "Green";
				dartChosen = BalloonBack.dartsProperty.get(4);
				description.setText("Score: " + score + "/nBalloon Popped: "+
		balloonChosen + "/nDart Used: " + dartChosen );
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			}
		} );
		balloon5B.setCurve(50,50);
		viewObjects.add(balloon5B);
		balloon6B = new Button(380, 360, 120, 120, "" , new Action() {
			
			@Override
			public void act() {
			//	BalloonBack.UpdateBalloons(5, 5);
				balloonChosen = "Gold";
				dartChosen = BalloonBack.dartsProperty.get(5);
				description.setText("Score: " + score + "/nBalloon Popped: "+
		balloonChosen + "/nDart Used: " + dartChosen );
				balloonDescription.setText("Balloon Popped:" + balloonChosen);
				dartDescription.setText("Dart Used: " + dartChosen);
			}
		} );
		balloon6B.setCurve(50,50);
		viewObjects.add(balloon6B);
		viewObjects.add(description);
		
		ticket = new Graphic (60,650,150,150, "poppingBalloons/ticket.png");
		viewObjects.add(ticket);
		
		dart1 = new Graphic (250,650,100,100,"poppingBalloons/dart1.png");
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
		
		
		

		
		
		
		
		
		
		
		
		
		
	}
	
	private ArrayList<String> getBalloons()
	{
		return BalloonBack.CreateBalloons();
	}

	private void changeTimer(String string) {
		Thread blink = new Thread(new Runnable() {

			@Override
			public void run() {
				//.setText(string);
				try {
					Thread.sleep(1000);
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
