import java.awt.Graphics2D;

public class Life {
	// Our variables.
	int x;
	int y;
	int w;
	int h;

	/**
	 * Constructor for the lives.
	 * @param x - x coordinate
	 * @param y - y coordinate
	 * @param w - width of rectangle
	 * @param h - height of rectangle
	 */
	public Life(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Draws a life.
	 * 
	 * @param g - graphics window.
	 */
	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawLife(g, x, y, w, h);
	}
}
