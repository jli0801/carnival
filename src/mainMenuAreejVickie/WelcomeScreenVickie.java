
package mainMenuAreejVickie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class WelcomeScreenVickie extends FullFunctionScreen {
		//private Button add;
		
		private  Button menu;
		private TextArea carnival;
		
		private Timer timer;
		private int count;
		private int randColor;
		
		private boolean startTimer;
		
		private boolean activate;
		private Color colors;
		
		private TimerTask complete;
		
		private Color []color = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.pink, Color.black, Color.DARK_GRAY, Color.magenta, Color.gray};
		private Timer startApp;
		private int startNum;
		
		private Timer background;
		private TimerTask updatePics;
		

		public WelcomeScreenVickie(int width, int height) {
			super(width, height);
			setVisible(true);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			
			/*
			 * https://stackoverflow.com/questions/39565472/how-to-automatically-execute-a-task-after-jframe-is-displayed-from-within-it
			 */
			
			
			if(!startTimer) {
				
				startTimer = !startTimer;
				
			}
			count = 1000;
			Graphic welcomeBackground = new Graphic(0,0, getWidth(), getHeight(), "resources/welcomeBackground21.jpg");
			
			carnival = new TextArea(225,75, 1000,1000, "Carnival");
			carnival.setForeground(Color.white);
			carnival.update();
//********	Changed TextArea in guiDoc.	
			
			timer = new Timer();
			complete = new TimerTask() {
				@Override
				public void run() {
					count --;
					//randomly change font color
					randColor = (int)(Math.random() * 11);
					colors = color[randColor];
					carnival.setForeground(colors);
					carnival.update();
					
					/*
					 * once open, the background is black and white pic
					 * the textarea in white text slowly says "welcome..to..the..CARNIVAL!" 
					 * once carnival is said, it turns a multitude of colors, welcomeBackground is in full color, 
					 * and the welcome button appears
					 */
					
					if(count ==0) {
						timer.cancel();
					}	
				}				
			};
			
			/*if(!startTimer) {
				timer.schedule(complete, 0, 200);
			}*/
			
			
			
			menu = new Button(getWidth() - 270, getHeight() - 180, 200, 100, "Welcome!", Color.red, new Action() {
				public void act() {
					/*if(!activate) {
						activate = !activate;
						timer.schedule(complete, 0, 200);
						menu.setText("Welcome!");
					}else {*/
						GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
						timer.cancel();
					//}
					
				}
			});
	
			
			viewObjects.add(welcomeBackground);
			viewObjects.add(carnival);
			viewObjects.add(menu);
			
			
			
			background = new Timer();
			updatePics = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				}
				
			};
			
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
			
			
			
			count = 1000;
			 if(count==1000) {
				 timer.schedule(complete, 0,200);
			 }
			//
			 
			
		}
		//maybe have balloons animation
	}

