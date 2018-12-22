package UI.PasswordField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * PasswordField用于密码输入。
 * 用户键入的字符通过显示回显字符串被隐藏。
 * JavaPasswordField类有setText方法来为控件设置文本字符串。
 * 对于密码字段，指定的字符串由回显字符隐藏。
 * 默认情况下，回显字符是一个点(或是星号)。
 * 密码字段中的值可以通过getText()方法获取。
 */
public class PasswordFieldDemo extends Application {
	final Label message = new Label("");

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 0, 0, 10));
		vBox.setSpacing(10);

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER_LEFT);

		Label label = new Label("Password");
		final PasswordField passwordField = new PasswordField();
		passwordField.setOnAction(event -> {  // 按下回车后触发的事件
			if (!passwordField.getText().equals("abc")) {
				message.setText("Your password is incorrect!");
				message.setTextFill(Color.web("red"));
			} else {
				message.setText("Your password has been confirmed.");
				message.setTextFill(Color.web("black"));
			}
			passwordField.setText("");
		});

		hBox.getChildren().addAll(label, passwordField);
		vBox.getChildren().addAll(hBox, message);

		Scene scene = new Scene(vBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
