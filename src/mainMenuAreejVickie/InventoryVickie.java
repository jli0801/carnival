package mainMenuAreejVickie;

import java.awt.Color;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import poppingBalloonsJessicaJi.BalloonBackJi;
import poppingBalloonsJessicaJi.DartJessica;

public class InventoryVickie extends FullFunctionScreen implements InventoryVickieInterface{

	private boolean firstTime;

	private Button menu;
	private Button store;

	private double money;
	private  int tickets;

	private static ArrayList<String> itemsList;
	private static ArrayList<DartJessica> darts;

	private Color purp = new Color(244, 164, 96);
	
	//store items
	private int dull;
	private int blunt;
	private int sharp;
	private int dangerous;
	
	//private static boolean hammer;
	
	private TextLabel mon;
	private TextLabel tic;
	
	//store prizes
	private int bearP;
	private int candyP;
	private int fishP;

	private TextLabel dullNum;
	private TextLabel bluntNum;
	private TextLabel sharpNum;
	private TextLabel dangerousNum;

	private TextLabel ham;
	private TextLabel bea;
	private TextLabel cot;
	private TextLabel fis;
	
	public InventoryVickie(int width, int height) {
		super(width, height);
		setBackground(purp);
		setVisible(true);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		if(firstTime==false) {
			firstTime =true;
			itemsList = new ArrayList<String>();
			darts = new ArrayList<DartJessica>();

			initializeDarts();
			money = 10;
			tickets = 0;
		}

		//Inventory
		TextLabel inventory = new TextLabel(512, 155, 900, 200, "Inventory!!");
		
		// current banner
		Graphic cBanner = new Graphic(0, 0, getWidth(), 200, "resources/cb.png");

		// screen
		Graphic white = new Graphic(300, 275, 850, 700, "resources/white.jpg"); 
		Graphic black = new Graphic(300, 275, 860, 725, "resources/black.jpg");

		// item pictures
		Graphic dullG = new Graphic(320, 295, 160, 160, "poppingBalloons/dart1.png");
		Graphic bluntG = new Graphic(532, 295, 160, 160, "poppingBalloons/dart2.png");
		Graphic sharpG = new Graphic(744, 295, 160, 160, "poppingBalloons/dart3.png");
		Graphic dangerousG = new Graphic(956, 295, 160, 160, "poppingBalloons/dart4.png");

		Graphic ticketG = new Graphic(30, 200, 50, 50, "resources/tickets1.png");
		Graphic moneyG = new Graphic(150, 200, 30, 30, "resources/money.png");

		Graphic hammerG = new Graphic(320, 500, 160, 160, "resources/hammer.png");
		Graphic bearG = new Graphic(532, 500, 160, 160, "resources/bear.png");
		Graphic cottonCandyG = new Graphic(744, 500, 160, 160, "resources/cottoncandy.png");
		Graphic fishG = new Graphic(956, 500, 160, 160, "resources/fish.png");
		
		//x's
		TextLabel dullX = new TextLabel(410, 350, 100, 100, "x");
		TextLabel bluntX = new TextLabel(622, 350, 100, 100, "x");
		TextLabel sharpX = new TextLabel(834, 350, 100, 100, "x");
		TextLabel dangerousX = new TextLabel(1046, 350, 100, 100, "x");

		//display num. of items
		dullNum = new TextLabel(418, 355, 100, 100, "" + dull + "");
		bluntNum = new TextLabel(630, 355, 100, 100, "" + blunt);
		sharpNum = new TextLabel(842, 355, 100, 100, "" + sharp);
		dangerousNum = new TextLabel(1054, 355, 100, 100, "" + dangerous);
		
		ham = new TextLabel(418, 580, 100, 100, "    x 1");
		bea = new TextLabel(630, 580, 100, 100, "          x "+bearP);
		cot = new TextLabel(851, 580, 100, 100, "    x " + candyP);
		fis = new TextLabel(1054, 580, 100, 100, "   x "+fishP);
	
		tic = new TextLabel(80, 203, 100, 100, "x " + tickets);
		mon = new TextLabel(175, 203, 100, 100, "x $" + String.format("%.2f",money));
		
		//buttons
		menu = new Button(10, 690, 280, 75, "Menu", Color.red, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
		});
		
		store = new Button(10, 600, 280, 75, "Store", Color.yellow, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.store);
			}
		});

		viewObjects.add(menu);
		viewObjects.add(store);
		
		viewObjects.add(cBanner);
		viewObjects.add(black);
		viewObjects.add(white);

		viewObjects.add(dullG);
		viewObjects.add(bluntG);
		viewObjects.add(sharpG);
		viewObjects.add(dangerousG);

		viewObjects.add(inventory);

		viewObjects.add(ticketG);
		viewObjects.add(moneyG);
		viewObjects.add(bearG);
		viewObjects.add(hammerG);
		viewObjects.add(cottonCandyG);
		viewObjects.add(fishG);

		viewObjects.add(dullX);
		viewObjects.add(bluntX);
		viewObjects.add(sharpX);
		viewObjects.add(dangerousX);

		viewObjects.add(dullNum);
		viewObjects.add(bluntNum);
		viewObjects.add(sharpNum);
		viewObjects.add(dangerousNum);

		viewObjects.add(ham);
		viewObjects.add(bea);
		viewObjects.add(cot);
		viewObjects.add(fis);

		viewObjects.add(tic);
		viewObjects.add(mon);
		
		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font dartNumss = font.deriveFont(100f);
			Font menuButton = font.deriveFont(40f);
			Font d = font.deriveFont(50f);
			
			inventory.setFont(dartNumss);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initializeDarts() {
		for (int i = 0; i < 4; i++) {
			itemsList.add("dullDart");
			itemsList.add("bluntDart");
			itemsList.add("sharpDart");
			itemsList.add("dangerousDart");
			
			dull++;
			blunt++;
			sharp++;
			dangerous++;
			
			darts.add(new DartJessica("Dull"));
			darts.add(new DartJessica("Blunt"));
			darts.add(new DartJessica("Strong"));
			darts.add(new DartJessica("Dangerous"));
		}
	}
	
	public void updateAllVariables() { //call from store
		updateDarts();
		amtOfBears();
		amtOfFish();
		amtOfCandy();
	}
	
	public void updateDarts() {

		darts = new ArrayList<DartJessica>();

		//if the user bought darts in the store, add it to the darts arraylist, and remove it from
		//inventory arraylist. then update darts
		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).equals("dullDart")) {
				darts.add(new DartJessica("Dull"));
				itemsList.remove(i);
			}

			if (itemsList.get(i).equals("bluntDart")) {
				darts.add(new DartJessica("Blunt"));
				itemsList.remove(i);
			}

			if (itemsList.get(i).equals("sharpDart")) {
				darts.add(new DartJessica("Strong"));
				itemsList.remove(i);
			}

			if (itemsList.get(i).equals("dangerousDart")) {
				darts.add(new DartJessica("Dangerous"));
				itemsList.remove(i);
			}
		}

		for (int i = 0; i < dull; i++) darts.add(new DartJessica("Dull"));
		for (int i = 0; i < blunt; i++) darts.add(new DartJessica("Blunt"));
		for (int i = 0; i < sharp; i++) darts.add(new DartJessica("Strong"));
		for (int i = 0; i < dangerous; i++) darts.add(new DartJessica("Dangerous"));

		dull =0;
		blunt = 0;
		sharp = 0;
		dangerous = 0;
		
		for (int i = 0; i < darts.size(); i++) {
			if (darts.get(i).getType().equals("Dull"))  
				dull++;

			if(darts.get(i).getType().equals("Blunt")) 
				blunt++; 
				
			if(darts.get(i).getType().equals("Strong")) 
				sharp++; 
			
			if(darts.get(i).getType().equals("Dangerous")) 
				dangerous++; 
		}
		
		dullNum.setText("" + dull + "");
		bluntNum.setText("" + blunt + "");
		sharpNum.setText("" + sharp + "");
		dangerousNum.setText("" + dangerous + "");
	
	}
	
	public void amtOfBears() {
		for(int i = 0; i<itemsList.size(); i++) {
			if (itemsList.get(i).equals("bear")) bearP++;
		}
		bea.setText("          x "+bearP);
	}
	
	public void amtOfFish() {
		for(int i = 0; i<itemsList.size(); i++) {
			if (itemsList.get(i).equals("fish")) fishP++;
		}
		fis.setText("   x "+fishP);
	}
	
	public void amtOfCandy() {
		for(int i = 0; i<itemsList.size(); i++) {
			if (itemsList.get(i).equals("candy")) candyP++;
		}
		cot.setText("    x " + candyP);
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int num) {
		tickets = num;
		String t = ""+tickets;
		tic.setText(t);
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double num) {
		money = num;
		mon.setText("x $" + String.format("%.2f",money));
	}

	public ArrayList<DartJessica> darts() {
		return darts;
	}

	public ArrayList<String> getInventoryArrayList() {
		return itemsList;
	}

	public void setInventoryArrayList(ArrayList<String> arr) {
		itemsList = arr;
	}

	@Override
	public void setDarts(String dullS, String bluntS, String sharpS, String danS) {
		dull = Integer.parseInt(dullS);
		blunt = Integer.parseInt(bluntS);
		sharp = Integer.parseInt(sharpS);
		dangerous = Integer.parseInt(danS);
		
		dullNum.setText("" + dullS + "");
		bluntNum.setText("" + bluntS + "");
		sharpNum.setText("" + sharpS + "");
		dangerousNum.setText("" + danS + "");
	}


}
