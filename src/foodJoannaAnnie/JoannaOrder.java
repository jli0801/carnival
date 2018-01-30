package foodJoannaAnnie;

import java.util.ArrayList;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import guiTeacher.components.ClickableGraphic;

public class JoannaOrder extends ClickableGraphic {

	private AnnieFoodItem[] requested; //toppings that will be used
	private int numIng; //# of toppings for tht order
	private AnnieWorkScreen annie;
	private Object[][] order; //complete order


	public JoannaOrder(int x, int y, int w, int h, String imageLocation, AnnieWorkScreen screen) {
		super(x, y, w, h, imageLocation);
		annie = screen;
		numIng= (int) ((Math.random()*5)+1);
		requested = new AnnieFoodItem[numIng];

		generateToppings(annie.getToppings());
		getOrder();
	}

	private AnnieFoodItem[] generateToppings(AnnieFoodItem[] arr) {
		int a;
		AnnieFoodItem b;
		for (int i = arr.length - 1; i > 0; i--) {
			a = (int) Math.floor(Math.random() * (i + 1));
			b = arr[i];
			arr[i] = arr[a];
			arr[a] = b;
		}
		for(int i = 0; i< requested.length;i++) {
			requested[i]= arr[1];
		}

		return requested;

	}


	private Object[][] getOrder(){
		order = new Object[requested.length][2];
		int quantity;
		for(int aOrder =0; aOrder<order.length;aOrder++) {
			for(int idx =0; order[aOrder].length< 2;idx++) {
				quantity = (int) ((Math.random()*7)+3);
				if(idx == 0) {
					order[aOrder][idx]= quantity;
				}else {
					order[aOrder][idx]= requested[aOrder];
				}

			}

		}
		return order;
	}
	
	public String toString() {
		String s="";
		for(int i=0; i<order.length; i++) {
			for(int j=0; j<order[i].length; j++) {
				s+= order[i]+" "+order[i][j] + "\n"; 
			}
		}
		return s;
	}


}








