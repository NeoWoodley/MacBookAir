package UI.RadioButton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * setSelected()方法带有true参数可以显式选择单选按钮。
 * isSelected()方法返回用户是否选择了特定单选按钮。
 * setGraphic()方法可以为RadioButton安装一个图像。
 *
 * 以下代码创建一个切换组和三个单选按钮，然后将每个单选按钮添加到切换组，并指定应选择哪个按钮。
 *
 * 我们通过ToggleGroup处理单选按钮选择的事件。
 * 更改侦听器添加到ToggleGroup。为每个单选按钮分配了用户数据。
 * ChangeListener对象检查组中的选定项目。
 * 所选单选按钮从getSelectedToggle方法返回。
 * 然后通过调用getUserData方法获取用户数据。
 */
public class RadioButtonEvent extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		RadioButton button1 = new RadioButton("one");
		RadioButton button2 = new RadioButton("two");
		RadioButton button3 = new RadioButton("three");

		// 使用ToggleGroup来管理单选按钮
		ToggleGroup group = new ToggleGroup();
		button1.setToggleGroup(group);
		button2.setToggleGroup(group);
		button3.setToggleGroup(group);
		button1.setSelected(true);
		button1.requestFocus();  // 使用requestFocus函数将焦点更改为所选单选按钮,把输入焦点放在调用这个方法的控件上。

		group.selectedToggleProperty().addListener(e->{
			if (group.getSelectedToggle() != null) {
				System.out.println(group.getSelectedToggle());
			}
		});

		HBox hBox = new HBox();
		hBox.getChildren().addAll(button1, button2, button3);
		Scene scene = new Scene(hBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
