package UI.Label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 当用户将鼠标光标悬停在标签上时，可以缩放标签。
 * 当在标签上触发MOUSE_ENTERED事件时，以下代码将缩放效果应用于标签。
 *
 * 以下代码显示如何缩放标签。
 */
public class LabelMouseDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		final Label label = new Label("Search long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long");
		label.setWrapText(true);
		label.setOnMouseEntered(event->{
			label.setScaleX(1.5);
			label.setScaleY(1.5);
		});

		label.setOnMouseExited(event->{
			label.setScaleX(1);
			label.setScaleY(1);
		});

		HBox hBox = new HBox(10);
		hBox.getChildren().add(label);
		Scene scene = new Scene(hBox);
		primaryStage.setScene(scene);
		primaryStage.setWidth(400);
		primaryStage.setHeight(180);
		primaryStage.show();
	}
}
