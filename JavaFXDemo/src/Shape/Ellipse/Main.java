package Shape.Ellipse;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * 椭圆Demo
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建阴影形状
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(10);
		dropShadow.setColor(Color.color(0.4, 0.4, 0.4));  // 通过RGB设置颜色

		// 创建椭圆
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX(50);
		ellipse.setCenterY(50);
		ellipse.setRadiusX(50);  // 椭圆的宽度，单位：像素
		ellipse.setRadiusY(25);  // 椭圆的高度，单位：像素
		ellipse.setEffect(dropShadow);  // 为椭圆设置阴影效果

		// 创建Group
		Group root = new Group();
		root.getChildren().add(ellipse);

		// 创建Scene，设置Stage
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
