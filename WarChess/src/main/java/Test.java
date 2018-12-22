import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Test extends Application {

	public static void main(String[] args) {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image orc = new Image(getClass().getResourceAsStream("enemy1.png"));
	}
}
