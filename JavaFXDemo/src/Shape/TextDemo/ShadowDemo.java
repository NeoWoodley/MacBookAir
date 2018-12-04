package Shape.TextDemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShadowDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Shadow
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(3);
		dropShadow.setColor(Color.color(0.4, 0.4, 0.4));

		// 创建Text
		Text text = new Text();
		text.setX(10);
		text.setY(70);
		text.setText("JavaFX");
		text.setFont(Font.font(null, FontWeight.BOLD, 32));
		text.setFill(Color.RED);
		text.setCache(true);
		text.setEffect(dropShadow);

		// 创建Group
		Group root = new Group();
		root.getChildren().add(text);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
