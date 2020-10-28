
public class AssetManager {

    private static int[][] Zero = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

    private static int[][] One = { { 0, 1, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

    private static int[][] Two = { { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };

    private static int[][] Three = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } };

    private static int[][] Four = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };

    private static int[][] Five = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } };

    private static int[][] Six = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

    private static int[][] Seven = { { 1, 1, 1 }, { 1, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };

    private static int[][] Eight = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

    private static int[][] Nine = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };

    
    public static int[][] Title = { 
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 },
            { 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0 } };


    public static int[][] HighScoreText = {
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0 } };


    public static int[][] ScoreText = {
            { 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
            { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
            { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0 } };


     public static int[][] NextPieceText = {
                {1,0,0,1,0,1,1,1,0,1,0,0,0,1,0,1,1,1,0,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,},
                {1,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,},
                {1,1,0,1,0,1,1,1,0,0,0,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,1,1,0,1,0,0,0,1,1,1,0,0,0,0,},
                {1,0,1,1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,},
                {1,0,0,1,0,1,1,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,}};



    public static int[][] AssetCreater(String srt) {

        int Length = 0;

        Length = srt.length() + (srt.length() * 3);

        int[][] TempArr = new int[Length][5];

        int Xoffset = 0;

        for (int k = 0; k < srt.length(); k++) {

            if (srt.charAt(k) == '0') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Zero[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '1') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (One[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '2') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Two[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '3') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Three[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '4') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Four[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '5') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Five[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '6') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Six[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '7') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Seven[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '8') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Eight[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }

            } else if (srt.charAt(k) == '9') {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (Nine[i][j] > 0) {

                            TempArr[j + Xoffset][i] = 1;
                        }
                    }
                }
            }

            Xoffset += 4;
        }

        return TempArr;

    }

}
