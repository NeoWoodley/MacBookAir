package UI.ScrollBar;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

/**
 * ScrollBar类经常带有一个可滚动的窗格。
 * 滚动条有四个区域：
 * 1. 拇指
 * 2. 右按钮或向下按钮
 * 3. 左按钮或向上按钮
 * 4. 跟踪
 *
 * setMin()和setMax()方法定义滚动条表示的最小值和最大值。
 * setValue()方法设置滚动的当前值，也设置拇指的位置。
 * 当用户移动缩略图时，滚动条的值会更改。
 * 默认情况下，滚动条水平定向。我们可以使用setOrientation()方法设置垂直方向。
 * 我们可以单击水平滚动条的左和右按钮或者向上和向下按钮，垂直滚动条以单位增量滚动。UNIT_INCREMENT属性设置此值。
 * 单击轨道可使滚动条移动块增量。BLOCK_INCREMENT属性定义此值。
 */
public class ScrollBarDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		ScrollBar scrollBar = new ScrollBar();
		scrollBar.setMin(0);
		scrollBar.setMax(500);
		scrollBar.setValue(100);
		scrollBar.setUnitIncrement(30);  // 设置滚动条的单位增量，设置鼠标滚动速度、点击上下按钮的滚动速度
		scrollBar.setBlockIncrement(35);  // 设置滚动条的块增量块增量是用户激活滚动条的块增量区域时增加或减少的值，即点击进度条的位置增减的值
		scrollBar.setOrientation(Orientation.VERTICAL);  // 设置滚动条的朝向
		scrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println(newValue.doubleValue());
		});

		Group root = new Group();
		root.getChildren().add(scrollBar);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
