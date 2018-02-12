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

public class InventoryVickie extends FullFunctionScreen{

	/*
	 * Available items:
	 * Integer ArrayList:
	 * 	4 indices, value default is 0, but changes as people buy it..... maybe....... or it could work for all of themmm..
	 * 
	 * Blunt Dart
	 * Dull Dart
	 * Sharp Dart
	 * Dangerous Dart
	 * 
	 * Hammer
	 * 
	 * Prizes:
	 * 
	 * 	teddy bear
	 * 	cotton candy
	 *  //more food
	 * 	goldfish
	 * 6 more prizes
	 */
	
	/*
	 * two arraylist:
	 * integer/string
	 * integer for balloon
	 * string for everything else?
	 */
	
	
	private Button menu;
	
	private static double money;
	private static int tickets; 

	private static int dartsNum;
	private static ArrayList<String> itemsList;
	
	private static ArrayList<DartJessica> darts;
	
	private Button store;
	
	private Color purp = new Color(244,164,96);
	private Color fuchsia = new Color(255,0,255);
	private Color blood = new Color(239,23,56);
	
	private static int dull;
	private static int blunt;
	private static int sharp;
	private static int dangerous;
	
	public InventoryVickie(int width, int height) {
		super(width, height);
		setBackground(purp);
		setVisible(true);
	}

	
	//https://www.javatpoint.com/java-arraylist
	/*
	 * https://beginnersbook.com/2013/12/java-arraylist/
	 * https://www.geeksforgeeks.org/arraylist-in-java/
	 * https://www.geeksforgeeks.org/array-vs-arraylist-in-java/
	 * https://www.tutorialspoint.com/java/java_arraylist_class.htm
	 * 
	 */
		
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		itemsList = new ArrayList<String>();
		
		//int[]dart = new int [4];
		//darts = dart;
		
		//default items
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
		
		money = 10;
		tickets = 0;
		
		//Inventory 
		TextLabel inventory = new TextLabel(512,155, 900, 200, "Inventory!!");
		/*
		 * make every other color red and the rest yellow
		 * make one letter change color: make it POP
		 */
		
		//background image
		Graphic inventoryBackground =new Graphic(0,0, getWidth(), getHeight(), "resources/inventoryF.jpg");
		
		//potential banner/borders
		Graphic banner1 =new Graphic(0,30,400, 200, "resources/banner1.png");
		Graphic banner2 =new Graphic(373,30,400, 200, "resources/banner2.png");
		
		Graphic b1 =new Graphic(0,30,300, 200, "resources/b1.png");
		Graphic b2 =new Graphic(296,25,300, 200, "resources/b2.png");
		
		Graphic b3 =new Graphic(590,30,300, 200, "resources/b1.png");
		Graphic b4 =new Graphic(888,25,300, 200, "resources/b2.png");
		
		//current banner
		Graphic cBanner =new Graphic(0,0,getWidth(), 200, "resources/cb.png");
		
		//screen
		Graphic white = new Graphic (300,275,850,700, "resources/white.jpg"); //700/4 = 175
		Graphic black = new Graphic (300,275, 860, 725, "resources/black.jpg");
		
		//items
		Graphic dullG = new Graphic (300,275,160,160, "poppingBalloons/dart1.png"); 
		Graphic bluntG = new Graphic (512,275,160,160, "poppingBalloons/dart2.png"); 
		Graphic sharpG = new Graphic (724,275,160,160, "poppingBalloons/dart3.png"); 
		Graphic dangerousG = new Graphic (936,275,160,160, "poppingBalloons/dart4.png"); 
		
		Graphic ticketG = new Graphic (30, 200, 50, 50, "resources/ticket.jpg");
		
		Graphic moneyG = new Graphic(150, 200, 30, 30, "resources/money.png");
		
				
		
		
		Graphic hammerG = new Graphic(300,500, 160,160, "resources/hammer.png");
		Graphic bearG = new Graphic(512,500,160,160, "resources/bear.png");
		Graphic cottonCandyG = new Graphic(724,500, 160,160,"resources/cottoncandy.png");

		Graphic fishG = new Graphic (936,500,160,160, "resources/fish.png");
		//numbers
		
		//updateDarts();
		
		TextLabel dullX = new TextLabel(390,330, 100, 100, "x"); //335
		TextLabel bluntX = new TextLabel(602,330, 100, 100, "x");
		TextLabel sharpX = new TextLabel(814,330, 100, 100, "x");
		TextLabel dangerousX = new TextLabel(1026,330, 100, 100, "x");

		TextLabel dullNum = new TextLabel(398,335, 100, 100, ""+dull+""); //335
		TextLabel bluntNum = new TextLabel(610,335, 100, 100, ""+blunt);
		TextLabel sharpNum = new TextLabel(821,335, 100, 100, ""+sharp);
		TextLabel dangerousNum = new TextLabel(1034,335, 100, 100, ""+dangerous);
		
		TextLabel ham = new TextLabel(398,560, 100, 100, "x 1"); //335
		TextLabel bea = new TextLabel(610,560, 100, 100, "     x 0");
		TextLabel cot = new TextLabel(821,560, 100, 100, "      x 0");
		TextLabel fis = new TextLabel(1034,560, 100, 100, "  x 0");
		
		TextLabel tic = new TextLabel(80,203, 100, 100, "x "+tickets);
		TextLabel mon = new TextLabel(175,203, 100, 100, "x $"+money);
		
		//description
		
		TextArea desc = new TextArea(100,265,250,600, " Keep \ntrack \n  of \n your \nstuff");
		
		
		
		//buttons
		menu = new Button(10, 690, 280, 75, "Menu", Color.red, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
			
		});
		
		/*Btest test = new Btest(100, 100, 100, 100, "THIS IS THE FREAKING Bfsd", null);
		TextArea t = test.getArea();
		//menu.hoverAction();
		*/
		
		store = new Button(10, 600, 280, 75, "Store", Color.yellow, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.store);
			}
			
		});
		
		//viewObjects.add(inventoryBackground);
	
		
		viewObjects.add(menu);
		viewObjects.add(store);
		//viewObjects.add(banner1);
		//viewObjects.add(banner2);
		
		//viewObjects.add(b1);
		//viewObjects.add(b2);
		//viewObjects.add(b3);
		//viewObjects.add(b4);
		
		
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
		
		viewObjects.add(desc);
		//viewObjects.add(test);
	
		/*if(menu.isHovered()) {
			menu.setText("HOVERED!");
			viewObjects.add(menu);
			viewObjects.add(t);
		}
		if(test.isHovered()) {
			test.setText("HOVERED!");
			viewObjects.add(t);
		}*/
		
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
			 
			 Font dartNumss=font.deriveFont(100f);
			 Font menuButton=font.deriveFont(40f);
			 Font d=font.deriveFont(50f);
			
		//	dullNum.setFont(dartNumss);
			//menu.setFont(menuButton); //make text orange
			
			//inventory label
			desc.setFont(d);
			desc.setForeground(Color.orange);
			desc.update();
			inventory.setFont(dartNumss);
			
			 } catch (Exception e) {

			 e.printStackTrace();

			 }
	}
	
	/*private static void updateDarts() {
		dull = 0;
		blunt = 0; 
		sharp = 0;
		dangerous = 0;
		
		//dull dart:0
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("dullDart")) {
				dull++;
			}
		}
		
		//blunt dart:1
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("bluntDart")) {
				blunt++;
			}
		}
		
		//sharp dart:2
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("sharpDart")) {
				sharp++;
			}
		}
		
		//dangerous dart:3
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("dangerousDart")) {
				dangerous++;
			}
		}
		
		
		darts[0] =dull;
		darts[1] =blunt;
		darts[2] =sharp;
		darts[3] =dangerous;
		
	}*/
	
	public static int getTickets() {
		return tickets;
	}
	
	public void setTickets(int num) {
		this.tickets = num;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(int num) {
		this.money = num;
	}
	
	/*public static int getDartNumber(int num) {
		updateDarts();
		dartsNum = darts[num];
		return dartsNum;
	}*/
	
	public static ArrayList<DartJessica> darts() {
		return darts;
	}
	
	public ArrayList<String> getInventoryArrayList() {
		return itemsList;
	}
	
	public void setInventoryArrayList(ArrayList<String> arr) {
		this.itemsList = arr;
	}
}
