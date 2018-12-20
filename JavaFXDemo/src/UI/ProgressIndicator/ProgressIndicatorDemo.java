package UI.ProgressBar;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

/**
 * 进度指示器(ProgressIndicator)以动态更改饼图的形式显示JavaFX中的操作进度。
 *
 * 以下代码显示如何使用不确定值创建ProgressIndicator。
 */
public class ProgressIndicatorDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		ProgressIndicator progressIndicator = new ProgressIndicator();
		Group root = new Group();
		root.getChildren().add(progressIndicator);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
