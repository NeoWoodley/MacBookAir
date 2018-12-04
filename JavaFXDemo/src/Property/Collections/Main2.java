package Property.Collections;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 以下代码显示了如何监听ObservableMap上的更改。
 */
public class Main2 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		ObservableMap<String, String> observableMap = FXCollections.observableMap(map);

		observableMap.addListener(new MapChangeListener<String, String>() {
			@Override
			public void onChanged(Change<? extends String, ? extends String> change) {
				System.out.println("change!");
			}
		});

		observableMap.put("key1", "value1");
		map.put("key2", "value2");
	}
}
