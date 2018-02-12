package mainMenuAreejVickie;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class StoreAreej extends FullFunctionScreen{

	private Button menu;
	private Button inventory;
	
	private static int moneys;
	private static int tickets; 
	
	private TextArea ticketDisplay;
	private TextArea moneyDisplay;
	
	private static ArrayList<String> prizeList;
	private static ArrayList<String> dartList;
	
	public StoreAreej(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, 1185, getHeight(), "resources/tent.png");
		Graphic shelf = new Graphic(330,275, 800, 700, "resources/shelf.png");
		ClickableGraphic bear = new ClickableGraphic(510,400, 100, 100, "resources/bear.png");
		ClickableGraphic fish = new ClickableGraphic(670,400, 100, 100, "resources/fish.png");
		ClickableGraphic candy = new ClickableGraphic(830,400, 100, 100, "resources/cottoncandy.png");
		ClickableGraphic dull = new ClickableGraphic (415,275,130,130, "poppingBalloons/dart1.png"); 
		ClickableGraphic blunt = new ClickableGraphic (590,275,130,130, "poppingBalloons/dart2.png"); 
		ClickableGraphic sharp = new ClickableGraphic (770,275,130,130, "poppingBalloons/dart3.png"); 
		ClickableGraphic dangerous = new ClickableGraphic (920,275,130,130, "poppingBalloons/dart4.png"); 
		ClickableGraphic hammer = new ClickableGraphic(670, 520, 100, 100, "resources/hammer.png");
		Graphic ticket = new Graphic (30, 200, 100, 100, "resources/ticket.jpg");
		Graphic money = new Graphic(30, 290, 90, 90, "resources/money.png");
		
		
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
		
		//prizes
		prizeList = new ArrayList<String>();
		prizeList.add("bear");
		prizeList.add("fish");
		prizeList.add("candy");
		
		//darts
		dartList = new ArrayList<String>();
		dartList.add("bluntDart");
		dartList.add("dullDart");
		dartList.add("sharpDart");
		dartList.add("dangerousDart");
		
	
		
		TextLabel store = new TextLabel(730,180, 900, 300, "STORE");
		
		moneyDisplay = new TextArea(10, 200, 100, 30, "");
		ticketDisplay = new TextArea(10, 290, 100, 30, "");
		
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
		moneys++;
	//	moneyDisplay.setText(money);
		
	}
	
	public void addTickets() {
		tickets++;
	//	ticketDisplay.setText(tickets);
		
		
	}
	
	
}
