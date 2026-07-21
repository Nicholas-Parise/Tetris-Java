package Tetris;
/***************************
 * Nicholas Parise, 
 * Sile Keenan, 
 * ICS4U, 
 * Tetris
 ****************************/


// This class deals with assets
public class AssetManager {

	// Numbers
	private static final int[][] Zero = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static final int[][] One = { { 0, 1, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

	private static final int[][] Two = { { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };

	private static final int[][] Three = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } };

	private static final int[][] Four = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };

	private static final int[][] Five = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } };

	private static final int[][] Six = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static final int[][] Seven = { { 1, 1, 1 }, { 1, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };

	private static final int[][] Eight = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static final int[][] Nine = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };

	// letters

	private static final int[][] ALetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static final int[][] BLetter = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };

	private static final int[][] CLetter = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };

	private static final int[][] DLetter = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };

	private static final int[][] ELetter = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };

	private static final int[][] FLetter = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 } };

	private static final int[][] GLetter = { { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

	private static final int[][] HLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static final int[][] ILetter = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

	private static final int[][] JLetter = { { 0, 1, 1, 1 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 1, 0 } };

	private static final int[][] KLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static final int[][] LLetter = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };

	private static final int[][] MLetter = { { 1, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 1 } };

	private static final int[][] NLetter = { { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 }, { 1, 0, 0, 1 } };

	private static final int[][] OLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static final int[][] PLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 } };

	private static final int[][] QLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 } };

	private static final int[][] RLetter = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static final int[][] SLetter = { { 0, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };

	private static final int[][] TLetter = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };

	private static final int[][] ULetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static final int[][] VLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 } };

	private static final int[][] WLetter = { { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1 },
			{ 1, 0, 0, 0, 1 } };

	private static final int[][] XLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static final int[][] YLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };

	private static final int[][] ZLetter = { { 1, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 0 }, { 1, 0, 0, 0 }, { 1, 1, 1, 1 } };

	// there are a few symbols I needed here also so here they are

	private static final int[][] DashLetter = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };

	private static final int[][] ColonLetter = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

	// ----------------------------------------

	// Assets

	// pause bars
	public static final int[][] Pause = { { 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 0, 0, 1, 1 } };

	// help button
	public static final int[][] HelpButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// StartButton
	public static final int[][] StartButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 2, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 2, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 0, 2, 0, 0, 0, 2, 0, 0, 2, 2, 2, 0, 2, 2, 0, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 2, 2, 0, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// BackButton
	public static final int[][] BackButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 2, 2, 0, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 2, 0, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// -------------------
	// Arrows

	// originally there was only one arrow matrix but when I rewrote the render class
	// I needed each arrow to be its own matrix or else there would be a lot of 2d
	// arrays and for loops
	public static final int[][] Arrow = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static final int[][] ArrowDown = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static final int[][] ArrowLeft = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 1, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static final int[][] ArrowRight = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// ---------------

	// esc button
	public static final int[][] Esc = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// enter
	public static final int[][] Enter = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// --------------------

	// This is the splash screen animation of a block falling

	public static final int[][] SplashMatrix = { { 0, 2, 0 }, { 0, 2, 2 }, { 1, 0, 2 }, { 1, 0, 0 }, { 1, 1, 0 } };

	public static final int[][] SplashMatrix1 = { { 0, 0, 0 }, { 0, 2, 0 }, { 1, 2, 2 }, { 1, 0, 2 }, { 1, 1, 0 } };

	public static final int[][] SplashMatrix2 = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 2, 0 }, { 1, 2, 2 }, { 1, 1, 2 } };

	public static final int[][] SplashMatrix3 = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 2, 0 }, { 1, 2, 2 }, { 0, 0, 0 } };

	public static final int[][] SplashMatrix4 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 1, 2, 0 }, { 1, 2, 2 } };

	// --------------

	// Words
	// calls the AssetCreater function to create a 2d array from a String

	public static int[][] Title = AssetCreater("tetris");

	public static int[][] NextLevel = AssetCreater("next level");

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

	public static int[][] EnterName = AssetCreater("enter name:");

	public static int[][] EnterToEnd = AssetCreater("press enter to finish");

	// ---------------------------

	public static int ArrLength(String srt) {
		// returns length of array from string
		// because some letters are larger than others you can't just use math
		int length = 0;

		for (int k = 0; k < srt.length(); k++) {

			if (srt.charAt(k) == 'g' || srt.charAt(k) == 'j' || srt.charAt(k) == 'n' || srt.charAt(k) == 'z') {

				length += 1;
			} else if (srt.charAt(k) == 'm' || srt.charAt(k) == 'w') {

				length += 2;
			} else if (srt.charAt(k) == ' ') {
				length -= 2;
			}

			length += 4;
		}

		return length;
	}

	private static void AddToArr(int[][] arr, int[][] symbol, int length, int offset) {
		// Takes old array and returns new arr with new letter / number

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < length; j++) {
				if (symbol[i][j] > 0) {

					arr[i][j + offset] = 1;
				}
			}
		}
	}

	public static int[][] AssetCreater(String srt) {
		// Creats a 2d array in the shape of numbers / letters from a string

		int Length = ArrLength(srt);

		int[][] TempArr = new int[5][Length];

		int Xoffset = 0;

		// goes through entire word and if any letter corresponds with a letter it's
		// testing for
		// it calls a function to add the new symbol to 2d array

		// I considered commenting all this but I think it's pretty self explanatory

		for (int k = 0; k < srt.length(); k++) {

			if (srt.charAt(k) == '0') {
				// if it's 0 add Zero Matrix to the matrix
				AddToArr(TempArr, Zero, 3, Xoffset);

			} else if (srt.charAt(k) == '1') {

				AddToArr(TempArr, One, 3, Xoffset);

			} else if (srt.charAt(k) == '2') {

				AddToArr(TempArr, Two, 3, Xoffset);

			} else if (srt.charAt(k) == '3') {

				AddToArr(TempArr, Three, 3, Xoffset);

			} else if (srt.charAt(k) == '4') {

				AddToArr(TempArr, Four, 3, Xoffset);

			} else if (srt.charAt(k) == '5') {

				AddToArr(TempArr, Five, 3, Xoffset);

			} else if (srt.charAt(k) == '6') {

				AddToArr(TempArr, Six, 3, Xoffset);

			} else if (srt.charAt(k) == '7') {

				AddToArr(TempArr, Seven, 3, Xoffset);

			} else if (srt.charAt(k) == '8') {

				AddToArr(TempArr, Eight, 3, Xoffset);

			} else if (srt.charAt(k) == '9') {

				AddToArr(TempArr, Nine, 3, Xoffset);

			} else if (srt.charAt(k) == 'a') {

				AddToArr(TempArr, ALetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'b') {

				AddToArr(TempArr, BLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'c') {

				AddToArr(TempArr, CLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'd') {

				AddToArr(TempArr, DLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'e') {

				AddToArr(TempArr, ELetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'f') {

				AddToArr(TempArr, FLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'g') {

				AddToArr(TempArr, GLetter, 4, Xoffset);

				// G is a bigger number so I just add 1 to offset
				Xoffset += 1;

			} else if (srt.charAt(k) == 'h') {

				AddToArr(TempArr, HLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'i') {

				AddToArr(TempArr, ILetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'j') {

				AddToArr(TempArr, JLetter, 4, Xoffset);

				Xoffset += 1;

			} else if (srt.charAt(k) == 'k') {

				AddToArr(TempArr, KLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'l') {

				AddToArr(TempArr, LLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'm') {

				AddToArr(TempArr, MLetter, 5, Xoffset);

				Xoffset += 2;

			} else if (srt.charAt(k) == 'n') {

				AddToArr(TempArr, NLetter, 4, Xoffset);

				Xoffset += 1;
			} else if (srt.charAt(k) == 'o') {

				AddToArr(TempArr, OLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'p') {

				AddToArr(TempArr, PLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'q') {

				AddToArr(TempArr, QLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'r') {

				AddToArr(TempArr, RLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 's') {

				AddToArr(TempArr, SLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 't') {

				AddToArr(TempArr, TLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'u') {

				AddToArr(TempArr, ULetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'v') {

				AddToArr(TempArr, VLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'w') {

				AddToArr(TempArr, WLetter, 5, Xoffset);

				Xoffset += 2;
			} else if (srt.charAt(k) == 'x') {

				AddToArr(TempArr, XLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'y') {

				AddToArr(TempArr, YLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'z') {

				AddToArr(TempArr, ZLetter, 4, Xoffset);

				Xoffset += 1;
			} else if (srt.charAt(k) == ' ') {
				Xoffset -= 2;
				// space is too big number so I just sub 2 from offset

			} else if (srt.charAt(k) == '-') {

				AddToArr(TempArr, DashLetter, 3, Xoffset);

			} else if (srt.charAt(k) == ':') {

				AddToArr(TempArr, ColonLetter, 3, Xoffset);

			}

			Xoffset += 4;
		}
		return TempArr;
	}
}
