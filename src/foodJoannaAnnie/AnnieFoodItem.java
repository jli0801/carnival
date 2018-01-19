package foodJoannaAnnie;

import java.awt.Graphics2D;

import guiTeacher.components.*;

public class AnnieFoodItem extends ClickableGraphic {
	
	private String name;
	private double price;

	public AnnieFoodItem(int x, int y, int w, int h, String imageLocation, String name, double price) {
		super(x, y, w, h, imageLocation);
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public void update(Graphics2D g, boolean hover) {
		
	}

}
