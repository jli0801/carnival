package foodJoannaAnnie;

import java.awt.Color;
import java.awt.Font;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class AnnieWorkScreen extends ClickableScreen {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static AnnieFoodItem[] items;
	public String[] imgLocations;
	public String[] imgLocations2;
	private String[] names;
	private double[] prices;

	private JoannaOrders currentOrder;
	private ArrayList<JoannaOrders> orders;
	private ArrayList<AnnieFoodItem> onScreen;
	
	private int trashCount;

	public AnnieWorkScreen(int width, int height) {
		super(width, height);
		setBackground(new Color(180, 230, 230));
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		String[] temp = {"food/pepperoni.png", "food/onion.png", "food/pineapple.png", "food/mushroom.png", "food/olive.png", "food/bacon.png", "food/pepper.png", "food/sausage.png",
				"food/soda.png", "food/donut.png", "food/corn.png", "food/popcorn.png"};
		imgLocations = temp;
		String[] temp1 = {"food/pepperoni2.png", "food/onion2.png", "food/pineapple2.png", "food/mushroom2.png", "food/olive2.png", "food/bacon2.png", "food/pepper2.png", "food/sausage2.png",
				"food/soda.png", "food/donut.png", "food/corn.png", "food/popcorn.png"};
		imgLocations2 = temp1;
		String[] temp2 = {"pepperoni", "onions", "pineapple", "mushrooms", "olives", "bacon", "peppers", "sausage",
				"soda", "donut", "corn", "popcorn"};
		names = temp2;
		double[] temp3 = {0.40, 0.20, 0.20, 0.25, 0.30, 0.40, 0.30, 0.35,
				1.25, 1.00, 1.50, 2.65};
		prices = temp3;
		StyledComponent.setBaseFont(new Font("Arial", Font.BOLD + Font.ITALIC, 30));
		Button done = new Button(getWidth() - 220, getHeight() - 160, 120, 60, "DONE", new Action() {
			public void act() {
				
			}
			
		});
		viewObjects.add(done);
		AnnieTray tray = new AnnieTray(10, 30, 701, 500);
		viewObjects.add(tray);
		items = new AnnieFoodItem[8];
		for(int i = 0; i < items.length; i++) {
			final int num = i;
			AnnieFoodItem item = new AnnieFoodItem(0, 0, 100, 100, imgLocations2[i], names[i], prices[i]);
			item.setAction(new Action() {
				
				@Override
				public void act() {
					viewObjects.add(new Graphic(50, 50, imgLocations[num]));
				}
			});
			viewObjects.add(item);
		}
	}

	public AnnieFoodItem[] getItems() {
		return items;
	}

	public String[] getNames() {
		return names;
	}

	public double[] getPrices() {
		return prices;
	}

	public JoannaOrders getCurrentOrder() {
		return currentOrder;
	}

	public ArrayList<AnnieFoodItem> getOnScreen() {
		return onScreen;
	}

	public int getTrashCount() {
		return trashCount;
	}

}
