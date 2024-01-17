import java.io.*;
import java.util.Scanner;

/***************************
 * Nicholas Parise, 
 * Sile Keenan, 
 * ICS4U, 
 * Tetris
 ****************************/


// Manages the score and high score along with input and output
public class ScoreManager {

	// public var
	public static int[] Letter = new int[9];

	public static int CurrentLetter = 0;
	public static int score = 0;
	public static int Highscore = 0;

	public static Boolean CanInput = false;
	public static Boolean NewHighScore = false;

	public static String InputString = "aaaaaaaaa";
	public static String HighScoreHolder = "aaaaaaaaa";

	// --------------------

	// changes the letter you can change
	public static void AddCurrent() {

		if (CanInput) {
			CurrentLetter++;

			if (CurrentLetter == 9) {
				CurrentLetter = 0;
			}
		}
		UpdateString();
	}

	// changes the letter you can change
	public static void SubCurrent() {

		if (CanInput) {
			CurrentLetter--;

			if (CurrentLetter == -1) {
				CurrentLetter = 8;
			}
		}
		UpdateString();
	}

	// changes the current letter
	public static void AddLetter() {

		if (CanInput) {
			Letter[CurrentLetter]++;

			if (Letter[CurrentLetter] == 27) {
				Letter[CurrentLetter] = 0;
			}
		}
		UpdateString();
	}

	// changes the current letter
	public static void SubLetter() {

		if (CanInput) {
			Letter[CurrentLetter]--;

			if (Letter[CurrentLetter] == -1) {
				Letter[CurrentLetter] = 26;
			}
		}

		UpdateString();
	}

	// Updates the input string
	public static void UpdateString() {

		for (int i = 0; i < 9; i++) {

			int intLetter = Letter[i] + 97;

			char charLetter = (char) intLetter;

			StringBuilder myName = new StringBuilder(InputString);
			myName.setCharAt(i, charLetter);

			InputString = myName.toString();
		}
		HighScoreHolder = InputString;
	}

	// Stop the name input
	public static void StopInput() {

		if (CanInput) {
			CanInput = false;
			ScoreManager.saveScore();
			GameStateManager.Menu();
		}
	}

	// Starts the name input
	public static void StartInput() {

		CanInput = true;
	}

	// --------------------

	public static void TestHS() {

		if (score > Highscore) {
			// if its a high score
			Highscore = score;
			NewHighScore = true;
			// saves high score

		} else {
			// if not don't do anything
			NewHighScore = false;
		}
	}

	// Saves the score to a file
	public static void saveScore() {

		HighScoreHolder = InputString;

		// saves high score
		try {
			FileWriter myWriter = new FileWriter("Saves");

			myWriter.write(InputString + Integer.toString(Highscore));

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {

		}
		InputString = "aaaaaaaaa";
		// if not don't do anything
	}

	public static void GetHighScore() {

		try {
			File myObj = new File("Saves");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());

				Highscore = 0;

			} else {
				System.out.println("File already exists.");

				try {
					myObj = new File("Saves");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {

						String data = myReader.nextLine();

						String name = data.substring(0, 9);

						String score = data.substring(9, data.length());

						HighScoreHolder = name;
						Highscore = Integer.parseInt(score);

					}
					myReader.close();
				} catch (FileNotFoundException e) {

				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
}