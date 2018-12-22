package Layout.Pane;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * 滚动窗口提供UI元素的可滚动视图。
 * 我们使用可滚动面板，当需要显示有限的空间大内容。可滚动窗格视口，其将显示内容的一部分，并且在必要时提供滚动条。
 *
 * ScrollPane不能直接放在Scene中
 */
public class ScrollPaneDemo1 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建WebView
		// {@code WebView} is a {@link javafx.scene.Node} that manages a
		// {@link WebEngine} and displays its content. The associated {@code WebEngine}
		// is created automatically at construction time and cannot be changed
		// afterwards. {@code WebView} handles mouse and some keyboard events, and
		// manages scrolling automatically, so there's no need to put it into a
		// {@code ScrollPane}.
		//
		// <p>{@code WebView} objects must be created and accessed solely from the
		// FX thread.

		// {@code WebEngine} is a non-visual object capable of managing one Web page
		// at a time. It loads Web pages, creates their document models, applies
		// styles as necessary, and runs JavaScript on pages. It provides access
		// to the document model of the current page, and enables two-way
		// communication between a Java application and JavaScript code of the page.
		// WebEngine是一个能够一次管理一个网页的非可视对象。
		// 它加载网页，创建文档模型，根据需要应用样式，并在页面上运行JavaScript。
		// 它提供对当前页面的文档模型的访问，并允许Java应用程序和页面的JavaScript代码之间的双向通信。
		final WebView browser = new WebView();
		final WebEngine webEngine = browser.getEngine();

		// 创建ScrollPane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(browser);
		webEngine.loadContent("<b>yes? This is default content load.</b>");  // load Web pages

		// 创建VBox
		VBox vBox = new VBox();
		vBox.getChildren().add(scrollPane);

		// 创建Scene、设置Stage
		Scene scene = new Scene(vBox);
		primaryStage.setWidth(200);
		primaryStage.setHeight(200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
