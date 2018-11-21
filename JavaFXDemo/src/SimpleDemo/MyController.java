package SimpleDemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Controller
 */
public class MyController implements Initializable {
	@FXML
	private Button myButton;

	@FXML
	private TextField myTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void showDateTime(ActionEvent event) {
		System.out.println("Button Clicked");  // 每点击一次按钮，就会在控制台输出，类似于log

		Date now = new Date();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		String dateTImeString = dateFormat.format(now);

		// Show int VIEW
		myTextField.setText(dateTImeString);  // 参数是String
	}

	public void testButton(ActionEvent event) {
		myTextField.setText("testButton");
	}
}
