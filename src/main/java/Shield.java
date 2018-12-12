import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Shield {
	// Our variables.
	int x;
	int y;
	int w;
	int h;

	/**
	 * Constructor for the shields.
	 * @param x - x coordinate
	 * @param y - y coordinate
	 * @param w - width of rectangle
	 * @param h - height of rectangle
	 */
	public Shield(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Draws a shield.
	 * @param g - graphics window.
	 */
	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawShield(g, x, y, w, h);
	}

	/**
	 * Gets the rectangle.
	 * @return the value of the rectangle.
	 */
	public Rectangle2D getRectangle() {
		return new Rectangle2D.Double(x + 2, y + 2, w + 2, h + 2);
	}

}
