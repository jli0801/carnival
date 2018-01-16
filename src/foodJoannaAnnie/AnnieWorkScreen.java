package foodJoannaAnnie;

import java.awt.Color;
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
	public static String[] names;
	public static double[] prices;

	private JoannaOrders currentOrder;
	private ArrayList<AnnieFoodItem> onScreen;
	
	private int trashCount;

	public AnnieWorkScreen(int width, int height) {
		super(width, height);
		setBackground(new Color(180, 230, 230));
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Button done = new Button(getWidth() - 100, getHeight() - 100, 100, 50, "done", new Action() {
			
			@Override
			public void act() {
				Testing.test.setScreen(new JoannaResultScreen(getWidth(), getHeight(), currentOrder, onScreen));
			}
		});
		viewObjects.add(done);
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
