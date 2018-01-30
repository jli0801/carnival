package poppingBalloonsJessicaJi;

import java.awt.Color;
import java.awt.Graphics;

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

	 public void paint(Graphics g) {
		 
	        g.setColor(Color.red);
	        g.drawRect (startX, startY, width, length);  
	        g.fillRect (startX, startY, width, length);
	       
	        
	        Thread move = new Thread(new Runnable() {

				@Override
				public void run() {
					length = length * 2;
					g.setColor(Color.red);
			        g.drawRect(startX, startY, width, length);
			        g.fillRect(startX, startY, width, length);
					try {
						Thread.sleep(2000);
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
