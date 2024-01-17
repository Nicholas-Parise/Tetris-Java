import java.io.*;
import java.util.Scanner;

public class ScoreManager {

	public static int score = 0;
	public static int Highscore = 0;
	public static Boolean NewHighScore = false;

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