package foodJoannaAnnie;

import guiTeacher.components.*;

public class AnnieFoodItem extends ClickableGraphic {
	
	private String name;
	private double price;
	private boolean topping;

	public AnnieFoodItem(int x, int y, int w, int h, String imageLocation, String name, double price, boolean topping) {
		super(x, y, w, h, imageLocation);
		this.name = name;
		this.price = price;
		this.topping = topping;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public boolean isTopping() {
		return topping;
	}
	
	public boolean equals(AnnieFoodItem item) {
		return this.getName() == item.getName();
	}

}
