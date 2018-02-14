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
		
	public static foodJoannaAnnie.AnnieWorkScreen foodGame;
	
	public static poppingBalloonsJessicaJi.BalloonInstructionsJi bInstruct;
	public static poppingBalloonsJessicaJi.BalloonScreenJessica bscreen;
	
	public static whackAMoleKevinSteph.WAMMenuStephanie moleInstruct;
	
	public static InventoryVickie inventory;
	
	public static StoreAreej store;

	/*
	 * 3 screens stephKevuhjk
	 * 	molePlay
	 * 	moleResult
	 * 	?
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
		
		inventory = new InventoryVickie(getWidth(), getHeight());
		
		bInstruct = new poppingBalloonsJessicaJi.BalloonInstructionsJi(getWidth(), getHeight());
		//bscreen = new poppingBalloonsJessicaJi.BalloonScreenJessica(getWidth(), getHeight());
				
		foodGame = new foodJoannaAnnie.AnnieWorkScreen(getWidth(), getHeight());
		
		moleInstruct = new whackAMoleKevinSteph.WAMMenuStephanie(getWidth(), getHeight());
		
		store = new StoreAreej(getWidth(), getHeight());
		
		setScreen(inventory);
		
		GUIApplication.enableCursorChange = true;
	}

}
