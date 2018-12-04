package Property.Bind;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 在JavaFX中，UI控件和域模型之间的数据绑定很容易。以下代码显示如何创建登录对话框并绑定用户域对象。
 *
 * 首先，我们定义域对象，它是描述用户名和密码的JavaFX JavaBean。
 */
public class UserBindDemo extends Application {
	private final static String MY_PASS = "passwd";  // 初始密码
	private final static BooleanProperty accessGranted = new SimpleBooleanProperty(false);

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 创建User对象
		User user = new User();

		// 创建了两个UI控件，
		// 一个用于使用Text控件显示用户名，
		// 另一个是 PasswordField 字段控件，它将输入值绑定到域对象(User)中的 password 字段。

		// 创建Text，绑定userName
		Text userName = new Text();
		userName.textProperty().bind(user.userNameProperty());

		// 创建PasswordField，绑定password
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Password");  // 设置提示文字
		user.passwordProperty().bind(passwordField.textProperty());

		// user hits he enter key
		passwordField.setOnAction(actionEvent->{
			if (accessGranted.get()) {
				System.out.println("granted access: " + user.getUserName());
				System.out.println("password: " + user.getPassword());
				Platform.exit();
			} else {
				primaryStage.setTitle("no access");
			}
		});

		// 设置监听器
		passwordField.textProperty().addListener(((observable,oldValue,newValue) -> {
			boolean granted = passwordField.getText().equals(MY_PASS);
			System.out.println(granted);  // 通过这一行输出，我们能发现在passwordField每输入一个字符，就重新计算granted
			accessGranted.set(granted);
			if (granted) {
				primaryStage.setTitle("");
			}
		}));

		// 创建VBox
		VBox formLayout = new VBox(4);
		formLayout.getChildren().addAll(userName, passwordField);
		formLayout.setLayoutX(12);
		formLayout.setLayoutY(12);

		// 创建Group
		Group root = new Group();
		root.getChildren().addAll(formLayout);

		// 创建Scene、设置Stage
		Scene scene = new Scene(root, 320, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

class User{
	private final ReadOnlyStringWrapper userName;
	private StringProperty password;

	public User() {
		userName = new ReadOnlyStringWrapper(this, "userName", "ABC");
		password = new SimpleStringProperty(this, "password", "");
	}

	public final String getUserName() {
		return userName.get();
	}

	public ReadOnlyStringProperty userNameProperty() {
		return userName.getReadOnlyProperty();
	}

	public final String getPassword() {
		return password.get();
	}

	public StringProperty passwordProperty() {
		return password;
	}
}

