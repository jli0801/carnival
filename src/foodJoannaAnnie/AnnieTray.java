package foodJoannaAnnie;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;
import guiTeacher.components.StyledComponent;

public class AnnieTray extends Component {
	
	private String[] imgLocations;

	public AnnieTray(int x, int y, int w, int h) {
		super(x, y, w, h);
		setVisible(true);
		String[] temp1 = {"food/pepperoni.png", "food/onion.png", "food/pineapple.png", "food/mushroom.png", "food/olive.png", "food/bacon.png", "food/pepper.png", "food/sausage.png",
				"food/soda.png", "food/donut.png", "food/corn.png", "food/popcorn.png"};
		imgLocations = temp1;
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(new Color(240, 240, 200));
		g.fillRect(0, 0, 700, 450);
		g.setColor(Color.black);
		g.drawRect(0, 0, 700, 450);
	}

	public void add(int i) {
		// TODO Auto-generated method stub
		
	}

}
