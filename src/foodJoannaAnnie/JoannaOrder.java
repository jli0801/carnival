package foodJoannaAnnie;

import java.awt.Component;
import java.util.ArrayList;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import guiTeacher.components.ClickableGraphic;

public class JoannaOrder extends ClickableGraphic {

	private int[] quantity; //toppings that will be used
	private int numInt; //# of toppings for tht order
	private AnnieWorkScreen annie;
	private AnnieFoodItem[] items; //complete order
	
	private Object[][] order;
	private Object[][] currentOrder;
	private ArrayList<AnnieFoodItem> holder;

	public Object[][] getOrder() {
		return order;
	}


	private ArrayList<AnnieFoodItem> screen;
	private ArrayList<AnnieFoodItem> temp;


	public JoannaOrder(int x, int y, int w, int h, String imageLocation, AnnieWorkScreen screen) {
		super(x, y, w, h, imageLocation);
		annie = screen;
		numInt = (int) ((Math.random()*5)+1);
		fillQuantity();
		generateToppings(annie.getToppings());
		makeOrder(numInt);

	}

	public JoannaOrder(int x, int y, int w, int h, String imageLocation,ArrayList<AnnieFoodItem> onScreen, Object[][] currentOrder) {
		super(x, y, w, h, imageLocation);
		screen = onScreen;
		temp = new ArrayList<AnnieFoodItem>();
		for(AnnieFoodItem foodItem : onScreen) {
			temp.add(foodItem);
		}
		this.currentOrder = currentOrder;
		setVisible(false);
		countItems();
	}




	private int findLength() {  //deletes repeating toppings 
		for(int i = 0; i < temp.size(); i++) {
			for(int j = i+1; j < temp.size(); j++) {
				if(temp.get(i).equals(temp.get(j))) {
					temp.remove(j);
					j--;
				}
			}

		}
		return temp.size();
	}

	private void countItems() {
		int mLen = notOnscreen();
		numInt = findLength();
		int fullLength = numInt +mLen;
		quantity =  new int[fullLength];
		items = new AnnieFoodItem[fullLength];
		for(int i=0; i < screen.size(); i++) {
			int tracker = 1;
			for(int j = i+1; j < screen.size(); j++) {
				if(screen.get(i).equals(screen.get(j))) {
					tracker++;
					screen.remove(j);
					j--;
				}

			}
			quantity[i] = tracker;
			items[i] = screen.get(i);	
		}
		int counter = 0;
		for(int k = numInt; k <fullLength; k++) {
			 quantity[k] = 0;
			 items[k] = holder.get(counter);
			 counter++;
			}
		
		makeOrder(numInt+notOnscreen());
	}

	private int notOnscreen() {
		int missingLen = 0;
		boolean exist = false;
		AnnieFoodItem temp = null;
		for(int i = 0; i < currentOrder.length; i++){
			for(int j = 0; j < order.length; j++) {
				if(currentOrder[i][1] == order[j][1]) 
					exist = true;
					else {
					temp =   (AnnieFoodItem) currentOrder[i][1]; 
				} 
			} 
			if(!exist) {
				holder.add(temp);
				missingLen++;
			}
		
	}
		return missingLen;
	}

	private void makeOrder(int len) {
		order = new Object[len][2];
		for(int i = 0; i<items.length; i++) {
			order[i][0] = quantity[i];
			order[i][1] = items[i];
		}

	}

	private void generateToppings(AnnieFoodItem[] arr) {
		items=  new AnnieFoodItem[numInt];
		int a;
		AnnieFoodItem b;
		for (int i = arr.length - 1; i > 0; i--) {
			a = (int) Math.floor(Math.random() * (i + 1));
			b = arr[i];
			arr[i] = arr[a];
			arr[a] = b;
		}
		for(int i = 0; i< items.length;i++) {
			items[i]= arr[i];
		}

	}

	private void fillQuantity() {
		quantity = new int[numInt];
		for(int i =0; i < quantity.length; i++) {
			quantity[i] = (int)((Math.random()*8)+4);
		}	
	}


	public String toString() {
		String s="1 PIZZA" +"\n";
		for(int i=0; i<numInt; i++) {
			s+="- "+ order[i][0]+  " " + ((AnnieFoodItem) order[i][1]).getName()+"\n" ; 
		}
		return s;
	}
}









