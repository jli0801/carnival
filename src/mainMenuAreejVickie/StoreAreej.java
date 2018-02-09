package mainMenuAreejVickie;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class StoreAreej extends FullFunctionScreen{

	private Button menu;
	private Button inventory;
	
	
	public StoreAreej(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, 1185, getHeight(), "resources/tent.png");
		Graphic bear = new Graphic(10,10, 100, 100, "resources/bear.png");
		
		menu = new Button(10, 600, 50, 50, "menu", Color.blue, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
			
		});
		
		inventory = new Button(10,700, 100, 50, "inventory", Color.orange, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.inventory);
			}
			
		});
		
		viewObjects.add(background);
		viewObjects.add(bear);
		viewObjects.add(menu);
		viewObjects.add(inventory);
		
	}

	//

}
