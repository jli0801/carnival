package foodJoannaAnnie;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import mainMenuAreejVickie.GuiLoadingVickie;


public class JoannaResultScreen extends ClickableScreen {

	private Button home;
	private Button work;
	private TextArea description;
	private TextArea receipt;
	private int amt;
	private int earned;
	private AnnieWorkScreen annie;
	private JoannaOrder currentOrder;
	private ArrayList<AnnieFoodItem> onScreen;
	private int trashCount;
	private TextLabel serveHeader;
	private TextLabel orderHeader;

	public JoannaResultScreen(int width, int height, AnnieWorkScreen screen ) {
		super(width, height);
		annie = screen; 
		currentOrder= annie.getCurrentOrder();
		description.setText(currentOrder.toString());
		setVisible(true);
		  
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
	
		setBackground(new Color(255, 250, 155));
		serveHeader =new TextLabel(600, 75, 175, 30, "YOU SERVED:");
		orderHeader =new TextLabel(175, 75, 150, 30, "ORDER");
		viewObjects.add(serveHeader);
		viewObjects.add(orderHeader);
		home = new Button(100,650,100,50,"Menu",Color.RED,new guiTeacher.components.Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu); 

			}
		});
		work = new Button(300,650,100,50,"Work", Color.green,new guiTeacher.components.Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(annie);

			}
		});
		work.setBackground(Color.GREEN);
		
		
		description = new TextArea(125, 170, 300, 400, "");
		Component orderBox = new Component(125,170,300,400) {
			
			@Override
			public void update(Graphics2D g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		orderBox.setVisible(true);
		viewObjects.add(orderBox);
		viewObjects.add(home);
		viewObjects.add(work);


 
		viewObjects.add(description);
	
	

	}



}
