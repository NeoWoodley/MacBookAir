package UI.DatePicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;

/**
 * 默认情况下，日历元素中的所有单元格都可供选择。可以使用日期单元工厂禁用单元格。
 */
public class DatePickerDateCell extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DatePicker startDatePicker = new DatePicker();
		DatePicker endDatePicker = new DatePicker();
		startDatePicker.setValue(LocalDate.now());  // 初始设置为当前日期

		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(DatePicker param) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(startDatePicker.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #EEEEEE");
						}
					}
				};
			}
		};

		// TODO: 2018-12-06 下面一行的代码到底做了什么？？？
		endDatePicker.setDayCellFactory(dayCellFactory);
		endDatePicker.setValue(startDatePicker.getValue().plusDays(1));

		VBox vBox = new VBox();
		vBox.setSpacing(20);
		vBox.getChildren().addAll(new Label("Start Date: "), startDatePicker, new Label("End Date: "),endDatePicker);
		Scene scene = new Scene(vBox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
