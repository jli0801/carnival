package mainMenuAreejVickie;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;
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

	private Button balloon;
	private Button mole;
	private Button food;
	private Button inventory;
	
	public MainScreenAreej(int width, int height) {
		super(width, height);
	}


	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, getWidth(), getHeight(), "resources/menu.png");
		
		//balloon pop button
		Graphic clown = new ClickableGraphic(130,490, 200, 200, "resources/clown.png");
		balloon = new Button(160, 700, 120, 40, "Balloon Pop", Color.yellow, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.balloonGame);

			}
		});
		
		//whack a mole
		Graphic mol = new Graphic(410,490, 200, 200, "resources/mole.png");
		mole = new Button(450, 690, 150, 40, "Whack-a-Mole", Color.blue, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);

			}
		});
		
		//food stall
		Graphic pizza = new Graphic(690,490, 200, 200, "resources/pizza.png");
		food = new Button(730, 690, 120, 40, "Food Stand", Color.green, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.foodGame);
			}
		});
		
		
		 try {

			 File fontFile = new File("resources//Bangers.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(24f);

			 balloon.setFont(baseFont);
			 mole.setFont(baseFont);
			 food.setFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }
		
		viewObjects.add(background);
		viewObjects.add(clown);
		viewObjects.add(mol);
		viewObjects.add(pizza);
		//viewObjects.add(inventory);
		viewObjects.add(balloon);
		viewObjects.add(mole);
		viewObjects.add(food);
		
		
		
		
	}

}