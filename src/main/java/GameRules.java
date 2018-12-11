import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import me.jjfoley.gfx.GFX;

/**
 * This class holds the logic of the game. Here is where the game starts, gets
 * updated and ends.
 */
public class GameRules extends GFX {

	// Our variables
	int delay; // Delay variable so that bullet doesn't become a laser.
	int delay2; // Delay variable so that bullet doesn't become a laser.
	SpaceGame game; // Game made from the SpaceGame class.
	static int score; // Score variable.
	static boolean bulletBool; // Boolean that alerts other classes when the spacebar is pressed.
	static boolean alienBulletBool; // Boolean that is true as long as the game is running (aliens keep shooting).
	static boolean moveSwitch; // Movement switch.
	ArrayList<Bullet> deadBullets = new ArrayList<>(); // List of bullets to delete.
	ArrayList<Opponent> deadAliens = new ArrayList<>(); // List of aliens to delete.
	static int screenX = 1100; // Background width
	static int screenY = 620; //Background height
	

	/**
	 * Initializes variables.
	 */
	public GameRules() {
		super(screenX, screenY);
		game = new SpaceGame();
		bulletBool = false;
		moveSwitch = true;
		score = 0;
		delay = 0;
		delay2 = 0;	
	}

	/**
	 * Draws everything.
	 */
	@Override
	public void draw(Graphics2D g) {
		game.draw(g);
	}

	/**
	 * Ends the game.
	 * 
	 * @return true if the player has won (or maybe lost?).
	 */
	public static boolean gameOver() {
		if (SpaceGame.aliens.size() == 0) {
			return true;
		}
		return false;
	}

	/*
	 * Starts the game
	 */
	public static void main(String[] args) {
		GameRules game = new GameRules();
		game.start();
	}

	/**
	 * This is where the game gets updated and the where logic lives.
	 * 
	 * @param secondsSinceLastUpdate
	 */
	@Override
	public void update(double secondsSinceLastUpdate) {
		// Handle game-over and restart.
		if (gameOver()) {
			if (this.processClick() != null) {
				this.game = new SpaceGame();
				score = 0;
			}
			return;
		}

		// Read the state of the keyboard.
		boolean left = this.isKeyDown(KeyEvent.VK_A) || this.isKeyDown(KeyEvent.VK_LEFT);
		boolean right = this.isKeyDown(KeyEvent.VK_D) || this.isKeyDown(KeyEvent.VK_RIGHT);
		boolean spaceBar = this.processKey(KeyEvent.VK_SPACE);

		// Move the aliens.
		if (moveSwitch == true) {
			for (Opponent alien : SpaceGame.aliens) {
				alien.moveRight();
			}
		}
		if (moveSwitch == false) {
			for (Opponent alien : SpaceGame.aliens) {
				alien.moveLeft();
			}
		}
		if (SpaceGame.aliens.size() != 0 && (SpaceGame.aliens.get(SpaceGame.aliens.size() - 1).getX()) >= screenX-30) {
			moveSwitch = false;
			for (Opponent alien : SpaceGame.aliens) {
				alien.moveDown();
			}
			
		}
		if (SpaceGame.aliens.size() != 0 && SpaceGame.aliens.get(0).getX() <= 10) {
			moveSwitch = true;
			for (Opponent alien : SpaceGame.aliens) {
				alien.moveDown();
			}
		}

		// Move the player if we can
		if (left) {
			SpaceGame.player.moveLeft();
		} else if (right) {
			SpaceGame.player.moveRight();
		}

		// Handle bullet logic.
		delay -= 1;
		if (spaceBar && delay <= 0) {
			bulletBool = true;
			Bullet newBullet = new Bullet((10 + SpaceGame.player.getX()), SpaceGame.player.getY(), 2, 15);
			this.game.bullets.add(newBullet);
			this.delay = 15;

		}

		// Handle alien bullet logic.
		delay2 -= 1;
		if (gameOver() != true && delay2 <= 0) {
			for (Opponent alien : SpaceGame.aliens) {
				if (alien.isFirstRow()) {
					int alienX = alien.getX();
					int alienY = alien.getY();
					alienBulletBool = true;
					AlienBullet newAlienBullet = new AlienBullet(alienX, alienY, 2, 15);
					this.game.alienBullets.add(newAlienBullet);
					this.delay2 = 150;
				}
			}
		}

		// Handle killing of the aliens logic.
		if (SpaceGame.aliens.size() > 0) {
			for (Opponent alien : SpaceGame.aliens) {
				for (Bullet bullet : this.game.bullets) {
					if (bullet.getRectangle().intersects(alien.getRectangle())) {
						this.deadAliens.add(alien);
						this.deadBullets.add(bullet);
						score += 100;
					}
				}
			}
		}

		// End the game when aliens touch the player.
		if (SpaceGame.aliens.size() > 0) {
			for (Opponent alien : SpaceGame.aliens) {
				if (SpaceGame.player.getRectangle().intersects(alien.getRectangle())) {
					deadAliens.addAll(SpaceGame.aliens);
				}
			}
		}

		// End the game when alien bullet touches player.
		if (SpaceGame.aliens.size() > 0) {
			for (AlienBullet alienBullet : this.game.alienBullets) {
				if (alienBullet.getRectangle().intersects(SpaceGame.player.getRectangle())) {
					deadAliens.addAll(SpaceGame.aliens);
				}
			}
		}

		// Remove aliens.
		for (Opponent alien : this.deadAliens) {
			SpaceGame.aliens.remove(alien);
		}

		// Remove aliens.
		for (Bullet bullet : this.deadBullets) {
			this.game.bullets.remove(bullet);
		}
	}
}