package mainMenuAreejVickie;

import java.awt.Font;
import java.io.File;

import foodJoannaAnnie.*;
import guiTeacher.GUIApplication;
import guiTeacher.components.*;
import poppingBalloonsJessicaJi.JessicaJiInstructions;
import whackAMoleKevinSteph.KevinStephInstructions;

public class GuiLoadingVickie extends GUIApplication{

	public GuiLoadingVickie(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static GuiLoadingVickie loading;
	public static WelcomeScreenVickie  welcome;
	public static MainScreenAreej menu;
	
	public static AnnieInstructionScreen foodInstruct;
	public static AnnieInstructionScreen balloonInstruct;
	public static AnnieInstructionScreen moleInstruct;
		
	public static foodJoannaAnnie.AnnieWorkScreen foodGame;
	
	public static poppingBalloonsJessicaJi.BalloonScreenJessica bscreen;
	public static poppingBalloonsJessicaJi.BalloonResultsJi bResults;
	
	public static poppingBalloonsJessicaJi.BalloonBackJi bBack;
		
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

			 Font baseFont=font.deriveFont(20f); //default 
			 
			 StyledComponent.setBaseFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }

		welcome = new WelcomeScreenVickie(getWidth(), getHeight());
		menu = new MainScreenAreej(getWidth(), getHeight());
		
		inventory = new InventoryVickie(getWidth(), getHeight());
						
		foodGame = new foodJoannaAnnie.AnnieWorkScreen(getWidth(), getHeight());
		
		store = new StoreAreej(getWidth(), getHeight());
		
		foodInstruct = new AnnieInstructionScreen(getWidth(), getHeight(), new AnnieJoannaInstructions());
		moleInstruct = new AnnieInstructionScreen(getWidth(), getHeight(), new KevinStephInstructions());
		balloonInstruct = new AnnieInstructionScreen(getWidth(), getHeight(), new JessicaJiInstructions());
		
		setScreen(welcome);
		
		GUIApplication.enableCursorChange = true;
	}

}
