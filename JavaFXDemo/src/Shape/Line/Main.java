package Shape.Line;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox box = new VBox();  // 垂直布局，这是scene的layout
		final Scene scene = new Scene(box, 300, 250);
		scene.setFill(null);  // TODO: 2018/11/21  设置填充色？？？

		Line line = new Line();
		line.setStartX(0.0f);
		line.setStartY(0.0f);
		line.setEndX(100.0f);
		line.setEndY(100.0f);

		box.getChildren().add(line);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
