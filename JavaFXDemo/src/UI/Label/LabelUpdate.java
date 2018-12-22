package UI.Label;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * 更新标签
 * <p>
 * 以下代码显示了如何在Button单击事件中更改Label文本。
 */
public class LabelUpdate extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		final Label label = new Label();
		label.setLayoutX(70);
		label.setLayoutY(150);

		Button button = new Button("Hello World!");
		button.setLayoutX(100);
		button.setLayoutY(100);
		button.setOnAction(event->{
			label.setText("Hello World! 文本被点击了");  // 如果疯狂地不停点击，就会发现label上的字变深了
		});

		Group root = new Group();
		root.getChildren().addAll(label, button);
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
