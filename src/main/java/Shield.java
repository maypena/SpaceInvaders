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
	 */
	public Shield(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = SpaceInvaderCreatures.shield.getWidth();
		this.h = SpaceInvaderCreatures.shield.getHeight();
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
		return new Rectangle2D.Double(x, y, w, h);
	}

}
