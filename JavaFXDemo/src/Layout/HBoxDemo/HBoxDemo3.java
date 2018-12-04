package Layout.HBoxDemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 设置HBox首选宽度
 */
public class HBoxDemo3 extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Button
		Button button1 = new Button("Add          ");
		Button button2 = new Button("Remove       ");

		// 创建HBox
		HBox hBox = new HBox();
		// 两个Button将会均分hBox的宽度，因为它们have the same horizontal grow priority，同时如果hBox的宽度发生改变，两个Button的宽度也会随之改变
		HBox.setHgrow(button1, Priority.ALWAYS);
		HBox.setHgrow(button2, Priority.ALWAYS);
		button1.setMaxWidth(Double.MAX_VALUE);
		button2.setMaxWidth(Double.MAX_VALUE);
		hBox.getChildren().addAll(button1, button2);
		hBox.setPrefWidth(400);  // 设置首选宽度
		// 在这个示例中，人为修改窗口大小，Button不会随之改变，因为Group没变-->hBox不变-->Button不变
		// 如果没有Group，直接在scene中添加hBox，则会相应调整

		// 创建Group
		Group root = new Group();
		root.getChildren().add(hBox);

		// 创建Scene、设置Stage
		Scene scene = new Scene(hBox, 300, 250, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
