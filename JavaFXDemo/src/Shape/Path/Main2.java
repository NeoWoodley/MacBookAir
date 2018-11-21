package Shape.Path;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

/**
 * 将QuadCurveTo添加到路径中（二次曲线）
 * 通过绘制与当前坐标和指定坐标相交的QuadraticBézier曲线(x, y)，
 * 使用指定的点(controlX, controlY) 作为Bézier控制点，
 * 创建由两个新点定义的弯曲路径元素。
 * 所有坐标都以双精度指定。
 */
public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Path
		Path path = new Path();

		// 设置MoveTo，来移动画笔，但不绘制
		MoveTo moveTo = new MoveTo();
		moveTo.setX(0);
		moveTo.setY(50);

		// 创建QuadCurveTo
		QuadCurveTo quadCurveTo = new QuadCurveTo();
		// 感觉ControlX、ControlY类似于二次曲线的极值点
		quadCurveTo.setControlX(25);  // 贝塞尔曲线控制点X坐标，即二次控制点X坐标
		quadCurveTo.setControlY(20);  // 贝塞尔曲线控制点Y坐标，即二次控制点Y坐标
		quadCurveTo.setX(50);  // 定义最终终点的X坐标
		quadCurveTo.setY(50);  // 定义最终终点的Y坐标

		path.getElements().add(moveTo);
		path.getElements().add(quadCurveTo);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(path);

		// 创建Scene，设置Stage
		// 通过构造函数，设置root；也可以这样做：scene.setRoot(root)
		Scene scene = new Scene(root,300,150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
