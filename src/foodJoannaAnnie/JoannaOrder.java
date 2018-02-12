package foodJoannaAnnie;

import java.awt.Component;
import java.util.ArrayList;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import guiTeacher.components.ClickableGraphic;

public class JoannaOrder extends ClickableGraphic {

	private ArrayList<Integer> quantity; //toppings that will be used
	private int numInt; //# of toppings for tht order
	private int itemCount;
	private AnnieWorkScreen annie;
	private ArrayList<AnnieFoodItem> items; //complete order

	//private Object[][] order;
	private ArrayList<Object[]> order;
	private ArrayList<Object[]> userOrder;
	private ArrayList<Object[]> currentOrder;
	//private Object[][] currentOrder;


	public ArrayList<Object[]> getOrder() {
		return order;
	}


	private ArrayList<AnnieFoodItem> screen;
	private ArrayList<AnnieFoodItem> temp;


	public JoannaOrder(int x, int y, int w, int h, String imageLocation, AnnieWorkScreen screen) {
		super(x, y, w, h, imageLocation);
		annie = screen;
		numInt = (int) ((Math.random()*5)+1);
		currentOrder = new ArrayList<Object[]>();
		quantity = new ArrayList<Integer>();
		items = new ArrayList<AnnieFoodItem>();
		fillQuantity();
		generateToppings(annie.getToppings(),numInt);
		itemCount = (int) ((Math.random()*3)+1);
		generateToppings(annie.getItems(),itemCount);
		while(items.size()!=quantity.size())
			quantity.add(1);
		order = currentOrder;
		makeOrder();


	}

	public JoannaOrder(int x, int y, int w, int h, String imageLocation,ArrayList<AnnieFoodItem> onScreen, ArrayList<Object[]>currentOrder) {
		super(x, y, w, h, imageLocation);
		screen = onScreen;
		temp = new ArrayList<AnnieFoodItem>();
		userOrder = new ArrayList<Object[]>();
		quantity = new ArrayList<Integer>();
		items = new ArrayList<AnnieFoodItem>();
		
		for(AnnieFoodItem foodItem : onScreen) {
			temp.add(foodItem);

		}
		this.currentOrder = currentOrder;
		setVisible(false);
		addCurrentOrder();
		deleteCopies();
		updateItems();

		getQuantity();
		order = userOrder;
		makeOrder();

	}




	//	private void getCurrentOrderQuantity() {
	//		int count = 0;
	//		for(int i = 0; i < items.size(); i++) {
	//			for(int j = 0; i <screen.size(); j++) {
	//				if(items.get(i).equals(screen.get(j))) {
	//					count++;
	//					screen.remove(j);
	//				}
	//			}
	//			quantity.add(count);
	//		}
	//	}

	private void getQuantity() {
		int count = 0;
		for(int i = 0; i <items.size(); i++) {
			for(int j = 0; j <screen.size(); j++) {
				if(items.get(i).equals(screen.get(j))) {
					count++;
				}
			}
			quantity.add(count);
		}
	}

	private void updateItems() {
		for(int i =0; i< temp.size();i++) {
			if(!check(i)) {
				items.add(temp.get(i));
			}
		}


	}

	private boolean check(int i) { //true means it's exists 
		for(int j=0; j< items.size();j++) {
			if(items.get(j).equals(temp.get(i)))
				return true;
		}
		return false;
	}

	private void addCurrentOrder() { //whatever was on the order is now on the receipt 
		for(Object[] a: currentOrder) {
			items.add((AnnieFoodItem) a[1]);
		}
	}

	private void deleteCopies() {  //deletes repeating toppings 
		for(int i = 0; i < temp.size(); i++) {
			for(int j = i+1; j < temp.size(); j++) {
				if(temp.get(i).equals(temp.get(j))) {
					temp.remove(j);
					j--;
				}
			}
		}	
	}






	private void makeOrder() {
		for(int i=0; i< items.size(); i++) {
			Object[] temp = {quantity.get(i), items.get(i)};
			order.add(temp);
		}




	}



	private void generateToppings(AnnieFoodItem[] arr,int len) {
		int a;
		AnnieFoodItem b;
		for (int i = arr.length - 1; i > 0; i--) {
			a = (int) Math.floor(Math.random() * (i + 1));
			b = arr[i];
			arr[i] = arr[a];
			arr[a] = b;
		}
		for(int i = 0; i< len;i++) {
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
			Object[] o = order.get(i);
			s+="- "+ o[0] +  " " + ((AnnieFoodItem) o[1]).getName()+"\n" ; 
		}
	
		for(int i=numInt; i<order.size(); i++) {
			Object[] o = order.get(i);
			s+=""+ o[0] +  " " + ((AnnieFoodItem) o[1]).getName()+"\n" ; 
		}
		return s;
	}
}




//	private void countItems() {
//		numInt = findLength();
//		for(int i=0; i < screen.size(); i++) {
//			int tracker = 1;
//			for(int j = i+1; j < screen.size(); j++) {
//				if(screen.get(i).equals(screen.get(j))) {
//					tracker++;
//					screen.remove(j);
//					j--;
//				}
//
//				
//			}
//			quantity.add(tracker);
//			items.set(i, screen.get(i));
//
//		}makeOrder();
//	}
//
//	private void addMissingOrder() {
//		int mLen = notOnscreen();
//		int fullLength = mLen + numInt;
//		Object[][] temp = new Object[fullLength][2];
//		for(int i =0; i < numInt; i++) {
//			temp[i][0] = order[i][0];
//			temp[i][1] = order[i][1];
//		}
//		quantity = new int[mLen];
//		items = new AnnieFoodItem[mLen];
//		int m = fullLength+1;
//		for(int k = numInt; k <fullLength; k++) {
//			// quantity[k] = 0;
//			items[k] = holder.get(m-k);
//		}
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




