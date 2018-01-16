package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BalloonScreen extends FullFunctionScreen  {
	
//	public static mainMenuAreejVickie.choseGame menu; Where user chooses games.

	public Graphic background;
	public Graphic ticket;
	public Graphic booth;
	public static Graphic dart1; //ji uses this in her class so it's static
	public static Graphic dart2;
	public static Graphic dart3;
	public static Graphic dart4;
	public BalloonScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void resizeComponents()
	{
		background.loadImages( "images/background.jpg", getWidth(), getHeight());
	
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, getWidth(), getHeight(), "images/background.jpg");
		viewObjects.add(background);
		
		
		booth = new Graphic (30,35, 590,590, "images/booth.png");
		viewObjects.add(booth);
		
		Button back = new Button(85, 650, 90, 70, "Back", new Action() {
			
			@Override
			public void act() {
		//		setScreen(menu);
			}
		} );
		
		viewObjects.add(back);
		ticket = new Graphic (60,650,150,150, "images/ticket.png");
		viewObjects.add(ticket);
		
		dart1 = new Graphic (250,650,100,100,"images/dart1.png");
		viewObjects.add(dart1);
		dart2 = new Graphic (350,650,100,100,"images/dart2.png");
		viewObjects.add(dart2);
		dart3 = new Graphic (450,650,100,100,"images/dart3.png");
		viewObjects.add(dart3);
		dart4 = new Graphic (550,650,100,100,"images/dart4.png");
		viewObjects.add(dart4);
		

	}



}
