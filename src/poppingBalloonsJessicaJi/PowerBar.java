package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;


import guiTeacher.components.AnimatedComponent;

public class PowerBar extends AnimatedComponent {

	private int length;
	private int width;
	private int startX;
	private int startY;
	
	public PowerBar(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		width = w;
		length = h;
		startX = x;
		startY = y;
		// TODO Auto-generated constructor stub
	}

	
	public int getLength()
	{
		return length; //equal to the strength will start at 0
	}
	
	public static void main(String args[]){
	
	}

	 public void paint(Graphics g) {
		 
		 Color lightYellow = new Color (255,255,153);
		 Color lightRed = new Color (255,153,153);
		 
	     g.setColor(Color.green);
	     g.drawRect(startX, startY, width, length);  
	     g.fillRect(startX, startY, width, length);
	       	        
	        Thread move = new Thread(new Runnable() {

				@Override
				public void run() {
					length = length * 2; //goes up exponentially by 2. 2,4,8,16,32
					if(length <= (int)BalloonScreen.getTimeLeft()/4) //below 8
					{
					g.setColor(Color.yellow);
					}
					else if (length < BalloonScreen.getTimeLeft()/2 && (length > (int)BalloonScreen.getTimeLeft()/4)) //8 to 15
					{
						g.setColor(lightYellow);
					}
					else if (length > BalloonScreen.getTimeLeft()/2 && (length < (int)BalloonScreen.getTimeLeft()*(3/4))) //15 to 23
					{
						g.setColor(lightRed);
					}
					else//23 to 30
					{
						g.setColor(Color.RED);
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
}
