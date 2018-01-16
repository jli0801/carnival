package mainMenuAreejVickie;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

//EDIT HIERARCHY!!

public class WelcomeScreenVickie extends FullFunctionScreen{ //possibly extends clickable screen
		//private Button add;
		
		private Button menu;
		
		public WelcomeScreenVickie(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
	
			Graphic welcomeBackground = new Graphic(0,0, getWidth(), getHeight(), "resources/welcomeBackground.jpg");
			
			
			menu = new Button(350, 580, 100, 100, "Welcome", Color.red, new Action() {
				public void act() {
					
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);

				}
			});
			
			menu.setCustomTextColor(new Color(250,250,250));
			viewObjects.add(welcomeBackground);
			//viewObjects.add(add);
			
			viewObjects.add(menu);
			
			//
			 
			
		}
		//maybe have balloons animation
	}

