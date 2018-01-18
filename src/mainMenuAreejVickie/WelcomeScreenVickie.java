package mainMenuAreejVickie;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
		
		private Timer timer;
		private int count;
		private int randColor;
		
		private boolean activate;
		private Color colors;
		
		private Color []color = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.pink, Color.black, Color.DARK_GRAY, Color.magenta, Color.gray};

		public WelcomeScreenVickie(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			count = 1000;
			Graphic welcomeBackground = new Graphic(0,0, getWidth(), getHeight(), "resources/welcomeBackground.png");
			
			carnival = new TextArea(225,75, 1000,1000, "Carnival");
			carnival.setForeground(Color.white);
			carnival.update();
//********	Changed TextArea in guiDoc.	
			
			timer = new Timer();
			TimerTask complete = new TimerTask() {
				@Override
				public void run() {
					count --;
					//randomly change font color
					randColor = (int)(Math.random() * 11);
					colors = color[randColor];
					carnival.setForeground(colors);
					carnival.update();
					
					if(count ==0) {
						timer.cancel();
					}	
				}				
			};
			
			menu = new Button(900, 650, 200, 100, "Go!!", Color.red, new Action() {
				public void act() {
					if(!activate) {
						activate = !activate;
						timer.schedule(complete, 0, 100);
						menu.setText("Welcome!!");
					}else {
						GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
						timer.cancel();
					}
					
				}
			});
	
			
			viewObjects.add(welcomeBackground);
			viewObjects.add(carnival);
			viewObjects.add(menu);
			
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
			
			
			
			//
			 
			
		}
		//maybe have balloons animation

		
	}

