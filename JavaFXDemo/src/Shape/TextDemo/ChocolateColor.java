package Shape.TextDemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChocolateColor extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Cicle
		Circle circle = new Circle(40, 40, 30);

		// 创建Text
		Text text = new Text(25, 25, "JavaFX");
		text.setFill(Color.CHOCOLATE);
		text.setFont(Font.font(java.awt.Font.SERIF, 25));

		// 创建Group
		Group root = new Group(circle);
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 800, 400, Color.BEIGE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
