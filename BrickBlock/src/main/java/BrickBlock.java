import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BrickBlock extends Application {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GameScene  root = new GameScene(WIDTH, HEIGHT);
		primaryStage.setTitle("BrickBlock");
		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		primaryStage.show();
	}
}
