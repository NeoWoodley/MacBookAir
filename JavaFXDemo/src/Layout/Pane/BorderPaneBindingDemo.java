package Layout.Pane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * 使用场景绑定BorderPane宽度和高度
 */
public class BorderPaneBindingDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建MenuBar
		MenuBar menuBar = new MenuBar();
		// 创建Menu
		Menu menu = new Menu("Direction");
		// 创建MenuItem
		MenuItem left = new MenuItem("Left");
		MenuItem right = new MenuItem("Right");
		MenuItem top = new MenuItem("Top");
		MenuItem bottom = new MenuItem("Bottom");
		menu.getItems().addAll(left, right, top, bottom);
		menuBar.getMenus().add(menu);

		// 创建EventHandler，为4个MenuItem设置点击事件
		EventHandler<ActionEvent> action = changeTabPlacement();
		left.setOnAction(action);
		right.setOnAction(action);
		top.setOnAction(action);
		bottom.setOnAction(action);

		// 创建BorderPane
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);  // 将nemuBar固定到左上角的位置

		// 创建Group
		Group root = new Group();
		root.getChildren().add(borderPane);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 400, 250, Color.WHITE);
		// 为borderPane绑定宽度
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private EventHandler<ActionEvent> changeTabPlacement() {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				MenuItem menuItem = (MenuItem) event.getSource();
				String side = menuItem.getText();
				if ("left".equalsIgnoreCase(side)) {
					System.out.println("left");
				} else if ("right".equalsIgnoreCase(side)) {
					System.out.println("right");
				} else if ("top".equalsIgnoreCase(side)) {
					System.out.println("top");
				} else if ("bottom".equalsIgnoreCase(side)) {
					System.out.println("bottom");
				}
			}
		};
	}

}
