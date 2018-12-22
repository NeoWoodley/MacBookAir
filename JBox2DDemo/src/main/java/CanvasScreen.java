import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.jbox2d.callbacks.ParticleQueryCallback;
import org.jbox2d.callbacks.QueryCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CanvasScreen extends Canvas {
	private GraphicsContext gc;
	private Timeline mTimeline;
	private double duration = 10;
	private static final int RATE = 10;
	private World world;
	private AABB aabb;
	private BodyDef bd;

	private List<WBody> bodys = new CopyOnWriteArrayList<WBody>();
	public CanvasScreen(double width, double height) {
		super(width, height);

		Vec2 gravity = new Vec2(-1.0f, 10.0f);
		world = new World(gravity);

		Vec2 minV = new Vec2(-100.0f, -100.0f);
		Vec2 maxV = new Vec2(100.0f, 100.0f);

		aabb = new AABB();
		aabb.lowerBound.set(minV);
		aabb.upperBound.set(maxV);

		world.queryAABB((ParticleQueryCallback) null, aabb);
		bd = new BodyDef();

		gc = getGraphicsContext2D();
		init();
		initObjects();
	}

	public void init() {
		mTimeline = new Timeline();
		mTimeline.setCycleCount(Timeline.INDEFINITE);
		KeyFrame frame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				draw(gc);
				update();

			}
		});
		mTimeline.getKeyFrames().add(frame);
		mTimeline.play();
	}

	public void initObjects(){
		createPolygon(10, 500, (int) getWidth() - 10 * 2, 10, 0.3f, 0.6f, true);
		createPolygon(10, 10, 10, 500, 0.3f, 0.6f, true);
		createPolygon((int) getWidth() - 10 * 2, 10, 10, 500, 0.3f, 0.6f, true);
		float restitution[] = new float[] { 0.9f, 0.9f, 0.9f, 0.9f, 0.75f, 0.9f, 1.0f, 0.6f, 0.8f, 0.4f, 0.9f, 0.9f,
				0.9f, 0.9f, 0.75f, 0.9f, 1.0f, 0.6f, 0.8f, 0.4f, 0.9f, 0.9f, 0.9f, 0.9f, 0.75f, 0.9f, 1.0f, 0.6f, 0.8f,
				0.4f, 0.9f, 0.9f, 0.9f, };
		for (int i = 0; i < restitution.length; i++) {
			createCircle(80 + i * 20, 5 * i, 15, 0.3f, restitution[i], false);
		}
	}

	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, getWidth(), getHeight());
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, getWidth(), getHeight());
		for(WBody mBody : bodys){
			mBody.draw(gc);
		}
	}

	public void update() {
		for(WBody body : bodys){
			body.update();
		}

		world.step(1.0f / 60.0f, 8, 3);
	}

	/**
	 * 创建矩形
	 */
	public void createPolygon(float x, float y, float w, float h, float friction, float restitution, boolean isStatic) {
		// 创建多边形皮肤
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(w / 2 / RATE, h / 2 / RATE);

		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 1.0f; // 设置密度
		fd.friction = friction; // 设置摩擦力
		fd.restitution = restitution; // 设置多边形的恢复力

		// 设置刚体初始坐标
		bd.type = isStatic ? BodyType.STATIC : BodyType.DYNAMIC;
		bd.position.set((x + w / 2) / RATE, (y + h / 2) / RATE);

		// 创建物体
		Body body = world.createBody(bd); // 物理世界创建物体

		// 此方法改变了
		// body.createShape(pDef); //为body添加皮肤
		body.createFixture(fd);

		WBoxBody boxBody = new WBoxBody(w, h, body, Color.WHITE);
		boxBody.setLocation(x, y);
		bodys.add(boxBody);
	}

	/**
	 * 创建圆形
	 */
	public void createCircle(float x, float y, float r, float friction, float restitution, boolean isStatic) {
		CircleShape shape = new CircleShape();
		shape.m_radius = r / RATE;

		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 1.0f;
		fd.friction = friction;
		fd.restitution = restitution;

		// 创建刚体
		bd.type = isStatic ? BodyType.STATIC : BodyType.DYNAMIC;
		bd.position.set((x + r) / RATE, (y + r) / RATE);

		// 创建一个body
		Body body = world.createBody(bd);
		body.createFixture(fd);

		WCircleBody circleBody = new WCircleBody(body, r, Color.RED);
		circleBody.setLocation(x, y);
		bodys.add(circleBody);
	}
}
