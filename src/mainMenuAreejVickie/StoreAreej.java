package mainMenuAreejVickie;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class StoreAreej extends FullFunctionScreen{

	public StoreAreej(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0,0, 1200, 800, "resources/tent.png");
		
		viewObjects.add(background);
		
	}

	

}
