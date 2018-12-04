package Shape.Curve;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

/**
 * 四次曲线，只有两个控制点
 */
public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建QuadCurve
		QuadCurve quadCurve = new QuadCurve();
		quadCurve.setStartX(0);
		quadCurve.setStartY(50);
		quadCurve.setControlX(25);
		quadCurve.setControlY(0);
		quadCurve.setEndX(50);
		quadCurve.setEndY(50);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(quadCurve);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 50);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
