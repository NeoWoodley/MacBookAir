package Layout.FlowPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FlowPaneDemo
 * 所有控件的生成、属性设置都在这个Main入口类中
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane root = new FlowPane();
		root.setHgap(10);  // 设置水平gap
		root.setVgap(20);  // 设置垂直gap
		root.setPadding(new Insets(15, 15, 15, 15));

		// Button1
		Button button1 = new Button("Button1");
		root.getChildren().add(button1);  // root.getChildren()得到的是一个存放children的list，即ObservableList<Node>，这是一个JavaFX的collections

		// Button2
		Button button2 = new Button("Button2");
		button2.setPrefSize(100, 100);  // TODO: 2018/11/21  prefSize是preferredSize的意思吗？？？
		root.getChildren().add(button2);

		// TextField
		TextField textField = new TextField("Text Field");
		textField.setPrefWidth(110);  // 设置TextField的宽度
		root.getChildren().add(textField);

		// CheckBox
		CheckBox checkBox = new CheckBox("Check Box");
		root.getChildren().add(checkBox);

		// RadioButton
		RadioButton radioButton = new RadioButton("Radio Button");
		root.getChildren().add(radioButton);  // add(Node)

		// Scene
		Scene scene = new Scene(root, 550, 250);

		primaryStage.setTitle("FlowPane Layout Demo");
		primaryStage.setScene(scene);
		primaryStage.show();  // zaistage上显示scene中的控件的顺序，就是按照root.getChildren()返回的list中控件的顺序来显示的
	}

	public static void main(String[] args) {
		launch(args);
	}
}
