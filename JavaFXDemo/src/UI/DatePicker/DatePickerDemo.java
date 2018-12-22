package UI.DatePicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DatePickerDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DatePicker datePicker = new DatePicker();

		DatePicker datePicker1 = new DatePicker(LocalDate.of(2018, 12, 6));

		DatePicker datePicker2 = new DatePicker();
		datePicker2.setValue(LocalDate.of(2018, 12, 12));

		DatePicker datePicker3 = new DatePicker();
		datePicker3.setValue(LocalDate.now());

		VBox vBox = new VBox(40);
		vBox.getChildren().addAll(datePicker,datePicker1,datePicker2,datePicker3);
		Scene scene = new Scene(vBox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
