package Layout.HBoxDemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * HBox布局类将JavaFX子节点放在水平行中。新的子节点附加到右侧的末尾。
 * 默认情况下，HBox布局尊重子节点的首选宽度和高度。
 * 当父节点不可调整大小时，例如Group节点，HBox的行高度设置为子节点的最大首选高度。
 * 默认情况下，每个子节点与左上(Pos.TOP_LEFT)位置对齐。
 * 我们可以通过编程方式改变HBox的布局约束，例如边框，填充，边距，间距和对齐。
 * 当处理不可缩放的子节点(如Shape节点)时，父节点会考虑Shape的矩形边界(ParentInBounds)的宽度和高度。
 * 当处理诸如TextField控件之类可调整大小的节点时，父节点计算TextField水平增长的可用空间。
 * 要在HBox中水平增长UI控件，请使用静态HBox.setHgrow()方法。
 *
 * 以下代码将TextField控件设置为在调整父HBox的宽度时水平增长
 */
public class HBoxDemo1 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建TextField
		TextField textField = new TextField();

		// 创建HBox
		HBox hBox = new HBox();
		hBox.getChildren().add(textField);
		HBox.setHgrow(textField, Priority.ALWAYS);  // 将TextField控件设置为在调整父HBox的宽度时水平增长，即当HBox被认为调整宽度时，TextField
		// 也做出相应的调整，保持与HBox相同的宽度

		// 创建Scene、设置Stage
		Scene scene = new Scene(hBox, 320, 112, Color.rgb(0, 0, 0, 0));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
