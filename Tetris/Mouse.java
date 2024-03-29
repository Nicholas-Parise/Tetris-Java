package Tetris;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/***************************
 * Nicholas Parise, 
 * Sile Keenan, 
 * ICS4U, 
 * Tetris
 ****************************/


// This class deals with mouse events
public class Mouse extends JPanel implements MouseListener, MouseMotionListener {

	public int x = 0;
	public int y = 0;

	private GameStateManager gsm;
	private Blocks bl;

	public Mouse(GameStateManager g, Blocks b){
		gsm = g;
		bl = b;
	}



	public void mouseMoved(MouseEvent e) {

		// changes the loction of mouse when the mouse is moved
		x = e.getX();
		y = e.getY();

	}

	public void mouseClicked(java.awt.event.MouseEvent evt) {

		x = evt.getX();
		y = evt.getY();

		// if the mouse is clicked and the mouse in hovered on the button, button is
		// clicked
		if (gsm.getCurrentState() == "Menu" || gsm.getCurrentState() == "Help") {
			if (Button.isButtonHover(x, y, 140, 450, 330, 540)) {
				gsm.StartPause();
			}

			if (Button.isButtonHover(x, y, 120, 280, 350, 370)) {
				gsm.StartGame();
				bl.ResetGame();
			}
		}
	}

	// these functions are nessisary, without them the program will not run
	// so... here they are
	public void mouseDragged(java.awt.event.MouseEvent evt) {
	}

	public void mouseEntered(java.awt.event.MouseEvent evt) {
	}

	public void mouseExited(java.awt.event.MouseEvent evt) {
	}

	public void mousePressed(java.awt.event.MouseEvent evt) {
	}

	public void mouseReleased(java.awt.event.MouseEvent evt) {
	}
}
