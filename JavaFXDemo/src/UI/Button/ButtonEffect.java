package UI.Button;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;


/**
 * 以下代码将DropShadow效果应用于按钮。
 */
public class ButtonEffect extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DropShadow shadow = new DropShadow();
		final Button button = new Button("Button Sample");

		button.setOnMouseEntered(e->{
			button.setEffect(shadow);
		});

		button.setOnMouseExited(e->{
			button.setEffect(null);
		});

		Group root = new Group();
		root.getChildren().add(button);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
