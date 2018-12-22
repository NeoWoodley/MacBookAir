package UI.ProgressIndicator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

/**
 * 可以使用空构造函数创建没有参数的进度指示器。
 * 然后可以使用setProgress()方法分配值。
 * 如果无法确定进度，可以在不确定模式下设置进度控制，直到确定任务的长度。
 *
 * 以下代码显示如何创建一个完成25％的ProgressIndicator。
 */
public class ProgressIndicatorChangeProgress extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		ProgressIndicator progressIndicator = new ProgressIndicator();
		progressIndicator.setProgress(0.25);
		Group root = new Group();
		root.getChildren().add(progressIndicator);
		Scene scene = new Scene(root,400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
