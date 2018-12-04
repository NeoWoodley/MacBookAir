package Shape.TextDemo;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 使用行分隔符，对文本执行换行
 */
public class NewLineDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建InnerShadow
		InnerShadow innerShadow = new InnerShadow(2, 3.5, 3.5, Color.DARKGREY);

		// 创建StringProperty
		StringProperty stringProperty = new SimpleStringProperty();
		stringProperty.set("Line\nLine2\nLine3");

		// 创建Text
		Text text = new Text();
		text.setX(100);
		text.setY(50);
		text.setTranslateY(50);
//		定义添加到此Node变换的平移的y坐标。
//		节点的最终转换将计算为layoutY+ translateY，其中layoutY建立节点的稳定位置，并可translateY 选择对该位置进行动态调整。
// 此变量可用于更改节点的位置而不会干扰layoutBounds节点的位置，这使得它可用于动画节点的位置。
		text.textProperty().bind(stringProperty);
//		text.setText("Line\nLine2\nLine3");  这样子也可以哦
		text.setEffect(innerShadow);
		text.setFont(Font.font(null, FontWeight.BOLD, 35));
		text.setFill(Color.LIME);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 530, 300, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
