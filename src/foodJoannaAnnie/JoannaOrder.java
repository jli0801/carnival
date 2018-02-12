package foodJoannaAnnie;

import java.awt.Component;
import java.util.ArrayList;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import guiTeacher.components.ClickableGraphic;

public class JoannaOrder extends ClickableGraphic {

	private ArrayList<Integer> quantity; //toppings that will be used
	private int numInt; //# of toppings for tht order
	private AnnieWorkScreen annie;
	private ArrayList <AnnieFoodItem> items; //complete order

	//private Object[][] order;
	private ArrayList<Object[]> userOrder;
	private ArrayList<Object[]> currentOrder;
	//private Object[][] currentOrder;


	public ArrayList<Object[]> getOrder() {
		return userOrder;
	}


	private ArrayList<AnnieFoodItem> screen;
	private ArrayList<AnnieFoodItem> temp;


	public JoannaOrder(int x, int y, int w, int h, String imageLocation, AnnieWorkScreen screen) {
		super(x, y, w, h, imageLocation);
		annie = screen;
		numInt = (int) ((Math.random()*5)+1);
//		fillQuantity();
		generateToppings(annie.getToppings());
		//makeOrder();

	}

	public JoannaOrder(int x, int y, int w, int h, String imageLocation,ArrayList<AnnieFoodItem> onScreen, ArrayList<Object[]>currentOrder) {
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
		numInt = findLength();
		for(int i=0; i < screen.size(); i++) {
			int tracker = 1;
			for(int j = i+1; j < screen.size(); j++) {
				if(screen.get(i).equals(screen.get(j))) {
					tracker++;
					screen.remove(j);
					j--;
				}

				makeOrder(tracker,screen.get(i));
			}
			quantity.add(tracker);
			items.set(i, screen.get(i));
			
		}



	}

	//	private void addMissingOrder() {
	//		int mLen = notOnscreen();
	//		int fullLength = mLen + numInt;
	//		Object[][] temp = new Object[fullLength][2];
	//		for(int i =0; i < numInt; i++) {
	//			temp[i][0] = order[i][0];
	//			temp[i][1] = order[i][1];
	//		}
	////		quantity = new int[mLen];
	//		items = new AnnieFoodItem[mLen];
	//		int m = fullLength+1;
	//		for(int k = numInt; k <fullLength; k++) {
	//			// quantity[k] = 0;
	//			 items[k] = holder.get(m-k);
	//			}
	//		for(int i = fullLength-mLen; i<temp.length; i++) {
	//			temp[i][0] = 0; //quantity[m-i];
	//			temp[i][1] = items[m-i];
	//		}
	//		order = new Object[fullLength][2];
	//		order = temp;
	//	}



	//	private int notOnscreen() {
	//		int missingLen = 0;
	//		boolean exist = false;
	//		AnnieFoodItem temp = null;
	//		for(int i = 0; i < currentOrder.length; i++){
	//			for(int j = 0; j < order.length; j++) {
	//				if(currentOrder[i][1] == order[j][1]) 
	//					exist = true;
	//					else {
	//					temp =   (AnnieFoodItem) currentOrder[i][1]; 
	//				} 
	//			} 
	//			if(!exist) {
	//				holder.add(temp);
	//				missingLen++;
	//			}
	//		
	//	}
	//		return missingLen;
	//	}

	private void makeOrder(int tracker, AnnieFoodItem annieFoodItem) {
		Object[] temp = {tracker, annieFoodItem};
		userOrder.add(temp);// quantity[i];

	}



	private void generateToppings(AnnieFoodItem[] arr) {
		int a;
		AnnieFoodItem b;
		for (int i = arr.length - 1; i > 0; i--) {
			a = (int) Math.floor(Math.random() * (i + 1));
			b = arr[i];
			arr[i] = arr[a];
			arr[a] = b;
		}
		for(int i = 0; i< numInt;i++) {
			items.add(arr[i]);
		}

	}

	private void fillQuantity() {

		for(int i =0; i < numInt; i++) {
			int n =(int) ((Math.random()*8)+4);
			quantity.add(n); 
		}	
	}


	public String toString() {
		String s="1 PIZZA" +"\n";
		for(int i=0; i<numInt; i++) {
			Object[] order = userOrder.get(i);
			s+="- "+ order[0] +  " " + ((AnnieFoodItem) order[1]).getName()+"\n" ; 
		}
		return s;
	}
}









