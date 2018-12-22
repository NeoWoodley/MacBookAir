package UI.ProgressBar;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 以下代码显示如何创建一个完成25％的进度条(ProgressBar)。
 */
public class ProgressBarChangeProgress extends Application {
	private Task copyWorker;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Label、ProgressBar放在一个HBox中
		final Label label = new Label("Files Transfer: ");
		final ProgressBar progressBar = new ProgressBar(0);
		final HBox hBox = new HBox();
		hBox.setSpacing(5);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(label, progressBar);

		// 两个Button放在另一个HBox
		final Button startButton = new Button("Start");
		final Button cancelButton = new Button("Cancel");
		cancelButton.setDisable(false);  // 初始时，cancelButton不能点击

		// 设置两个按钮Button点击事件
		startButton.setOnAction(event -> {
			startButton.setDisable(true);  // 设置为无效，即不能点击
			cancelButton.setDisable(false);  // 设置为有效，即可以点击
			progressBar.setProgress(0);
			copyWorker = createWorker();  // 创建一个Task，但是Task还没有成为一个新的线程

			// 重新绑定progressBar进度
			progressBar.progressProperty().unbind();
			progressBar.progressProperty().bind(copyWorker.progressProperty());
			copyWorker.messageProperty().addListener((observable, oldValue, newValue) -> {
				// 如果messageProperty更新了，就触发以下事件
				// 在createWorker()方法中，call()方法被Override，其中就有对messageProperty的更新行为
				System.out.println(newValue);
			});
			new Thread(copyWorker).start();  // 创建一个新线程
		});

		cancelButton.setOnAction(event -> {
			startButton.setDisable(false);  // 设置为有效
			cancelButton.setDisable(true);  // 设置为无效
			copyWorker.cancel(true);  // cancel这个Task
			progressBar.progressProperty().unbind();  // 解绑
			progressBar.setProgress(0);
			System.out.println("Canceled.");
		});

		final HBox hBox1 = new HBox();
		hBox1.setSpacing(5);
		hBox1.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(startButton, cancelButton);

		// 将两个HBox放入BorderPane中
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(hBox);
		mainPane.setBottom(hBox1);

		Group root = new Group();
		root.getChildren().add(mainPane);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Task createWorker() {
		return new Task() {
			@Override
			protected Object call() throws Exception {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(2000);
					updateMessage("2000 milliseconds");
					updateProgress(i + 1, 10);
				}
				return true;
			}
		};
	}
}
