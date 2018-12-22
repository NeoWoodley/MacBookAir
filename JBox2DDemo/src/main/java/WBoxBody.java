import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.jbox2d.dynamics.Body;

public class WBoxBody extends WBody {
	public WBoxBody(double width, double height, Body body, Paint paint) {
		this.mBody = body;
		this.mColor = paint;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.save();
		gc.setFill(mColor);
		gc.fillRect(getX(), getY(), getWidth(),getHeight());
		gc.restore();
	}

	@Override
	public void update() {
		setX(mBody.getPosition().x * RATE - getWidth() / 2);
		setY(mBody.getPosition().y * RATE - getHeight() / 2);
	}
}
