package mainMenuAreejVickie;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class InventoryVickie extends FullFunctionScreen{

	public InventoryVickie(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic inventoryBackground = new Graphic(0,0, getWidth(), getHeight(), "resources/inventoryF.jpg");
		
		
		viewObjects.add(inventoryBackground);
	}
	
	//private ArrayList<> inventory;

	
}
