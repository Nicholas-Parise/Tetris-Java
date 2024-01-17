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
			System.out.println("Enter");
		}

		if (keyCode == KeyEvent.VK_LEFT) {
			// left arrow key

			Blocks.GoLeft();

			System.out.println("Left");

		} else if (keyCode == KeyEvent.VK_RIGHT) {
			// right arrow key

			Blocks.GoRight();
			System.out.println("Right");

		} else if (keyCode == KeyEvent.VK_UP) {
			// up arrow key

			Blocks.ClockRotate();

			System.out.println("Up");
		} else if (keyCode == KeyEvent.VK_DOWN) {
			// down arrow key

			Blocks.CounterClockRotate();

			System.out.println("Down");
		}
	}

	public void keyTyped(KeyEvent e) {
		// System.out.println("keyTyped: " + e);
	}

	public void keyReleased(KeyEvent e) {
		// System.out.println("keyReleased: " + e);
	}

}
