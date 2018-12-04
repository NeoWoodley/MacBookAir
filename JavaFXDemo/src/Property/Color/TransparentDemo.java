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


public class TransparentDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建LinearGradient
		LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0.1,
				Color.rgb(25, 200, 0, 0.4)), new Stop(1.0, Color.rgb(0, 0, 0, 0.1)));

		// 创建Rectangle
		Rectangle rectangle = new Rectangle();
		rectangle.setX(50);
		rectangle.setY(50);
		rectangle.setWidth(100);
		rectangle.setHeight(70);
		rectangle.setFill(linearGradient);

		// 创建VBox
		VBox vBox = new VBox();
		vBox.getChildren().add(rectangle);

		// 创建Scene、设置Stage
		Scene scene = new Scene(vBox, 300, 250);
		scene.setFill(null);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
