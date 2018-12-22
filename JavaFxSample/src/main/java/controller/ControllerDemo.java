package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerDemo {
	@FXML
	private TextField textField;
	@FXML
	private Button button;

	@FXML
	public void onButtonClick(ActionEvent event) {
		textField.setText("Button is clicked.");
	}
}
