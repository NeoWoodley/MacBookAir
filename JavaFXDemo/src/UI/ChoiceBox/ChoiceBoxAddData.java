package UI.ChoiceBox;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 以下代码显示了如何在ChoiceBox中填充数据。
 */
public class ChoiceBoxAddData extends Application {
	ObservableList cursors = FXCollections.observableArrayList(
			Cursor.DEFAULT,
			Cursor.CROSSHAIR,
			Cursor.WAIT,
			Cursor.TEXT,
			Cursor.HAND,
			Cursor.MOVE,
			Cursor.N_RESIZE,
			Cursor.NE_RESIZE,
			Cursor.SE_RESIZE,
			Cursor.NONE
	);

	@Override
	public void start(Stage primaryStage) throws Exception {
		ChoiceBox choiceBox = new ChoiceBox(this.cursors);

		VBox vBox = new VBox();
		vBox.getChildren().add(choiceBox);

		Scene scene = new Scene(vBox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		scene.cursorProperty().bind(choiceBox.getSelectionModel().selectedItemProperty());  // Defines the mouse cursor for this {@code Scene}.
	}
}
