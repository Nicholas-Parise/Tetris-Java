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

		if(keyCode == KeyEvent.VK_ESCAPE){

			GameStateManager.StartPause();
		}


		if (keyCode == KeyEvent.VK_LEFT) {
			System.out.println("Left");
			
			if(Blocks.CanMove){
			Blocks.GoLeft();
			}

		} else if (keyCode == KeyEvent.VK_RIGHT) {
			
			if(Blocks.CanMove){
			Blocks.GoRight();
			}

			System.out.println("Right");
		} else if (keyCode == KeyEvent.VK_UP) {
			System.out.println("Up");
		
			if(Blocks.CanMove){
			Blocks.ClockRotate();
			}
		} else if (keyCode == KeyEvent.VK_DOWN) {
			System.out.println("Down");
			if(Blocks.CanMove){
			Blocks.CounterClockRotate();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		//System.out.println("keyTyped: " + e);
	}

	public void keyReleased(KeyEvent e) {
	//	System.out.println("keyReleased: " + e);
	}

}
