package poppingBalloonsJessicaJi;

import java.awt.Color;

import foodJoannaAnnie.AnnieInstructionInterface;
import guiTeacher.components.Button;
import mainMenuAreejVickie.GuiLoadingVickie;

public class JessicaJiInstructions implements AnnieInstructionInterface {

	@Override
	public Color getBackgroundColor() {
		return new Color(200, 240, 255); 
	}

	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "Popping Balloons";
	}

	@Override
	public Color getButtonColor() {
		return new Color(180, 230, 255); 
	}

	@Override
	public String getInstructions() {
		// TODO Auto-generated method stub
		return "When time starts, Try to pop as many as you can "
				+ "but not all of them will pop "
				+ "according to which dart you’re using and how much strength you have. The balloons will "
				+ "pop up again but stronger each time."
				+ " You are given four darts of each type, dull, blunt, strong, dangerous. It is listed "
				+ "from weakest to strongest."
				+ " Be sure to use them wisely! Good Luck!"
				+ "\n\n"
				+ " Proceed with the game by clicking 'Play.'";
	}

	@Override
	public String getBackImageLocation() {
		// TODO Auto-generated method stub
		return "poppingBalloons/back.png";
	}

	@Override
	public int getNumButtons() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Button getButton(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void playButtonAct() {
		GuiLoadingVickie.loading.setScreen(new BalloonScreenJessica(GuiLoadingVickie.loading.getWidth(), GuiLoadingVickie.loading.getHeight()));
		
	}

	@Override
	public Color getTitleColor() {
		return new Color(235, 115, 130);
	}

}
