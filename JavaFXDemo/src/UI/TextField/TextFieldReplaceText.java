package UI.TextField;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Override replaceText和replaceSelection以创建自定义的TextField，如下所示
 * 上面的代码生成以下结果，只能输入除了a-z之外的字符
 */
public class TextFieldReplaceText extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		TextField textField = new TextField() {
			@Override
			public void replaceText(int start, int end, String text) {
				System.out.println("replaceText: "+text);
				if (!text.matches("[a-z]")) {
					super.replaceText(start,end,text);
				}

			}

			@Override
			public void replaceSelection(String replacement) {
				System.out.println("replaceSelection: "+replacement);
				if (!replacement.matches("[a-z]")) {
					super.replaceSelection(replacement);  // 如果没有选择的内容，则该操作插入给定的文本。如果没有替换文本，则该操作移除当前选择的内容。
				}
			}
		};

		Group root = new Group();
		root.getChildren().add(textField);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
