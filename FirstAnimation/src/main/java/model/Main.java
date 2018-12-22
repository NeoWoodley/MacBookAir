package model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		GamePanel mPanel = new GamePanel();
		final Scene scene = new Scene(mPanel,800, 600);
		mPanel.load();
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("JavaFX游戏开发--第一课  精灵动画");
		stage.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(Main.class, args);
	}
}
