package Shape.TextDemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Text
		Text text = new Text(100, 100, "JavaFX Hahahaha~");
		text.setFill(Color.rgb(10, 100, 200));
		text.setRotate(60);  // 设置旋转角度

		// 创建Group
		Group root = new Group();
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
