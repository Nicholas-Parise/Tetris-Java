import java.util.concurrent.TimeUnit;

// Due Nov 11

public class Main {

	public static void main(String[] args) {

		Render.construc();
		Blocks.ResetGame();

		float last_time = System.nanoTime();
		float time = 0;
		int delta_time = 0;

		ScoreManager.GetHighScore();

		GameStateManager.EndSplash();

		do {
			
			time = System.nanoTime();
			delta_time = (int) ((time - last_time) / 1000000);
			last_time = time;

			GameStateManager.Delta(delta_time);
			GameStateManager.SwitchPause();
			GameStateManager.SwitchEnd();
			GameStateManager.SwitchMenu();
			GameStateManager.SwitchSplash();
			GameStateManager.SwitchLevel();

			Render.Delta(delta_time);

			if (GameStateManager.CurrentState == "Game") {

				if (Blocks.WhereFloor(Blocks.offsetX, Blocks.offsetY)) {

					Blocks.onFloor();

				} else {

					Blocks.NotonFloor();
				}

				Blocks.ShowFuture();
				Blocks.Delta(delta_time);
			}

			try {
				Render.Update();

				TimeUnit.MILLISECONDS.sleep(5);
			} catch (Exception e) {
			}

		} while (true);
	}
}
