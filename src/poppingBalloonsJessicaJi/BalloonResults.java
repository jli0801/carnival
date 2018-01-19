package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BalloonResults extends FullFunctionScreen {

	private TextArea result;
	private TextArea score;
	private TextArea rate;

	public BalloonResults(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		result = new TextArea(50, 10, 200, 100, "You (win/lose)");
		score = new TextArea(50, 50, 100, 50, "Final score: _");
		rate  = new TextArea(50, 70, 500, 50, "You popped an average of _ balloons per second");
		
		Button back = new Button(300, 300, 50, 50, "Back", Color.YELLOW, new Action() {
			
			@Override
			public void act() {
				//setScreen(menu);
				
			}
		});
		
		viewObjects.add(result);
		viewObjects.add(score);
		viewObjects.add(rate);
		viewObjects.add(back);
	}

}
