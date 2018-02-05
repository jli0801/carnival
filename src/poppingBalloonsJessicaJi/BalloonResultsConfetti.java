package poppingBalloonsJessicaJi;

import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;

public class BalloonResultsConfetti extends AnimatedComponent{

	public BalloonResultsConfetti() {
		super(40, 40, 100, 80);
		addSequence("poppingBalloons/", 150, 0, 0, 100, 200, 10);
		Thread animation = new Thread(this);
		animation.start();
		update();
	}

	@Override
	public void update(Graphics2D g) {
		super.update(g);
	}
}
