package Shape.Path;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Path
		Path path = new Path();
		// getElement() 获取此路径的ObservableList，该List中存放着path element
		// MoveTo和LineTo对象实例可以添加到Path对象的path元素中，但不可以添加到Scene的Shape中
		// MoveTO 通过移动到指定的坐标来创建路径的附加项
		// LineTo 通过从当前坐标绘制直线到新坐标来创建线路径元素
		path.getElements().add(new MoveTo(0, 50));  // 移动画笔，不进行绘制
		path.getElements().add(new LineTo(100, 100));  // 进行直线绘制
		path.getElements().add(new MoveTo(100, 200));
		path.getElements().add(new LineTo(0, 10));

		// 创建VBox
		VBox vBox = new VBox();
		vBox.getChildren().addAll(path);  // TODO: 2018/11/21 add()函数貌似也可以 
		vBox.setSpacing(5);  // 设置vBox中每个子结点之间的垂直空间量

		// 创建HBox
		HBox hBox = new HBox();
		hBox.getChildren().add(vBox);
		hBox.setSpacing(40);  // 设置hBox中每个子结点之间的水平空间量
		hBox.setPadding(new Insets(20, 10, 10, 20));  // 设置hBox与四周的距离值

		// 创建Scene，这里采用了不同的方式创建Group
		Scene scene = new Scene(new Group());
		((Group) scene.getRoot()).getChildren().add(hBox);  // 获取Scene的root

		// 设置Stage
		primaryStage.setTitle("CheckBox Sample");
		primaryStage.setWidth(230);
		primaryStage.setHeight(120);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
