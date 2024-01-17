import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class ScoreManager {

	public static int score = 0;
	public static int Highscore = 0;
	public static Boolean NewHighScore = false;

	public static int[] Letter = new int[9];

	public static int CurrentLetter = 0;

	public static Boolean CanInput = false;

	public static String InputString = "aaaaaaaaa";

	// --------------------

	public static void AddCurrent() {

		if (CanInput) {
			CurrentLetter++;

			if (CurrentLetter == 9) {
				CurrentLetter = 0;
			}
		}
		UpdateString();
	}

	public static void SubCurrent() {

		if (CanInput) {
			CurrentLetter--;

			if (CurrentLetter == -1) {
				CurrentLetter = 8;
			}
		}
		UpdateString();
	}

	public static void AddLetter() {

		if (CanInput) {
			Letter[CurrentLetter]++;

			if (Letter[CurrentLetter] == 27) {
				Letter[CurrentLetter] = 0;
			}
		}
		UpdateString();
	}

	public static void SubLetter() {

		if (CanInput) {
			Letter[CurrentLetter]--;

			if (Letter[CurrentLetter] == -1) {
				Letter[CurrentLetter] = 26;
			}
		}

		UpdateString();

	}

	public static void UpdateString() {

		for (int i = 0; i < 9; i++) {

			int Letssee = Letter[i] + 97;

			char Test = (char) Letssee;

			StringBuilder myName = new StringBuilder(InputString);
			myName.setCharAt(i, Test);

			InputString = myName.toString();

		}

	}

	public static void StopInput() {

		if(CanInput){
		CanInput = false;
		GameStateManager.Menu();
		}

	}

	public static void StartInput() {

		CanInput = true;
	}

	public static void saveScore() {

		if (score > Highscore) {
			Highscore = score;
			NewHighScore = true;

			// saves high score

			try {
				FileWriter myWriter = new FileWriter("Saves.txt");

				myWriter.write(Integer.toString(Highscore));

				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {

			}

		} else {
			NewHighScore = false;
		}
	}

	public static void GetHighScore() {

		try {
			File myObj = new File("Saves.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());

				Highscore = 0;

			} else {
				System.out.println("File already exists.");

				try {
					myObj = new File("Saves.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {

						String data = myReader.nextLine();

						Highscore = Integer.parseInt(data);

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