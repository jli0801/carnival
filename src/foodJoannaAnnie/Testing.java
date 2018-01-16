package foodJoannaAnnie;

import guiTeacher.GUIApplication;

public class Testing extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Testing(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		JoannaResultScreen results = new JoannaResultScreen(getWidth(), getHeight());
		setScreen(results);
	}

	public static void main(String[] args) {
		Testing test = new Testing(1200, 800);
		Thread runner = new Thread(test);
		runner.start();
	}

}
