package SimpleDemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 这是主程序的入口类
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Read file fxml and draw interface
			Parent root = FXMLLoader.load(getClass().getResource("SimpleDemo/MyScene.fxml"));
			primaryStage.setTitle("My Application");
			primaryStage.setScene(new Scene(root));  // 一个Scene只有一个root
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

