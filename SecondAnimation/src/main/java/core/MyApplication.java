package core;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class MyApplication extends Application {
	private Group mGroup;
	private Scene mScene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		loadBefore();
		mGroup= new Group();
		mScene = new Scene(mGroup, MySystem.WIDTH, MySystem.HEIGHT);
		loadEnd();
		showStage(primaryStage);
	}

	protected abstract void loadBefore();

	protected abstract void loadEnd();

	protected void showStage(Stage stage){
		stage.setScene(mScene);
		stage.show();
	}

	protected Scene getScene(){
		return mScene;
	}

	protected Group getRoot(){
		return mGroup;
	}

	public void setWindowSize(int width, int height){
		MySystem.init(width, height);
	}
}
