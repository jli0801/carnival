package foodJoannaAnnie;

import java.util.ArrayList;

import guiTeacher.components.ClickableGraphic;

public class JoannaOrders extends ClickableGraphic {

	private AnnieFoodItem[] requested;
	private int numIng;
	private AnnieWorkScreen annie;
	private JoannaOrders currentOrder;
	private ArrayList<AnnieFoodItem> onScreen;

	public void setCurrentOrder(JoannaOrders currentOrder) {
		this.currentOrder = currentOrder;
	}

	public void setOnScreen(ArrayList<AnnieFoodItem> onScreen) {
		this.onScreen = onScreen;
	}

	public void setTrashCount(int trashCount) {
		this.trashCount = trashCount;
	}

	private int trashCount;

	public JoannaOrders(int x, int y, int w, int h, String imageLocation, AnnieWorkScreen screen) {
		super(x, y, w, h, imageLocation);
		annie = screen;
		numIng= (int) ((Math.random()*5)+1);
		requested = new AnnieFoodItem[numIng];
		generateToppings();
	}

	private void generateToppings() {
		int[] track;
		track= new int[numIng];
	
		int n= (int)((Math.random()*annie.getToppings().length));



	}

}




/***
 * 
 * int[] track;
		track= new int[numIng];
		for(int i=0;i<requested.length;i++) {

				int n= (int)((Math.random()*annie.getToppings().length));
				track[i] = n;
			requested[i]= annie.getToppings()[n];
 * 
 * 
 * 
 * 
 */




