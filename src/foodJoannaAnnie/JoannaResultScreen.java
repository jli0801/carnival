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
import guiTeacher.userInterfaces.FullFunctionScreen;

import java.awt.Font;
import mainMenuAreejVickie.GuiLoadingVickie;


public class JoannaResultScreen extends FullFunctionScreen {

	private Button home;
	private Button work;
	
	private double earned;
	private double trashCount;
	private double[] prices;	
	private double trashAmt;

	private AnnieWorkScreen annie;
	private Object[][] onScreen;

	private Object[][] currentOrder;
	private JoannaOrder orderInstance;

	private TextLabel serveHeader;
	private TextLabel orderHeader;

	private TextArea bigOrder;
	private TextArea list;
	private TextArea profit;
	private TextArea trash;
	private TextArea trashCost;
	private TextArea total;
	private TextArea totalCost;
	


	public JoannaResultScreen(int width, int height, AnnieWorkScreen screen ) {
		super(width, height);
		annie = screen; 
		currentOrder= annie.getCurrentOrder().getOrder();
		setVisible(true);
		orderInstance = new JoannaOrder(0, 0, 100, 130, "food/order.png", annie.getOnScreen(),currentOrder);
		orderInstance.setVisible(false);
		onScreen = orderInstance.getOrder();
		separatePrices();
		trashCount = annie.getTrashCount();
		bigOrder.setText(annie.getCurrentOrder().toString());
		list.setText(orderInstance.toString());
		profit.setText(displayPrices());
		trashCost.setText(displayTrash());
		totalCost.setText(calcTotal());
	}




	private String calcTotal() {
		earned = 6 + trashAmt;
		for(int i =0; i <prices.length; i++) {
			earned += prices[i] ;
		}
		String s = "$"+ String.format("%.2f",earned);
		return s;

	}




	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		setBackground(new Color(255, 250, 155));
		serveHeader = new TextLabel(600, 75, 250, 150, "YOU SERVED:");
		orderHeader = new TextLabel(175, 75,200, 150, "ORDER");

		home = new Button(100,650,100,50,"Menu",Color.RED,new guiTeacher.components.Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu); 
				annie.resetTray(annie.getViewObjects());
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
		bigOrder= new TextArea(125, 170,270, 360,"");		

		Component orderBox = new Component(100,150,320,400) {

			@Override
			public void update(Graphics2D g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.BLACK);
				g.drawRect(0, 0, getWidth()-1, getHeight()-1);
			}
		};

//		Component totalBox = new Component(550,140,500,600) {
//
//			@Override
//			public void update(Graphics2D g) {
//				g.setStroke(new BasicStroke(5));
//				g.setColor(Color.BLACK);
//				g.drawRect(0, 0, getWidth()-1, getHeight()-1);
//			}
//		};
		
		list = new TextArea(555, 170, 300, 400,"");
		profit = new TextArea(955, 170, 200, 400, "");
		trash = new TextArea(555, 600, 500, 95, "TRASH PENALTY");
		trashCost = new TextArea(955, 600, 500, 95, "");
		total = new TextArea(555, 650, 500, 95, "TOTAL");
		totalCost = new TextArea(955, 650, 500, 95, "");

		orderBox.setVisible(true);
//		totalBox.setVisible(true);
		viewObjects.add(orderBox);
//		viewObjects.add(totalBox);
		viewObjects.add(profit);
		viewObjects.add(list);
		viewObjects.add(home);
		viewObjects.add(work);
		viewObjects.add(bigOrder);
		viewObjects.add(serveHeader);
		viewObjects.add(orderHeader);
		viewObjects.add(trash);
		viewObjects.add(trashCost);
		viewObjects.add(total);
		viewObjects.add(totalCost);

		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			orderHeader.setFont(font.deriveFont(50f));
			serveHeader.setFont(font.deriveFont(50f));

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	private void compareToOrder() {
		//for(int i = 0; i < order  )
			// check to c if topping is even in seq then compare quantity
	}

	private String displayPrices() {
		String s = "6.00";
		for(int i =0; i < prices.length; i++ ) {
			s+= "\n"+ String.format("%.2f", prices[i]);
		}
		return s;
	}

	private String displayTrash() {
		String s = "$0.00";
		if(trashCount > 0) {
			trashAmt = trashCount*-3;
			s = "$"+ String.format("%.2f",trashAmt);

		}

		return s;
	}

	private void separatePrices() {
		prices = new double[onScreen.length];

		for(int i = 0; i < onScreen.length; i++ ) {
			double price = (((AnnieFoodItem) onScreen[i][1]).getPrice());
			int num= calcDiff(i);
			double a = price * num;
			prices[i] = Math.round( a * 100.0)/100.0;
		}
		
	}




	private int calcDiff(int i) {
		int n = toppingExist(i);
		int diff;
		if(n != -1){
			diff = (int)currentOrder[n][0] - (int)onScreen[i][0];
		}else {
			diff = (int)onScreen[i][0];
		}
		diff = (Math.abs(diff)) *-1;
		return diff;
	}




	private int toppingExist(int i) {
		for(int j = 0; j < currentOrder.length; j++) {
			if(onScreen[i][1] == currentOrder[j][1]) {
				return j;
			}
		}
		return -1;
	}




	
}
