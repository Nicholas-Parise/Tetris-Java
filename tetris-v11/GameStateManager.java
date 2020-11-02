public class GameStateManager {

    public static String CurrentState = "Menu";

    private static Boolean PauseCount = false;
    private static int PauseTime = 0;

    private static Boolean EndCount = false;
    private static int EndTime = 0;

    private static Boolean MenuCount = false;
    private static int MenuTime = 0;


    public static void Delta(int DeltaTime) {

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

        if (PauseCount) {
            if (PauseTime > 200) {
                if (CurrentState == "Game") {
                    PauseCount = false;
                    CurrentState = "Pause";
                    PauseTime = 0;
                    Blocks.CanMove = false;
                } else {
                    PauseCount = false;
                    PauseTime = 0;
                    CurrentState = "Game";
                    Blocks.CanMove = true;
                }
            }
        }
    }


    public static void StartPause() {
        PauseCount = true;
    }

    public static void StartEnd() {
        EndCount = true;
    }

    public static void StartMenu() {
        MenuCount = true;
    }
  

    public static void SwitchEnd() {

        if (EndCount) {
            if (EndTime > 500) {
                EndCount = false;
                CurrentState = "GameOver";
                EndTime = 0;
                Blocks.CanMove = false;
            }
        }
    }



    public static void SwitchMenu() {

        if (MenuCount) {
            if (MenuTime > 2500) {
                MenuCount = false;
                CurrentState = "Menu";
                MenuTime = 0;
                Blocks.CanMove = false;
            }
        }
    }





    public static void StartGame() {
        CurrentState = "Game";
        
        Blocks.ResetGame();
    }

    public static void GameOver() {
        CurrentState = "GameOver";
    }

}