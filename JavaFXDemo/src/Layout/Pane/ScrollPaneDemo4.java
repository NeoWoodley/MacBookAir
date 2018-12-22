package Layout.Pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * 将setFitToWidth或setFitToHeight方法设置为true以匹配特定维度。
 * 默认情况下，FIT_TO_WIDTH和FIT_TO_HEIGHT属性都为false，可调整大小的内容保持其原始大小。
 *
 * 以下代码显示如何设置JScrollPane以适合宽度。
 */
public class ScrollPaneDemo4 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建WebView、WebEngine
		final WebView browser = new WebView();
		final WebEngine webEngine=browser.getEngine();
		webEngine.loadContent("<b>asdf</b>");

		// 创建ScrollPane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToWidth(true);  // 匹配特定宽度
		scrollPane.setContent(browser);

		// 创建VBox
		VBox vBox = new VBox();
		vBox.getChildren().add(scrollPane);

		// 创建Scene、设置Stage
		Scene scene = new Scene(vBox);
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
