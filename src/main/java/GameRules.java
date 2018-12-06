import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 * Updates the window and starts and ends whole game
 * Dynamics - keeps the game running
 * ALIVE
 */

import me.jjfoley.gfx.GFX;

public class GameRules extends GFX {
	/**
	 * 
	 */
	SpaceGame game;
	/**
	 * 
	 */
	static boolean bulletBool = false;
	/**
	 * 
	 */
	static int score = 0;

	public GameRules() {
		super(700, 500);
		game = new SpaceGame();
	}

	/**
	 * We separate our "PlayFish" game logic update here.
	 * 
	 * @param secondsSinceLastUpdate - my GFX code can tell us how long it is
	 *                               between each update, but we don't actually care
	 *                               here.
	 */
	@SuppressWarnings("unused")
	@Override
	public void update(double secondsSinceLastUpdate) {
		// Handle game-over and restart.
		if (game.gameOver()) {
			if (this.processClick() != null) {
				this.game = new SpaceGame();
			}
			return;
		}

		/*
		 * // Update the text in the TextBox. - score this.gameState.setString(
		 * "Step #: " + game.stepsTaken + " ... Fish Left: " + game.missingFishLeft() +
		 * " ... Score: "+ game.score);
		 */

		// Read the state of the keyboard:
		boolean left = this.isKeyDown(KeyEvent.VK_A) || this.isKeyDown(KeyEvent.VK_LEFT);
		boolean right = this.isKeyDown(KeyEvent.VK_D) || this.isKeyDown(KeyEvent.VK_RIGHT);
		boolean spaceBar = this.processKey(KeyEvent.VK_SPACE);

		// Move the player if we can:
		boolean moved = true;
		
		if (left) {
			moved = this.game.player.moveLeft();
		} else if (right) {
			moved = this.game.player.moveRight();
		}

		// if the space bar is pressed
		if (spaceBar) {
			// make bullet bool true
			bulletBool = true;
			// make a new bullet that starts at the middle position of the player
			Bullet newBullet = new Bullet((10 + this.game.player.getX()), this.game.player.getY(), 2, 15);
			// add that bullet to the list of bullets located in space game
			this.game.bullets.add(newBullet);

		}

		// killing aliens
		// if size of aliens is larger than 0
		if (this.game.aliens.size() > 0) {
			for (Opponent alien : this.game.aliens) {
				for (Bullet bullet : this.game.bullets) {
					// if the bullet is at the same y position as the alien and the x position of
					// the bullet is in the range of
					// the x position of the alien + 30 to account for its width
					if (bullet.getY() == alien.getY()
							&& (bullet.getX() > alien.getX() && bullet.getX() < alien.getX() + 30)) {
						this.game.deadAliens.add(alien);
						// increment score by 100 every time you hit an alien
						score += 100;

					}

				}

			}
		}

		// go through dead aliens and remove alien from original list so that it deletes
		// off the screen
		for (Opponent alien : this.game.deadAliens) {
			this.game.aliens.remove(alien);

		}

		// when the x and y position of bullet equals the x and y position of the alien
		// - delete alien from list
		// in between the x + size of alien and y - size of alien

		// if the bullet's position is at y position this.game.alien.getY()-30
		// and at the same time the bullet's position is at x position in between
		// this.game.alien.getX() and this.game.alien.getX() + 30

	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		game.draw(g);
	}

	public static void main(String[] args) {
		GameRules game = new GameRules();
		game.start();
	}

}
