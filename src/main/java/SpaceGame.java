import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import me.jjfoley.gfx.GFX;
import me.jjfoley.gfx.TextBox;

/**
 * This class draws and undraws everything on screen.
 * @author mahaawaisi
 */
public class SpaceGame extends GFX {
	// Our variables
	BufferedImage background; // background image
	ArrayList<Bullet> bullets = new ArrayList<>(); // List of bullets.
	static Player player = new Player(350, 450, 20, 20); // Creates the player.
	static ArrayList<Opponent> aliens = new ArrayList<>(); // List of aliens.
	ArrayList<AlienBullet> alienBullets = new ArrayList<>(); // List of alien bullets.


	/**
	 * SpaceGame constructor.
	 */
	public SpaceGame() {
		for (int i = 0; i < 10; i++) { // Columns
			for (int j = 0; j < 5; j++) { // Rows
				Opponent alien = new Opponent(60 * i, 50 * j, 30, 30);
				aliens.add(alien);
			}
		}
	}

	/**
	 * Load background picture
	 */
	public void LoadImageExample() throws IOException {
		background = ImageIO.read(new File("background.jpg"));

	}

	/**
	 * Draws everything on the screen.
	 * @param g - The graphics window.
	 */
	public void draw(Graphics2D g) {
		// Background 
		try {
			LoadImageExample();
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(background, 0, 0, null);

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

		// Alien bullets
		if (GameRules.alienBulletBool) {
			for (int i = 0; i < alienBullets.size(); i++) {
				alienBullets.get(i).draw(g);
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