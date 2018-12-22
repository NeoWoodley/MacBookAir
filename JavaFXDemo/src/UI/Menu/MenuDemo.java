package UI.Menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 菜单是桌面应用程序选择选项的标准方法。
 * 菜单和菜单项可以与选择选项快捷键组合，称为键盘快捷键。
 *
 * 必须创建一个菜单栏javafx.scene.control.MenuBar对象来保存javafx.scene.control.Menu对象。
 * 菜单对象可以包含Menu和javafx.scene.control.MenuItem对象。
 * 菜单可以包含其他菜单作为子菜单。
 * MenuItems是Menu对象内的子选项。
 *
 * 以下代码显示如何创建菜单栏并添加菜单和菜单项。
 * Menu类是MenuItem的子类，它有一个getItems().add()方法，它能够添加诸如其他Menu和MenuItem实例的子元素。
 */
public class MenuDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// FileMenu
		MenuItem newMenuItem = new MenuItem("New");
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem exitMenuItem = new MenuItem("Exit");

		exitMenuItem.setOnAction(event -> {
			Platform.exit();
		});

		Menu fileMenu = new Menu("File");
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);

		// WebMenu
		CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
		CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
		htmlMenuItem.setSelected(true);
		cssMenuItem.setSelected(true);

		Menu webMenu = new Menu("Web");
		webMenu.getItems().addAll(htmlMenuItem, cssMenuItem);

		// SQLMenu
		RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
		RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
		ToggleGroup toggleGroup = new ToggleGroup();
		mysqlItem.setToggleGroup(toggleGroup);
		oracleItem.setToggleGroup(toggleGroup);
		oracleItem.setSelected(true);

		Menu sqlMenu = new Menu("SQL");
		sqlMenu.getItems().addAll(mysqlItem, oracleItem,new SeparatorMenuItem());

		// TutorialMenu
		Menu tutorialMenu = new Menu("Tutorial");
		tutorialMenu.getItems().addAll(new CheckMenuItem("Java"), new CheckMenuItem("JavaFX"), new CheckMenuItem("Swing"));
		sqlMenu.getItems().add(tutorialMenu);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);
		Scene scene = new Scene(borderPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
