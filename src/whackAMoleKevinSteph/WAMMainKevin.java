package whackAMoleKevinSteph;

import guiTeacher.GUIApplication;
public class WAMMainKevin extends GUIApplication {

	public static WAMMainKevin main;
	public static WAMMenuStephanie mainScreen;
	public static WAMGameKevin gameScreen;
	
	public WAMMainKevin(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		mainScreen = new WAMMenuStephanie(getWidth(), getHeight());
		gameScreen = new WAMGameKevin(getWidth(), getHeight());
		setScreen(mainScreen);

	}
	
	public static void main(String[] args){
		WAMMainKevin main = new WAMMainKevin(1200, 800);
		Thread go = new Thread(main);
		go.start();
	}

}
