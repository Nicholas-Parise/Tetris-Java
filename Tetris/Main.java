package Tetris;
import java.util.concurrent.TimeUnit;

/***************************
 * Nicholas Parise, 
 * Sile Keenan, 
 * ICS4U, 
 * Tetris
 ****************************/

public class Main {

	public static void main(String[] args) {

		// Delta time is the time between frames, i use the time between frames as a way
		// to regulate game speed
		// this way the game could be going 10 fps or 1000 fps either way the block will
		// fall every 0.500 seconds (on the first level anyway)

		float last_time = System.nanoTime();
		float time = 0;
		int delta_time = 0;


		ScoreManager sm = new ScoreManager();
		GameStateManager gsm = new GameStateManager(sm);
		Blocks bl = new Blocks(sm,gsm);

		Render r = new Render(sm,gsm,bl);



		// ending the splash screen
		gsm.EndSplash();

		do {
			// changes delta time
			time = System.nanoTime();
			delta_time = (int) ((time - last_time) / 1000000);
			last_time = time;

			// adds delta time to Gamestates and to the render class
			gsm.Delta(delta_time);
			r.Delta(delta_time);

			// Tests if the game state switches can switch game states every frame
			gsm.SwitchMenu();
			gsm.SwitchEnd();
			gsm.SwitchSplash();
			bl.CanMove = gsm.SwitchPause();
			if(gsm.SwitchLevel())
				bl.NextLevel();




			if (gsm.CurrentState == "Game") {

				if (bl.WhereFloor(bl.offsetX, bl.offsetY)) {
					// if the block is on the floor
					bl.WaitOnFloor();
				} else {
					// if it's not
					bl.NotonFloor();
				}

				// this only needs to be updated when in game mode
				bl.Delta(delta_time);
			}

			// for some reason .sleep must be in a try catch or else there is a compiler
			// error
			try {

				// update render window
				r.Update();

				// wait 5 MILLISECONDS
				// people on the internet said this would help stop crashing
				// and since it doesn't crash it's here
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (Exception e) {
			}

		} while (true);
	}
}
