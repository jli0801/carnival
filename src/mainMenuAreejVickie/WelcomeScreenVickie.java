package mainMenuAreejVickie;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

//EDIT HIERARCHY!!

public class WelcomeScreenVickie extends FullFunctionScreen{ //possibly extends clickable screen
		//private Button add;
		
		private Button menu;
		private TextArea carnival;

		public WelcomeScreenVickie(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
	
			Graphic welcomeBackground = new Graphic(0,0, getWidth(), getHeight(), "resources/welcomeBackground.png");
			
			carnival = new TextArea(400,400, 500,300, "Carnival");
			
			menu = new Button(900, 650, 200, 100, "Welcome", Color.red, new Action() {
				public void act() {
					
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);

				}
			});
			
			menu.setCustomTextColor(new Color(0,0,0)); //?
			
			viewObjects.add(carnival);
			viewObjects.add(welcomeBackground);
			//viewObjects.add(add);
			
			viewObjects.add(menu);
			
			//
			 
			
		}
		//maybe have balloons animation
	}

