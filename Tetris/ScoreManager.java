package Tetris;
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

	public int[] Letter;

	public int CurrentLetter,score, Highscore;

	public Boolean CanInput, NewHighScore;

	public  String InputString, HighScoreHolder;

	public ScoreManager(){

		Letter = new int[9];

		CurrentLetter = 0;
		score = 0;
		Highscore = 0;

		CanInput = false;
		NewHighScore = false;

		InputString = "aaaaaaaaa";
		HighScoreHolder = "aaaaaaaaa";

		getHighScore();
	}

	// --------------------

	public int getScore(){
		return score;
	}

	public void setScore(int s){
		score = s;
	}

	public int getHighscore(){
		return Highscore;
	}

	public void setHighscore(int hs){
		score = hs;
	}

	public String getInputString(){
		return InputString;
	}

	public void setInputString(String s){
		InputString = s;
	}

	public int getCurrentLetter(){
		return CurrentLetter;
	}

	public void setCurrentLetter(int s){
		CurrentLetter = s;
	}


	public String getHighScoreHolder(){
		return HighScoreHolder;
	}





	// changes the letter you can change
	public void AddCurrent() {

		if (CanInput) {
			CurrentLetter++;

			if (CurrentLetter == 9) {
				CurrentLetter = 0;
			}
		}
		UpdateString();
	}

	// changes the letter you can change
	public void SubCurrent() {

		if (CanInput) {
			CurrentLetter--;

			if (CurrentLetter == -1) {
				CurrentLetter = 8;
			}
		}
		UpdateString();
	}

	// changes the current letter
	public void AddLetter() {

		if (CanInput) {
			Letter[CurrentLetter]++;

			if (Letter[CurrentLetter] == 27) {
				Letter[CurrentLetter] = 0;
			}
		}
		UpdateString();
	}

	// changes the current letter
	public void SubLetter() {

		if (CanInput) {
			Letter[CurrentLetter]--;

			if (Letter[CurrentLetter] == -1) {
				Letter[CurrentLetter] = 26;
			}
		}

		UpdateString();
	}

	// Updates the input string
	public void UpdateString() {

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
	public boolean StopInput() {

		if (CanInput) {
			CanInput = false;
			saveScore();
			return true;
		}
	return false;
	}

	// Starts the name input
	public void StartInput() {

		CanInput = true;
	}

	// --------------------

	public boolean TestHS() {

		if (score > Highscore) {
			return true;
		}
		return false;
	}


	// Saves the score to a file
	public void saveScore() {

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

	public void getHighScore() {

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