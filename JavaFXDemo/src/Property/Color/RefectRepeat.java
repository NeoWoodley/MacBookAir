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

/**
 * 反射循环渐变
 */
public class RefectRepeat extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建LinearGradient
		LinearGradient linearGradient = new LinearGradient(50, 50, 70, 70, false, CycleMethod.REFLECT, new Stop(0,
				Color.rgb(21, 25, 0, 0.784)), new Stop(1, Color.rgb(0, 210, 0, 0.784)));

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
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
