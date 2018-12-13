import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import me.jjfoley.gfx.GFX;
import me.jjfoley.gfx.TextBox;

/**
 * This class draws and undraws everything on screen.
 * 
 * @author mahaawaisi
 */
public class SpaceGame extends GFX {
	// Our variables
	BufferedImage background; // background image
	static ArrayList<Life> lives = new ArrayList<>(); // List of lives.
	ArrayList<Bullet> bullets = new ArrayList<>(); // List of bullets.
	ArrayList<Shield> shields = new ArrayList<>(); // List of shields
	static ArrayList<Opponent> aliens = new ArrayList<>(); // List of aliens.
	static ArrayList<AlienBullet> alienBullets = new ArrayList<>(); // List of alien bullets.
	static Player player = new Player(GameRules.screenX / 2, GameRules.screenY - 100); // Creates the player.

	/**
	 * SpaceGame constructor.
	 */
	public SpaceGame() {
		for (int i = 0; i < 10; i++) { // Columns
			for (int j = 0; j < 5; j++) { // Rows
				Opponent alien = new Opponent(GameRules.screenX / 13 * i, GameRules.screenY / 10 * j, 30, 30, j == 0);
				aliens.add(alien);
			}
		}
		for (int i = 0; i < 3; i++) {
			Life life = new Life((GameRules.screenX / 20 * i) + 90, GameRules.screenY - 600, 20, 5);
			lives.add(life);
		}

	}

	/**
	 * Draws everything on the screen.
	 * 
	 * @param g - The graphics window.
	 */
	public void draw(Graphics2D g) {

		// Score board
		TextBox score = new TextBox(("Score " + GameRules.score));
		Rectangle2D centerText = new Rectangle2D.Double(GameRules.screenX - 200, 0, 100, 40);
		score.setFontSize(30.0);
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

		// Alien bullets
		if (GameRules.alienBulletBool) {
			for (int i = 0; i < alienBullets.size(); i++) {
				alienBullets.get(i).draw(g);
			}
		}

		// Shields
		for (int i = 0; i < 3; i++) {
			Shield shield = new Shield((GameRules.screenX / 3 * i) + 120, 400);
			shields.add(shield);
			shield.draw(g);
		}

		// Lives
		TextBox liveText = new TextBox(("Lives"));
		Rectangle2D centerText2 = new Rectangle2D.Double(0, 0, 100, 40);
		liveText.setFontSize(30.0);
		liveText.setColor(Color.white);
		liveText.centerInside(centerText2);
		liveText.draw(g);
		for (int i = 0; i < lives.size(); i++) {
			lives.get(i).draw(g);
		}

		// Game over text
		if (GameRules.gameOver() == true) {
			TextBox gameOver = new TextBox(" GAME OVER! ");
			Rectangle2D centerTextGO = new Rectangle2D.Double(GameRules.screenX / 2, GameRules.screenY / 2, 100, 40);
			gameOver.setFontSize(100.0);
			gameOver.setColor(Color.white);
			gameOver.centerInside(centerTextGO);
			gameOver.draw(g);

		}

	}
}