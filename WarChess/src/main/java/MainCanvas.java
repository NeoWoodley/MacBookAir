import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class MainCanvas extends Canvas {
	// 游戏地图
	private GameMap gameMap;
	private GraphicsContext gContext;
	private Image map;
	private int tileWidth = 32;
	private int tileHeight = 32;
	// 我方角色
	private List<BasePlayer> players = new ArrayList<BasePlayer>();
	// 敌方角色
	private List<BasePlayer> enemys = new ArrayList<BasePlayer>();
	// 操作菜单
	private ActionMenu actionMenu;
	// 属性菜单
	private PropertyMenu propertyMenu;
	// 移动的Timer
	private MyTimer moveTimer;

	private boolean isRunning = true;
	private long sleep = 100;
	// 主线程
	private Thread thread = new Thread(() -> {
		while (isRunning) {
			Platform.runLater(() -> {
				draw();
				update();
			});
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	public MainCanvas(double width, double height) {
		super(width, height);
		map = new Image(getClass().getResourceAsStream("map0.png"));
		gContext = getGraphicsContext2D();

		// 初始化游戏地图
		gameMap = new GameMap(tileWidth, tileHeight, map);

		thread.start();
	}

	public void draw() {
		gameMap.drawMap(gContext);
		initPlayers();
		initEnemy();
		initActionMenu();
		initMyTimer();
		drawPlayer();
		actionMenu.draw(gContext);
		propertyMenu.draw(gContext);
	}

	public void update() {
		moveTimer.update();
	}

	public void drawPlayer() {
		for (BasePlayer player : players) {
			player.draw(gContext);
		}
		for (BasePlayer enemy : enemys) {
			enemy.draw(gContext);
		}
	}

	/**
	 * 初始化我方角色
	 */
	private void initPlayers() {
		Image player1Image = new Image(getClass().getResourceAsStream("player1.jpeg"),30,30,false,false);
		BasePlayer player1 = new BasePlayer();
		player1.setName("茉妍");
		player1.setImage(player1Image);
		player1.setLocation(10 * tileWidth, 8 * tileHeight);

		Image player2Image = new Image(getClass().getResourceAsStream("player2.jpg"),30,30,false,false);
		BasePlayer player2 = new BasePlayer();
		player2.setName("张达");
		player2.setImage(player2Image);
		player2.setLocation(12 * tileWidth, 8 * tileHeight);

		Image player3Image = new Image(getClass().getResourceAsStream("player3.jpg"),30,30,false,false);
		BasePlayer player3 = new BasePlayer();
		player3.setName("燕鱈");
		player3.setImage(player3Image);
		player3.setLocation(8 * tileWidth, 8 * tileHeight);

		players.add(player1);
		players.add(player2);
		players.add(player3);
	}

	/**
	 * 初始化敌方角色
	 */
	private void initEnemy() {
		Image orc = new Image(getClass().getResourceAsStream("enemy2.png"),30,30,false,false);
		int[][] locations = { { 3, 3 }, { 3, 5 }, { 5, 3 } };
		for (int i = 0; i < 3; i++) {
			BasePlayer enemy = new BasePlayer();
			enemy.setImage(orc);
			enemy.setName("信(克隆)");
			enemy.setAttack(3);
			enemy.setDefense(1);
			enemy.setHp(5);
			enemy.setHpMax(5);
			enemy.setGroup(BasePlayer.Group.Enemy);
			enemy.setMove(3);
			enemy.setExp(50);
			enemy.setLocation(locations[i][0] * tileWidth, locations[i][1] * tileHeight);
			enemys.add(enemy);
		}
	}

	private void initActionMenu() {
		// 初始化操作菜单
		actionMenu = new ActionMenu(new String[] { "移动", "攻击", "待机" }, 50, 100);
		actionMenu.setLocation(100, 50);
		actionMenu.setOnMenuItemClickListener(index ->{
			System.out.println("你点击的是:" + index);
		});

		// 属性菜单
		propertyMenu = new PropertyMenu(100, 200);
		propertyMenu.initPlayer(players.get(0));
		// 鼠标事件
		setOnMousePressed(e ->{
			actionMenu.onMousePressed(e);
		});
	}

	private void initMyTimer() {
		moveTimer = MyTimer.createWTimer(50, new MyTimer.OnTimerListener() {

			@Override
			public void onTimerRunning(MyTimer mTimer) {
				System.out.println("Timer Running");
			}
		});
	}
}
