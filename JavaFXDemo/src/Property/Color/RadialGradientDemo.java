package Property.Color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 径向渐变
 * Radial：星状
 */
public class RadialGradientDemo extends Application {
	static int dx = 1;
	static int dy = 1;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Group
		Group root = new Group();

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 400, 300, Color.WHITE);
		primaryStage.setTitle("Animation");
		primaryStage.setScene(scene);
		addBouncyBall(scene);
		primaryStage.show();
	}

	/**
	 * 创建"有弹性的小球"
	 * @param scene
	 */
	private void addBouncyBall(final Scene scene) {
		final Circle ball = new Circle(100, 100, 20);

		// 创建RadialGradient
		RadialGradient radialGradient = new RadialGradient(0, 0.1, 100, 100, 20, false, CycleMethod.NO_CYCLE, new Stop(0,
				Color.RED), new Stop(1, Color.BLACK));

		ball.setFill(radialGradient);

		// 创建Group
//		((Group)scene.getRoot()).getChildren().add(ball)  可以这样子从scene获取root，并将ball添加进去
		// 或者这样做
		final Group root = (Group)scene.getRoot();
		root.getChildren().add(ball);
	}
}
