import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Bullet class and its methods.
 * @author mahaawaisi
 */
public class AlienBullet {
	
	// Our variables.
	int x;
	int y;
	int w;
	int h;
	
	/**
	 * Constructor for the alien bullets.
	 * @param x - x coordinate
	 * @param y - y coordinate 
	 * @param w - width of rectangle
	 * @param h - height of rectangle
	 */
	public AlienBullet(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Draws alien bullet in motion. 
	 * @param g - graphics window. 
	 */
	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawAlienBullet(g, x, y, w, h);
		this.y += 5;
	}
	
	/**
	 * Gets x position of the alien bullet.
	 * @return the x coordinate of the alien bullet.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets y position of the alien bullet.
	 * @return the y coordinate of the alien bullet.
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Gets the rectangle. 
	 * @return the value of the rectangle.
	 */
	public Rectangle2D getRectangle() {
		return new Rectangle2D.Double(x,y,w,h);
	}

}