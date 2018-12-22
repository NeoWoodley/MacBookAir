package Layout.Pane;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

/**
 * 以下是一个实现登录窗口的代码
 */
public class GridPaneDemoSignIn extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Text、TextField、Label、Button
		Text sceneTitle = new Text("Welcome");
		sceneTitle.setFont(Font.font("Tohoma", FontWeight.NORMAL,20));

		Label userName = new Label("User Name: ");
		Label password = new Label("Password: ");

		TextField userTextField = new TextField();
		PasswordField passwordField = new PasswordField();

		Text actionTarget = new Text();

		Button button = new Button("Sign in");
		// 设置按钮点击事件
		button.setOnAction(event -> {
			actionTarget.setFill(Color.FIREBRICK);  // 设置字体颜色
			actionTarget.setText("Sign in button pressed");
		});
		// 创建HBox，放置Button
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.BOTTOM_RIGHT);
		hBox.getChildren().add(button);

		// 创建GridPane
		GridPane gridPane = new GridPane();
		// Pos: A set of values for describing vertical and horizontal positioning and alignment.
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		// Adds a child to the gridpane at the specified column,row position and spans.
		gridPane.add(sceneTitle,0, 0, 2, 1);
		gridPane.add(userName, 0, 1);
		gridPane.add(userTextField, 1, 1);
		gridPane.add(password, 0, 2);
		gridPane.add(passwordField, 1, 2);
		gridPane.add(hBox, 1, 4);
		gridPane.add(actionTarget, 1, 6);

		// 创建Scene、设置Stage
		Scene scene = new Scene(gridPane, 310, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
