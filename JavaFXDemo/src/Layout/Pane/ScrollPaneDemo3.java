package Layout.Pane;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 以下代码使用jpg文件创建一个图像，并将该图像添加到滚动窗格。如果图像较大，滚动窗格将显示滚动条，我们可以使用它来查看隐藏的部分。
 */
public class ScrollPaneDemo2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Rectangle
		Rectangle rectangle = new Rectangle(200, 200, Color.RED);

		// 创建ScrollPane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPannable(true);  // 通过单击并移动鼠标光标来预览图像
		scrollPane.setPrefSize(120, 120);
		scrollPane.setContent(rectangle);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(scrollPane);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 500, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
