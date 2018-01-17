package whackAMoleKevinSteph;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainGameScreen extends FullFunctionScreen {

	private Button returnMSButton;
	private Button instructionsButton;
	private Button startButton;
	private TextBox instructionsText;

	public MainGameScreen(int width, int height) {
		super(width, height);

	}

	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic background = new Graphic(0,0, getWidth(), getHeight(), "resources/background.jpg");
		
		returnMSButton = new Button(100,100,200,50,"RETURN TO MAIN MENU",Color.RED, new Action() {

			public void act() {
				returnMainScreen();
			}
		});

		viewObjects.add(returnMSButton);

		instructionsButton = new Button(100,200,200,50,"SEE INSTRUCTIONS",Color.YELLOW, new Action() {

			public void act() {
				showInstructions();
			}
		});

		viewObjects.add(instructionsButton);

		startButton = new Button(100,300,200,50,"START GAME",Color.GREEN, new Action() {

			public void act() {
				startGame();
			}
		});

		viewObjects.add(startButton);

		instructionsText = new TextBox(500,100,500,500,"WELCOME TO WHACK-A-MOLE");
		instructionsText.setInactiveBorderColor(Color.RED);
		instructionsText.setReadOnly(true);
		instructionsText.setEditable(false);
		instructionsText.update();
		viewObjects.add(instructionsText);
	}

	public void returnMainScreen() {
		System.out.print("Return to Main Screen");
	}

	public void showInstructions() {
		instructionsText.setText("HOW TO PLAY:" + "\n" + "YOU HAVE....");
		instructionsText.update();
	}

	public void startGame() {
		System.out.print("Start Game");
	}

}
