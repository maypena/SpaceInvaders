import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import me.jjfoley.gfx.GFX;
import me.jjfoley.gfx.TextBox;

/**
 * This class draws and undraws everything on screen.
 * @author mahaawaisi
 */
public class SpaceGame extends GFX {

	// Our variables
	Player player = new Player(350, 450, 20, 20); 	       // Creates the player.
	ArrayList<Bullet> bullets = new ArrayList<>();         // List of bullets.
	static ArrayList<Opponent> aliens = new ArrayList<>(); // List of aliens.

	/**
	 * SpaceGame constructor.
	 */
	public SpaceGame() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Opponent alien = new Opponent(60 * i, 50 * j, 30, 30);
				aliens.add(alien);
			}
		}
	}

	/**
	 * Draws everything on the screen.
	 * @param g - The graphics window.
	 */
	public void draw(Graphics2D g) {
		// Bakcground
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);

		// Score board
		TextBox score = new TextBox(("Score " + GameRules.score));
		Rectangle2D centerText = new Rectangle2D.Double(550, 0, 100, 40);
		score.setFontSize(20.0);
		score.setColor(Color.white);
		score.centerInside(centerText);
		score.draw(g);

		// Player
		player.draw(g);

		// Aliens 
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

		// Bullets
		if (GameRules.bulletBool) {
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).draw(g);
			}
		}
		
		// Game over text
		if (GameRules.gameOver() == true) {
			TextBox gameOver = new TextBox("Game Over!");
			gameOver.setFontSize(40.0);
			gameOver.setColor(Color.white);
			gameOver.draw(g);
		}
	}
}