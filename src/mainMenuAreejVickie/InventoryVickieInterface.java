package mainMenuAreejVickie;

import java.util.ArrayList;

import poppingBalloonsJessicaJi.DartJessica;

public interface InventoryVickieInterface {

	void initializeDarts();
	
	void updateDarts();
	
	void amtOfBears();
	
	void amtOfFish();
	
	void amtOfCandy();
	
	int getTickets();

	void setTickets(int num);

	 public double getMoney();

	 public void setMoney(double num);

	 ArrayList<DartJessica> darts();

	 ArrayList<String> getInventoryArrayList();

	 void setInventoryArrayList(ArrayList<String> arr);
	 void setHammer(boolean n);
	 boolean getHammer();

	void setDarts(String dull, String blunt, String sharp, String dan);
}
