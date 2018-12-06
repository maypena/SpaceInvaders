import java.awt.Graphics2D;
import me.jjfoley.gfx.GFX;

/**
 * Player class with methods
 * 
 * @author mahaawaisi
 *
 */

public class Player extends GFX {

	int x; // x position
	int y; // y position
	int w; // width of rectangle
	int h; // height of rectangle

	public Player(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

	}

	/**
	 * draw method for the player
	 */
	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawPlayer(g, x, y, w, h);
	}

	/**
	 * methods to move the player right and left
	 * 
	 * @return
	 */
	public boolean moveLeft() {
		if (this.x <= 0 == true) {
			return false;

		} else {
			this.x -= 5;
			return true;
		}
	}

	public boolean moveRight() {
		if (this.x >= 680 == true) {
			return false;

		} else {
			this.x += 5;
			return true;
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
