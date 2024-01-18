package Tetris;
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

	ScoreManager sm;
	GameStateManager gsm;
	Blocks bl;

	public KeyBoard(ScoreManager s, GameStateManager g, Blocks b){
		sm = s;
		gsm = g;
		bl = b;
	}


	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();

		if (keyCode == KeyEvent.VK_ESCAPE) {
			// escape key
			gsm.StartPause();
			// allows the game to be paused
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			// space key
			if(gsm.StartGame()) {
				bl.ResetGame();
			}
			// starts the game
		}

		if (keyCode == KeyEvent.VK_ENTER) {
			// Enter key
			System.out.println("test");
			// if in game mode makes the blocks instantly teleport to the bottom
			bl.FastFall();

			// if in game over stop input
			if(sm.StopInput()){
				gsm.Menu();
			}
		}

		if (keyCode == KeyEvent.VK_LEFT) {
			// left arrow key

			// if in game mode go left
			bl.GoLeft();

			// if in game over change change which letter can be changed
			sm.SubCurrent();
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			// right arrow key

			// if in game mode go right
			bl.GoRight();

			sm.AddCurrent();
			// if in game over change change which letter can be changed
		}
		if (keyCode == KeyEvent.VK_UP) {
			// up arrow key

			// if in game mode clock rotate
			bl.ClockRotate();

			// if in game over change change the current letter
			sm.AddLetter();
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			// down arrow key

			// if in game mode counter clock rotate
			bl.CounterClockRotate();

			// if in game over change change the current letter
			sm.SubLetter();
		}
	}

	public void keyTyped(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_LEFT) {
			// left arrow key
			sm.SubCurrent();

			// if in game over change change which letter can be changed
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			// right arrow key

			sm.AddCurrent();
			// if in game over change change which letter can be changed

		} else if (keyCode == KeyEvent.VK_UP) {
			// up arrow key

			sm.AddLetter();

			// change change the current letter
		} else if (keyCode == KeyEvent.VK_DOWN) {
			// down arrow key
			// change change the current letter
			sm.SubLetter();
		}
	}

	// this funtion is necessary to stop run time error but is unused
	public void keyReleased(KeyEvent e) {
	}

}
