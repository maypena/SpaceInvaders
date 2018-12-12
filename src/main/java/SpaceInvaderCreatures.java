import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Graphic blueprints for all objects in the game.
 * @author mahaawaisi
 */
public class SpaceInvaderCreatures {
	static BufferedImage alien; // background image
	static BufferedImage spaceship;
	static BufferedImage shield; //shield
	
	/**
	 * This method loads all the images for the game. 
	 */
	public static void LoadImageExample() throws IOException {
		if (alien == null) {
		alien = ImageIO.read(new File("alien.png"));
		spaceship = ImageIO.read(new File("spaceship.png"));
		shield = ImageIO.read(new File("shield.png"));
		}
	}

	/**
	 * Draws the player.
	 * @param g - graphics window.
	 * @param x - x coordinate.
	 * @param y - y coordinate.
	 * @param w - width of square.
	 * @param h - height of square.
	 */
	public static void drawPlayer(Graphics2D g, int x, int y, int w, int h) {
		try {
			LoadImageExample();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(spaceship, x, y , null);
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
		try {
			LoadImageExample();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(alien, x, y, null);
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
		g.setColor(Color.white);
		g.drawRect(x, y, w, h);
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
		g.setColor(Color.red);
		g.drawRect(x, y, w, h);
		g.fillRect(x, y, w, h);
	}
	
	/**
	 * Draws the shield.
	 * @param g
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public static void drawShield(Graphics2D g, int x, int y, int w, int h) {
		try {
			LoadImageExample();

		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(shield, x, y, null);
	}
	
	/**
	 * Draws the shield.
	 * @param g
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public static void drawLife(Graphics2D g, int x, int y, int w, int h) {
		g.setColor(Color.blue);
		g.drawRect(x, y, w, h);
		g.fillRect(x, y, w, h);
	}
}
