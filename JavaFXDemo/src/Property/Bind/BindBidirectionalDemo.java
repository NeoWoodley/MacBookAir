//package Property.Bind;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
///**
// * 双向绑定绑定相同类型的属性，并同步两侧的值。当使用bindBidirectional()方法双向绑定时，需要两个属性都必须是可读/写的。
// * 以下代码显示如何在firstName属性和字符串属性变量之间进行双向绑定
// */
//public class BindBidirectionalDemo {
//	public static void main(String[] args) {
//		User contact = new User("Neo", "Woodley");
//		StringProperty firstName = new SimpleStringProperty();
//		firstName.bindBidirectional(contact.firstNameProperty());
//
//		contact.firstNameProperty().set("new value");
////		firstName.set("新绑定名称值");
//
//		System.out.println("firstNameProperty = " + contact.firstNameProperty().get());
//		System.out.println("firstName = " + firstName.get());
//	}
//}
//
//class User{
//	private SimpleStringProperty firstName = new SimpleStringProperty();
//	private SimpleStringProperty lastName = new SimpleStringProperty();
//
//	public User(String firstName, String lastName) {
//		this.firstName.setValue(firstName);
//		this.lastName.setValue(lastName);
//	}
//
//	public final String getFirstName() {
//		return this.firstName.getValue();
//	}
//
//	public StringProperty firstNameProperty() {
//		return this.firstName;
//	}
//
//	public final String getLastName() {
//		return this.lastName.getValue();
//	}
//
//	public StringProperty lastNameProperty() {
//		return this.lastName;
//	}
//
//	public final void setLastName(String lastName) {
//		this.lastName.setValue(lastName);
//	}
//}
//
