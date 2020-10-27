import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class KeyBoard extends JPanel implements KeyListener {

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();

		/*
		int d;
		if (evt.isShiftDown())
			d = 5;
		else
			d = 1;
		*/

		if (keyCode == KeyEvent.VK_LEFT) {
			System.out.println("Left");
			Blocks.GoLeft();
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			Blocks.GoRight();
			System.out.println("Right");
		} else if (keyCode == KeyEvent.VK_UP) {
			System.out.println("Up");
			Blocks.ClockRotate();
		} else if (keyCode == KeyEvent.VK_DOWN) {
			System.out.println("Down");
			Blocks.CounterClockRotate();
		}
	}

	public void keyTyped(KeyEvent e) {
		//System.out.println("keyTyped: " + e);
	}

	public void keyReleased(KeyEvent e) {
	//	System.out.println("keyReleased: " + e);
	}

}
