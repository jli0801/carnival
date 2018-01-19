package mainMenuAreejVickie;

import java.awt.Color;
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
	public static balloonGame
	public static balloonResult
	
	
	*/
	/*
	 * 2 screens jessJi
	 * 	balloonGameplay
	 *	balloonGameResult
	 *
	 * 3 screens stephKev
	 * 	molePlay
	 * 	moleResult
	 * 	?
	 * 
	 * 2 screens AnnieJoanna
	 * 	workPlay
	 * 	workResult
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
			 File fontFile = new File("resources/Bangers.ttf");
			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(16f); //default 
			 
			 StyledComponent.setBaseFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }

		welcome = new WelcomeScreenVickie(getWidth(), getHeight());
		menu = new MainScreenAreej(getWidth(), getHeight());
		
		setScreen(welcome);
	}

}