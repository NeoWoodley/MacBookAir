package Shape.Rectangle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250, Color.WHITE);  // 一个Scene只有一个root

		Rectangle rectangle = new Rectangle();
		rectangle.setX(50);
		rectangle.setY(50);
		rectangle.setWidth(200);
		rectangle.setHeight(100);

		root.getChildren().add(rectangle);  // 把rectangle放到Group中包含的ObservableList里去

		primaryStage.setTitle("Shape.Rectangle Demo");
		primaryStage.setScene(scene);  // 把scene放到stage中去
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
