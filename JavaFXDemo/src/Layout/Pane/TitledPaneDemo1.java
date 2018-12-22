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
 * 标题窗格是具有标题的面板，窗格可以打开和关闭。我们可以添加节点(如UI控件或图像)和一组元素到窗格。
 */
public class TitledPaneDemo1 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建TitledPane
		TitledPane titledPane = new TitledPane("My Title", new CheckBox("OK"));  // 向TiTledPane标题窗格中添加CheckBox控件

		// 创建HBox
		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(20, 10, 10, 20));  // 设置内边距
		hBox.getChildren().setAll(titledPane);  //  Clears the ObservableList and adds all the elements passed as var-args.

		// 创建Group
		Group root = new Group();
		root.getChildren().add(hBox);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 350, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
