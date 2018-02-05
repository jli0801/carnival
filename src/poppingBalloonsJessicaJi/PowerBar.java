package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.MovingComponent;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;

public class PowerBar extends MovingComponent implements Visible {

	private int length;
	private int width;
	private int startX;
	private int startY;
	private Color lightYellow = new Color (255,255,153);
	private Color lightRed = new Color (255,153,153);
	
	public PowerBar(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		width = w;
		length = h;
		startX = x;
		startY = y;
		setVisible(true);
		//update();
		setVx(-1);
		Thread go = new Thread(this);
		go.start();
		// TODO Auto-generated constructor stub
	}

	
	public int getLength()
	{
		return length; //equal to the strength will start at 5
	}


	/* public void paint(Graphics g) {
		
	    }*/


	@Override
	public void drawImage(Graphics2D g) {
		
 	  Thread move = new Thread(new Runnable() {

		@Override
		public void run() {

			if(length <= 35) //going up
				{
					length = length + 5; // 5,10,15,20,25,30,35,40
					if(length <= 15) //5 -> 15
					{
						g.setColor(Color.yellow);
					}
					else if (length <= 25 && length > 15) //16 -> 25
					{
						g.setColor(lightYellow);
					}
					else if (length >= 35 && length < 25) //26 -> 35
					{
						g.setColor(lightRed);
					}
					else//36 -> 40
					{
						g.setColor(Color.RED);
					}
				}
				else //going down 
				{
					length = length-5; //5,10,15,20,25,30,35,40
					if(length <= 40) //36 -> 40
					{
						g.setColor(Color.RED);
					}
					else if (length >= 35 && length < 25) //35 ->26
					{
						g.setColor(lightRed);
					}
					else if (length >= 25 && length < 15) //25 -> 16
					{
						g.setColor(lightYellow);
					}
					else//5->15
					{
						g.setColor(Color.YELLOW);
					}
				}

			g.drawRect(startX, startY, width, length);
			g.fillRect(startX, startY, width, length);


			try {
				Thread.sleep(BalloonScreen.getTimeLeft());
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	move.start();
		try {
			move.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public float getAlpha() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setAlpha(float f) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void unhoverAction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void hoverAction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void checkBehaviors() {
		// TODO Auto-generated method stub
		
	}
	

}
