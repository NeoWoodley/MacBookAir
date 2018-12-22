package UI.TextField;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 以下代码显示如何将字符串值从TextField绑定到Stage Title。
 */
public class TextFieldBinding extends Application {
	private StringProperty title = new SimpleStringProperty();

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextField textField = new TextField("Stage Coach");
		textField.setPrefColumnCount(15);
		title.bind(textField.textProperty());

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		hBox.getChildren().add(new Label("title: "));
		hBox.getChildren().add(textField);

		Scene scene = new Scene(hBox, 270, 200);
		primaryStage.setScene(scene);
		primaryStage.titleProperty().bind(title);  // 直接绑定textField.textProperty()也是可以的，就不用创建title变量了
		primaryStage.show();
	}
}
