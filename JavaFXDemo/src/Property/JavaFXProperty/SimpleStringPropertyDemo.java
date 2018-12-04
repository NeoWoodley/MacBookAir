package Property.JavaFXProperty;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

import java.lang.reflect.Method;

/**
 * 读/写属性是可以读取和修改的属性值。
 * 例如，SimpleStringProperty类创建一个字符串属性，该属性对包装的字符串值是可读写的。
 * 以下代码演示了SimpleStringProperty类的一个实例，并通过set()方法修改该属性。
 * 下面的代码声明了类型为StringProperty的变量password，并分配给SimpleStringProperty类的实例。
 * 实际的值是字符串“yiibai.com”，
 * 它被传递到SimpleStringProperty类的构造函数中。
 * 要读取值，请调用get()方法或getValue()方法，该方法返回实际的包装值。
 * 如果要修改这个值，请调用set()方法或setValue()并传入一个字符串值。
 * <p>
 * --------------------------
 * 要创建只读属性，请使用以ReadOnly作为前缀的包装类。创建只读属性需要两个步骤。实例化只读包装类调用方法getReadOnlyProperty()返回一个真正的只读属性对象
 */
public class SimpleStringPropertyDemo {
	public static void main(String[] args) {
		// 读/写属性
		StringProperty password = new SimpleStringProperty("javafx");
		password.set("example");  // 修改password的值
		System.out.println(password.get());

		// 只读属性
		ReadOnlyStringWrapper userName = new ReadOnlyStringWrapper("neowoodley");
		ReadOnlyStringProperty readOnlyUserName = userName.getReadOnlyProperty();  // 返回一个真正的只读属性对象
		System.out.println(readOnlyUserName);
	}
}
