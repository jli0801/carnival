package poppingBalloonsJessicaJi;

import java.awt.Color;

public interface DartJiInterface {

	String getType();
	//returns type
	
	void setType(String type);
	//sets type
	
	int getStrength();
	//returns strength
	
	int setStrength(String kind);
	//depending on description, sets strength to dart
	
	Color getColor();
	//returns color
	
	Color setColor(String kind);
	//sets color depending on dart description
	
}
