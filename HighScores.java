import java.io.PrintWriter;

public class HighScores {
	public static void StoreHighScores(ScoresList scores) {
		try {	
			PrintWriter scoreList = new PrintWriter("highScores.txt");
			//scoreList.println("This");
			for (int i=0; i<10; i++) {
				scoreList.println(scores.scores[i] + scores.names[i]);
			}
			scoreList.close();
		} catch(Exception e) {
			System.out.println("This doesn't work for some reason");
		}
	}
}