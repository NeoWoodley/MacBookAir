package UI.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonCSS extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button1 = new Button("使用CSS实现");
		Button button2 = new Button("使用Java代码实现");

		button1.getStyleClass().add("button1");  // TODO: 2018-12-04 这里使用CSS来实现，并没有完成哦！！！
		button2.setStyle("-fx-font: 30 arial; -fx-base:#ee2211;");

		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.getChildren().add(button2);

		Scene scene = new Scene(vBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
