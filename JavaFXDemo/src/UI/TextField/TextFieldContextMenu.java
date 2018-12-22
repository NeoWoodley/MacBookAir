package UI.TextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * 以下代码显示了如何将ContextMenu添加到TextField。
 */
public class TextFieldContextMenu extends Application {
	// TODO: 2018-12-05 这段代码好像没实现什么功能啊？？？
	@Override
	public void start(Stage primaryStage) throws Exception {
//		TextField textField = new TextField();
//		final ContextMenu menu = new ContextMenu();
//		menu.setOnShowing(event -> {
//			System.out.println("showing");
//		});
//
//		menu.setOnShown(event -> {
//			System.out.println("shown");
//		});
//
//		MenuItem menuItem = new MenuItem("About");
//		menuItem.setOnAction(event -> {
//			System.out.println("About");
//		});
//
//		MenuItem menuItem1 = new MenuItem("Preference");
//		menuItem1.setOnAction(event -> {
//			System.out.println("Preference");
//		});
//
//		menu.getItems().addAll(menuItem, menuItem1);
//		textField.setContextMenu(menu);
//
//		GridPane gridPane = new GridPane();
//		gridPane.setVgap(4);
//		gridPane.setHgap(10);
//		gridPane.setPadding(new Insets(5, 5, 5, 5));
//		gridPane.add(new Label("To: "), 0, 0);
//		gridPane.add(textField, 1, 0);
//
//		Group root = new Group();
//		root.getChildren().add(gridPane);
//		Scene scene = new Scene(root, 400, 300);
//		primaryStage.setScene(scene);
//		primaryStage.show();

		Scene scene = new Scene(new Group(), 450, 250);

		TextField notification = new TextField();

		final ContextMenu contextMenu = new ContextMenu();
		contextMenu.setOnShowing(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				System.out.println("showing");
			}
		});
		contextMenu.setOnShown(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				System.out.println("shown");
			}
		});

		MenuItem item1 = new MenuItem("About");
		item1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("About");
			}
		});
		MenuItem item2 = new MenuItem("Preferences");
		item2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("Preferences");
			}
		});
		contextMenu.getItems().addAll(item1, item2);

		notification.setContextMenu(contextMenu);
		GridPane grid = new GridPane();
		grid.setVgap(4);
		grid.setHgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.add(new Label("To: "), 0, 0);
		grid.add(notification, 1, 0);

		Group root = (Group) scene.getRoot();
		root.getChildren().add(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
