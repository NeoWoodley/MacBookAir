package UI.ProgressBar;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

/**
 * 进度条(ProgressBar)可视化JavaFX应用程序中的操作进度。
 */
public class ProgressBarDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 进度条(ProgressBar)可视化JavaFX应用程序中的操作进度。
		ProgressBar progressBar = new ProgressBar(0.6);
		// 还可以使用空构造函数创建没有参数的进度条。
		// 然后使用setProgress()方法分配值。
		// 如果我们不能确定任务的完全完成时间，可以设置进度条在不确定模式，直到确定任务的长度。
		progressBar.setProgress(0.3);

		Group root = new Group();
		root.getChildren().add(progressBar);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
