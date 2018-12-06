import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
/**
 * Bullet and its methods 
 * @author mahaawaisi
 * 
 */

public class Bullet {
	int x;
	int y;
	int w;
	int h;

	public Bullet(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	// new bullet from position of player
	// processKey - delayed

	public void draw(Graphics2D g) {
		SpaceInvaderCreatures.drawBullet(g, x, y, w, h);
		this.y -= 5;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public Rectangle2D getRectangle() {
		return new Rectangle2D.Double(x,y,w,h);
	}

}