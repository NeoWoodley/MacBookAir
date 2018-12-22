package UI.CheckBox;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Tooltips are common UI elements which are typically used for showing
		// * additional information about a Node in the scenegraph when the Node is
		// * hovered over by the mouse. Any Node can show a tooltip. In most cases a
		// * Tooltip is created and its {@link #textProperty() text} property is modified
		// * to show plain text to the user. However, a Tooltip is able to show within it
		// * an arbitrary scenegraph of nodes - this is done by creating the scenegraph
		// * and setting it inside the Tooltip {@link #graphicProperty() graphic}
		// * property.
		// 工具提示是常见的UI元素，通常用于在鼠标悬停控件时显示有关控件的其他信息。任何控件都可以显示工具提示，但默认情况下大多数都没有。JavaFX中的工具提示是使用Popups实现的。在JavaFX中，任意内容可以嵌入工具提示中，仅限于String。
		final Tooltip tooltip = new Tooltip("$ tooltip");
		tooltip.setFont(new Font("Arial", 16));
		final CheckBox checkBox = new CheckBox("checkBox");
		checkBox.setTooltip(tooltip);
		checkBox.selectedProperty().addListener(event->{
			System.out.println(checkBox.isSelected());
		});

		Group root = new Group();
		root.getChildren().add(checkBox);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
