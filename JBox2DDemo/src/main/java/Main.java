import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	@Override
	public void start(Stage primaryStage) {
		CanvasScreen mCanvas = new CanvasScreen(WIDTH, HEIGHT);
		Group root = new Group();
		root.getChildren().add(mCanvas);
		Scene scene = new Scene(root, WIDTH, HEIGHT);

		primaryStage.setTitle("JavaFX中JBox2D的使用");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
