package foodJoannaAnnie;

import java.util.ArrayList;

public interface JoannaScreenInterface {
	
	public AnnieFoodItem[] getToppings();
	
	public AnnieFoodItem[] getItems();
	
	public JoannaOrder getCurrentOrder();
	
	public int getTrashCount();
	
	public ArrayList<AnnieFoodItem> getOnScreen();
	
}
