package Property.Color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 使用ColorName表示颜色
 */
public class ColorName extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Circle
		Circle circle = new Circle(40, 40, 60);

		// 创建Text
		Text text = new Text(25, 25, "Hahaha~");  // 设置Text起始位置
		text.setFill(Color.RED);
		text.setFont(Font.font(java.awt.Font.SERIF, 25));

		// 创建Group
		Group root = new Group();
		root.getChildren().add(circle);
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 800, 400, Color.BEIGE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
