package UI.Label;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * 创建标签后，我们可以使用Label类中的以下方法添加文本和图形内容。
 * setText(String text) - 设置标签的文本标题
 * setGraphic(Node graphic) - 设置图形图标
 * setGraphicTextGap()方法设置文本和图标之间的间距。
 * setTextFill()方法设置标签文本的颜色。
 * setTextAlignment()方法可以在其布局区域内设置标签内容的对齐方式。
 * setContentDisplay()方法设置图形相对于文本的位置。
 * 该方法接受以下ContentDisplay常量中的一个：LFFT，RIGHT，CENTER，TOP，BOTTOM。
 *
 * 以下代码创建文本标签，向其添加图标，并为文本设置填充颜色。
 */
public class LabelContent extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label = new Label("Search");
		// TODO: 2018-12-04 好像没什么用啊？？？
//		label.setPrefWidth(500);
//		label.setTextAlignment(TextAlignment.RIGHT);
		label.setTextFill(Color.web("#0076a3"));

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.getChildren().add(label);

		Scene scene = new Scene(hBox, 200, 150);
		primaryStage.setTitle("Label Sample");
		primaryStage.setWidth(400);
		primaryStage.setHeight(180);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
