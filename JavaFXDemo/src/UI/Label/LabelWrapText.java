package UI.Label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 包装文本要包装文本以将文本适合布局区域，请使用setWrapText方法并设置为true值。
 */
public class LabelWrapText extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label = new Label("Search long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long");
		label.setPrefWidth(300);
		label.setWrapText(true);

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.getChildren().add(label);

		Scene scene = new Scene(hBox, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
