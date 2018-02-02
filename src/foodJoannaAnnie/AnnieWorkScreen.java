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
		String[] temp2 = {"food/soda.png", "food/cone.png", "food/dog.png", "food/donut.png", "food/popcorn.png"};
		itemImgs = temp2;
		String[] temp3 = {"food/soda2.png", "food/cone2.png", "food/dog2.png", "food/donut2.png", "food/popcorn2.png"};
		itemImgs2 = temp3;
		String[] temp4 = {"pepperoni", "onions", "pineapple", "mushrooms", "olives", "bacon", "peppers", "sausage", 
				"soda", "ice cream cone", "corn dog", "donut", "popcorn"};
		names = temp4;
		double[] temp5 = {0.30, 0.20, 0.20, 0.25, 0.30, 0.40, 0.30, 0.35,
				1.25, 2.75, 1.30, 1.00, 2.65};
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
					g.setColor(new Color(235, 235, 235));
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
					Visible.move(topping, getRandomX(), getRandomY(), 150);
				}
				
				public void generateXY() {
					x = (int)(Math.random() * 260 + 60);
					y = (int)(Math.random() * 260 + 80);
					while(Math.pow(x - 190, 2) + Math.pow(y - 210, 2) > Math.pow(115, 2)) {
						x = (int)(Math.random() * 260 + 60);
						y = (int)(Math.random() * 260 + 80);
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
		for(int i = 0; i < 2; i++) {
			final int num = i;
			Component box = new Component(toppings[3].getX() + (20 + toppings[0].getWidth()) * (i + 1), toppings[0].getY(), toppings[0].getWidth(), toppings[0].getHeight() * 2 + 20) {

				public void update(Graphics2D g) {
					g.setColor(new Color(235, 235, 235));
					g.fillRect(0, 0, getWidth(), getHeight());
					g.setStroke(new BasicStroke(5));
					g.setColor(Color.black);
					g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
				}
				
			};
			box.setVisible(true);
			viewObjects.add(box);
			AnnieFoodItem item = new AnnieFoodItem(box.getX(), box.getY(), box.getWidth(), box.getHeight(), itemImgs2[i], names[i + 8], prices[i + 8]);
			item.setAction(new Action() {
				
				public void act() {
					onScreen.add(item);
					Graphic food = new Graphic(420 + 190 * num, tray.getY() + tray.getHeight() - 280 + ((num + 1) % 2) * 15, .7, itemImgs[num]);
					stuff.add(food);
					viewObjects.add(food);
				}
				
			});
			items[i] = item;
			viewObjects.add(item);
		}
		
		for(int i = 3; i < items.length; i++) {
			final int num = i;
			Component box = new Component(20 + tray.getWidth() - toppings[0].getWidth(), toppings[((i - 1) % 2) * 4].getY(), toppings[0].getWidth(), toppings[0].getHeight()) {

				public void update(Graphics2D g) {
					g.setColor(new Color(235, 235, 235));
					g.fillRect(0, 0, getWidth(), getHeight());
					g.setStroke(new BasicStroke(5));
					g.setColor(Color.black);
					g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
				}
				
			};
			box.setVisible(true);
			viewObjects.add(box);
			AnnieFoodItem item = new AnnieFoodItem(box.getX(), box.getY(), box.getWidth(), box.getHeight(), itemImgs2[i], names[i + 8], prices[i + 8]);
			item.setAction(new Action() {
				
				public void act() {
					onScreen.add(item);
					Graphic food = new Graphic(item.getX() - 105 * (num - 2) - 90 * ((num - 1) % 2), tray.getY() + 30, .6, itemImgs[num]);
					stuff.add(food);
					viewObjects.add(food);
				}
				
			});
			items[i] = item;
			viewObjects.add(item);
		}

		Component box = new Component(items[1].getX() + items[1].getWidth() + 20, toppings[0].getY(), 75, toppings[0].getHeight() * 2 + 20) {

			public void update(Graphics2D g) {
				g.setColor(new Color(235, 235, 235));
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.black);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
			
		};
		box.setVisible(true);
		viewObjects.add(box);
		AnnieFoodItem item = new AnnieFoodItem(box.getX(), box.getY(), box.getWidth(), box.getHeight(), itemImgs2[2], names[10], prices[10]);
		item.setAction(new Action() {
			
			public void act() {
				onScreen.add(item);
				Graphic food = new Graphic(80, 435, .7, itemImgs[2]);
				stuff.add(food);
				viewObjects.add(food);
			}
			
		});
		items[2] = item;
		viewObjects.add(item);		
		
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
		orderAnimation();
				
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
		Component back = new Component(20, 40, 775, 500) {
			
			public void update(Graphics2D g) {
				g.setColor(new Color(180, 230, 230));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			
		};
		back.setX(back.getX() - 1500);
		back.setVisible(true);
		viewObjects.add(back);
		Visible.move(back, back.getX() + 1500, back.getY(), 1250);
		tray = newTray();
		pizza = newPizza();
		viewObjects.add(tray);
		viewObjects.add(pizza);
		Visible.move(tray, tray.getX() + 1500, tray.getY(), 1250);
		Visible.move(pizza, pizza.getX() + 1500, pizza.getY(), 1250);
	}

	private Graphic newPizza() {
		Graphic pizza = new Graphic(50, 70, 330, 330, "food/pizza.png");
		pizza.setX(pizza.getX() - 1500);
		return pizza;
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
	
	public void animation(List<Visible> viewObjects) {
		resetTray(viewObjects);
		setOrders(viewObjects);
		resetClicked();
	}
	
	private void resetClicked() {
//		for(int i = 0; i < items.length; i++)
//			items[i].setClicked(false);
	}

	private void setOrders(List<Visible> viewObjects) {
		moveOrder(papers.get(orders.indexOf(currentOrder)), currentOrder, currentOrder.getX(), currentOrder.getY() - 1000, 1000);
		papers.remove(orders.indexOf(currentOrder));
		orders.remove(currentOrder);
		newOrder(viewObjects);
		setCurrentOrder(orders.get(0));
		orderAnimation();
	}

	private void orderAnimation() {
		for(int i = 0; i < orders.size(); i++)
			moveOrder(papers.get(i), orders.get(i), orderX[i], 40, 1250);
	}

	private void setCurrentOrder(JoannaOrder currentOrder) {
		this.currentOrder = currentOrder;
		bigOrder.setText(currentOrder.toString());
	}

	private void newOrder(List<Visible> viewObjects) {
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
	
	private void moveOrder(Component paper, JoannaOrder newOrder, int x, int y, int t) {
		Visible.move(paper, x, y, t);
		Visible.move(newOrder, x, y, t);
	}
	
	private void resetTray(List<Visible> viewObjects) {
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

	public AnnieFoodItem[] getToppings() {
		return toppings;
	}

	public AnnieFoodItem[] getItems() {
		return items;
	}

	public ArrayList<AnnieFoodItem> getOnScreen() {
		return onScreen;
	}

	public int getTrashCount() {
		return trashCount;
	}

	public JoannaOrder getCurrentOrder() {
		return currentOrder;
	}

}
