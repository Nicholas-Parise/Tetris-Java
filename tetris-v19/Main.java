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

		// Sets up the game by
		// init the render window
		Render.construc();
		// reseting game matrix
		Blocks.ResetGame();
		// retriving highscore
		ScoreManager.GetHighScore();
		// ending the splash screen
		GameStateManager.EndSplash();

		do {
			// changes delta time
			time = System.nanoTime();
			delta_time = (int) ((time - last_time) / 1000000);
			last_time = time;

			// adds delta time to Gamestates and to the render class
			GameStateManager.Delta(delta_time);
			Render.Delta(delta_time);

			// Tests if the game state switches can switch game states every frame
			GameStateManager.SwitchPause();
			GameStateManager.SwitchEnd();
			GameStateManager.SwitchMenu();
			GameStateManager.SwitchSplash();
			GameStateManager.SwitchLevel();

			if (GameStateManager.CurrentState == "Game") {

				if (Blocks.WhereFloor(Blocks.offsetX, Blocks.offsetY)) {
					// if the block is on the floor
					Blocks.WaitOnFloor();
				} else {
					// if it's not
					Blocks.NotonFloor();
				}

				// this only needs to be updated when in game mode
				Blocks.Delta(delta_time);
			}

			// for some reason .sleep must be in a try catch or else there is a compiler
			// error
			try {

				// update render window
				Render.Update();

				// wait 5 MILLISECONDS
				// people on the internet said this would help stop crashing
				// and since it doesn't crash it's here
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (Exception e) {
			}

		} while (true);
	}
}
