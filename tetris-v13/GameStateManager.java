public class GameStateManager {

    public static String CurrentState = "Menu";

    private static Boolean PauseCount = false;
    private static int PauseTime = 0;
    private static Boolean EndCount = false;
    private static int EndTime = 0;
    private static Boolean MenuCount = false;
    private static int MenuTime = 0;

    public static void Delta(int DeltaTime) {
        // adds delta time to individual times

        if (PauseCount) {
            PauseTime += DeltaTime;
        }
        if (EndCount) {
            EndTime += DeltaTime;
        }

        if (MenuCount) {
            MenuTime += DeltaTime;
        }
    }

    public static void SwitchPause() {
        // switches from paused to game

        if (PauseCount) {
            if (PauseTime > 200) {
                if (CurrentState == "Game") {
                    PauseCount = false;
                    CurrentState = "Pause";
                    PauseTime = 0;
                    Blocks.CanMove = false;
                } else if (CurrentState == "Pause") {
                    PauseCount = false;
                    PauseTime = 0;
                    CurrentState = "Game";
                    Blocks.CanMove = true;
                }
            }
        }
    }

    public static void SwitchEnd() {
        // switches to game over
        if (EndCount) {
            if (EndTime > 500) {
                EndCount = false;
                ScoreManager.saveScore();
                CurrentState = "GameOver";
                EndTime = 0;
                Blocks.CanMove = false;
            }
        }
    }

    public static void SwitchMenu() {
        // switches to menu
        if (MenuCount) {
            if (MenuTime > 2500) {
                MenuCount = false;
                CurrentState = "Menu";
                MenuTime = 0;
                Blocks.CanMove = false;
            }
        }
    }

    // allows timer to start
    public static void StartPause() {
        PauseCount = true;
    }

    public static void StartEnd() {
        EndCount = true;
    }

    public static void StartMenu() {
        MenuCount = true;
    }

    // ---------

    // instanly switches state
    public static void StartGame() {
        CurrentState = "Game";
        Blocks.ResetGame();
    }

    public static void GameOver() {
        CurrentState = "GameOver";
    }

}