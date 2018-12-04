package Property.Color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 可以通过指定色相，饱和度和亮度(HSB)来创建颜色。 要使用HSB创建颜色，请使用Color.hsb()方法。
 */
public class HSB extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Text
		Text text = new Text(50, 100, "JavaFX Hahahah~");

		// 创建Group
		Group root = new Group();
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 550, 250, Color.hsb(270, 1.0, 1.0));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] ars) {
		launch(ars);
	}
}
