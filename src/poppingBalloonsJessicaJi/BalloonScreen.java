package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BalloonScreen extends FullFunctionScreen  {
	
//	public static mainMenuAreejVickie.choseGame menu; Where user chooses games.

	public BalloonScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Button back = new Button(100, 100, 100, 100, "Back" , Color.YELLOW, new Action() {
			
			@Override
			public void act() {
		//		setScreen(menu);
			}
		} );
		
		viewObjects.add(back);

	}



}
