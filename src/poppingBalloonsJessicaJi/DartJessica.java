package poppingBalloonsJessicaJi;

import java.awt.Color;

public class DartJessica implements DartJiInterface{

	private String type;
	private int strength; //dull = 1 blunt = 2 
	private Color color;
	
	public DartJessica(String kind) {
		type = kind;
		strength = setStrength(kind);
		color = setColor(kind);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int setStrength(String kind) {
		if(kind.equals("Dull"))
		{
			return 1;
		}
		else if(kind.equals("Blunt"))
		{
			return 2;
		}
		else if(kind.equals("Strong"))
		{
			return 3;
		}
		else
		{
			return 4;
		}
	}
	
	//darts.get(i).getStrength = 1,2,3,4 
	//new DartJessica("Dull");
	//darts.get(dartChosen)
	public Color getColor() {
		return color;
	}
	
	public Color setColor(String kind) {
		if(kind.equals("Dull"))
		{
			return Color.BLACK;
		}
		else if(kind.equals("Blunt"))
		{
			return Color.BLUE;
		}
		else if(kind.equals("Strong"))
		{
			return Color.GREEN;
		}
		else
		{
			return Color.RED;
		}
	}
	
	

}
