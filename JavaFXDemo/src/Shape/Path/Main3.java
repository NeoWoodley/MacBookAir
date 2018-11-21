package Shape.Path;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * 使用Path、MoveTo、CubicCurveTo创建三次曲线
 */
public class Main3 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Path
		Path path = new Path();

		// 创建MoveTo
		MoveTo moveTo = new MoveTo();
		moveTo.setX(0);
		moveTo.setY(0);

		// 创建CubicCurveTo，实际上是三个点确定一条三次曲线
		CubicCurveTo cubicCurveTo = new CubicCurveTo();
		cubicCurveTo.setControlX1(0);
		cubicCurveTo.setControlY1(0);
		cubicCurveTo.setControlX2(100);
		cubicCurveTo.setControlY2(100);
		cubicCurveTo.setX(100);
		cubicCurveTo.setY(50);

		// 设置Path
		path.getElements().add(moveTo);
		path.getElements().add(cubicCurveTo);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(path);

		// 创建Scene
		Scene scene = new Scene(root, 450, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
