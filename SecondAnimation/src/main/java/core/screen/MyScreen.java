import MyObject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public abstract class MyScreen extends Canvas {
	protected enum GameState {GAME_MENU, GAME_START, GAME_CONTINUE, GAME_HELP, GAME_SET, GAME_EXIT, GAME_PAUSE}

	;
	private List<MyObject> mObjects = new ArrayList<MyObject>();
	private Timeline timeline;
	private KeyFrame keyFrame;
	private int duration = 10;
	protected GameState mGameState = GameState.GAME_MENU;

	public MyScreen(double width, double height) {
		super(width, height);
		initTimeLine();
	}

	public void initEvents() {
		getParent().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				onKeyPressed(event);
			}
		});
		getParent().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				onKeyReleased(event);
			}
		});
	}

	protected abstract void onKeyPressed(KeyEvent event);

	protected abstract void onKeyReleased(KeyEvent event);


	/**
	 * add the object
	 *
	 * @param baseObject the object to be add
	 */
	public void addObject(MyObject baseObject) {
		this.mObjects.add(baseObject);
	}

	/**
	 * remove the object
	 *
	 * @param baseObject the object to be remove
	 */
	public void removeObject(MyObject baseObject) {
		this.mObjects.remove(baseObject);
	}

	/**
	 * remove the object with the index
	 *
	 * @param index the index of the object
	 */
	public void removeObjectAtIndex(int index) {
		this.mObjects.remove(index);
	}

	/**
	 * draw the objects
	 *
	 * @param gc
	 */
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < mObjects.size(); i++) {
			MyObject wObject = mObjects.get(i);
			if (wObject.isVisible()) {
				wObject.draw(gc);
			}
		}
	}

	/**
	 * update all the objects
	 */
	public void update() {
		for (int i = 0; i < mObjects.size(); i++) {
			MyObject wObject = mObjects.get(i);
			if (wObject.isUpdate()) {
				mObjects.get(i).update();
			}
		}
	}

	/**
	 * init the timeline
	 */
	private void initTimeLine() {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);

		keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				draw(getGraphicsContext2D());
				update();
			}
		});
		timeline.getKeyFrames().add(keyFrame);
	}

	/**
	 * start the update timeline
	 */
	public void start() {
		timeline.play();
	}

	/**
	 * pause the update timeline
	 */
	public void pause() {
		timeline.pause();
	}

	/**
	 * stop the update timeline
	 */
	public void stop() {
		timeline.stop();
	}
}
