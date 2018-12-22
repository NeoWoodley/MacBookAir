package UI.ToggleButton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * setUserData()方法将用户值与切换按钮相关联。
 * ChangeListener对象检查组中选定的切换。
 * 如果没有选择任何开关按钮，则输出默认值。
 *
 * 如果选择其中一个切换按钮，getSelectedToggle和getUserData方法返回用户定义的值。
 */
public class ToggleButtonEvent extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hBox = new HBox();
		Scene scene = new Scene(hBox, 300, 200);
		// TODO: 2018-12-05 这里添加CSS样式失败
//		scene.getStylesheets().add("myStyle.css");

		ToggleButton button1 = new ToggleButton("A");
		ToggleButton button2 = new ToggleButton("B");
		ToggleButton button3 = new ToggleButton("C");
		button1.setUserData("我是A");
		button2.setUserData("我是B");
		button3.setUserData("我是C");

//		button1.getStyleClass().add("toggle-button1");
//		button2.getStyleClass().add("toggle-button2");
//		button3.getStyleClass().add("toggle-button3");

		ToggleGroup group = new ToggleGroup();
		button1.setToggleGroup(group);
		button2.setToggleGroup(group);
		button3.setToggleGroup(group);
		button1.setSelected(true);
		button1.requestFocus();

		group.selectedToggleProperty().addListener((observable,toggle,new_toggle)->{
			if (new_toggle == null) {
				System.out.println("default value");
			} else {
				System.out.println(group.getSelectedToggle());
				System.out.println(group.getSelectedToggle().getUserData());
				System.out.println("----------");
			}
		});

		hBox.getChildren().addAll(button1, button2, button3);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
