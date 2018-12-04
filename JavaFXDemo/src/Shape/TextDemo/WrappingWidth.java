package Shape.TextDemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 设置文本换行宽度
 */
public class WrappingWidth extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Text
		Text text = new Text(10, 50, "This is a test.");  // 这里设置的text会被后面设置的text覆盖掉
		text.setText("First row Second row Second row Second row Second row Second row Second row Second row Second row Second row Second row Second row Second row Second row.");
		text.setFont(new Font(20));
		text.setWrappingWidth(200);  // 当宽度到达200像素时，就自动换行

		// 创建Group
		Group root = new Group();
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
