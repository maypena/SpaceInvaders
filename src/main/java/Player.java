import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import me.jjfoley.gfx.GFX;

/**
 * This class holds the player and its methods.
 * @author mahaawaisi
 */
public class Player extends GFX {
	// Our variables.
	int x; // x position.
	int y; // y position.
	int w; // width of rectangle.
	int h; // height of rectangle.
	
	/**
	 * Constructor for the player.
	 * @param x - x position.
	 * @param y - y position.
	 * @param w - width of rectangle.
	 * @param h - height of rectangle.
	 */
	public Player(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Draws player.
	 * @param g - Graphics window
	 */
	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawPlayer(g, x, y, w, h);
	}


	/**
	 * Moves player to the left.
	 * @return true if it was able to move and false if it wasn't.
	 */
	public boolean moveLeft() {
		if (this.x <= 0 == true) {
			return false;
		} else {
			this.x -= 5;
			return true;
		}
	}
	
	/**
	 * Moves player to the right.
	 * @return true if it was able to move and false if it wasn't.
	 */
	public boolean moveRight() {
		if (this.x >= 680 == true) {
			return false;
		} else {
			this.x += 5;
			return true;
		}
	}
	
	/**
	 * Gets x position of the player.
	 * @return the x coordinate.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets y position of the player.
	 * @return the y coordinate.
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
