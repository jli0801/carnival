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
		 
	     g.setColor(Color.YELLOW);
	     g.drawRect(startX, startY, width, length);  
	     g.fillRect(startX, startY, width, length);
	       	        
	        Thread move = new Thread(new Runnable() {

				@Override
				public void run() {
					if(length <= 30) //going up
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
						length = length/2; //5,10,15,20,25,30,35,40
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
}
