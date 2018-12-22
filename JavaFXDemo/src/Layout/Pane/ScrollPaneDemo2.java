//package Layout.Pane;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//
// TODO: 2018-12-04 这个类有问题
//public class ScrollPaneDemo2 extends Application {
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// 创建Image
//		Image image = new Image(getClass().getResourceAsStream("myImage.jpeg"));
//
//		// 创建ScrollPane
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setContent(new ImageView(image));
//
//		// 创建Group
//		Group root = new Group();
//		root.getChildren().add(scrollPane);
//
//		// 创建Scene、设置Stage
//		Scene scene = new Scene(root,200,200);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//}
