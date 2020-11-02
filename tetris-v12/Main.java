import java.util.concurrent.TimeUnit;

// Due Nov 11

public class Main {

	public static void main(String[] args) {

		// Arr[Y][X]

		Render.construc();

		Blocks.ResetGame();

		int fallTimer = 0;
		int floorTimer = 0;

		long last_time = System.nanoTime();
		long time = 0;
		int delta_time = 0;

		do {

			time = System.nanoTime();
			delta_time = (int) ((time - last_time) / 1000000);
			last_time = time;

			GameStateManager.Delta(delta_time);

			GameStateManager.SwitchPause();
			GameStateManager.SwitchEnd();
			GameStateManager.SwitchMenu();

			if (GameStateManager.CurrentState == "Game") {

				if (Blocks.WhereFloor(Blocks.offsetX, Blocks.offsetY)) {
					fallTimer = 0;

					if (floorTimer > 800) {

						Blocks.CanMove = false;

						if (floorTimer > 1000) {
							GameLogic.FullRow();
							Blocks.NextBlock();
							floorTimer = 0;

							Blocks.CanMove = true;

							ScoreManager.score += 30;
						}
					}

				} else {
					floorTimer = 0;

					if (fallTimer > 500) {
						Blocks.Gravity();
						fallTimer = 0;
					}
				}
			}

			Blocks.ShowFuture();

			if (Render.DeltaTitle > 2400) {
				Render.DeltaTitle = 0;
			}

			Render.DeltaTitle += delta_time;
			fallTimer += delta_time;
			floorTimer += delta_time;

			try {
				Render.Update();

				TimeUnit.MILLISECONDS.sleep(10);
			} catch (Exception e) {
				System.out.println("Failed To draw");
			}

		} while (true);

	}

}
