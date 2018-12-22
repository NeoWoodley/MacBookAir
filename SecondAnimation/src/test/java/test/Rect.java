package test;

import core.component.MyObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends MyObject {
	public Rect(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.CHOCOLATE);
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void update() {
		moveX(1);
	}
}
