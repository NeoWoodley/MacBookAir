package Property.JavaFXProperty;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 以下代码显示了如何创建一个invalidationListener以向属性注册。随着属性的值改变，将调用invalidated()方法。
 *
 * ChangeListener和invalidationListener之间的区别。使用ChangeListener将可获取Observable(ObservableValue)的旧值和新值。使用invalidationListener只获取Observable对象(属性)
 */
public class InvalidationListenerDemo {
	public static void main(String[] args) {
		SimpleIntegerProperty xProperty = new SimpleIntegerProperty(0);

		// 创建一个invalidationListener有两个方式——内部类、lambda表达式
		// Adding a invalidation listener (anonymous inner class)
		xProperty.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				System.out.println(observable.toString());
			}
		});

		// Adding a invalidation listener (lambda expression)
		xProperty.addListener((Observable observable)->{
			System.out.println(observable.toString());
		});
	}
}
