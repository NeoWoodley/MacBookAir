package Shape.Arc;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * 绘制圆弧形
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Arc（弧）
		Arc arc = new Arc();
		arc.setCenterX(50);
		arc.setCenterY(50);
		arc.setRadiusX(25);  // 设置X方向上的半径
		arc.setRadiusY(25);  // 设置Y方向上的半径
		arc.setStartAngle(10);  // 设置开始时的角度，逆时针旋转
		arc.setLength(270);  // 设置圆弧的弧长
		// ArcType.CHORD  一个将弦连起来的
		// ArcType.ROUND  一个扇形
		// ArcType.OPEN
		arc.setType(ArcType.CHORD);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(arc);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 550, 250, Color.web("0x0000FF", 1));  // 设置透明度
		primaryStage.setTitle("Text Fonts");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
