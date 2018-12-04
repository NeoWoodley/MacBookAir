package Shape.Curve;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;

/**
 * 创建三次曲线，需要三个点来确定曲线表达式，需要额外的一个end点来确定曲线的终点
 *
 * 设置三次曲线的主要参数是startX，startY，controlX1(控件点1X)，controlY1(控件点1Y)，controlX2(控件点2X)和controlY2(控件点2Y)，endX，endY。
 *
 * startX，startY，endX和endY参数是曲线的起点和终点。controlX1，controlY1，controlX2和controlY2是控件点。
 * 控制点(控制X1，控制Y1)影响线起点(startX，startY)和中间点之间的线段。
 * 控制点(controlX2，controlY2)影响线的中点与其终点(endX，endY)之间的线段。
 * 控制点将曲线拉向自身的方向。
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建曲线
		CubicCurve cubicCurve = new CubicCurve();
		cubicCurve.setStartX(0);
		cubicCurve.setStartY(50);
		cubicCurve.setControlX1(25);
		cubicCurve.setControlY1(0);
		cubicCurve.setControlX2(75);
		cubicCurve.setControlY2(100);
		cubicCurve.setEndX(100);
		cubicCurve.setEndY(50);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(cubicCurve);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 450, 250);
		primaryStage.setTitle("ComboBoxSample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
