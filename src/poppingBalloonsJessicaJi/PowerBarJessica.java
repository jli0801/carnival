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

public class PowerBarJessica extends StyledComponent{

	public static int length;
	private Color lightYellow = new Color (255,255,150);
	private Color background = new Color(200, 240, 255);
	private boolean goingUp;
	
	
	public PowerBarJessica(int x, int y, int w, int h) {
		
		super(x, y, w, h);

		length = 15;
		setVisible(true);
		goingUp=true;
		
		update();
		
		// TODO Auto-generated constructor stub
	}

	
	public static int getLength()
	{
		return length; //equal to the strength will start at 5
	}


	
	@Override
	public void update(Graphics2D g) {
			g.setColor(background);
			g.fillRect(0, 0, getWidth(), getHeight()); 
			if(goingUp) //going up
			{
				length = length + 10; // 15,25,35,45,55,65,75,85,95,105,115
				if(length <= 45 && length > 15) // length is between 50 to 200
				{
					g.setColor(lightYellow);
				}
				else if (length <= 75 && length > 45) //16 -> 25
				{
					g.setColor(Color.YELLOW);
				}
				else if (length <= 95 && length > 75) //26 -> 35
				{
					g.setColor(Color.ORANGE);
				}
				else//36 -> 40
				{
					g.setColor(Color.RED);
				}
				
				if(length == 115)
				{
					goingUp = false;
				}
			}
			else //going down 
			{
				length = length - 10; //15,25,35,45,55,65,75,85,95,105,115
				if(length <= 115 && length > 95) //36 -> 40
				{
					g.setColor(Color.RED);
				}
				else if (length <= 95 && length > 75) //35 ->26
				{
					g.setColor(Color.ORANGE);
				}
				else if (length <= 75 && length > 45) //25 -> 16
				{
					g.setColor(Color.YELLOW);
				}
				else//5->15
				{
					g.setColor(lightYellow);
				}
				
				if(length == 15)
				{
					goingUp = true;
				}
			}
	
		g.fillRect(0, getHeight() - length, getWidth(), length);
		g.setColor(Color.BLACK);
		g.drawRect(0, getHeight() - length, getWidth()-1, length-1);
		
	}

	
	public void startTask(){
	
			Thread runTask = new Thread(new Runnable() {

				@Override
				public void run() {
					
					while(BalloonScreenJessica.getTimeLeft() > 0)
					{
						update();
						try {
							Thread.sleep((length));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
					
					
				
			});
			runTask.start();
		}

}
