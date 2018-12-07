import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Graphic blueprints for all objects in the game.
 * @author mahaawaisi
 */
public class SpaceInvaderCreatures {
	
	/**
	 * Draws the player.
	 * @param g - graphics window.
	 * @param x - x coordinate.
	 * @param y - y coordinate.
	 * @param w - width of square.
	 * @param h - height of square.
	 */
	public static void drawPlayer(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
		g.setColor(Color.gray);
		g.fillRect(x, y, w, h);
	}
	
	/**
	 * Draws the opponent.
	 * @param g - graphics window.
	 * @param x - x coordinate.
	 * @param y - y coordinate.
	 * @param w - width of square.
	 * @param h - height of square.
	 */
	public static void drawOpponent(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
		g.setColor(Color.green);
		g.fillRect(x, y, w, h);
	}
	
	/**
	 * Draws the bullet.
	 * @param g - graphics window.
	 * @param x - x coordinate.
	 * @param y - y coordinate.
	 * @param w - width of square.
	 * @param h - height of square.
	 */
	public static void drawBullet(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
		g.setColor(Color.white);
		g.fillRect(x, y, w, h);
	}
	/**
	 * Draws the alien bullet.
	 * @param g - graphics window.
	 * @param x - x coordinate.
	 * @param y - y coordinate.
	 * @param w - width of square.
	 * @param h - height of square.
	 */
	public static void drawAlienBullet(Graphics2D g, int x, int y, int w, int h) {
		g.drawRect(x, y, w, h);
		g.setColor(Color.red);
		g.fillRect(x, y, w, h);
	}

}
