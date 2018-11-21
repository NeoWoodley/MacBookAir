package Shape.Rectangle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 圆角矩形Demo
 */
public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建圆角矩形
		Rectangle rectangle = new Rectangle(20, 20, 200, 200);
		rectangle.setArcHeight(15);  // 定义矩形四个角处的圆弧垂直直径
		rectangle.setArcWidth(15);  // 定义矩形四个角处的圆弧水平直径
		rectangle.setStroke(Color.BLACK);

		// 把rectangle放入Group的ObservableList中去
		Group root = new Group();
		root.getChildren().add(rectangle);

		// 创建Scene，并放入Group实例root、设置Scene大小；同时设置Stage属性，并展示
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
