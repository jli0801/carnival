package foodJoannaAnnie;

import java.awt.Color;

import guiTeacher.components.*;
import mainMenuAreejVickie.GuiLoadingVickie;

public class AnnieJoannaInstructions implements AnnieInstructionInterface {

	@Override
	public Color getBackgroundColor() {
		return new Color(255, 210, 220);
	}

	@Override
	public String getGameName() {
		return "Go to work, make a pizza";
	}

	@Override
	public Color getButtonColor() {
		return new Color(255, 135, 150);
	}

	@Override
	public String getInstructions() {
		String s = "Work at the carnival's concession stand, and earn money to support your carnival game playing career! "
				+ "Construct the pizzas according to the orders by clicking on the toppings requested. Make sure to include anything else requested on the orders. "
				+ "Follow the orders carefully! "
				+ "The amount of money you earn will be based on how accurately you follow the customer's order. You will be penalized for any food that you waste. "
				+ "After you've completed the order, press 'done' to serve the customer.";
		return s;
	}

	@Override
	public boolean hasBackImage() {
		return false;
	}

	@Override
	public String getBackImageLocation() {
		return null;
	}

	@Override
	public int getNumButtons() {
		return 1;
	}

	@Override
	public Button getButton(int i) {
		return null;
	}

	@Override
	public void playButtonAct() {
		GuiLoadingVickie.loading.setScreen(GuiLoadingVickie.foodGame);
	}

	@Override
	public Color getTitleColor() {
		return new Color(235, 115, 130);
	}

}
