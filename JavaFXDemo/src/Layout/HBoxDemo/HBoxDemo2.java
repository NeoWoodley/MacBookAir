package Layout.HBoxDemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 以下代码向HBox添加了四个矩形，设置了HBox约束，并演示了HBox布局控件的许多间距属性。
 * 矩形节点不可调整大小。
 */
public class HBoxDemo2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建矩形
		Rectangle r1 = new Rectangle(10, 10);
		Rectangle r2 = new Rectangle(20, 100);
		Rectangle r3 = new Rectangle(50, 20);
		Rectangle r4 = new Rectangle(20, 50);

		// 创建HBox
		HBox hBox = new HBox(5);  // 5 pixels space between child nodes
		hBox.setPadding(new Insets(10));  // 10 pixel padding between child nodes only，对所有矩形都起作用
		// TODO: 2018-12-03 padding、margin区别？？？
		HBox.setMargin(r1, new Insets(20, 2, 2, 2));  // 仅对第一个矩形有作用，这是一个类的静态方法
		hBox.getChildren().addAll(r1, r2, r3, r4);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(hBox);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
