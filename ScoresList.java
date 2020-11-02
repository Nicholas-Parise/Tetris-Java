import java.io.File;
import java.util.Scanner;

public class ScoresList {
	//The scores and the names of the people who got the scores (name input not added yet)
	int[] scores = new int[10];
	String[] names = new String[10];
	/*
	 * creates a ScoreList object which gets high sc
	 */
	public ScoresList() {
		try {	
			Scanner file = new Scanner(new File("highScores.txt"));
			for (int i=0; i<10; i++) {
				try {	
					scores[i] = file.nextInt();
					names[i] = file.next();
				} catch (Exception e) {
					scores[i] = 0;
					names[i] = "---";
				}
			}
		} catch (Exception e) {
			for (int i=0; i<10; i++) {
				scores[i] = 0;
				names[i] = "---";
			}
		}
	}
	/*
	 * DOESN'T WORK YET
	 * At the end of a round, adds score to the ScoreList's scores array
	 * by reading the data gotten from highScores.txt
	 */
	public void AddNewScores(int score) {
		for (int i=0; i<10; i++) {
			if (scores[i] <= 0) {
				scores[i] = score;
				names[i] = "wow";
				break;
			} else {
				System.out.println("Score already here");
			}
		}
	}
	public void PrintScoreList() {
		for (int i=0; i<10; i++) {
			System.out.println(scores[i] + names[i]);
		}
	}
}
