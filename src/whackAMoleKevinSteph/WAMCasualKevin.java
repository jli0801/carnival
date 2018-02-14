package whackAMoleKevinSteph;

import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Graphic;

public class WAMCasualKevin extends WAMEasyKevin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WAMCasualKevin(int width, int height) {
		super(width, height);
		
	}

	public static void main(String[] args) {
		

	}
	
	public void moleTimer(Graphic addMole,Graphic removeMole) {
		if (moleTimerOn < 9) {
			Timer mTimer = new Timer();
			TimerTask mTask;
			mTask = new TimerTask() {
				@Override
				public void run() { 
					if (moleTime > 0) {
						moleTime--;
					} else {
						cancel();
						moleTime = 5;
						moleSwap(addMole,removeMole);
						disableMole(removeMole);
						upMole();
					}
				}
			};
			mTimer.schedule(mTask, 0, 1000);
		}else {
			
		}
	}

}
