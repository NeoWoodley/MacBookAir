package UI.FileChooser;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * FileChooser允许用户导航文件系统并选择一个文件或文件夹。
 *
 * 文件选择器可用作打开文件对话框，用于选择单个文件或多个文件，或作为文件保存对话框。
 * 可以通过设置initialDirectory和title属性来配置文件选择器对话框窗口。
 *
 * 以下代码创建一个FileChooser对象并设置其标题，然后显示给用户。
 */
public class FileChooserDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		// 可以通过设置initialDirectory和title属性来配置文件选择器对话框窗口。
		fileChooser.setInitialDirectory(new File("/Users/neowoodley/Documents/壁纸"));

		// 可以设置扩展过滤器来确定在文件选择器中打开哪些文件。
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
		);

		// TODO: 2018-12-06 不会保存文件？？？
//		// FileChooser API允许用户为由应用程序保存的文件指定文件名及其文件夹。
//		// showSaveDialog方法打开保存对话框窗口。
//		File file = fileChooser.showOpenDialog(primaryStage);
//
//		fileChooser.showOpenDialog(primaryStage);
	}
}
