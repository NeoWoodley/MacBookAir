package UI.Label;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX API的javafx.scene.control包中的Label类可用于显示一个文本元素。
 * 我们可以包装文本元素以适应特定空间，添加图形图像或使用JavaFX Label控件应用视觉效果。
 *
 * 以下代码显示如何使用Label显示文本。
 */
public class LabelDemo1 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label = new Label("Label");

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(label, 0, 0);

		Group root = new Group();
		root.getChildren().add(gridPane);

		Scene scene = new Scene(root, 300, 130, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
