import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/***************************
 * Nicholas Parise, 
 * Sile Keenan, 
 * ICS4U, 
 * Tetris
 ****************************/


/// Handles Keyboard input
public class KeyBoard extends JPanel implements KeyListener {

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();

		if (keyCode == KeyEvent.VK_ESCAPE) {
			// escape key
			GameStateManager.StartPause();
			// allows the game to be paused
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			// space key
			GameStateManager.StartGame();
			// starts the game
		}

		if (keyCode == KeyEvent.VK_ENTER) {
			// Enter key

			// if in game mode makes the blocks instantly teleport to the bottom
			Blocks.FastFall();

			// if in game over stop input
			ScoreManager.StopInput();
		}

		if (keyCode == KeyEvent.VK_LEFT) {
			// left arrow key

			// if in game mode go left
			Blocks.GoLeft();

			// if in game over change change which letter can be changed
			ScoreManager.SubCurrent();
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			// right arrow key

			// if in game mode go right
			Blocks.GoRight();

			ScoreManager.AddCurrent();
			// if in game over change change which letter can be changed
		}
		if (keyCode == KeyEvent.VK_UP) {
			// up arrow key

			// if in game mode clock rotate
			Blocks.ClockRotate();

			// if in game over change change the current letter
			ScoreManager.AddLetter();
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			// down arrow key

			// if in game mode counter clock rotate
			Blocks.CounterClockRotate();

			// if in game over change change the current letter
			ScoreManager.SubLetter();
		}
	}

	public void keyTyped(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_LEFT) {
			// left arrow key
			ScoreManager.SubCurrent();

			// if in game over change change which letter can be changed
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			// right arrow key

			ScoreManager.AddCurrent();
			// if in game over change change which letter can be changed

		} else if (keyCode == KeyEvent.VK_UP) {
			// up arrow key

			ScoreManager.AddLetter();

			// change change the current letter
		} else if (keyCode == KeyEvent.VK_DOWN) {
			// down arrow key
			// change change the current letter
			ScoreManager.SubLetter();
		}
	}

	// this funtion is necessary to stop run time error but is unused
	public void keyReleased(KeyEvent e) {
	}

}
