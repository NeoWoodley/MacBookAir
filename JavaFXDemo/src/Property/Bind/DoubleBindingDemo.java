package Property.Bind;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * 当对NumberBinding类进行子类化时，使用低级别绑定.
 * 例如Double类型的DoubleBinding类。在DoubleBinding类的子类中，我们覆盖它的computeValue()方法，以便可以使用运算符(例如*和 - )来制定复杂的数学方程计算。
 * 高级绑定使用如multiply()，subtract()等方法，
 * 而低级绑定使用诸如*和 - 等运算符。
 * <p>
 * 以下代码显示如何为公式创建低级别绑定，来计算矩形的面积。
 */
public class DoubleBindingDemo {
	public static void main(String[] args) {
		DoubleProperty width = new SimpleDoubleProperty(2);
		DoubleProperty height = new SimpleDoubleProperty(2);
		DoubleBinding area = new DoubleBinding() {
			{
				super.bind(width, height);  // 初始化bind
			}

			@Override
			protected double computeValue() {
				return width.get() * height.get();
			}
		};

		System.out.println(area.get());
	}
}
