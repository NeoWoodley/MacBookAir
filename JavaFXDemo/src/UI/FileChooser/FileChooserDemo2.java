package UI.FileChooser;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileChooserDemo2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("Load");
		button.setOnAction(event -> {
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)",
					Arrays.asList("*.jpeg")
			);
			fileChooser.getExtensionFilters().add(extensionFilter);

			File file = fileChooser.showOpenDialog(primaryStage);
			System.out.println(file);
		});

		VBox vBox = new VBox();
		vBox.getChildren().add(button);
		Group root = new Group();
		root.getChildren().add(vBox);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
