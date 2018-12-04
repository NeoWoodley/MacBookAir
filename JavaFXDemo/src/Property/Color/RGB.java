package Property.Color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 使用RGB表示颜色
 */
public class RGB extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Text
		Text text = new Text(100, 100, "JavaFX");
		text.setFill(Color.rgb(70,200,10,0.99));  // 透明度
		text.setRotate(60);  // 旋转

		// 创建Group
		Group root = new Group();
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		primaryStage.setTitle("Drawing Text");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
