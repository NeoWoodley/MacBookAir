package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerDemo {
	@FXML
	private Button button;
	@FXML
	private TextField textField;
	@FXML
	public void fun() {
		System.out.println("Hello!"+textField.getText());
	}
}
