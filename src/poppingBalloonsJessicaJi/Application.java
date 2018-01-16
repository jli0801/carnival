package poppingBalloonsJessicaJi;

import guiTeacher.GUIApplication;


public class Application extends GUIApplication {

	public static BalloonResults screen;
	public static Application app;
	public Application(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		screen = new BalloonResults(getWidth(),getHeight());
		setScreen(screen);
	}
	
	public static void main(String[] args) {
		app = new Application(1200, 800);
		Thread runner = new Thread(app);
		runner.start();
	}

}
