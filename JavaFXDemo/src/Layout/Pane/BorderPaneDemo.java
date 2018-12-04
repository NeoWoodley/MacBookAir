package Layout.Pane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * BorderPane布局顶部，底部，左，右或中心区域中的子节点。每个区域只能有一个节点。
 * BorderPane的顶部和底部区域允许可调整大小的节点占用所有可用宽度。
 * 左边界区域和右边界区域占据顶部和底部边界之间的可用垂直空间。
 * 默认情况下，所有边界区域尊重子节点的首选宽度和高度。
 * 放置在顶部，底部，左侧，右侧和中心区域中的节点的默认对齐方式如下：
 * 顶部: Pos.TOP_LEFT
 * 底部: Pos.BOTTOM_LEFT
 * 左侧: Pos.TOP_LEFT
 * 右侧: Pos.TOP_RIGHT
 * 中心: Pos.CENTER
 */
public class BorderPaneDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Button
		Button buttonTop = new Button("Top");
		Button buttonLeft = new Button("Left");
		Button buttonRight = new Button("Right");
		Button buttonBottom = new Button("Bottom");

		// 创建BorderPane
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10, 20, 10, 20));
		borderPane.setTop(buttonTop);
		borderPane.setLeft(buttonLeft);
		borderPane.setRight(buttonRight);
		borderPane.setBottom(buttonBottom);

		// 创建Scene、设置Stage
		Scene scene = new Scene(borderPane, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
