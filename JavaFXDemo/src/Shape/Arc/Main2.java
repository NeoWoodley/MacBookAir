package Shape.Arc;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 创建一个愿
 */
public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建圆
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);  // 设置半径

		// 创建Group
		Group root = new Group();
		root.getChildren().add(circle);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 550, 250, Color.web("0x0000FF"));  // 设置背景色，创建使用HTML或CSS属性字符串指定的RGB颜色
		primaryStage.setTitle("Text Fonts");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
