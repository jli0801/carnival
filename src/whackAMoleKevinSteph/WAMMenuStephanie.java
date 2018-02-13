package whackAMoleKevinSteph;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMMenuStephanie extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Button returnMSButton;
	private Button easyButton;
	private Button casualButton;
	private Button diffButton;
	private TextArea instructionsText;

	public WAMMenuStephanie(int width, int height) {
		super(width, height);

	}

	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, getWidth(), getHeight(), "wam/background.jpg");
		
		viewObjects.add(background);
		
		 try {

			 File fontFile = new File("resources/Bangers.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(26f);

			 StyledComponent.setBaseFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }
		
		
		returnMSButton = new Button(20,30,210,50,"RETURN TO MAIN MENU",Color.ORANGE, new Action() {

			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
			}
		});

		viewObjects.add(returnMSButton);

		easyButton = new Button(970,30,200,50,"EASY",Color.GREEN, new Action() {

			public void act() {
				JFrame mainPane = GUIApplication.mainFrame;
				GuiLoadingVickie.loading.setScreen(new WAMEasyKevin(getWidth(), getHeight()));
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit.getImage("wam/mallet.png");
				Cursor c = toolkit.createCustomCursor(image , new Point(mainPane.getX(), 
				           mainPane.getY()), "img");	
				mainPane.setCursor (c);
				GUIApplication.enableCursorChange = false;
			}
			
		});
		
		viewObjects.add(easyButton);
		
		casualButton = new Button(970,100,200,50,"CASUAL",Color.ORANGE, new Action() {

			public void act() {
				JFrame mainPane = GUIApplication.mainFrame;
				GuiLoadingVickie.loading.setScreen(new WAMCasual(getWidth(), getHeight()));
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit.getImage("wam/mallet.png");
				Cursor c = toolkit.createCustomCursor(image , new Point(mainPane.getX(), 
				           mainPane.getY()), "img");	
				mainPane.setCursor (c);
				GUIApplication.enableCursorChange = false;
			}
			
		});
		
		viewObjects.add(casualButton);
		
		diffButton = new Button(970,170,200,50,"DIFFICULT",Color.RED, new Action() {

			public void act() {
				JFrame mainPane = GUIApplication.mainFrame;
				//GuiLoadingVickie.loading.setScreen(new WAMGameKevin(getWidth(), getHeight()));
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit.getImage("wam/mallet.png");
				Cursor c = toolkit.createCustomCursor(image , new Point(mainPane.getX(), 
				           mainPane.getY()), "img");	
				mainPane.setCursor (c);
				GUIApplication.enableCursorChange = false;
			}
			
		});
		
		viewObjects.add(diffButton);
		
		instructionsText = new TextArea(250,80,700,270," ");
		//instructionsText.setInactiveBorderColor(Color.ORANGE);

		instructionsText.setText("HOW TO PLAY:" + "\n" + "WHACK AS MANY MOLES AS YOU CAN UNDER THE TIME LIMIT."
				+ "THERE ARE 3 DIFFICULTIES: EASY, CASUAL, AND DIFFICULT. "
				+ "THE HARDER THE DIFFICULTY, THE MORE TICKETS YOU EARN."
				+ "EASY STARTS OFF WITH 20 SECONDS WHILE THE OTHER DIFFICULTIES HAVE 5 SECONDS LESS THAN THE LAST"
				+ " AND THE MOLES WILL MOVE FASTER. CLICKING ON THE WRONG HOLE WILL ALSO RESULT IN A 1 SECOND PENALTY."  
				+ "\n" + "NOW GO WHACK SOME MOLES AND ENJOY THE GAME!!");
		viewObjects.add(instructionsText);
	}
}

