import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Try extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		root.getChildren().add(new Label("test"));
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
