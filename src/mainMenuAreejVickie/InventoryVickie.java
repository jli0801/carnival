package mainMenuAreejVickie;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
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
	
	private static int[] darts;
	
	private static int dartsNum;
	private static ArrayList<String> itemsList;
	
	private InventoryVickie i;
	
	private Color purp = new Color(244,164,96);
	private Color fuchsia = new Color(255,0,255);
	private Color blood = new Color(239,23,56);
	
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

		//InventoryVickie i = new InventoryVickie(getWidth(), getHeight() );
		itemsList = new ArrayList<String>();
		
		int[]dart = {4,4,4,4};
		darts = dart;
		
		money = 10;
		tickets = 0;
		
		arrEx();
		
		Graphic inventoryBackground =new Graphic(0,0, getWidth(), getHeight(), "resources/inventoryF.jpg");
		
		Graphic banner1 =new Graphic(0,30,400, 200, "resources/banner1.png");
		Graphic banner2 =new Graphic(373,30,400, 200, "resources/banner2.png");
		
		Graphic b1 =new Graphic(0,30,300, 200, "resources/b1.png");
		Graphic b2 =new Graphic(296,25,300, 200, "resources/b2.png");
		
		Graphic b3 =new Graphic(590,30,300, 200, "resources/b1.png");
		Graphic b4 =new Graphic(888,25,300, 200, "resources/b2.png");
		
		Graphic cBanner =new Graphic(0,0,getWidth(), 200, "resources/cb.png");
		
		Graphic white = new Graphic (300,250,850,700, "resources/white.jpg"); 
		Graphic black = new Graphic (300,250, 860, 725, "resources/black.jpg");
		
		menu = new Button(10, 750, 50, 50, "menu", Color.blue, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
			
		});
		
		//viewObjects.add(inventoryBackground);
	
		
		viewObjects.add(menu);
		//viewObjects.add(banner1);
		//viewObjects.add(banner2);
		
		//viewObjects.add(b1);
		//viewObjects.add(b2);
		//viewObjects.add(b3);
		//viewObjects.add(b4);
		
		viewObjects.add(cBanner);
		viewObjects.add(black);
		viewObjects.add(white);
	}
	
	private static void updateDarts() {
		int dull = 0;
		int blunt = 0; 
		int sharp = 0;
		int dangerous = 0;
		
		//dull dart:0
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("dullDart")) {
				dull++;
			}
		}
		
		//blunt dart:1
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("bluntDart")) {
				dull++;
			}
		}
		
		//sharp dart:2
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("sharpDart")) {
				dull++;
			}
		}
		
		//dangerous dart:3
		for(int i = 0; i<itemsList.size();i++) {
			if(itemsList.get(i).equals("dangerousDart")) {
				dull++;
			}
		}
		
		
		darts[0] =dull;
		darts[1] =blunt;
		darts[2] =sharp;
		darts[3] =dangerous;
		
	}
	
	public  void arrEx()
    {
        /* ........... Normal Array............. */
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(arr[0]);
 
        /*............ArrayList..............*/
        // Create an arrayList with initial capacity 2
        ArrayList<Integer> arrL = new ArrayList<Integer>(2); //String
 
        // Add elements to ArrayList
        arrL.add(1);
        arrL.add(2);
 
        // Access elements of ArrayList
        System.out.println(arrL.get(0));
    }
	
	//private ArrayList<> inventory;

	
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
	
	public static int getDartNumber(int num) {
		//updateDarts();
		dartsNum = darts[num];
		return dartsNum;
	}
	
	public static int [] darts() {
		return darts;
	}
	
	
}
