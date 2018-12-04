package Layout.HBoxDemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * HBox设置填充和间距
 */
public class HBoxDemo5 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Button
		Button button1 = new Button();
		button1.setText("Button1");
		Button button2 = new Button();
		button2.setText("Button2");
		Button button3 = new Button();
		button3.setText("Button3");
		Button button4 = new Button();
		button4.setText("Button4");

		// 创建HBox
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(15,12,15,12));  // 设置元素内边距，其判断的依据即边框离内容正文的距离
		hBox.getChildren().addAll(button1, button2, button3, button4);
		// 在本例中，人为地修改窗口的大小，Button的大小也会随之改变，因为hBox直接放在了Scene中，而没有放在Group中，所以修改窗口大小的同时，hBox的大小也随之改变
//		Group root = new Group();
//		root.getChildren().add(hBox);

		// 创建Scene、设置Stage
		Scene scene = new Scene(hBox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
