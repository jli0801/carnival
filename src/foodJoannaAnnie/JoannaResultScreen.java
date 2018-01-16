package foodJoannaAnnie;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;


public class JoannaResultScreen extends ClickableScreen {

	private Button home;
	private Button work;
	private TextLabel description;
//	private ArrayList<> orders;
	private int amt;
	private int earned;
	
	
	public JoannaResultScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		home = new Button(650,100,100,50,"Menu",new guiTeacher.components.Action() {
			
			@Override
			public void act() {
				///set to main menu screen
				
			}
		});
		
		work = new Button(650,100,100,50,"Work", new guiTeacher.components.Action() {
			
			@Override
			public void act() {
				Testing.test.setScreen(new AnnieWorkScreen(getWidth(), getHeight()));
			}
		});
		
		setBackground(Color.YELLOW);
	}

}
