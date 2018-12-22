import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.jbox2d.dynamics.Body;

public abstract class WBody {
	protected Body mBody;
	protected Paint mColor;
	protected final static int RATE = 30;
	protected double x,y,width,height;
	public Body getBody() {
		return mBody;
	}
	public void setBody(Body mBody) {
		this.mBody = mBody;
	}
	public Paint getColor() {
		return mColor;
	}
	public void setColor(Paint mColor) {
		this.mColor = mColor;
	}

	public abstract void draw(GraphicsContext gc);

	public abstract void update();

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public void setLocation(double x,double y){
		setX(x);
		setY(y);
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
