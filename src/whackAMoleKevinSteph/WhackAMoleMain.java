package whackAMoleKevinSteph;

import guiTeacher.GUIApplication;
public class WhackAMoleMain extends GUIApplication {

	public static WhackAMoleMain main;
	public static MainGameScreen mainScreen;
	public static WhackAMoleScreen gameScreen;
	
	public WhackAMoleMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		mainScreen = new MainGameScreen(getWidth(), getHeight());
		gameScreen = new WhackAMoleScreen(getWidth(), getHeight());
		setScreen(mainScreen);

	}
	
	public static void main(String[] args){
		WhackAMoleMain main = new WhackAMoleMain(1200, 800);
		Thread go = new Thread(main);
		go.start();
	}

}
