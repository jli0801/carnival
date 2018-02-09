package mainMenuAreejVickie;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;

public class Btest extends Button{

	TextArea d;
	public Btest(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		
	}

	public TextArea getArea() {
		d = new TextArea(100,100,100,100, "hihiihihh");
		return d;
	}
	
}
