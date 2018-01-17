package foodJoannaAnnie;

import guiTeacher.components.ClickableGraphic;

public class JoannaOrders extends ClickableGraphic {

	private String[] requested;
	private int numIng;
	private AnnieWorkScreen annie;

	public JoannaOrders(int x, int y, int w, int h, String imageLocation, AnnieWorkScreen screen) {
		super(x, y, w, h, imageLocation);
		annie = screen;
		numIng= (int) ((Math.random()*5)+1);
		requested = new String[numIng];
		generateItems();
	}
	
	private void generateItems() {
		int n = 0;
		for(int i=0;i<requested.length;i++) {
			//while() {
				n= (int)((Math.random()*annie.getNames().length));
			//}
			requested[i]= annie.getName()[n];
		}

	}






}
