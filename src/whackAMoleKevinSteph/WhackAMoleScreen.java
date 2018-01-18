package whackAMoleKevinSteph;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class WhackAMoleScreen extends ClickableScreen {

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
	
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Button(100, 100, 200, 300, "", new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		}));

	}

}
