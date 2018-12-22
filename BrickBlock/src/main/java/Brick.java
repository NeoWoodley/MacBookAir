import javafx.geometry.Bounds;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends BaseObject {
	private Rectangle mRectangle;
	private int hp;
	private BoxBlur mBlur;

	public Brick(Color color, int hp)
	{
		this.hp = hp;
		this.mRectangle = new Rectangle();
		this.mRectangle.widthProperty().bindBidirectional(widthProperty());
		this.mRectangle.heightProperty().bindBidirectional(heightProperty());
		this.mRectangle.xProperty().bindBidirectional(xProperty());
		this.mRectangle.yProperty().bindBidirectional(yProperty());

		this.mRectangle.setFill(color);
		this.mBlur = new BoxBlur();
		this.mBlur.setWidth(5);
		this.mBlur.setHeight(5);
		this.mRectangle.setEffect(new Lighting());
		setWidth(100);
		setHeight(25);
		getChildren().add(this.mRectangle);
	}

	public Bounds getBounds() {
		return this.mRectangle.getLayoutBounds();
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
