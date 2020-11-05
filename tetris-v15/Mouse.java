import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Mouse extends JPanel implements MouseListener, MouseMotionListener {

	public int x = 0;
	public int y = 0;

	public void mouseMoved(MouseEvent e) {

		x = e.getX();
		y = e.getY();

		if (Button.isButtonHover(x, y)) {
		//	System.out.println("On Button");

		}
	}

	public void mouseClicked(java.awt.event.MouseEvent evt) {

		x = evt.getX();
		y = evt.getY();

		if (Button.isButtonHover(x, y)) {
		//	System.out.println("Button Clicked");
			GameStateManager.StartPause();
		}

	}

	public void mouseDragged(java.awt.event.MouseEvent evt) {

	}

	public void mouseEntered(java.awt.event.MouseEvent evt) {
		// System.out.println("mouseEntered");
	}

	public void mouseExited(java.awt.event.MouseEvent evt) {
		// System.out.println("mouseExited");
	}

	public void mousePressed(java.awt.event.MouseEvent evt) {
		// System.out.println("mousePressed");
	}

	public void mouseReleased(java.awt.event.MouseEvent evt) {
		// System.out.println("mouseReleased");
	}
}
