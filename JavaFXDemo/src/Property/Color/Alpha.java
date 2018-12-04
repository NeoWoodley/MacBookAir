package Property.Color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 使用颜色alpha通道
 * 另一个重载方法需要三个整数(int)值和第四个double类型值，即alpha通道。
 * 第四个值设置颜色的不透明度。此值介于零(0)和一(1)之间。
 */
public class Alpha extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Text
		Text text = new Text(50, 100, "JavaFX Hahahaha~");
		Font sanSerif = Font.font("Dialog", 30);
		text.setFont(sanSerif);
		text.setFill(Color.RED);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 550, 250, new Color(0, 0, 1, 1.0));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
