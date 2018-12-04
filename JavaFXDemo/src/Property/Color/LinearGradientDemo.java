package Property.Color;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class LinearGradientDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Stop，定义要在渐变上使用的渐变颜色的一个元素
		Stop[] stops = new Stop[]{new Stop(0, Color.BLACK), new Stop(0.5,Color.GREEN),new Stop(1, Color.RED)};
		// offset定义了Stop's position(ranging from 0 to 1)
		// color定义了Stop's color

		// 创建LinearGradient，线性渐变梯度
		LinearGradient linearGradient = new LinearGradient(0, 0, 0.5, 0, true,CycleMethod.REFLECT, stops);
		// proportional定义了按比例来确定位置
		// startX、startY：确定开始渐变的位置
		// stopX、stopY：确定了渐变结束的位置，若是后面还有部分图形，并且CycleMethod.NO_CIRCLE，就用stops[]数组中最后一个元素的颜色来填充
		// stops[]数组中Stop型对象中设定的offset会根据linearGradient中的start、stop而调整

		// 创建矩形
		Rectangle rectangle = new Rectangle(0, 0, 100, 100);
		rectangle.setFill(linearGradient);

		// 创建VBox
		VBox vBox = new VBox();
		vBox.getChildren().add(rectangle);

		// 创建Scene、设置Stage
		Scene scene = new Scene(vBox, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
