import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class BasePlayer extends BaseObject {
	//角色分组 玩家 敌人 中立(暂未用到)
	public enum Group {
		Player, Enemy, Normal
	}
	private String name = "默认";
	private int lv = 1;
	private int attack = 3;
	private int defense = 1;
	private int hp = 6;
	private int hp_max = 6;
	private int exp = 0;
	private int gold = 1;
	private int move = 4;
	private Random random = new Random();
	private Image image;
	private Group group = Group.Player;
	//是否被选择
	private boolean isChoose = false;
	//是否正在等待攻击(已显示攻击范围)
	private boolean isWaitToAttack = false;
	//是否正在等待移动(已显示移动范围)
	private boolean isWaitToMove = false;
	//是否能够行动
	private boolean isCanAction = true;
	//是否能够移动
	private boolean isCanMove = true;
	//是否能够攻击
	private boolean isCanAttack = true;
	//下面是被攻击后的属性(本想做成闪烁，后来图简单没搞，名称未改)
	private int flashCount = 10;
	private int startCount = 0;
	private boolean isFlash = false;

	/**
	 * 等级提升
	 */
	public void levelUp() {
		attack += random.nextInt(3);
		defense += random.nextInt(2);
		hp += random.nextInt(3);
		lv++;
	}

	/**
	 * 获取经验值
	 * @param ex 经验值
	 */
	public void getExp(int ex){
		exp += ex;
		if(exp >= 100){
			levelUp();
			exp = 0;
		}
	}

	/**
	 * 攻击
	 * @param player 被攻击的角色
	 */
	public void attack(BasePlayer player) {
		player.hp -= Math.max(0, attack - player.defense);
	}

	public void draw(GraphicsContext gc) {
		gc.save();
		if (image != null) {
			if (isCanAction) {  //如果行动未结束
				if (isFlash) {  //如果被攻击，绘制红色填充矩形，并等待计数结束
					if (startCount < flashCount) {
						gc.setGlobalAlpha(0.3f);
						gc.setFill(Color.RED);
						gc.fillRect(getX(), getY(), width, height);
						startCount ++ ;
					} else {
						startCount = 0;
						isFlash = false;
					}
				}
				gc.setGlobalAlpha(1.0f);
				gc.drawImage(image, x, y);
			} else { //行动结束 透明度变为0.5
				gc.setGlobalAlpha(0.5f);
				gc.drawImage(image, x, y);
			}
			gc.setGlobalAlpha(1.5f);
			if (isChoose) { // 当被选择时，显示边框
				gc.strokeRect(x, y, 32, 32);
			}
		}
		gc.restore();
	}

	/*
	 * 被攻击 效果
	 */
	public void flash() {
		isFlash = true;
		startCount = 0;
	}

	/**
	 * 是否附近有Players里的角色
	 *
	 * @param players
	 *            角色集合
	 * @return 是否附近有Players里的角色
	 */
	public boolean isHasNearBP(List<BasePlayer> players) {
		int mx = (int) (getX() / width);
		int my = (int) (getY() / height);
		for (BasePlayer bp : players) {
			int x = (int) (bp.getX() / width);
			int y = (int) (bp.getY() / height);
			if ((x == mx && y == my + 1) || (x == mx - 1 && y == my) || (x == mx + 1 && y == my)
					|| (x == mx && y == my - 1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 寻找离自己最近的角色
	 *
	 * @param players
	 *            角色集合
	 * @return 最近的角色
	 */
	public BasePlayer getNearestBP(List<BasePlayer> players) {
		BasePlayer basePlayer = players.get(0);
		for (int i = 0; i < players.size(); i++) {
			BasePlayer player = players.get(i);
			if (Math.abs(getX() - basePlayer.getX()) + Math.abs(getY() - basePlayer.getY()) > Math.abs(getX()
					- player.getX())
					+ Math.abs(getY() - player.getY())) {
				basePlayer = player;
			}
		}
		return basePlayer;
	}

	@Override
	public void update() {

	}

	/**
	 * 重置所有状态
	 */
	public void reset() {
		isChoose = false;
		isWaitToAttack = false;
		isWaitToMove = false;
		isCanAction = true;
		isCanMove = true;
		isCanAttack = true;
	}

	/**
	 *  判断是否与某个点碰撞
	 */
	public boolean isCollisionWith(double x, double y) {
		return x > getX() && y > getY() && x < getX() + getWidth() && y < getY() + getHeight();
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		setWidth(image.getWidth());
		setHeight(image.getHeight());
	}

//	public void setImage(Image image, double width, double height) {
//		this.image = image;
//		setWidth(width);
//		setHeight(height);
//	}

	public boolean isChoose() {
		return isChoose;
	}

	public void setChoose(boolean isChoose) {
		this.isChoose = isChoose;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWaitToAttack() {
		return isWaitToAttack;
	}

	public void setWaitToAttack(boolean isWaitToAttack) {
		this.isWaitToAttack = isWaitToAttack;
	}

	public boolean isWaitToMove() {
		return isWaitToMove;
	}

	public void setWaitToMove(boolean isWaitToMove) {
		this.isWaitToMove = isWaitToMove;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isCanAction() {
		return isCanAction;
	}

	public void setCanAction(boolean isCanAction) {
		this.isCanAction = isCanAction;
	}

	public boolean isCanMove() {
		return isCanMove;
	}

	public void setCanMove(boolean isCanMove) {
		this.isCanMove = isCanMove;
	}

	public boolean isCanAttack() {
		return isCanAttack;
	}

	public void setCanAttack(boolean isCanAttack) {
		this.isCanAttack = isCanAttack;
	}

	public boolean isFlash() {
		return isFlash;
	}

	public void setFlash(boolean isFlash) {
		this.isFlash = isFlash;
	}

	public int getHpMax() {
		return hp_max;
	}

	public void setHpMax(int hp_max) {
		this.hp_max = hp_max;
	}
}
