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
	 * 	goldfish
	 */
	
	/*
	 * two arraylist:
	 * integer/string
	 * integer for balloon
	 * string for everything else?
	 */
	
	
	private Button menu;
	
	private double money;
	private int tickets; 
	
	public InventoryVickie(int width, int height) {
		super(width, height);
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

		money = 10;
		tickets = 0;
		
		arrEx();
		ClickableGraphic inventoryBackground =new ClickableGraphic(0,0, getWidth(), getHeight(), "resources/inventoryF.jpg");
		inventoryBackground.setAction(new Action() {

			@Override
			public void act() {
				TextArea test = new TextArea(100,100,200,200, "Test");
				viewObjects.add(test);
			}
			
		});
		menu = new Button(600, 400, 50, 50, "menu", Color.blue, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
			
		});
		
		viewObjects.add(inventoryBackground);
		viewObjects.add(menu);
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

	
}
