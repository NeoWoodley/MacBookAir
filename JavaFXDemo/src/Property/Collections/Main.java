package Property.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * 以下代码显示了如何使用ObservableList，ObservableMap和FXCollections。
 */
public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		ObservableList<String> observableList = FXCollections.observableList(list);
		// 使用匿名内部类可以实现监听器，但可以使用更为简便的lambda表达式
		observableList.addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(Change<? extends String> c) {
				System.out.println("有修改操作");
			}
		});

		observableList.add("item  one");  // 将会触发监听器中方法的运行
		observableList.add("item  one");  // 将会触发监听器中方法的运行
		observableList.add("item  one");  // 将会触发监听器中方法的运行
		list.add("item two");  // 不会触发监听器
		list.add("item two");  // 不会触发监听器
		list.add("item two");  // 不会触发监听器

		System.out.println("Size: " + observableList.size());
	}
}
