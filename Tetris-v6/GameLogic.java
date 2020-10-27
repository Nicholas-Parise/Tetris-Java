
public class GameLogic {




    public static void FullRow() {

        Boolean fullRown = false;

        for (int i = 0; i < 20; i++) {
            fullRown = true;
            for (int j = 0; j < 10; j++) {

                if (Blocks.GameMatrix[i][j] == 0) {

                    fullRown = false;
                }

            }

            if(fullRown){

                for (int j = 0; j < 10; j++) {

                    Blocks.GameMatrix[i][j] = 0;
                    Main.score +=100;
                }
            }


        }

    }

}
