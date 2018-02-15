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
	
	private static double money;
	private static int tickets; 
	
	private TextArea ticketDisplay;
	private TextArea moneyDisplay;

	public StoreAreej(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		tickets = InventoryVickie.getTickets();
		
		Graphic background = new Graphic(0,0, 1185, getHeight(), "resources/tent.png");
		Graphic shelf = new Graphic(330,275, 800, 700, "resources/shelf.png");
		ClickableGraphic bear = new ClickableGraphic(510,400, 100, 100, "resources/bear.png");
		bear.setAction(new Action() {

			public void act() {
				TextLabel buy = new TextLabel(30, 260, 300, 200, "Would you like to buy this" + " item for 30 tickets?");
				Button yes = new Button(50, 300, 50, 50, "Yes", new Action() {
					@Override
					public void act() {
						if(tickets >= 30) {
						tickets = tickets - 30;
					}
					else {
						TextLabel err = new TextLabel(300, 200, 100, 100, "Yu don't have enough tickets to get this.");
						viewObjects.add(err);
					}
					}
				});
				Button no = new Button(100, 300, 50, 50, "No", new Action() {
					
					@Override
					public void act() {
						GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.inventory);
										
					}//
				});
				viewObjects.add(buy);
				viewObjects.add(yes);
				viewObjects.add(no);
			}
			
		});
		ClickableGraphic fish = new ClickableGraphic(670,400, 100, 100, "resources/fish.png");
		ClickableGraphic candy = new ClickableGraphic(830,400, 100, 100, "resources/cottoncandy.png");
		ClickableGraphic dull = new ClickableGraphic (415,275,130,130, "poppingBalloons/dart1.png"); 
		ClickableGraphic blunt = new ClickableGraphic (590,275,130,130, "poppingBalloons/dart2.png"); 
		ClickableGraphic sharp = new ClickableGraphic (770,275,130,130, "poppingBalloons/dart3.png"); 
		ClickableGraphic dangerous = new ClickableGraphic (920,275,130,130, "poppingBalloons/dart4.png"); 
		ClickableGraphic hammer = new ClickableGraphic(670, 520, 100, 100, "resources/hammer.png");
		
		Graphic ticketG = new Graphic(30, 200, 50, 50, "resources/tickets1.png");
		Graphic moneyG = new Graphic(150, 200, 30, 30, "resources/money.png");

		
		
		TextLabel tic = new TextLabel(80, 203, 100, 100, "x " + tickets);
		TextLabel mon = new TextLabel(175, 203, 100, 100, "x $" + String.format("%.2f",money));
		
		
		menu = new Button(30, 650, 280, 75, "Menu", Color.red, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}

		});
		
		inventory = new Button(30, 560, 280, 75, "Inventory", Color.orange, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.inventory);
			}

		});

		
	
		
		TextLabel store = new TextLabel(730,180, 900, 300, "STORE");
		
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
		viewObjects.add(ticketG);
		viewObjects.add(moneyG);
		viewObjects.add(hammer);
		
		viewObjects.add(menu);
		viewObjects.add(inventory);
		viewObjects.add(tic);
		viewObjects.add(mon);
		
		
	}
	
	
	
	
}
