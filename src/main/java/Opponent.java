import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Opponent class and its methods.
 * @author mahaawaisi
 */
public class Opponent {
	// Our variables.
	int x; 
	int y; 
	int w; 
	int h; 

	
	/**
	 * Constructor for the opponents.
	 * @param x - x coordinate
	 * @param y - y coordinate 
	 * @param w - width of rectangle
	 * @param h - height of rectangle
	 */
	public Opponent(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Draws opponent. 
	 * @param g - graphics window. 
	 */
	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawOpponent(g, x, y, w, h);
	}
	
	/**
	 * Moves aliens to the right.
	 */
	public void moveRight() {
		if (GameRules.moveSwitch == true) {
			this.x += 2;
		}
	}
	
	/**
	 * Moves aliens to the left. 
	 */
	public void moveLeft() {
		if (GameRules.moveSwitch == false) {
			this.x -= 2;
		}
	}
	
	/**
	 * Moves aliens down.
	 */
	public void moveDown() {
		this.y += 5;
	}
	
	/**
	 * Gets x position of the opponent.
	 * @return the x coordinate of the alien.
	 */
	public int getX() {
		return this.x;

	}
	
	/**
	 * Gets y position of the opponent.
	 * @return the y coordinate of the alien.
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