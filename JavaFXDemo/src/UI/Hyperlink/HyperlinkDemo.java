package UI.Hyperlink;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Hyperlink类表示类似于JavaFX的网页上的锚链接的超链接。
 */
public class HyperlinkDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Hyperlink hyperlink = new Hyperlink("www.baidu.com");
		hyperlink.setFont(Font.font("Arial",14));
		hyperlink.setOnAction(event -> {
			System.out.println("This link is clicked.");
		});

		VBox vBox = new VBox();
		vBox.getChildren().add(hyperlink);
		Scene scene = new Scene(vBox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
