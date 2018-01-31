package foodJoannaAnnie;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class AnnieWorkScreen extends ClickableScreen {
	
	private static final long serialVersionUID = 1L;
	
	private String[] toppingImgs;
	private String[] toppingImgs2;
	private String[] itemImgs;
	private String[] itemImgs2;
	private String[] names;
	private double[] prices;
	private AnnieFoodItem[] toppings;
	private AnnieFoodItem[] items;

	private int[] orderX;
	private ArrayList<Component> papers;
	private ArrayList<JoannaOrder> orders;
	private ArrayList<AnnieFoodItem> onScreen;
	private ArrayList<Graphic> stuff;
	
	private Component tray;
	private Graphic pizza;
	private TextArea bigOrder;
	private int trashCount;
	private JoannaOrder currentOrder;	

	public AnnieWorkScreen(int width, int height) {
		super(width, height);
		setBackground(new Color(180, 230, 230));
		onScreen = new ArrayList<AnnieFoodItem>();
		stuff = new ArrayList<Graphic>();
		trashCount = 0;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		
		String[] temp = {"food/pepperoni.png", "food/onion.png", "food/pineapple.png", "food/mushroom.png", "food/olive.png", "food/bacon.png", "food/pepper.png", "food/sausage.png"};
		toppingImgs = temp;
		String[] temp1 = {"food/pepperoni2.png", "food/onion2.png", "food/pineapple2.png", "food/mushroom2.png", "food/olive2.png", "food/bacon2.png", "food/pepper2.png", "food/sausage2.png"};
		toppingImgs2 = temp1;
		String[] temp2 = {"food/soda.png", "food/donut.png", "food/corndog.png", "food/popcorn.png"};
		itemImgs = temp2;
		String[] temp3 = {"food/soda2.png", "food/donut2.png", "food/corndog2.png", "food/popcorn2.png"};
		itemImgs = temp3;
		String[] temp4 = {"pepperoni", "onions", "pineapple", "mushrooms", "olives", "bacon", "peppers", "sausage",
				"soda", "donut", "corn dog", "popcorn"};
		names = temp4;
		double[] temp5 = {0.30, 0.20, 0.20, 0.25, 0.30, 0.40, 0.30, 0.35,
				1.25, 1.00, 1.30, 2.65};
		prices = temp5;
		
		newTrayPizza(viewObjects);
		
		toppings = new AnnieFoodItem[toppingImgs.length];
		for(int i = 0; i < toppings.length; i++) {
			final int num = i;
			int x = (i % 4) * 100 + 20;
			int y;
			if(i < toppings.length / 2)
				y = getHeight() - 240;
			else
				y = getHeight() - 140;
			Component box = new Component(x, y, 80, 80) {

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
			AnnieFoodItem item = new AnnieFoodItem(x, y, box.getWidth(), box.getHeight(), toppingImgs2[i], names[i], prices[i]);
			item.setAction(new Action() {
				
				private int x;
				private int y;
				
				public void act() {
					onScreen.add(item);
					generateXY();
					Graphic topping = new Graphic(item.getX() + 15, item.getY() + 15, 50, 50, toppingImgs[num]);
					stuff.add(topping);
					viewObjects.add(topping);
					Visible.move(topping, getRandomX(), getRandomY(), 250);
				}
				
				public void generateXY() {
					x = (int)(Math.random() * 260 + 55);
					y = (int)(Math.random() * 260 + 75);
					while(Math.pow(x - 185, 2) + Math.pow(y - 205, 2) > Math.pow(115, 2)) {
						x = (int)(Math.random() * 260 + 55);
						y = (int)(Math.random() * 260 + 75);
					}
				}

				private int getRandomX() {
					return x;
				}

				private int getRandomY() {
					return y;
				}
				
			});
			toppings[i] = item;
			viewObjects.add(item);
		}
		
		items = new AnnieFoodItem[itemImgs.length];
		for(int i = 0; i < items.length; i++) {
			final int num = i;
			int x = (i % 4) * 100 + toppings[3].getX() + toppings[3].getWidth() + 20;
			Component box = new Component(x, toppings[0].getY(), toppings[0].getWidth() * 2 + 20, toppings[0].getWidth() * 2 + 20) {

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
//			AnnieFoodItem item = new AnnieFoodItem(x, item.getY(), item.getWidth(), item.getHeight(), itemImgs2[i], names[i + 8], prices[i + 8]);

		}
		
		Component box1 = new Component(getWidth() - 385, getHeight() - 160, 220, 100) {
			
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
		Button done = new Button(box1.getX(), box1.getY(), box1.getWidth(), box1.getHeight(), "done", new Action() {
			
			public void act() {
				GuiLoadingVickie.loading.setScreen(new JoannaResultScreen(getWidth(), getHeight(), AnnieWorkScreen.this));
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
		ClickableGraphic trash = new ClickableGraphic(box2.getX(), box2.getY(), box2.getWidth(), box2.getHeight(), "food/trash.png");
		trash.setAction(new Action() {

			public void act() {
				resetTray(viewObjects);
				orderAnimation(viewObjects);
				trashCount++;
			}
			
		});
		viewObjects.add(trash);
		
		Component bigPaper = new Component(done.getX(), 190, done.getWidth() + trash.getWidth() + 20, 430) {
			
			public void update(Graphics2D g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.black);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
			
		};
		bigPaper.setVisible(true);
		viewObjects.add(bigPaper);
		bigOrder = new TextArea(bigPaper.getX() + 25, bigPaper.getY() + 25, bigPaper.getWidth() - 50, bigPaper.getHeight() - 50, "");
		viewObjects.add(bigOrder);
		
		orderX = new int[3];
		papers = new ArrayList<Component>();
		orders = new ArrayList<JoannaOrder>();
		for(int i = 0; i < orderX.length; i++) {
			orderX[i] = bigPaper.getX() + i * 120;
			newOrder(viewObjects);
		}
		setCurrentOrder(orders.get(0));
		moveOrders();
		
		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			done.setFont(font.deriveFont(40f));
			bigOrder.setFont(font.deriveFont(30f));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void newTrayPizza(List<Visible> viewObjects) {
		tray = newTray();
		pizza = newPizza();
		viewObjects.add(tray);
		viewObjects.add(pizza);
		Visible.move(tray, tray.getX() + 1500, tray.getY(), 1250);
		Visible.move(pizza, pizza.getX() + 1500, pizza.getY(), 1250);
	}

	private Component newTray() {
		Component tray = new Component(20, 40, 775, 500) {
			
			public void update(Graphics2D g) {
				g.setColor(new Color(240, 240, 200));
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.black);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
			
		};
		tray.setX(tray.getX() - 1500);
		tray.setVisible(true);
		return tray;
	}
	
	private Graphic newPizza() {
		Graphic pizza = new Graphic(45, 65, 330, 330, "food/pizza.png");
		pizza.setX(pizza.getX() - 1500);
		return pizza;
	}

	protected void resetTray(List<Visible> viewObjects) {
		trashAnimation(viewObjects);
		newTrayPizza(viewObjects);
		stuff.clear();
		onScreen.clear();
	}
	
	private void trashAnimation(List<Visible> viewObjects) {
		ArrayList<Visible> trash = new ArrayList<Visible>();
		trash.add(viewObjects.get(viewObjects.indexOf(tray)));
		trash.add(viewObjects.get(viewObjects.indexOf(pizza)));
		trash.addAll(stuff);
		for(int i = 0; i < trash.size(); i++) {
			Visible.move(trash.get(i), ((Visible) trash.get(i)).getX(), trash.get(i).getY() - 1000, 1000);
		}
	}

	public void newOrder(List<Visible> viewObjects) {
		Component paper = new Component(getWidth(), 40, 100, 130) {
			
			public void update(Graphics2D g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.black);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
			
		};
		paper.setVisible(true);
		papers.add(paper);
		viewObjects.add(paper);
		JoannaOrder newOrder = new JoannaOrder(paper.getX(), paper.getY(), paper.getWidth(), paper.getHeight(), "food/order.png", this);
		newOrder.setAction(new Action() {
			
			public void act() {
				setCurrentOrder(newOrder);
			}
			
		});
		orders.add(newOrder);
		viewObjects.add(newOrder);
	}
	
	protected void orderAnimation(List<Visible> viewObjects) {
		moveOrder(papers.get(orders.indexOf(currentOrder)), currentOrder, currentOrder.getX(), currentOrder.getY() - 1000, 1000);
		papers.remove(orders.indexOf(currentOrder));
		orders.remove(currentOrder);
		newOrder(viewObjects);
		setCurrentOrder(orders.get(0));
		moveOrders();
	}

	private void moveOrders() {
		for(int i = 0; i < orders.size(); i++)
			moveOrder(papers.get(i), orders.get(i), orderX[i], 40, 1250);
	}

	private void moveOrder(Component paper, JoannaOrder newOrder, int x, int y, int t) {
		Visible.move(paper, x, y, t);
		Visible.move(newOrder, x, y, t);
	}

	public void setCurrentOrder(JoannaOrder currentOrder) {
		this.currentOrder = currentOrder;
		bigOrder.setText(currentOrder.toString());
	}

	public AnnieFoodItem[] getToppings() {
		return toppings;
	}

	public AnnieFoodItem[] getItems() {
		return items;
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
