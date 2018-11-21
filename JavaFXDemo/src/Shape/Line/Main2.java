package Shape.Line;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 * 为线段设置一些属性
 */
public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 300, 150, Color.GRAY);  // 设置场景的背景色

		Line redLine = new Line(10,10,200,10);
		redLine.setStroke(Color.RED);  // 设置线段颜色
		redLine.setStrokeWidth(50);  // 设置线段宽度
		redLine.setStrokeLineCap(StrokeLineCap.BUTT);  // 在线或路径的末端设置帽的样式
		redLine.getStrokeDashArray().addAll(15d, 5d, 15d, 15d, 20d);  // 定义表示虚线段长度的数组
		redLine.setStrokeDashOffset(20);  // 定义用户坐标中指定的距离，该距离表示虚线图形中的偏移量

		root.getChildren().add(redLine);

		primaryStage.setTitle("Drawing Lines");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
