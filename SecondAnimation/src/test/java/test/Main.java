package test;

import core.MyApplication;
import core.MySystem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends MyApplication {
	@Override
	protected void loadBefore() {
		setWindowSize(800, 600);
	}

	@Override
	protected void loadEnd() {
		TestScreen testScreen = new TestScreen(MySystem.WIDTH, MySystem.HEIGHT);
		getRoot().getChildren().add(testScreen);
		testScreen.start();
		testScreen.initEvents();
		getScene().setFill(Color.BLACK);
	}

	@Override
	protected void showStage(Stage stage) {
		super.showStage(stage);
		stage.setTitle("JavaFX游戏开发 第二课 基础游戏框架");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
