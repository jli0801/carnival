package whackAMoleKevinSteph;

import guiTeacher.GUIApplication;
public class WhackAMoleMain extends GUIApplication {

	public WhackAMoleMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		MainGameScreen screen = new MainGameScreen(getWidth(), getHeight());
		setScreen(screen);

	}
	
	public static void main(String[] args){
		WhackAMoleMain game = new WhackAMoleMain(1200, 800);
		Thread go = new Thread(game);
		go.start();
	}

}
