import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TestDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		root.getChildren().add(new Button("test"));
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
