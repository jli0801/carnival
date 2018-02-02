package foodJoannaAnnie;

import guiTeacher.components.*;

public class AnnieFoodItem extends ClickableGraphic {
	
	private String name;
	private double price;
	private boolean clicked;

	public AnnieFoodItem(int x, int y, int w, int h, String imageLocation, String name, double price) {
		super(x, y, w, h, imageLocation);
		this.name = name;
		this.price = price;
		clicked = false;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public boolean isClicked() {
		return clicked;
	}
	
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	public boolean equals(AnnieFoodItem item) {
		return this.getName() == item.getName();
	}

}
