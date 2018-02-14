package whackAMoleKevinSteph;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

import java.util.Timer;
import java.util.TimerTask;

import java.util.Random;

public class WAMCasual extends FullFunctionScreen {

	private int time;
	private int score;
	private TextArea scoreText;
	private TextArea timeText;
	private ClickableGraphic m1;
	private ClickableGraphic m2;
	private ClickableGraphic m3;
	private ClickableGraphic m4;
	private ClickableGraphic m5;
	private ClickableGraphic m6;
	private ClickableGraphic m7;
	private ClickableGraphic m8;
	private ClickableGraphic m9;
	
	public WAMCasual(int width, int height) {
		super(width, height);
		//time = 5;
		score = 0;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic gamebg = new Graphic(0,0, getWidth(), getHeight(), "wam/grass.png");
		viewObjects.add(gamebg);
		
		m1 = new ClickableGraphic(250,200,80,80,"wam/mole.png");
		m1.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m1);
				score++;
				endGame();
			}
		});
		viewObjects.add(m1);
		
		m2 = new ClickableGraphic(450,200,80,80,"wam/mole.png");
		m2.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m2);
				score++;
				endGame();
				
			}
		});
		viewObjects.add(m2);
		
		m3 = new ClickableGraphic(650,200,80,80,"wam/mole.png");
		m3.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m3);
				score++;
				
			}
		});
		viewObjects.add(m3);
		
		m4 = new ClickableGraphic(250,400,80,80,"wam/mole.png");
		m4.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m4);
				endGame();
			}
		});
		viewObjects.add(m4);
		
		m5 = new ClickableGraphic(450,400,80,80,"wam/mole.png");
		m5.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m5);
				
			}
		});
		viewObjects.add(m5);
		
		m6 = new ClickableGraphic(650,400,80,80,"wam/mole.png");
		m6.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m6);
				
			}
		});
		viewObjects.add(m6);
		
		m7 = new ClickableGraphic(250,600,80,80,"wam/mole.png");
		m7.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m7);
				
			}
		});
		viewObjects.add(m7);
		
		m8 = new ClickableGraphic(450,600,80,80,"wam/mole.png");
		m8.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m8);
				
			}
		});
		viewObjects.add(m8);
		
		m9 = new ClickableGraphic(650,600,80,80,"wam/mole.png");
		m9.setAction(new Action() {
			
			@Override
			public void act() {
				viewObjects.remove(m9);
				
			}
		});
		viewObjects.add(m9);
		
		
		//timeText = new TextArea(950,150,200,200, "Time: " + time + " Seconds");
		//viewObjects.add(timeText);
		//Timer();

	}
	
	public void endGame() {
		if (score == 2) {
			GuiLoadingVickie.loading.setScreen(new WAMResultStephanie(getWidth(), getHeight()));
			GUIApplication.enableCursorChange = true;
		}
	}

	/* private void Timer() {
		Timer timer = new Timer();
		TimerTask task;
		task = new TimerTask() {
			@Override
			public void run() { 
				if (time < 0) {
					cancel();
					endGame();
				} else {
					timeText.setText("Time Left: " + time);
					time--;
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}
	*/
}
