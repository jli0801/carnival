package mainMenuAreejVickie;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class GuiLoadingVickie extends GUIApplication{

	public GuiLoadingVickie(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static GuiLoadingVickie loading;
	public static WelcomeScreenVickie  welcome;
	public static MainScreenAreej menu;
	/*
	 * 2 screens jessJi
	 * 3 screens stephKev
	 * 2 screens AnnieJoanna
	 */

	public static void main(String[] args) {
		loading = new GuiLoadingVickie(1200, 800);
		 Thread runner = new Thread(loading);
		 runner.start();
	}

	@Override
	public void initScreen() {
		//StyledComponent.setTextColor(Color.white);
		try {

			 File fontFile = new File("resources//christmaseve.ttf");

			 // File fontFile = new File("resources//DayRoman.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(20f);

			 StyledComponent.setBaseFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }
		
		welcome = new WelcomeScreenVickie(getWidth(), getHeight());
		menu = new MainScreenAreej(getWidth(), getHeight());
		setScreen(welcome);
		
		//setScreen(menu);
	}

}
