public class ScoreManager {



    public static int score = 0;
    public static int Highscore = 0;
    public static Boolean NewHighScore = false;

    public static void saveScore() {

        if (score > Highscore) {
            Highscore = score;
            NewHighScore = true;
        }else{
            NewHighScore = false;
        }
    }

    public static void GetScore() {

    }

}