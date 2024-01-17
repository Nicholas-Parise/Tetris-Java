import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

///Handles Keyboard input
public class KeyBoard extends JPanel implements KeyListener {

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();

		if (keyCode == KeyEvent.VK_ESCAPE) {
			// escape key
			GameStateManager.StartPause();
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			// space key
			GameStateManager.StartGame();
		}

		if (keyCode == KeyEvent.VK_ENTER) {
			// Enter key
			Blocks.FastFall();

			ScoreManager.StopInput();

			System.out.println("Enter");
		}

		if (keyCode == KeyEvent.VK_LEFT) {
			// left arrow key

			Blocks.GoLeft();


			ScoreManager.SubCurrent();

			System.out.println("Left");

		} 
		 if (keyCode == KeyEvent.VK_RIGHT) {
			// right arrow key

			Blocks.GoRight();

			ScoreManager.AddCurrent();

			System.out.println("Right");

		} 
		 if (keyCode == KeyEvent.VK_UP) {
			// up arrow key

			Blocks.ClockRotate();

			ScoreManager.AddLetter();


			System.out.println("Up");
		} 
		 if (keyCode == KeyEvent.VK_DOWN) {
			// down arrow key

			Blocks.CounterClockRotate();

			ScoreManager.SubLetter();


			System.out.println("Down");
		}
	}

	public void keyTyped(KeyEvent e) {
		
		int keyCode = e.getKeyCode();


		if (keyCode == KeyEvent.VK_LEFT) {
			// left arrow key
			ScoreManager.SubCurrent();


		} else if (keyCode == KeyEvent.VK_RIGHT) {
			// right arrow key
			
			ScoreManager.AddCurrent();


		} else if (keyCode == KeyEvent.VK_UP) {
			// up arrow key

			ScoreManager.AddLetter();

		} else if (keyCode == KeyEvent.VK_DOWN) {
			// down arrow key

			ScoreManager.SubLetter();

		}
	
	}

	public void keyReleased(KeyEvent e) {
		// System.out.println("keyReleased: " + e);
	}

}
