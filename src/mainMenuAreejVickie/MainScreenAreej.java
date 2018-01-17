package mainMenuAreejVickie;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class MainScreenAreej extends FullFunctionScreen {

	private Button balloon;
	private Button mole;
	private Button food;
	
	public MainScreenAreej(int width, int height) {
		super(width, height);
	}


	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, getWidth(), getHeight(), "resources/menu.jpg");
		
		balloon = new Button(280, 580, 120, 40, "Balloon Pop", Color.yellow, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.welcome);

			}
		});
		mole = new Button(440, 580, 150, 40, "Wack-a-Mole", Color.blue, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.welcome);

			}
		});
		food = new Button(630, 580, 120, 40, "Food Stand", Color.green, new Action() {

			public void act() {
				
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.welcome);

			}
		});
		TextArea ta = new TextArea(140, 180, 330 ,400, "HAVE YOUR PICK");
		 try {

			 File fontFile = new File("resources//AdventPro-Medium.ttf");

			 // File fontFile = new File("resources//DayRoman.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(50f);

			 balloon.setFont(baseFont);
			 mole.setFont(baseFont);
			 food.setFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }
		ta.setTextColor(Color.black);
		balloon.setTextColor(Color.white);
		mole.setTextColor(Color.white);
		food.setTextColor(Color.white);
		
		
		viewObjects.add(background);
		viewObjects.add(balloon);
		viewObjects.add(mole);
		viewObjects.add(food);
		viewObjects.add(ta);
		
		 StyledComponent.setButtonOutline(true);
		
		
	}

}