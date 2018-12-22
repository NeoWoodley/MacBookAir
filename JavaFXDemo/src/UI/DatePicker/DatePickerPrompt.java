package UI.DatePicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 为每个日期单元格安装工具提示。
 */
public class DatePickerPrompt extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DatePicker startDatePicker = new DatePicker();
		DatePicker endDatePicker = new DatePicker();
		startDatePicker.setValue(LocalDate.now());

		// DateCell用于DatePicker在日历月中呈现单个网格单元格。
		// 通过提供a dayCellFactory，应用程序可以提供更新方法来更改每个单元格的属性，例如文本，背景颜色等。

		// 此接口的实现被传递给a CallbackHandler，
		// 允许底层安全服务能够与调用应用程序交互以检索特定的身份验证数据（如用户名和密码），或显示某些信息，如错误和警告消息。
		// Callback实现不检索或显示底层安全服务请求的信息。
		// Callback实现只是提供将这些请求传递给应用程序的方法，
		// 并且如果合适的话，为应用程序提供将所请求的信息返回给底层安全服务的方法。
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(DatePicker param) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						// ChronoUnit：需要注意的是，如果要以不同的单位展示时间差，
						// between入参中的时间对象必须包含有对应的时间信息，否则会抛出
						// java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit XXX的异常
						long p = ChronoUnit.DAYS.between(startDatePicker.getValue(), item);  // 用于计算时间差
						setTooltip(new Tooltip("You're about to stay for " + p + " days"));
					}
				};
			}
		};

		endDatePicker.setDayCellFactory(dayCellFactory);
		endDatePicker.setValue(startDatePicker.getValue().plusDays(1));

		VBox vBox = new VBox(20);
		vBox.getChildren().addAll(new Label("Start Date: "), startDatePicker, new Label("End Date: "), endDatePicker);
		Scene scene = new Scene(vBox,400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
