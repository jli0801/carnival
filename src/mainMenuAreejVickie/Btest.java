package mainMenuAreejVickie;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;

public class Btest extends Button{

	TextArea d;
	public Btest(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		
	}

	public void hoverAction(){
		d = new TextArea(100,100,100,100, "hihiihihh");
		//viewObjects.add(d);
	}
	
	public TextArea getArea() {
		return d;
	}
	
}
