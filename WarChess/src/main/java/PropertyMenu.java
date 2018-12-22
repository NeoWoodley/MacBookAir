import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PropertyMenu extends BaseObject {
	private TextObject[] textObjects;
	private Paint color = Color.BLACK;
	private int spaceLine = 5;

	public PropertyMenu(int width, int height) {
		setWidth(width);
		setHeight(height);
		textObjects = new TextObject[7];
		for (int i = 0; i < textObjects.length; i++) {
			textObjects[i] = new TextObject();
			textObjects[i].setColor(Color.WHITE);
		}

	}
	/**
	 * 初始化载入某个角色的属性
	 * @param player 角色
	 */
	public void initPlayer(BasePlayer player) {
		setProperty(textObjects[0], "姓名", player.getName());
		setProperty(textObjects[1], "等级", String.valueOf(player.getLv()));
		setProperty(textObjects[2], "攻击", String.valueOf(player.getAttack()));
		setProperty(textObjects[3], "防御", String.valueOf(player.getDefense()));
		setProperty(textObjects[4], "移动力", String.valueOf(player.getMove()));
		setProperty(textObjects[5], "HP", String.valueOf(player.getHp()) + "/" + player.getHpMax());
		setProperty(textObjects[6], "EXP", String.valueOf(player.getExp()));
	}

	private void setProperty(TextObject textObject, String propertyName, String value) {
		textObject.setText(propertyName + ":" + value);
		textObject.setFontSize(16);
	}

	@Override
	public void draw(GraphicsContext gContext) {
		gContext.save();
		gContext.setStroke(color);
		gContext.setGlobalAlpha(0.8f);
		gContext.fillRect(x, y, width, height);
		if (textObjects != null) {
			for (int i = 0; i < textObjects.length; i++) {
				textObjects[i].setX((getWidth() - textObjects[i].getWidth()) / 2 + getX());
				textObjects[i].setY(getY() + spaceLine * (i + 1) + textObjects[i].getHeight() * (i + 1));
				textObjects[i].draw(gContext);
			}
		}
		gContext.restore();
	}

	@Override
	public void update() {

	}
}
