package model;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 用来添加我们的所有精灵和地图绘制
 */
class GamePanel extends Parent {
	private Sprite sprite;
	private Sprite sprite2;

	public GamePanel() {
	}

	public void load(){
		sprite = new Sprite(50, 50, 32, 32, "/picture/精灵1.png");
		sprite2 = new Sprite(100, 100, 32, 32, "/picture/精灵1.png");
		getChildren().addAll(sprite,sprite2);
		getScene().setOnKeyPressed(event -> onKeyPressed(event));
	}


	public void onKeyPressed(KeyEvent event){
		if(event.getCode() == KeyCode.LEFT){
			sprite.moveLeft();
			sprite2.moveLeft();
		}else if(event.getCode() == KeyCode.RIGHT){
			sprite.moveRight();
			sprite2.moveRight();
		}else if(event.getCode() == KeyCode.UP){
			sprite.moveUp();
			sprite2.moveUp();
		}else if(event.getCode() == KeyCode.DOWN){
			sprite.moveDown();
			sprite2.moveDown();
		}
	}


	public void update(long now){

	}
}
