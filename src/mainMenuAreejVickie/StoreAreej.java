package mainMenuAreejVickie;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class StoreAreej extends FullFunctionScreen{

	private Button menu;
	private Button inventory;
	
	private static double money = 10;
	private static int ticket; 
	
	
	private TextArea ticketDisplay;
	private TextArea moneyDisplay;
	
	public StoreAreej(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, 1185, getHeight(), "resources/tent.png");
		Graphic shelf = new Graphic(330,275, 800, 700, "resources/shelf.png");
		Graphic bear = new Graphic(510,400, 100, 100, "resources/bear.png");
		Graphic fish = new Graphic(670,400, 100, 100, "resources/fish.png");
		Graphic candy = new Graphic(830,400, 100, 100, "resources/cottoncandy.png");
		Graphic dull = new Graphic (415,275,130,130, "poppingBalloons/dart1.png"); 
		Graphic blunt = new Graphic (590,275,130,130, "poppingBalloons/dart2.png"); 
		Graphic sharp = new Graphic (770,275,130,130, "poppingBalloons/dart3.png"); 
		Graphic dangerous = new Graphic (920,275,130,130, "poppingBalloons/dart4.png"); 
		Graphic ticket = new Graphic (30, 200, 100, 100, "resources/ticket.jpg");
		Graphic money = new Graphic(30, 290, 90, 90, "resources/money.png");
		Graphic hammer = new Graphic(670, 520, 100, 100, "resources/hammer.png");
		
		menu = new Button(30, 580, 60, 50, "menu", Color.blue, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
			
		});
		
		inventory = new Button(30,660, 100, 50, "inventory", Color.orange, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.inventory);
			}
			
		});
		
		TextLabel store = new TextLabel(730,180, 900, 300, "STORE");
		
		moneyDisplay = new TextArea(10, 200, 100, 30, "10");
		ticketDisplay = new TextArea(10, 290, 100, 30, "0");
		
		viewObjects.add(background);
		viewObjects.add(store);
		viewObjects.add(shelf);
		viewObjects.add(bear);
		viewObjects.add(dull);
		viewObjects.add(blunt);
		viewObjects.add(sharp);
		viewObjects.add(dangerous);
		viewObjects.add(fish);
		viewObjects.add(candy);
		viewObjects.add(ticket);
		viewObjects.add(money);
		viewObjects.add(hammer);
		viewObjects.add(menu);
		viewObjects.add(inventory);
		
		viewObjects.add(moneyDisplay);
		viewObjects.add(ticketDisplay);
		
		
	}
	
	public void addMoney() {
		money++;
	//	moneyDisplay.setText(money);
		
	}
	
	public void addTickets() {
		ticket++;
	//	ticketDisplay.setText(tickets);
		
		
	}
	
		

}
