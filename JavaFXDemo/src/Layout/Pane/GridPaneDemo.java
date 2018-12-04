package Layout.Pane;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * GridPane通常用于布局：第一列上的只读标签的输入表单和第二列上的输入字段。
 * GridPane可以在行，列或单元格级别指定约束。
 * 例如，我们可以设置包含输入文本字段的第二列，以在窗口调整大小时调整大小。
 * <p>
 * 以下代码演示使用GridPane布局的简单表单应用程序。它有以下布局。
 * +------------------------+
 * | [label ] [   field   ] |
 * | [label ] [   field   ] |
 * |             [ button ] |
 * +------------------------+
 */
public class GridPaneDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建Label、TextField、Button
		Label firstNameLabel = new Label("First Name");
		Label lastNameLabel = new Label("Second Name");
		TextField firstNameTextField = new TextField();
		TextField lastNameTextField = new TextField();
		Button saveButton = new Button("Save");

		// 创建GridPane（网格）
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));  // Insets: A set of inside offsets for the 4 side of a rectangular area
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		// Sets the horizontal alignment for the child when contained by a gridpane.
		// If set, will override the gridpane's default horizontal alignment.
		// Setting the value to null will remove the constraint.
		// 设置各个控件的水平对其位置，居中对齐、靠右对齐、靠左对齐等等
		GridPane.setHalignment(firstNameLabel, HPos.RIGHT);
		GridPane.setHalignment(lastNameLabel, HPos.RIGHT);
		GridPane.setHalignment(firstNameTextField, HPos.LEFT);
		GridPane.setHalignment(lastNameTextField, HPos.LEFT);
		GridPane.setHalignment(saveButton, HPos.RIGHT);
		// 设置各个控件所在象限
		gridPane.add(firstNameLabel, 0, 0);
		gridPane.add(lastNameLabel, 0, 1);
		gridPane.add(firstNameTextField, 1, 0);
		gridPane.add(lastNameTextField, 1, 1);
		gridPane.add(saveButton, 1, 2);

		// 创建ColumnConstraints
		// Defines optional layout constraints for a column in a {@link GridPane}.
		// If a ColumnConstraints object is added for a column in a gridpane, the gridpane
		// will use those constraint values when computing the column's width and layout.
		ColumnConstraints columnConstraints1 = new ColumnConstraints(100);  // 设置第一列的宽度
		ColumnConstraints columnConstraints2 = new ColumnConstraints(50, 150, 300);  // 设置第二列的宽度
		columnConstraints2.setHgrow(Priority.ALWAYS);  // 让第二列的宽度随窗口大小的改变而变动
		// 这样会导致在设置Scene大小的同时，也会改变第二列的宽度；
		// 可以计算出如果Scene宽度设为400的话，恰好两列能完全填满；但如果超过了400，则右边会产生空隙
		gridPane.getColumnConstraints().addAll(columnConstraints1, columnConstraints2);

		// 创建BorderPane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(gridPane);

		// 创建Scene、设置Stage
		// 如果gridPane是放在Group中的，那么改变窗口大小的话，控件大小是不会随之改变的，因为Group是不能改变子结点大小的
		Scene scene = new Scene(borderPane, 450, 150, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
