package poppingBalloonsJessicaJi;

import java.util.ArrayList;

public class BalloonBack {
	
	ArrayList<String> darts = new ArrayList<String>(); 
	ArrayList<String> dartsProperty = new ArrayList<String>(); 
	public static ArrayList<String> balloons = new ArrayList<String>(); //static b/c jessica needs to use it
	public static ArrayList<String> balloonsProperty = new ArrayList<String>(); //static b/c jessica needs to use it
	
	public void Timer() { //links to text area
		//thread
	}
	
	public void CreateDarts() {
		//for loop make darts
	}
	
	public static ArrayList<String> CreateBalloons() {
		return balloons; //static because jessica needs to display it
		//for loop make balloons
	}
	
	public void UpdateBalloons(int x ) { //x represents index
		//front end-balloon deleted -> goes to confetti
		//thread for time & disable button  
		//change a balloon at the same position and change strength 
	}
	
	public void MakeBallonsPoppable() {
		//for loop make poppable
	}
	
	public void MakeBalloonsUnpoppable() {
		//for loop make unpoppable
	}
	
	
	public void EndGame() {
		//disable buttons & switch screen
		
	}
	
}
