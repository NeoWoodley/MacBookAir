package Shape.Polygon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


/**
 * 多边形
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Polygon，多边形
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(0.0, 0.0, 20.0, 10.0, 10.0, 20.0);  // 6个数字代表3个点

		// 创建Group
		Group root = new Group();
		root.getChildren().add(polygon);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 260, 80);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
