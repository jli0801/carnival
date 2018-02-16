
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

public class WelcomeScreenVickie extends FullFunctionScreen {
	private Button menu;
	
	private TextArea carnival;
	
	private int count;
	private int track;
	private int randColor;
	
	private Color colors;
	
	private Timer timer;
	private TimerTask complete;

	private Color[] color = { Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.pink,
			Color.black, Color.DARK_GRAY, Color.magenta, Color.gray};

	private Timer background;
	private TimerTask updatePics;
	

	public WelcomeScreenVickie(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		track = 0;
		count = 0;

		Graphic welcomeBackground = new Graphic(0, 0, getWidth(), getHeight(), "resources/welcomeBackground1.jpg");

		viewObjects.add(welcomeBackground);

		//carnival = new TextArea(225, 75, 1000, 1000, "Carnival");
		
		carnival = new TextArea(225, 75, 1000, 1000, "WELCOME");
		
		//make carnival textarea change color
		timer = new Timer();
		complete = new TimerTask() {
			@Override
			public void run() {

				count++;
		
				if(count == 7) {
					carnival.setText("   To   ");
					carnival.setForeground(Color.DARK_GRAY);
					carnival.update();
				}
				
				if(count == 14) {
					carnival.setText("   The  ");
					carnival.setForeground(Color.lightGray);
					carnival.update();

				}
				
				if(count>21) {
					carnival.setText("Carnival");
				// randomly chooses color from array and change font color
				randColor = (int) (Math.random() * 11);
				colors = color[randColor];
				carnival.setForeground(colors);
				carnival.update();

				if (count == 1000) {
					timer.cancel();
				}
				}
			}
		};

		menu = new Button(getWidth() - 270, getHeight() - 180, 200, 100, "Welcome!", Color.red, new Action() {
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
				timer.cancel();
				background.cancel();
			}
		});
		
		menu.setBackgroundColor(Color.orange);

		viewObjects.add(carnival);
		viewObjects.add(menu);

		//change backgroundImages from black to color
		background = new Timer();
		updatePics = new TimerTask() {

			@Override
			public void run() {

				track++;
				if (track == 22) {
					background.cancel();
				} else {
					Graphic welcomeBackground = new Graphic(0, 0, getWidth(), getHeight(),
							"resources/welcomeBackground" + track + ".jpg");
					viewObjects.add(welcomeBackground);
					viewObjects.add(carnival);
					viewObjects.add(menu);
				}
			}

		};

		try {
			File fontFile = new File("resources/Bangers.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font carnivalTextArea = font.deriveFont(200f);
			Font menuButton = font.deriveFont(40f);

			carnival.setFont(carnivalTextArea);
			menu.setFont(menuButton); 

		} catch (Exception e) {

			e.printStackTrace();

		}

		//start timers
		if (count == 0) {
			background.schedule(updatePics, 2500, 200); //change backgroundImages
			timer.schedule(complete, 2000, 200); //make "Carnival" change color

		}

	}
}
