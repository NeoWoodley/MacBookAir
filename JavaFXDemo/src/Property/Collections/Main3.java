package Property.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * 以下代码显示了如何找出已更改的内容。
 */
public class Main3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		ObservableList<String> observableList = FXCollections.observableList(list);

		observableList.addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(Change<? extends String> c) {
				System.out.println("-------------");
				System.out.println("Detected a change");
				while (c.next()) {
					System.out.println("Was added?" + c.wasAdded());
					System.out.println("Was removed?" + c.wasRemoved());
					System.out.println("Was replaced?" + c.wasReplaced());
					System.out.println("Was permutated" + c.wasPermutated());
				}
			}
		});

		observableList.add("item one");
		list.add("item two");
		list.add("item two");
		observableList.remove(1);
		System.out.println("Size: " + observableList.size());
	}
}
