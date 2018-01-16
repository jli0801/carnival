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
	private TextArea description;
	private TextArea receipt;
	private int amt;
	private int earned;
	private AnnieWorkScreen annie;

	public JoannaResultScreen(int width, int height, JoannaOrders orders, ) {
		super(width, height);
		annie = workspace;
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.YELLOW);


		home = new Button(100,650,100,50,"Menu",new guiTeacher.components.Action() {

			@Override
			public void act() {
				///set to main menu screen

			}
		});

		home.setBackground(Color.GREEN);
		work = new Button(300,650,100,50,"Work", new guiTeacher.components.Action() {

			@Override
			public void act() {
				Testing.test.setScreen(new AnnieWorkScreen(getWidth(), getHeight()));
			}
		});

		description = new TextArea(300, 100, 150, 500, "text goes here");
		description.setBackground(Color.WHITE);

		viewObjects.add(home);
		viewObjects.add(work);
		viewObjects.add(description);

	}

}
