package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLDemo.fxml"));
			Scene scene = new Scene(parent, 300, 200);
			scene.getStylesheets().add(getClass().getResource("/style/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println(getClass().getResource("").getPath());  // 获取当前相对路径
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
