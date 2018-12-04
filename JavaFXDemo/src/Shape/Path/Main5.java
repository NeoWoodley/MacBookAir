package Shape.Path;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

/**
 * 使用VLineTo创建垂直线
 */
public class Main5 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Path
		Path path = new Path();
		path.getElements().add(new MoveTo(50, 0));
		path.getElements().add(new VLineTo(50));  // 创建从当前点到y的垂直线路径元素，即（50，0）->（50，50）的一条垂直线

		// 创建VBox
		VBox vBox = new VBox();
		vBox.getChildren().add(path);  // TODO: 2018/11/22 如果有多个对象要添加，就需要使用addAll()???

		// 创建Group
//		Group root = new Group();
//		root.getChildren().add()

		// 创建Scene、设置Stage
		Scene scene = new Scene(vBox);  // 指定场景图的根为vBox
		primaryStage.setTitle("HTML");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
