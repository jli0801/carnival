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
		
		private Button switchScreen;
		
		public WelcomeScreenVickie(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			//Graphic forest = new Graphic(0,0, getWidth(), getHeight(), "resources/download.jpg");
			Graphic baymax = new Graphic(0,0, getWidth(), getHeight(), "resources/welcomeBackground.jpg");
			
			
			switchScreen = new Button(350, 580, 70, 30, "Page 2", Color.red, new Action() {
				public void act() {
					
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);

				}
			});
			
			switchScreen.setCustomTextColor(new Color(250,250,250));
			viewObjects.add(baymax);
			//viewObjects.add(add);
			
			viewObjects.add(switchScreen);
			
			//
			 
			
		}
	}

