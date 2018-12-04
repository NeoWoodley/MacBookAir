package Layout.HBoxDemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 在HBox的控件之间设置空格(空间)
 */
public class HBoxDemo4 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Button
		Button button1 = new Button("Add          ");
		Button button2 = new Button("Remove          ");
		button1.setMaxWidth(Double.MAX_VALUE);
		button2.setMaxWidth(Double.MAX_VALUE);

		// 创建HBox
		HBox hBox = new HBox(8);  // 每个子结点相距为8，形成空格
		HBox.setHgrow(button1, Priority.ALWAYS);
		HBox.setHgrow(button2, Priority.ALWAYS);
		hBox.getChildren().addAll(button1, button2);
		hBox.setPrefWidth(400);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(hBox);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
