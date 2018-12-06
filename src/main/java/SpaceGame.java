import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import me.jjfoley.gfx.GFX;
import me.jjfoley.gfx.TextBox;

/**
 * SpaceGame creates players, opponents, etc. and moves all of them main method
 * 
 * @author mahaawaisi
 *
 */

public class SpaceGame extends GFX {
	// make a new player
	Player player = new Player(400, 390, 20, 20);
	// Bullet bullet = new Bullet(player.getX(), player.getY(), 2, 15);

	// make a list of aliens, dead aliens, and bullets
	ArrayList<Opponent> aliens = new ArrayList<>();
	ArrayList<Opponent> deadAliens = new ArrayList<>();
	ArrayList<Bullet> bullets = new ArrayList<>();

	// make the flipSwitch boolean equal to true at first so the aliens start by
	// moving to the right
	static boolean flipSwitch = true;

	// Space Game constructor
	public SpaceGame() {
		// make this many opponents and space them so they are equally spaced by
		// incrementing the counter
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) { 
				//100 + space * 5
			Opponent alien = new Opponent(60 * i, 50 * j, 30, 30);
			// add the alien to the list of aliens
			aliens.add(alien);
			}
		}
	}

	/**
	 * This method is how the GameRules app tells whether we're done.
	 * 
	 * @return true if the player has won (or maybe lost?).
	 */
	public boolean gameOver() {
		// if the size of aliens is 0 then return true so that the game is over
		if (aliens.size() == 0) {
			return true;
		}
		// otherwise the game is not over so return false
		return false;

	}

	/**
	 * This method draws all of the objects for the game
	 */

	public void draw(Graphics2D g) {
		// make the background black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);

		// score board
		TextBox score = new TextBox(("Score " + GameRules.score));
		Rectangle2D centerText = new Rectangle2D.Double(550, 0, 100, 40);
		score.setFontSize(20.0);
		score.setColor(Color.white);

		score.centerInside(centerText);
		score.draw(g);

		// if the game is over show text: game over
		if (gameOver() == true) {
			TextBox gameOver = new TextBox("Game Over!");
			gameOver.setFontSize(40.0);
			gameOver.setColor(Color.white);
			gameOver.draw(g);

		}

		// draw the player
		player.draw(g);

		// draw all aliens from the list
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);

		}

		// if the flipSwitch is true then move all aliens to the right
		if (flipSwitch == true) {
			for (Opponent alien : aliens) {
				alien.moveRight();
			}

		}
		// if flipSwith is false then move all the aliens to the left
		if (flipSwitch == false) {
			for (Opponent alien : aliens) {
				alien.moveLeft();
			}

		}
		// if the alien at the end is at the edge then make flipSwitch false - move to
		// left
		if (aliens.size() != 0 && (aliens.get(aliens.size() - 1).getX()) >= 690) {
			flipSwitch = false;
		}
		// if the alien at the beginning is at the edge then make flipSwitch true - move
		// to right
		if (aliens.size() != 0 && aliens.get(0).getX() <= 10) {
			flipSwitch = true;
		}

		// if the size of the aliens is not 0 and the last one or the first one hits the
		// edge then move all the aliens down
		if (aliens.size() != 0 && (aliens.get(aliens.size() - 1).getX() >= 690 || aliens.get(0).getX() <= 10)) {
			for (Opponent alien : aliens) {
				alien.moveDown();
			}

		}

		// if the space bar is pressed then move all bullets
		if (GameRules.bulletBool) {
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).draw(g);

			}
		}

	}

}