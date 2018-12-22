import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameScene extends Parent {
	private int width, height;
	private Rectangle background;
	private MainBrick mainBrick = new MainBrick();
	private Ball ball = new Ball(15, 15, 15);
	private Timeline timeline;
	private KeyFrame keyFrame;
	private CopyOnWriteArrayList<Brick> bricks = new CopyOnWriteArrayList<Brick>();


	public GameScene(int width, int height){
		this.width = width;
		this.height = height;

		initGameObjects();
		initTimeLine();
		initLevel();
	}

	private void initGameObjects(){
		background = new Rectangle(0, 0, this.width, this.height);
		background.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainBrick.onMouseMove(event);
			}
		});
		background.setFill(Color.BLACK);

		mainBrick.setX(0);
		mainBrick.setY(height - mainBrick.getHeight());
		ball.setX((mainBrick.getWidth() - ball.getWidth())/2);
		ball.setY(height - mainBrick.getHeight() - ball.getHeight());

		getChildren().add(background);
		getChildren().add(mainBrick);
		getChildren().add(ball);
	}

	private void initTimeLine(){
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		keyFrame = new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				ball.moveX(ball.getSpeedX());
				ball.moveY(ball.getSpeedY());

				if(ball.getX() <= 0 || ball.getX() >= BrickBlock.WIDTH - ball.getWidth()){
					ball.setSpeedX(-ball.getSpeedX());
				}

				if(ball.getY() <= 0 || ball.getY() >= BrickBlock.HEIGHT - ball.getHeight()){
					ball.setSpeedY(-ball.getSpeedY());
				}

				if(ball.isCollisionWith(mainBrick)) {
					ball.setSpeedY(-ball.getSpeedY());
				}

				for (Brick brick : bricks) {
					if (ball.isCollisionWith(brick)) {
						brick.setHp(brick.getHp() - 1);
						ball.setSpeedY(-ball.getSpeedY());
						if (brick.getHp() <= 0) {
							destroyObject(brick);
						}
						break;
					}
				}
			}
		});
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

	private void destroyObject(final BaseObject brick) {
		FadeTransition fade = new FadeTransition(Duration.millis(200.0D), brick);
		fade.setFromValue(1.0D);
		fade.setToValue(0.0D);
		fade.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				getChildren().remove(brick);
			}
		});
		this.bricks.remove((Brick) brick);
		fade.play();
	}

	private void initLevel() {
		LevelLoader.load(this, 1);
	}

	public void addChild(Parent parent) {
		getChildren().add(parent);
	}

	public CopyOnWriteArrayList<Brick> getBricks() {
		return this.bricks;
	}
}
