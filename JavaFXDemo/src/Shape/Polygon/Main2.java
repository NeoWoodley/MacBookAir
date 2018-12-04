package Shape.Polygon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 * 折线Polyline
 */
public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建折线
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(0.0, 0.0, 20.0, 10.0, 10.0, 20.0);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(polyline);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 260, 80);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
