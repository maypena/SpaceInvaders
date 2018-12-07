import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Bullet class and its methods.
 * @author mahaawaisi
 */
public class Bullet {
	
	// Our variables.
	int x;
	int y;
	int w;
	int h;
	
	/**
	 * Constructor for the bullets.
	 * @param x - x coordinate
	 * @param y - y coordinate 
	 * @param w - width of rectangle
	 * @param h - height of rectangle
	 */
	public Bullet(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Draws bullet in motion. 
	 * @param g - graphics window. 
	 */
	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawBullet(g, x, y, w, h);
		this.y -= 5;
	}
	
	/**
	 * Gets x position of the bullet.
	 * @return the x coordinate of the bullet.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets y position of the bullet.
	 * @return the y coordinate of the bullet.
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