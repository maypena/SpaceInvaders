
import java.awt.Graphics2D;

/**
 * 
 * opponent class with its methods
 * 
 * 
 * 
 * @author mahaawaisi
 *
 * 
 * 
 */

public class Opponent {

	int x; // x position

	int y; // y position

	int w; // width of rectangle

	int h; // height of rectangle

	// boolean for direction opponent moves in

	public Opponent(int x, int y, int w, int h) {

		this.x = x;

		this.y = y;

		this.w = w;

		this.h = h;

	}

	/**
	 * 
	 * moves opponent
	 * 
	 */

	public void moveRight() {

		if (SpaceGame.flipSwitch == true) {

			this.x += 2;

		}

	}

	public void moveLeft() {

		if (SpaceGame.flipSwitch == false) {

			this.x -= 2;

		}

	}

	public void moveDown() {

		this.y += 5;

	}

	/**
	 * 
	 * draw method
	 * 
	 * 
	 * 
	 * @param g
	 * 
	 */

	public void draw(Graphics2D g) {

		SpaceInvaderCreatures.drawOpponent(g, x, y, w, h);

	}

	public int getX() {

		return this.x;

	}

	public int getY() {

		return this.y;

	}

}