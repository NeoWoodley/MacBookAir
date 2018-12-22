package UI.RadioButton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 单选按钮通常组合在一起，以便用户进行单选，即用户只能在单选按钮列表中选择一个项目。
 * 单选按钮只能执行：选择或取消选择。
 *
 * 以下代码显示，当放置在ToggleGroup（切换组）中时，只能选择一个RadioButton。
 * 我们可以添加单选按钮到ToggleGroup对象，它将管理它们，使得一次只能选择一个单选按钮。
 */
public class RadioButtonInToggleGroup extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		RadioButton radioButton1 = new RadioButton("first");
		RadioButton radioButton2 = new RadioButton("second");

		ToggleGroup toggleGroup = new ToggleGroup();
		radioButton1.setToggleGroup(toggleGroup);
		radioButton2.setToggleGroup(toggleGroup);
		radioButton1.setSelected(true);

		HBox hBox = new HBox();
		hBox.getChildren().addAll(radioButton1, radioButton2);
		Scene scene = new Scene(hBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
