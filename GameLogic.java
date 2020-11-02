
public class GameLogic {


    public static Boolean GameOver = false;

    
    public static void gameOver() {
    	
    }

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
            
            
                for(int k = i; k>0; k--) {

                    for(int l = 0; l<10; l++) {

                        Blocks.GameMatrix[k][l]=Blocks.GameMatrix[k-1][l];
                    }
                }
            }
        }
    }













}
