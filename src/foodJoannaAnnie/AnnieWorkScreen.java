package foodJoannaAnnie;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.File;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class AnnieWorkScreen extends ClickableScreen {
	
	private static final long serialVersionUID = 1L;

	private AnnieFoodItem[] toppings;
	private AnnieFoodItem[] items;
	private String[] toppingImgs;
	private String[] toppingImgs2;
	private String[] itemImgs;
	private String[] names;
	private double[] prices;

	private ArrayList<JoannaOrder> orders;
	private ArrayList<AnnieFoodItem> onScreen;
	private JoannaOrder currentOrder;	
	private int trashCount;
	
	private Component tray;
	private Graphic pizza;

	public AnnieWorkScreen(int width, int height) {
		super(width, height);
		setBackground(new Color(180, 230, 230));
		onScreen = new ArrayList<AnnieFoodItem>();
		trashCount = 0;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		
		try {
			File fontFile = new File("food/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(60f);
			StyledComponent.setBaseFont(baseFont);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
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
		
		tray = new Component(20, 40, 700, 450) {
			
			public void update(Graphics2D g) {
				g.setColor(new Color(240, 240, 200));
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.black);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
			
		};
		tray.setVisible(true);
		viewObjects.add(tray);
		
		pizza = new Graphic(40, 100, 330, 330, "food/pizza.png");
		viewObjects.add(pizza);
		
		toppings = new AnnieFoodItem[toppingImgs.length];
		for(int i = 0; i < toppings.length; i++) {
			final int num = i;
			int x = (i % 4) * 120 + 20;
			int y;
			if(i < toppings.length / 2)
				y = getHeight() - 280;
			else
				y = getHeight() - 160;
			Component box = new Component(x, y, 100, 100) {

				public void update(Graphics2D g) {
					g.setColor(new Color(225, 225, 225));
					g.fillRect(0, 0, getWidth(), getHeight());
					g.setStroke(new BasicStroke(5));
					g.setColor(Color.black);
					g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
				}
				
			};
			box.setVisible(true);
			viewObjects.add(box);
			AnnieFoodItem item = new AnnieFoodItem(x, y, 100, 100, toppingImgs2[i], names[i], prices[i]);
			item.setAction(new Action() {
				
				private int x;
				private int y;
				
				public void act() {
					generateXY();
					viewObjects.add(new Graphic(getRandomX(), getRandomY(), 40, 40, toppingImgs[num]));
					onScreen.add(item);
				}
				
				public void generateXY() {
					x = (int)(Math.random() * 270 + 50);
					y = (int)(Math.random() * 270 + 110);
					while(Math.pow(x - 184, 2) + Math.pow(y - 244, 2) > Math.pow(120, 2)) {
						x = (int)(Math.random() * 270 + 50);
						y = (int)(Math.random() * 270 + 110);
					}
				}

				private int getRandomX() {
					return x;
				}

				private int getRandomY() {
					return y;
				}
				
			});
			viewObjects.add(item);
		}
		
		Component box1 = new Component(getWidth() - 365, getHeight() - 160, 200, 100) {
			
			public void update(Graphics2D g) {
				g.setColor(new Color(60, 180, 120));
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.black);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
			
		};
		box1.setVisible(true);
		viewObjects.add(box1);
		Button done = new Button(getWidth() - 365, getHeight() - 160, 200, 100, "DONE", new Action() {
			
			public void act() {
				Testing.test.setScreen(new JoannaResultScreen(getWidth(), getHeight(), AnnieWorkScreen.this));
				resetTray(viewObjects);
				trashCount = 0;
			}
			
		});
		viewObjects.add(done);
		
		Component box2 = new Component(getWidth() - 145, getHeight() - 160, 100, 100) {
			
			public void update(Graphics2D g) {
				g.setColor(new Color(250, 50, 50));
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.black);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
			
		};
		box2.setVisible(true);
		viewObjects.add(box2);
		ClickableGraphic trash = new ClickableGraphic(getWidth() - 145, getHeight() - 160, 100, 100, "food/trash.png");
		trash.setAction(new Action() {

			public void act() {
				resetTray(viewObjects);
				trashCount++;
			}
			
		});
		viewObjects.add(trash);

	}

	protected void resetTray(List<Visible> viewObjects) {
		onScreen.clear();
		viewObjects.add(tray);
		viewObjects.add(pizza);		
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
