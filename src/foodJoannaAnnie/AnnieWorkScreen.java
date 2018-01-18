package foodJoannaAnnie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class AnnieWorkScreen extends ClickableScreen {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AnnieFoodItem[] toppings;
	private AnnieFoodItem[] items;
	private String[] toppingImgs;
	private String[] toppingImgs2;
	private String[] itemImgs;
	private String[] names;
	private double[] prices;

	private JoannaOrder currentOrder;
	private ArrayList<JoannaOrder> orders;
	private ArrayList<AnnieFoodItem> onScreen;
	
	private int trashCount;

	public AnnieWorkScreen(int width, int height) {
		super(width, height);
		setBackground(new Color(180, 230, 230));
		onScreen = new ArrayList<AnnieFoodItem>();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setBaseFont(new Font("Arial", Font.BOLD + Font.ITALIC, 30));
		String[] temp = {"food/pepperoni.png", "food/onion.png", "food/pineapple.png", "food/mushroom.png", "food/olive.png", "food/bacon.png", "food/pepper.png", "food/sausage.png"};
		toppingImgs = temp;
		String[] temp1 = {"food/pepperoni2.png", "food/onion2.png", "food/pineapple2.png", "food/mushroom2.png", "food/olive2.png", "food/bacon2.png", "food/pepper2.png", "food/sausage2.png"};
		toppingImgs2 = temp1;
		String[] temp2 = {"food/soda.png", "food/donut.png", "food/corn.png", "food/popcorn.png"};
		itemImgs = temp2;
		String[] temp3 = {"pepperoni", "onions", "pineapple", "mushrooms", "olives", "bacon", "peppers", "sausage",
				"soda", "donut", "corn", "popcorn"};
		names = temp3;
		double[] temp4 = {0.40, 0.20, 0.20, 0.25, 0.30, 0.40, 0.30, 0.35,
				1.25, 1.00, 1.50, 2.65};
		prices = temp4;
		Button done = new Button(getWidth() - 220, getHeight() - 160, 120, 60, "DONE", new Action() {
			public void act() {
				Testing.test.setScreen(new JoannaResultScreen(getWidth(), getHeight(), AnnieWorkScreen.this));
			}
			
		});
		viewObjects.add(done);
		Component tray = new Component(20, 40, 750, 500) {
			
			@Override
			public void update(Graphics2D g) {
				g.setColor(new Color(240, 240, 200));
				g.fillRect(0, 0, 700, 450);
				g.setColor(Color.black);
				g.drawRect(0, 0, 700, 450);
			}
		};
		tray.setVisible(true);
		viewObjects.add(tray);
		Graphic pizza = new Graphic(40, 60, 410, 410, "food/pizza.png");
		viewObjects.add(pizza);
		toppings = new AnnieFoodItem[toppingImgs.length];
		for(int i = 0; i < toppings.length; i++) {
			final int num = i;
			AnnieFoodItem item = new AnnieFoodItem(i * 50 + 50, getHeight() - 100, 50, 50, toppingImgs2[i], names[i], prices[i]);
			item.setAction(new Action() {
				
				@Override
				public void act() {
					viewObjects.add(new Graphic(50, 50, 60, 60, toppingImgs[num]));
					onScreen.add(item);
				}
			});
			viewObjects.add(item);
		}
	}

	public AnnieFoodItem[] getToppings() {
		return toppings;
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

	public JoannaOrder getCurrentOrder() {
		return currentOrder;
	}

	public ArrayList<AnnieFoodItem> getOnScreen() {
		return onScreen;
	}

	public int getTrashCount() {
		return trashCount;
	}

}
