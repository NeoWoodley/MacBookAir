import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.jbox2d.dynamics.Body;

public class WCircleBody extends WBody {
	protected DoubleProperty radius;

	public WCircleBody(Body body, double radius, Paint color){
		this.mBody = body;
		this.radius = new SimpleDoubleProperty(radius);
		this.mColor = color;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.save();
		gc.setFill(mColor);
		gc.fillOval(getX(), getY(),  getRaidus() * 2, getRaidus() * 2);
		gc.restore();
	}

	@Override
	public void update() {
		setX(mBody.getPosition().x * RATE - getRaidus());
		setY(mBody.getPosition().y * RATE - getRaidus());
	}

	public double getWidth(){
		return 2 * getRaidus();
	}

	public double getHeight(){
		return 2 * getRaidus();
	}

	public DoubleProperty radiusProperty(){
		return radius;
	}

	public double getRaidus(){
		return radius.get();
	}

	public void setRadius(double radius){
		this.radius.set(radius);
	}
}
