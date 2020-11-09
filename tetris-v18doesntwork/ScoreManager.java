import java.io.*;
import java.util.Scanner;

public class ScoreManager {

	public static int score = 0;
	public static int Highscore = 0;
	public static Boolean NewHighScore = false;
	public static int[] HighScores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	public static void saveScore() {
		addNewScore();
		orderScores();

		if (score > HighScores[0]) {
			Highscore = score;
			NewHighScore = true;

			// saves high score

			try {
				FileWriter myWriter = new FileWriter("Saves.txt");
					for (int i=0; i<10; i++){
						try{
							System.out.println(HighScores[i]);
						} catch (Exception e){
							System.out.println(HighScores[i]);
						}
					}
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {

			}

		} else {
			NewHighScore = false;
		}
		for (int i=0; i<10; i++){
			System.out.println(HighScores[i]);
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
					int i=0;
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();

						HighScores[i] = Integer.parseInt(data);

						i++;
					}
					myReader.close();
				} catch (FileNotFoundException e) {

				}

			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}

	}
	public static void addNewScore(){
		if(score>HighScores[9]){
			HighScores[9]=score;
		}
	}

	public static void orderScores(){
		for (int i=0; i<10; i++){
			for (int j=0; j<9; j++){
				if (HighScores[i]>HighScores[j]){
					int temp = HighScores[j];
					HighScores[j] = HighScores[i];
					HighScores[i] = temp;
				}
			}
		}
	}

}