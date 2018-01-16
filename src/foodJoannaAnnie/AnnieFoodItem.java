package foodJoannaAnnie;

import guiTeacher.components.ClickableGraphic;

public class AnnieFoodItem extends ClickableGraphic {
	
	private String name;
	private double price;

	public AnnieFoodItem(int x, int y, int w, int h, String imageLocation, String name, double price) {
		super(x, y, w, h, imageLocation);
		this.name = name;
		this.price = price;
	}

}
