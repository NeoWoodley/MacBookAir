package UI.Button;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonMouse extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("Mouse Event Test.");
		button.setOnMouseEntered(e->{
			System.out.println("Mouse Entered.");
		});

		button.setOnMouseExited(e -> {
			System.out.println("Mouse Exited.");
		});

		Group root = new Group();
		root.getChildren().add(button);
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
