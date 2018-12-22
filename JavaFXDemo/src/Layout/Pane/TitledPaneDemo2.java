package Layout.Pane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 要创建一个TitledPane控件，请调用其构造函数。
 *
 * 以下代码使用GridPane在TitledPane中布局控件。
 *
 * 我们可以定义标题窗格的打开和关闭方式。
 * 默认情况下，所有标题窗格都是可折叠的，打开和关闭操作都是动画。
 * setCollapsible(false)关闭Collapsible状态。
 * setAnimated(false)停止动画。
 */
public class TitledPaneDemo2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建TitledPane
		TitledPane titledPane = new TitledPane("我的标题", new CheckBox("确定？"));
		titledPane.setCollapsible(false);  // 关闭Collapsible状态
		titledPane.setAnimated(false);  // 停止动画

		// 创建HBox
		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(20, 0, 0, 20));
		hBox.getChildren().add(titledPane);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(hBox);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 450, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
