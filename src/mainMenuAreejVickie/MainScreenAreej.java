package mainMenuAreejVickie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Timer;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class MainScreenAreej extends FullFunctionScreen {

		private Button inventory;
	private Button store;

	public MainScreenAreej(int width, int height) {
		super(width, height);
	}


	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, getWidth(), getHeight(), "resources/menu.png");
		
		//balloon pop
		ClickableGraphic clown = new ClickableGraphic(130,490, 200, 200, "resources/clown.png");
		clown.setAction(new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.balloonGame);
			}
			
		});
		
		//whack a mole
		ClickableGraphic mole = new ClickableGraphic(410,490, 200, 200, "resources/mole.png");
		mole.setAction(new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
				
			}
			
		});
		
		
		//food stall
		ClickableGraphic pizza = new ClickableGraphic(690,490, 200, 200, "resources/pizza.png");
		pizza.setAction(new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.foodGame);
				
			}
			
		});
		
		//inventory
		inventory = new Button(950, 470, 120,80, "Inventory", Color.orange, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.inventory);

			}
		});

		//store
		store = new Button(950, 590, 120, 80, "Store", Color.red, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.store);

			}
		});
		
		 try {

			 File fontFile = new File("resources//Bangers.ttf");
			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			 Font baseFont=font.deriveFont(24f);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }
		 
		
		viewObjects.add(background);
		viewObjects.add(clown);
		viewObjects.add(mole);
		viewObjects.add(pizza);
		viewObjects.add(inventory);
		viewObjects.add(store);

		
	}

}