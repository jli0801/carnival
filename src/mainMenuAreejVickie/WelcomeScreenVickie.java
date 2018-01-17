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

//EDIT HIERARCHY!!

public class WelcomeScreenVickie extends FullFunctionScreen{ //possibly extends clickable screen
		//private Button add;
		
		private  Button menu;
		private TextArea carnival;

		public WelcomeScreenVickie(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
	
			Graphic welcomeBackground = new Graphic(0,0, getWidth(), getHeight(), "resources/welcomeBackground.png");
			
			carnival = new TextArea(225,75, 1000,1000, "Carnival");
			carnival.setForeground(Color.white);
			carnival.update();
//********	Changed TextArea in guiDoc.	
			
			menu = new Button(900, 650, 200, 100, "Welcome", Color.red, new Action() {
				public void act() {
					
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);

				}
			});
			menu.setForeground(Color.orange);
			menu.update();
			
			try {
				 File fontFile = new File("resources/Bangers.ttf");
				 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
				 
				 Font carnivalTextArea=font.deriveFont(200f);
				 Font menuButton=font.deriveFont(40f);
				
				carnival.setFont(carnivalTextArea);
				menu.setFont(menuButton); //make text orange
				
				 } catch (Exception e) {

				 e.printStackTrace();

				 }
			
			menu.setCustomTextColor(new Color(0,0,0)); //?
			
			
			viewObjects.add(welcomeBackground);
			//viewObjects.add(add);
			viewObjects.add(carnival);
			viewObjects.add(menu);
			
			//
			 
			
		}
		//maybe have balloons animation

		
	}

