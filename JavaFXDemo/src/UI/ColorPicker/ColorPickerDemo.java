package UI.ColorPicker;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 颜色选择器控件允许用户从可用的颜色范围中选择颜色，或通过指定RGB或HSB组合设置其他颜色。
 * JavaFX ColorPicker控件具有颜色选择器，调色板和自定义颜色对话框窗口。
 */
public class ColorPickerDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		ColorPicker colorPicker = new ColorPicker();
		colorPicker.setValue(Color.RED);

		// 自定义颜色
		// getCustomColors()方法返回创建的自定义颜色作为Color对象的ObservableList。
		ObservableList<Color> customColors = colorPicker.getCustomColors();  // 习惯性的颜色
		colorPicker.setValue(customColors.get(0));

		Text text = new Text("Color picker: ");
		text.setFill(colorPicker.getValue());

		// TODO: 2018-12-06 在colorPicker上添加setOnAction有什么用呢？？？
		colorPicker.setOnAction(event -> {
			text.setFill(colorPicker.getValue());  // 一旦colorPicker颜色改变，立马同步应用到text上
			// TODO: 2018-12-06 咦？怎么没同步到text上？？？
			System.out.println(colorPicker.getValue());
		});

		Button button = new Button("Change Color");
		button.setTooltip(new Tooltip("Change to blue"));
		button.setOnAction(event -> {
			colorPicker.setValue(Color.BLUE);
			text.setFill(colorPicker.getValue());  // TODO: 2018-12-06 这行代码能同步更新text的颜色！！！
			System.out.println("You change the color of text."+colorPicker.getValue());
		});

		HBox hBox = new HBox();
		hBox.getChildren().addAll(text,button);
		Scene scene = new Scene(hBox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
