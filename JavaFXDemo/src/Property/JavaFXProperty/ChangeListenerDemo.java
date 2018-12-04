package Property.JavaFXProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * 属性可以通知值更改的事件处理程序，以便在属性更改时进行响应处理相关操作。JavaFX属性对象包含一个addListener()方法，它接受两种类型的功能接口：ChangeListener和invalidationListener。
 * 所有JavaFX属性都是实现了ObservableValue和Observable接口，它们分别为ChangeListener和invalidationListener提供了addListener()方法。以下代码显示如何创建ChangeListener来注册到属性。当属性的值发生改变时，将调用change()方法。
 */
public class ChangeListenerDemo {
	public static void main(String[] args) {
		SimpleIntegerProperty xProperty = new SimpleIntegerProperty(0);

		// 有两种方式来实现Listener——内部类、lambda表达式
		// Adding a change listener with anonymous inner class
		xProperty.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("old value: " + oldValue);
				System.out.println("new value: " + newValue);
			}
		});

		// Adding a change listener with lambda expression
		xProperty.addListener((ObservableValue<? extends Number> ov,Number oldValue,Number newValue) -> {
			System.out.println("old value: " + oldValue);
			System.out.println("new value: " + newValue);
		});
	}
}
