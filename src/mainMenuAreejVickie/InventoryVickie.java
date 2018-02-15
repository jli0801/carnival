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
import poppingBalloonsJessicaJi.DartJessica;

public class InventoryVickie extends FullFunctionScreen implements InventoryMethods{

	private boolean firstTime;
	private boolean trigger;
	
	private Button menu;
	private Button store;

	private double money;
	private  int tickets;

	private static ArrayList<String> itemsList;
	private static ArrayList<DartJessica> darts;

	
	private Color purp = new Color(244, 164, 96);
	//private Color fuchsia = new Color(255, 0, 255);
	//private Color blood = new Color(239, 23, 56);

	//store items
	private static int dull;
	private static int blunt;
	private static int sharp;
	private static int dangerous;
	
	private static boolean hammer;
	
	private TextLabel mon;
	private TextLabel tic;
	
	//store prizes
	private int bearP;
	private int candyP;
	private int fishP;
	private boolean trigger2;
	
	
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
		
		System.out.print("Vickie"+tickets);
		System.out.print("Vickie" +money);
		
		initializeDarts();
		
		updateDarts();
		amtOfBears();
		amtOfFish();
		amtOfCandy();

		// Inventory
		TextLabel inventory = new TextLabel(512, 155, 900, 200, "Inventory!!");
		/*
		 * make every other color red and the rest yellow make one letter change color:
		 * make it POP
		 */

		// background image
		// Graphic inventoryBackground =new Graphic(0,0, getWidth(), getHeight(),
		// "resources/inventoryF.jpg");

		// potential banner/borders
		// Graphic banner1 =new Graphic(0,30,400, 200, "resources/banner1.png");
		// Graphic banner2 =new Graphic(373,30,400, 200, "resources/banner2.png");

		// Graphic b1 =new Graphic(0,30,300, 200, "resources/b1.png");
		// Graphic b2 =new Graphic(296,25,300, 200, "resources/b2.png");

		// Graphic b3 =new Graphic(590,30,300, 200, "resources/b1.png");
		// Graphic b4 =new Graphic(888,25,300, 200, "resources/b2.png");

		// current banner
		Graphic cBanner = new Graphic(0, 0, getWidth(), 200, "resources/cb.png");

		// screen
		Graphic white = new Graphic(300, 275, 850, 700, "resources/white.jpg"); // 700/4 = 175
		Graphic black = new Graphic(300, 275, 860, 725, "resources/black.jpg");

		// items
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
		// numbers

		// updateDarts();

		TextLabel dullX = new TextLabel(410, 350, 100, 100, "x"); // 335
		TextLabel bluntX = new TextLabel(622, 350, 100, 100, "x");
		TextLabel sharpX = new TextLabel(834, 350, 100, 100, "x");
		TextLabel dangerousX = new TextLabel(1046, 350, 100, 100, "x");

		TextLabel dullNum = new TextLabel(418, 355, 100, 100, "" + dull + ""); // 335
		
		TextLabel bluntNum = new TextLabel(630, 355, 100, 100, "" + blunt);
		
		TextLabel sharpNum = new TextLabel(842, 355, 100, 100, "" + sharp);
		
		TextLabel dangerousNum = new TextLabel(1054, 355, 100, 100, "" + dangerous);
		TextLabel ham = new TextLabel(418, 580, 100, 100, "    x 1"); // 335
		TextLabel bea = new TextLabel(630, 580, 100, 100, "          x "+bearP);
		
		TextLabel cot = new TextLabel(851, 580, 100, 100, "    x " + candyP);
		
		TextLabel fis = new TextLabel(1054, 580, 100, 100, "   x "+fishP);
		

		 tic = new TextLabel(80, 203, 100, 100, "x " + tickets);
		
		
		mon = new TextLabel(175, 203, 100, 100, "x $" + String.format("%.2f",money));
		
		// description

		//TextArea desc = new TextArea(100, 265, 250, 600, " Keep \ntrack \n  of \n your \nstuff");

		// buttons
		menu = new Button(10, 690, 280, 75, "Menu", Color.red, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}

		});

		/*
		 * Btest test = new Btest(100, 100, 100, 100, "THIS IS THE FREAKING Bfsd",
		 * null); TextArea t = test.getArea(); //menu.hoverAction();
		 */

		store = new Button(10, 600, 280, 75, "Store", Color.yellow, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.store);
			}

		});

		// viewObjects.add(inventoryBackground);

	/*	if (trigger==false) {
			//trigger2 =true;
			dullNum.setText("" + dull + "");
			System.out.print(dull);
			bluntNum.setText("" + blunt + "");
			sharpNum.setText("" + sharp + "");
			dangerousNum.setText("" + dangerous + "");
			bea.setText("          x "+bearP);
			cot.setText("    x " + candyP);
			fis.setText("   x "+fishP);
			tic.setText("x " + tickets);
			System.out.print(tickets);
			mon.setText("x $" + String.format("%.2f",money));
			
			dullNum.update();
			tic.update();
			
		}
		
		if(trigger2 ==true) {
			//trigger = false;
			dullNum.setText("" + dull + "");
			System.out.print(dull);
			bluntNum.setText("" + blunt + "");
			sharpNum.setText("" + sharp + "");
			dangerousNum.setText("" + dangerous + "");
			bea.setText("          x "+bearP);
			cot.setText("    x " + candyP);
			fis.setText("   x "+fishP);
			tic.setText("x " + tickets);
			System.out.print(tickets);
			mon.setText("x $" + String.format("%.2f",money));
		}*/
		viewObjects.add(menu);
		viewObjects.add(store);
		// viewObjects.add(banner1);
		// viewObjects.add(banner2);

		// viewObjects.add(b1);
		// viewObjects.add(b2);
		// viewObjects.add(b3);
		// viewObjects.add(b4);

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

	//	viewObjects.add(desc);
		// viewObjects.add(test);

		/*
		 * if(menu.isHovered()) { menu.setText("HOVERED!"); viewObjects.add(menu);
		 * viewObjects.add(t); } if(test.isHovered()) { test.setText("HOVERED!");
		 * viewObjects.add(t); }
		 */

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

			// dullNum.setFont(dartNumss);
			// menu.setFont(menuButton); //make text orange

			// inventory label
		//	desc.setFont(d);
		//	desc.setForeground(Color.orange);
			//desc.update();
			inventory.setFont(dartNumss);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void initializeDarts() {
		itemsList.add("dullDart");
		itemsList.add("dullDart");
		itemsList.add("dullDart");
		itemsList.add("dullDart");

		itemsList.add("bluntDart");
		itemsList.add("bluntDart");
		itemsList.add("bluntDart");
		itemsList.add("bluntDart");

		itemsList.add("sharpDart");
		itemsList.add("sharpDart");
		itemsList.add("sharpDart");
		itemsList.add("sharpDart");

		itemsList.add("dangerousDart");
		itemsList.add("dangerousDart");
		itemsList.add("dangerousDart");
		itemsList.add("dangerousDart");

		for (int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).equals("dullDart")) {
				darts.add(new DartJessica("Dull"));
			}

			if (itemsList.get(i).equals("bluntDart")) {
				darts.add(new DartJessica("Blunt"));
			}

			if (itemsList.get(i).equals("sharpDart")) {
				darts.add(new DartJessica("Strong"));
			}

			if (itemsList.get(i).equals("dangerousDart")) {
				darts.add(new DartJessica("Dangerous"));
			}
		}
		
		System.out.print(darts.get(1).getType());
	}
	/*private void addMoney() {
		money++;
		System.out.print(money);
	}*/

	public void updateDarts() {
		dull = 0; 
		blunt = 0; 
		sharp = 0; 
		dangerous = 0;
		
		/*ArrayList<DartJessica> jessicas = new ArrayList<DartJessica>();
		
		jessicas = getNewDarts();
		
		for(int i = 0; i<jessicas.size(); i++) {
			if(jessicas.get(i).equals("Dull")) {
				itemsList.add("dullDart");
			}
			if(jessicas.get(i).equals("Blunt")) {
				itemsList.add("bluntDart");
			}
			if(jessicas.get(i).equals("Strong")) {
				itemsList.add("sharpDart");
			}
			if(jessicas.get(i).equals("Dangerous")) {
				itemsList.add("dangerousDart");
			}
		}
		
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
		}*/
		
		for(int i = 0; i< darts.size(); i++ ) {
			if(darts.get(i).getType().equals("Dull"))  
				dull++;

			if(darts.get(i).getType().equals("Blunt")) 
				blunt++; 
				
			if(darts.get(i).getType().equals("Strong")) 
				sharp++; 
			
			if(darts.get(i).getType().equals("Dangerous")) 
				dangerous++; 
		}
	
	  }
	
	public void amtOfBears() {
		for(int i = 0; i<itemsList.size(); i++) {
			if (itemsList.get(i).equals("bear")) {
				bearP ++;
			}
		}
	}
	
	public void amtOfFish() {
		for(int i = 0; i<itemsList.size(); i++) {
			if (itemsList.get(i).equals("fish")) {
				fishP ++;
			}
		}
	}
	
	public void amtOfCandy() {
		for(int i = 0; i<itemsList.size(); i++) {
			if (itemsList.get(i).equals("candy")) {
				candyP ++;
			}
		}
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
	
	/*public void setJessdarts(ArrayList<DartJessica> update) {
		this.darts = update;
	}*/

	public ArrayList<String> getInventoryArrayList() {
		return itemsList;
	}

	public void setInventoryArrayList(ArrayList<String> arr) {
		InventoryVickie.itemsList = arr;
	}
	
	public void setHammer(boolean n) {
		InventoryVickie.hammer = n;
	}
	
	public boolean getHammer() {
		return hammer;
	}

	@Override
	public void updateVariables() {
		// TODO Auto-generated method stub
		
	}
}
