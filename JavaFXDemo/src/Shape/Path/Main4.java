package Shape.Path;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main4 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建两个Ellipse
		// TODO: 2018/11/21 是不是EllipseBuilder，没有了？？？
		Ellipse bigEllipse = new Ellipse();
		bigEllipse.setCenterX(100);
		bigEllipse.setCenterY(100);
		bigEllipse.setRadiusX(50);
		bigEllipse.setRadiusY(75 / 2);
		bigEllipse.setStrokeWidth(3);
		bigEllipse.setStroke(Color.BLACK);
		bigEllipse.setFill(Color.WHITE);

		Ellipse smallEllipse = new Ellipse();
		smallEllipse.setCenterX(100);
		smallEllipse.setCenterY(100);
		smallEllipse.setRadiusX(35 / 2);
		smallEllipse.setRadiusY(25 / 2);

		// 创建Shape，减去两个形状以创建路径；有点类似于自己定义一个Shape形状
		Shape shape = Path.subtract(bigEllipse, smallEllipse);
		shape.setStrokeWidth(1);  // 设置该形状的边框线的宽度
		shape.setStroke(Color.BLACK);
		shape.setFill(Color.rgb(255, 200, 0));

		// 创建Group
		Group root = new Group();
		root.getChildren().add(shape);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 300, Color.WHITE);
		primaryStage.setTitle("Shapes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
