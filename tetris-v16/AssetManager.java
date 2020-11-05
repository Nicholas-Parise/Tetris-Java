
//This class deals with assets

public class AssetManager {

	// Numbers
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

	// letters

	private static int[][] ALetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static int[][] BLetter = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };

	private static int[][] CLetter = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };

	private static int[][] DLetter = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };

	private static int[][] ELetter = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };

	private static int[][] FLetter = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 } };

	private static int[][] GLetter = { { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

	private static int[][] HLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static int[][] ILetter = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

	private static int[][] JLetter = { { 0, 1, 1, 1 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 1, 0 } };

	private static int[][] KLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static int[][] LLetter = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };

	private static int[][] MLetter = {
			// {0,1,0,1,0},
			// {1,0,1,0,1},
			// {1,0,1,0,1},
			// {1,0,1,0,1},
			// {1,0,1,0,1}
			{ 1, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 } };

	private static int[][] NLetter = { { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 }, { 1, 0, 0, 1 } };

	private static int[][] OLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static int[][] PLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 } };

	private static int[][] QLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 } };

	private static int[][] RLetter = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static int[][] SLetter = { { 0, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };

	private static int[][] TLetter = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };

	private static int[][] ULetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static int[][] VLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 } };

	private static int[][] WLetter = {
			// {1,0,1,0,1},
			// {1,0,1,0,1},
			// {1,0,1,0,1},
			// {1,0,1,0,1},
			// {0,1,0,1,0}
			{ 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 1 } };

	private static int[][] XLetter = { { 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 1 } };

	private static int[][] YLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };

	private static int[][] ZLetter = { { 1, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 0 }, { 1, 0, 0, 0 }, { 1, 1, 1, 1 } };

	private static int[][] DashLetter = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };

	// ----------------------------------------

	// Assets

	public static int[][] Pause = { { 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 0, 0, 1, 1 } };

	public static int[][] HelpButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static int[][] BackButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 2, 2, 0, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 2, 0, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static int[][] Arrow = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static int[][] Esc = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static int[][] Enter = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// Words

	public static int[][] Title = AssetCreater("tetris");

	public static int[][] HighScoreText = AssetCreater("high score");

	public static int[][] NewHighScoreText = AssetCreater("new high score");

	public static int[][] ScoreText = AssetCreater("score");

	public static int[][] NextPieceText = AssetCreater("next piece");

	public static int[][] GameOverText = AssetCreater("game over");

	public static int[][] PressStart = AssetCreater("press space");

	public static int[][] KeyBindings = AssetCreater("key bindings");

	public static int[][] LeftText = AssetCreater("left");

	public static int[][] RightText = AssetCreater("right");

	public static int[][] DownText = AssetCreater("down");

	public static int[][] PauseText = AssetCreater("pause");

	public static int[][] TextCRotation = AssetCreater("counter clockwise rotation");

	public static int[][] TextRotation = AssetCreater("clockwise rotation");

	public static int[][] CreditNick = AssetCreater("nick");

	public static int[][] CreditSile = AssetCreater("sile");

	public static int[][] Company = AssetCreater("snuffleupagus-pemphigus");

	// ---------------------------

	public static int ArrLength(String srt) {
		// returns length of array from string
		// because some letters are larger than others you can't just use math
		int length = 0;

		for (int k = 0; k < srt.length(); k++) {

			if (srt.charAt(k) == 'g') {

				length += 1;

			} else if (srt.charAt(k) == 'j') {

				length += 1;

			} else if (srt.charAt(k) == 'm') {

				length += 2;

			} else if (srt.charAt(k) == 'n') {

				length += 1;
			} else if (srt.charAt(k) == 'w') {

				length += 2;
			} else if (srt.charAt(k) == 'x') {

				length += 2;
			} else if (srt.charAt(k) == 'z') {

				length += 1;

			} else if (srt.charAt(k) == ' ') {
				length -= 2;
			}

			length += 4;
		}

		return length;
	}

	public static int[][] AssetCreater(String srt) {
		// Creats a 2d array in the shape of numbers / letters
		// to show score/highscore and words

		int Length = ArrLength(srt);

		int[][] TempArr = new int[5][Length];

		int Xoffset = 0;

		for (int k = 0; k < srt.length(); k++) {

			if (srt.charAt(k) == '0') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Zero[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '1') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (One[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '2') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Two[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '3') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Three[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '4') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Four[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '5') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Five[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '6') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Six[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '7') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Seven[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '8') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Eight[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == '9') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (Nine[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
			} else if (srt.charAt(k) == 'a') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (ALetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'b') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (BLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'c') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (CLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'd') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (DLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'e') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (ELetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'f') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (FLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'g') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 4; j++) {
						if (GLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

				Xoffset += 1;

			} else if (srt.charAt(k) == 'h') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (HLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'i') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (ILetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'j') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 4; j++) {
						if (JLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
				Xoffset += 1;

			} else if (srt.charAt(k) == 'k') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (KLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'l') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (LLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'm') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (MLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
				Xoffset += 2;

			} else if (srt.charAt(k) == 'n') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 4; j++) {
						if (NLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
				Xoffset += 1;
			} else if (srt.charAt(k) == 'o') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (OLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'p') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (PLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'q') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (QLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'r') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (RLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 's') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (SLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 't') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (TLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'u') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (ULetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'v') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (VLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			} else if (srt.charAt(k) == 'w') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (WLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
				Xoffset += 2;
			} else if (srt.charAt(k) == 'x') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (XLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
				Xoffset += 2;
			} else if (srt.charAt(k) == 'y') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (YLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
			} else if (srt.charAt(k) == 'z') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 4; j++) {
						if (ZLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}
				Xoffset += 1;
			} else if (srt.charAt(k) == ' ') {
				Xoffset -= 2;

			} else if (srt.charAt(k) == '-') {

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 3; j++) {
						if (DashLetter[i][j] > 0) {

							TempArr[i][j + Xoffset] = 1;
						}
					}
				}

			}

			Xoffset += 4;
		}

		return TempArr;

	}

}
