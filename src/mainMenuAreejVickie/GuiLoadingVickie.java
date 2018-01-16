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
	public static WelcomeScreenVickie  windowOne;
	public static MainScreenAreej windowTwo;

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
		
		windowOne = new WelcomeScreenVickie(getWidth(), getHeight());
		windowTwo = new MainScreenAreej(getWidth(), getHeight());
		setScreen(windowOne);
		
		//setScreen(windowTwo);
	}

}
