import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

///Handles Keyboard input
public class KeyBoard extends JPanel implements KeyListener {

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();

		if(keyCode == KeyEvent.VK_ESCAPE){
			//escape arrow key
			GameStateManager.StartPause();
		}

		if(keyCode == KeyEvent.VK_SPACE){
			//space arrow key
			GameStateManager.StartGame();
		}

		if (keyCode == KeyEvent.VK_LEFT) {
			//left arrow key
			if(Blocks.CanMove){
			Blocks.GoLeft();
			}
			System.out.println("Left");
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			//right arrow key
			if(Blocks.CanMove){
			Blocks.GoRight();
			}
			System.out.println("Right");
		
		} else if (keyCode == KeyEvent.VK_UP) {
			//up arrow key
			if(Blocks.CanMove){
			Blocks.ClockRotate();
			}
			System.out.println("Up");
		} else if (keyCode == KeyEvent.VK_DOWN) {
			//down arrow key
			if(Blocks.CanMove){
			Blocks.CounterClockRotate();
			}
			System.out.println("Down");
		}
	}

	public void keyTyped(KeyEvent e) {
		//System.out.println("keyTyped: " + e);
	}

	public void keyReleased(KeyEvent e) {
	//	System.out.println("keyReleased: " + e);
	}

}
