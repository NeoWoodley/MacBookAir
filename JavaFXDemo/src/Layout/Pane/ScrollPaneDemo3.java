package Layout.Pane;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 可滚动ScrollPane调用setPannable(true)方法通过单击并移动鼠标光标来预览图像。
 *
 * 滚动条策略
 * 我们可以控制何时显示滚动条的策略：
 * 1. 总是
 * 2. 决不
 * 3. 必要时
 * setHbar策略和setar策略方法分别为水平和垂直滚动条指定滚动条策略。
 * sp.setHbarPolicy(ScrollBarPolicy.NEVER);
 * sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
 */
public class ScrollPaneDemo3 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Rectangle
		Rectangle rectangle = new Rectangle(200, 200, Color.RED);

		// 创建ScrollPane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPannable(true);  // 通过单击并移动鼠标光标来预览图像
		scrollPane.setPrefSize(120, 120);
		scrollPane.setContent(rectangle);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(scrollPane);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 500, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
