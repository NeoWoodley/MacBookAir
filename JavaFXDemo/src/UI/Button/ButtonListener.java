package UI.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonListener extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("Hello World!");
		button.setOnAction(event->{
			System.out.println("Hello World!");
		});

		// StackPane lays out its children in a back-to-front stack.
		// 它是类似于以前的CardLayout的一种卡片布局方式，就是后面的内容会显示在前面内容之上，所以，这种布局很方便用于在图片上显示文字等等
		// 孩子都是居中的，而且空间大小是充满其父空间的。
		// 比如说某一个区域需要共享，会被多个视图所共用，它就发挥作用啦。而且它可以轻易可以把元素居中，它总是铺满父布局的。
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(button,new Button("StackPane feature test."));
		primaryStage.setScene(new Scene(stackPane, 300, 250));
		primaryStage.show();
	}
}
