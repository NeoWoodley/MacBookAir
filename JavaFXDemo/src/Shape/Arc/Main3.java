package Shape.Arc;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 创建一个有阴影的圆形
 */
public class Main3 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建DropShadow阴影
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(4);  // 偏移量

		// 创建圆形
		Circle circle = new Circle();
		circle.setCenterX(50);
		circle.setCenterY(125);
		circle.setRadius(30);
		circle.setFill(Color.RED);
		circle.setEffect(dropShadow);
		circle.setCache(true);
//		设置属性缓存的值。
//		系统的性能提示，指示Node 应将其缓存为位图。在许多情况下，渲染节点的位图表示将比渲染基元更快，尤其是在应用了效果的基元（例如模糊）的情况下。但是，它也会增加内存使用量。此提示表明是否值得进行权衡（增加内存使用以提高性能）。另请注意，在某些平台（如GPU加速平台）上，当使用模糊和其他效果时，将节点缓存为位图几乎没有什么好处，因为它们在GPU上渲染速度非常快。该cacheHintProperty()变量提供了其他选项，可用于启用更具攻击性的位图缓存。
//		对于对其自身，其任何祖先或其任何后代具有3D变换的任何节点，可以禁用缓存。
//		默认值：假

		// 创建Group
		Group root = new Group();
		root.getChildren().add(circle);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
