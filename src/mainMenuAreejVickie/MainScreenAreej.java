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

	public MainScreenAreej(int width, int height) {
		super(width, height);
	}


	public void initAllObjects(List<Visible> viewObjects) {
		
Graphic baymaxtree = new Graphic(0,0, getWidth(), getHeight(), "resources/baymaxtree.jpg");
		
		back = new Button(350, 580, 70, 30, "Page 1", Color.red, new Action() {

			public void act() {
				
				GuiPart.part.setScreen(GuiPart.windowOne);

			}
		});
		TextArea ta = new TextArea(140, 180, 330 ,400, "HAPPY NEW YEAR!");
		 try {

			 File fontFile = new File("resources//AdventPro-Medium.ttf");

			 // File fontFile = new File("resources//DayRoman.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(50f);

			 back.setFont(baseFont);

			 } catch (Exception e) {

			 e.printStackTrace();

			 }
		ta.setTextColor(Color.black);
	
		
		viewObjects.add(baymaxtree);
		viewObjects.add(back);
		viewObjects.add(ta);
		
		 StyledComponent.setButtonOutline(true);
		
		
	}

}