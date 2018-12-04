package Property.JavaFXProperty;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 以下代码显示了如何创建JavaFX JavaBean。当构建基于Swing的应用程序时，我们使用getter和setter创建JavaBean。然后我们必须通过Swing模型类在UI逻辑中获取和设置数据。通过使用JavaFX属性创建JavaFX JavaBean，JavaFX将执行数据绑定，并完成域模型类和UI控件之间的数据交换作业。
 *
 * JavaBean 是一种JAVA语言写成的可重用组件。为写成JavaBean，类必须是具体的和公共的，并且具有无参数的构造器。JavaBean 通过提供符合一致性设计模式的公共方法将内部域暴露成员属性，set和get方法获取。
 *
 * 从基本上说，JavaBean可以看成是一个黑盒子，即只需要知道其功能而不必管其内部结构的软件设备。黑盒子只介绍和定义其外部特征和与其他部分的接口，如按钮、窗口、颜色、形状、句柄等。
 * JavaBean 图册
 * JavaBean 图册(6张)
 *  通过将系统看成使用黑盒子关联起来的通讯网络，我们可以忽略黑盒子内部的系统细节，从而有效地控制系统的整体性能。
 * 作为一个黑盒子的模型，JavaBean有3个接口面，可以独立进行开发。
 * 1. JavaBean可以调用的方法。
 * 2. JavaBean提供的可读写的属性。
 * 3. JavaBean向外部发送的或从外部接收的事件。
 */
public class JavaBeanDemo {
	private final static String USERNAME_PROP_NAME = "userName";
	private final ReadOnlyStringWrapper userName;  // 只读字符串包装器
	private final static String PASSWORD_PROP_NAME = "password";
	private StringProperty password;

	public JavaBeanDemo() {
		this.userName = new ReadOnlyStringWrapper(this, USERNAME_PROP_NAME, "fake user");  // fake：假冒者
		password = new SimpleStringProperty(this, PASSWORD_PROP_NAME, "");
	}

	public final String getUserName() {
		return this.userName.get();
	}

	public ReadOnlyStringProperty userNameProperty() {
		return userName.getReadOnlyProperty();
	}

	public final String getPassword() {
		return password.get();
	}

	public final void setPassword(String password) {
		this.password.set(password);
	}
}
