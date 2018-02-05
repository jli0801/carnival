package foodJoannaAnnie;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import java.awt.Font;
import mainMenuAreejVickie.GuiLoadingVickie;


public class JoannaResultScreen extends ClickableScreen {

	private Button home;
	private Button work;
	private int amt;
	private int earned;
	private AnnieWorkScreen annie;
	private JoannaOrder currentOrder;
	private ArrayList<AnnieFoodItem> onScreen;
	private int trashCount;
	private TextLabel serveHeader;
	private TextLabel orderHeader;
	private TextArea bigOrder;
	private TextArea list;
	private TextArea profit;
	private TextArea trash;
	private TextArea total;


	public JoannaResultScreen(int width, int height, AnnieWorkScreen screen ) {
		super(width, height);
		annie = screen; 
		currentOrder= annie.getCurrentOrder();
		bigOrder.setText(currentOrder.toString());
		setVisible(true);
		onScreen = annie.getOnScreen();
		JoannaOrder order = new JoannaOrder(0, 0, 100, 130, "food/order.png", onScreen);
		order.setVisible(false);
		list.setText(order.toString());

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		setBackground(new Color(255, 250, 155));
		serveHeader =new TextLabel(600, 75, 250, 150, "YOU SERVED:");
		orderHeader =new TextLabel(175, 75,200, 150, "ORDER");

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
				annie.animation(annie.getViewObjects());

			}
		});
		work.setBackground(Color.GREEN);
		bigOrder= new TextArea(130, 145,295, 400,"");		

		Component orderBox = new Component(125,140,300,405) {

			@Override
			public void update(Graphics2D g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.BLACK);
				g.drawRect(0, 0, getWidth()-1, getHeight()-1);
			}
		};

		Component totalBox = new Component(550,140,500,600) {

			@Override
			public void update(Graphics2D g) {
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.BLACK);
				g.drawRect(0, 0, getWidth()-1, getHeight()-1);
			}
		};


		list = new TextArea(555, 145, 300, 400,"");
		profit= new TextArea(955, 45, 200, 400, "");
		trash = new TextArea(555, 550, 500, 95, "TRASH PENALTY");
		total = new TextArea(555, 650, 500, 95, "TOTAL");
		
		orderBox.setVisible(true);
		totalBox.setVisible(true);
		viewObjects.add(orderBox);
		viewObjects.add(totalBox);
		viewObjects.add(profit);
		viewObjects.add(list);
		viewObjects.add(home);
		viewObjects.add(work);
		viewObjects.add(bigOrder);
		viewObjects.add(serveHeader);
		viewObjects.add(orderHeader);
		viewObjects.add(trash);
		viewObjects.add(total);

		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			orderHeader.setFont(font.deriveFont(50f));
			serveHeader.setFont(font.deriveFont(50f));

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}

//	private String getItemsNames() {
//		
//	}
//
//}
