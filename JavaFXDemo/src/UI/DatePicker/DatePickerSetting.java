package UI.DatePicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerSetting extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		String pattern = "yyyy-MM-dd";
		// 字符串转换器
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate object) {
				if (object != null) {
					return dateTimeFormatter.format(object);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateTimeFormatter);
				} else {
					return null;
				}
			}
		};

		DatePicker datePicker = new DatePicker();
		datePicker.setConverter(converter);
		// TODO: 2018-12-06 下面的两行代码并没有什么用吧
//		datePicker.setPromptText(pattern.toLowerCase());
//		datePicker.setPromptText("111");
		VBox vBox = new VBox();
		vBox.getChildren().add(datePicker);
		Scene scene = new Scene(vBox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
