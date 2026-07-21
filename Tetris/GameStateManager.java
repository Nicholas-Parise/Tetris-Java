package Tetris;

/***************************
 * Nicholas Parise, 
 * Sile Keenan, 
 * ICS4U, 
 * Tetris
 ****************************/


//Manages Game states
public class GameStateManager {
	
	// private var
	private Boolean PauseCount,EndCount,MenuCount,SplashCount,NextCount;

	private int PauseTime, EndTime, MenuTime, SplashTime, NextTime;

	private ScoreManager sm;

	public String CurrentState = "Splash";


	public GameStateManager(ScoreManager s){
		sm = s; // score manager

		PauseCount = false;
		PauseTime = 0;
		EndCount = false;
		EndTime = 0;
		MenuCount = false;
		MenuTime = 0;
		SplashCount = false;
		SplashTime = 0;
		NextCount = false;
		NextTime = 0;
	}

	//-----------------

	public String getCurrentState(){
		return CurrentState;
	}

	public void Delta(int DeltaTime) {
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

		if (SplashCount) {
			SplashTime += DeltaTime;
		}

		if (NextCount) {
			NextTime += DeltaTime;
		}
	}

	//-----------------
	
	//switchs game states if conditions meet

	public boolean SwitchLevel() {
		// changes the level 
		if (NextCount && NextTime > 1000) {
				NextTime = 0;
				CurrentState = "Game";
				NextCount = false;
				return true;
		}
		return false;
	}

	public void SwitchSplash() {
		// makes the game go to menu from the splash screen
		if (SplashCount && SplashTime > 2000) {
				CurrentState = "Menu";
				SplashCount = false;
		}
	}

	public boolean SwitchPause() {
		// switches from paused to game
		// or Menu to Help
		if (PauseCount && PauseTime > 200) {

			PauseCount = false;
			PauseTime = 0;

			// Pause
				if (CurrentState == "Game") {
					CurrentState = "Pause";
					//Blocks.CanMove = false;
					return false;
				} else if (CurrentState == "Pause") {
					CurrentState = "Game";
					//Blocks.CanMove = true;
					return true;
					// Help
				} else if (CurrentState == "Menu") {
					CurrentState = "Help";
				} else if (CurrentState == "Help") {
					CurrentState = "Menu";
				}

			}

		return true;
	}

	public void SwitchEnd() {
		// switches to game over
		if (EndCount) {
			if (EndTime > 500) {
				EndCount = false;

				CurrentState = "GameOver";
				EndTime = 0;
				//Blocks.CanMove = false;

				if(sm.TestHS()){
					sm.StartInput();
					sm.setHighscore(sm.getScore());

					// starts the input of name
				}else{
					// if not new highscore go to menu
					StartMenu();
				}
			}
		}
	}

	public void SwitchMenu() {
		// switches to menu
		if (MenuCount) {
			if (MenuTime > 2500) {
				Menu();
			}
		}
	}


	public void Help() {
		if (CurrentState == "Menu") {
			CurrentState = "Help";
		}
	}


	// ---------

	// allows timer to start
	public void StartPause() {
		PauseCount = true;
	}

	public void StartEnd() {
		EndCount = true;
	}

	public void StartMenu() {
		MenuCount = true;
	}

	public void EndSplash() {
		SplashCount = true;
	}

	public void StartNextLevel() {
		NextCount = true;
		CurrentState = "Next";
	}

	// ---------

	// instanly switches state

	public void Menu() {

		MenuCount = false;
		CurrentState = "Menu";
		MenuTime = 0;
	}

	public boolean StartGame() {

		if (CurrentState == "Menu") {
			CurrentState = "Game";
			return true;
		}
		return false;
	}

	public void GameOver() {
		CurrentState = "GameOver";
	}



}