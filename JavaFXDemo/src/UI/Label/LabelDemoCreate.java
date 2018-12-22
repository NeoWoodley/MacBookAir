package UI.Label;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * A label with the text element and graphical icon
 */
public class LabelDemoCreate extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Image image = new Image(getClass().getResourceAsStream("/Users/neowoodley/GitAll/MacBookAir/JavaFXDemo/src" +
				"/Layout/Pane/myImage.jpeg"));  // TODO: 2018-12-04 这里出错了，嘤嘤嘤，为什么呢？？？
		Label label = new Label("Name", new ImageView(image));

		Group root = new Group();
		root.getChildren().add(label);

		Scene scene = new Scene(root, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
