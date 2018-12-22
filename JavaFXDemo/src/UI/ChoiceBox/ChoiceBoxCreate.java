package UI.ChoiceBox;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChoiceBoxCreate extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		final Label label = new Label("Hello");
		label.setStyle("-fx-font:25 arial;");
		label.setLayoutX(40);

		final String[] greetings = new String[]{"aa", "bb", "cc"};

		// 我们可以使用ChoiceBox中的构造函数来创建ChoiceBox对象。
		// 以下代码显示了如何使用其构造函数创建和填充选择框。
		// 列表项是从可观察的列表来创建的。
		ChoiceBox<String> choiceBox = new ChoiceBox(FXCollections.observableArrayList("A", "B", "C"));

		// 我们还可以使用一个空的选择框使用它的默认构造函数，并使用setItems方法设置列表项。
		// 上面的代码还向选择框中添加了一个分隔符对象。分隔符分隔控件项目。
		ChoiceBox choiceBox1 = new ChoiceBox();
		choiceBox1.setItems((FXCollections.observableArrayList("D", "E", "F", new Separator(), "G", "H")));

		choiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
			label.setText(greetings[newValue.intValue()]);
//			System.out.println(choiceBox.getValue());  // 有啥用呢？？？
		});

		choiceBox.setTooltip(new Tooltip("Select the laguage"));

		HBox hBox = new HBox();
		hBox.getChildren().addAll(choiceBox, label);
		hBox.setSpacing(30);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(10, 0, 0, 10));

		Scene scene = new Scene(hBox,400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
