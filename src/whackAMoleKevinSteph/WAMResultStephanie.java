package whackAMoleKevinSteph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import mainMenuAreejVickie.GuiLoadingVickie;

public class WAMResultStephanie extends FullFunctionScreen {

	private Button returnMSButton;
	private Button playButton;
	private TextArea resultTitle;
	private TextArea ticketA;
	private TextArea scoreA;
	private TextArea totalA;
	private Graphic tpic;
	private Graphic mpic;
	private Graphic tapic;
	public int ticketNum;
	
	public WAMResultStephanie(int width, int height) {
		super(width, height);
	}
	
	public int getTickets() {
		if(WAMEasyKevin.score == 0) {
			ticketNum = 0;
		}else {
			ticketNum = (int)(Math.rint((WAMEasyKevin.score/2) + 1));
		}
		
		return ticketNum;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		Graphic gamebg = new Graphic(0,0, getWidth(), getHeight(), "wam/grass.png");
		viewObjects.add(gamebg);
			 
		returnMSButton = new Button(20,40,210,50,"RETURN TO MAIN MENU",Color.ORANGE, new Action() {

				public void act() {
					GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.menu);
					GUIApplication.enableCursorChange = true;
					
				}
			});

		viewObjects.add(returnMSButton);
		 
		playButton = new Button(980,40,200,50,"PLAY AGAIN", Color.ORANGE, new Action() {
			
			public void act() {
				GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.moleInstruct);
				GUIApplication.enableCursorChange = true;
			}
		});
		 
		viewObjects.add(playButton);
		
		resultTitle = new TextArea(510,165,500,270,"RESULTS");
		viewObjects.add(resultTitle);
				
		
		
		ticketA = new TextArea(420,280,500,280, "TICKETS EARNED: " + getTickets());
		Component box1 = new Component(320,230,520,120) {

			public void update(Graphics2D g) {
				drawBox(g, this, new Color(116, 195, 101));
			}
		};
		box1.setVisible(true);
		viewObjects.add(box1);
		viewObjects.add(ticketA);
		
		scoreA = new TextArea(410,380,500,270, "SCORE: " + WAMEasyKevin.score);
		Component box2 = new Component(320,340,520,120) {

			public void update(Graphics2D g) {
				drawBox(g, this, new Color(135, 169, 107));
			}
		};
		box2.setVisible(true);
		viewObjects.add(box2);
		viewObjects.add(scoreA);
		
		totalA = new TextArea(420,490,300,270, "TOTAL NUMBER OF TICKETS: ");
		Component box3 = new Component(320,450,520,120) {

			public void update(Graphics2D g) {
				drawBox(g, this, new Color(113, 188, 120));
			}
		};
		box3.setVisible(true);
		viewObjects.add(box3);
		viewObjects.add(totalA);
		
		tpic = new Graphic(340,250,80,80,"wam/ticket.png");
		viewObjects.add(tpic);
		
		mpic = new Graphic(340,350,80,80,"wam/mouse.png");
		viewObjects.add(mpic);
		
		tapic = new Graphic(340,470,80,80,"wam/totalA.png");
		viewObjects.add(tapic);
		
		try {

			File fontFile = new File("resources/Bangers.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font baseFont=font.deriveFont(26f);

			StyledComponent.setBaseFont(baseFont);
			
			resultTitle.setFont(font.deriveFont(50f));

			} catch (Exception e) {

			e.printStackTrace();

			}
	}
	
	protected void drawBox(Graphics2D g, Component component, Color color) {
		g.setColor(color);
		g.fillRect(0, 0, component.getWidth(), component.getHeight());
		g.setStroke(new BasicStroke(5));
		g.setColor(Color.black);
		g.drawRect(0, 0, component.getWidth() - 1, component.getHeight() - 1);
	}
	
}
