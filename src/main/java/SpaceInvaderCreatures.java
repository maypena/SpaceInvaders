import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Blueprints for all objects for the game
 * 
 * @author mahaawaisi
 *
 */
public class SpaceInvaderCreatures {
	public static void drawPlayer(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
		g.setColor(Color.gray);
		g.fillRect(x, y, w, h);

	}

	public static void drawOpponent(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
		g.setColor(Color.green);
		g.fillRect(x, y, w, h);
	}

	public static void drawBullet(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
		g.setColor(Color.white);
		g.fillRect(x, y, w, h);
	}

}
