package test;

import core.MySystem;
import core.screen.MyScreen;
import javafx.scene.input.KeyEvent;

public class TestScreen extends MyScreen {
	private Rect player;

	public TestScreen(double width, double height) {
		super(width, height);

		player = new Rect(50, 50, 100, 100);
		addObject(player);
	}

	@Override
	protected void onKeyPressed(KeyEvent event) {
		switch (event.getCode()) {
			case UP:
				player.moveY(-1);
				break;
			case DOWN:
				player.moveY(1);
				break;
			case ENTER:
				addObject(new Rect(Math.random() * MySystem.WIDTH, Math.random() * MySystem.HEIGHT, 100, 100));
				break;
			default:
				break;
		}
	}

	@Override
	protected void onKeyReleased(KeyEvent event) {

	}
}
