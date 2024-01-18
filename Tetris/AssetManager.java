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

	private static int[][] MLetter = { { 1, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 1 } };

	private static int[][] NLetter = { { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 }, { 1, 0, 0, 1 } };

	private static int[][] OLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static int[][] PLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 0 } };

	private static int[][] QLetter = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 } };

	private static int[][] RLetter = { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static int[][] SLetter = { { 0, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };

	private static int[][] TLetter = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };

	private static int[][] ULetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	private static int[][] VLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 } };

	private static int[][] WLetter = { { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1 },
			{ 1, 0, 0, 0, 1 } };

	private static int[][] XLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };

	private static int[][] YLetter = { { 1, 0, 1 }, { 1, 0, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };

	private static int[][] ZLetter = { { 1, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 0 }, { 1, 0, 0, 0 }, { 1, 1, 1, 1 } };

	// there are a few symbols I needed here also so here they are

	private static int[][] DashLetter = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };

	private static int[][] ColonLetter = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

	// ----------------------------------------

	// Assets

	// pause bars
	public static int[][] Pause = { { 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 0, 0, 1, 1 } };

	// help button
	public static int[][] HelpButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 1 },
			{ 1, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1 },
			{ 1, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// StartButton
	public static int[][] StartButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 2, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 2, 0, 0, 2, 2, 2, 0, 1 },
			{ 1, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 0, 2, 0, 0, 0, 2, 0, 0, 2, 2, 2, 0, 2, 2, 0, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 2, 2, 0, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// BackButton
	public static int[][] BackButton = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
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

	// origonaly there was only one arrow matrix but when I rewrote the render class
	// I needed each arrow to be it's own matrix or else there would be a lot of 2d
	// arrays and for loops
	public static int[][] Arrow = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static int[][] ArrowDown = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static int[][] ArrowLeft = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 1, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 1, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public static int[][] ArrowRight = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// ---------------

	// esc button
	public static int[][] Esc = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	// enter
	public static int[][] Enter = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
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

	public static int[][] SplashMatrix = { { 0, 2, 0 }, { 0, 2, 2 }, { 1, 0, 2 }, { 1, 0, 0 }, { 1, 1, 0 } };

	public static int[][] SplashMatrix1 = { { 0, 0, 0 }, { 0, 2, 0 }, { 1, 2, 2 }, { 1, 0, 2 }, { 1, 1, 0 } };

	public static int[][] SplashMatrix2 = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 2, 0 }, { 1, 2, 2 }, { 1, 1, 2 } };

	public static int[][] SplashMatrix3 = { { 0, 0, 0 }, { 0, 0, 0 }, { 1, 2, 0 }, { 1, 2, 2 }, { 0, 0, 0 } };

	public static int[][] SplashMatrix4 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 1, 2, 0 }, { 1, 2, 2 } };

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
			} else if (srt.charAt(k) == 'z') {

				length += 1;
			} else if (srt.charAt(k) == ' ') {
				length -= 2;
			}

			length += 4;
		}

		return length;
	}

	private static int[][] AddToArr(int[][] arr, int[][] symbol, int length, int offset) {
		// Takes old array and returns new arr with new letter / number

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < length; j++) {
				if (symbol[i][j] > 0) {

					arr[i][j + offset] = 1;
				}
			}
		}
		return arr;
	}

	public static int[][] AssetCreater(String srt) {
		// Creats a 2d array in the shape of numbers / letters from a string

		int Length = ArrLength(srt);

		int[][] TempArr = new int[5][Length];

		int Xoffset = 0;

		// goes through entire word and if any letter corrisponds with a letter it's
		// testing for
		// it calls a function to add the new symbol to 2d array

		// I considered commenting all this but I think it's pretty self explanitory

		for (int k = 0; k < srt.length(); k++) {

			if (srt.charAt(k) == '0') {
				// if it's 0 add Zero Matrix to the matrix
				TempArr = AddToArr(TempArr, Zero, 3, Xoffset);

			} else if (srt.charAt(k) == '1') {

				TempArr = AddToArr(TempArr, One, 3, Xoffset);

			} else if (srt.charAt(k) == '2') {

				TempArr = AddToArr(TempArr, Two, 3, Xoffset);

			} else if (srt.charAt(k) == '3') {

				TempArr = AddToArr(TempArr, Three, 3, Xoffset);

			} else if (srt.charAt(k) == '4') {

				TempArr = AddToArr(TempArr, Four, 3, Xoffset);

			} else if (srt.charAt(k) == '5') {

				TempArr = AddToArr(TempArr, Five, 3, Xoffset);

			} else if (srt.charAt(k) == '6') {

				TempArr = AddToArr(TempArr, Six, 3, Xoffset);

			} else if (srt.charAt(k) == '7') {

				TempArr = AddToArr(TempArr, Seven, 3, Xoffset);

			} else if (srt.charAt(k) == '8') {

				TempArr = AddToArr(TempArr, Eight, 3, Xoffset);

			} else if (srt.charAt(k) == '9') {

				TempArr = AddToArr(TempArr, Nine, 3, Xoffset);

			} else if (srt.charAt(k) == 'a') {

				TempArr = AddToArr(TempArr, ALetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'b') {

				TempArr = AddToArr(TempArr, BLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'c') {

				TempArr = AddToArr(TempArr, CLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'd') {

				TempArr = AddToArr(TempArr, DLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'e') {

				TempArr = AddToArr(TempArr, ELetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'f') {

				TempArr = AddToArr(TempArr, FLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'g') {

				TempArr = AddToArr(TempArr, GLetter, 4, Xoffset);

				// G is a bigger number so I just add 1 to offset
				Xoffset += 1;

			} else if (srt.charAt(k) == 'h') {

				TempArr = AddToArr(TempArr, HLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'i') {

				TempArr = AddToArr(TempArr, ILetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'j') {

				TempArr = AddToArr(TempArr, JLetter, 4, Xoffset);

				Xoffset += 1;

			} else if (srt.charAt(k) == 'k') {

				TempArr = AddToArr(TempArr, KLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'l') {

				TempArr = AddToArr(TempArr, LLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'm') {

				TempArr = AddToArr(TempArr, MLetter, 5, Xoffset);

				Xoffset += 2;

			} else if (srt.charAt(k) == 'n') {

				TempArr = AddToArr(TempArr, NLetter, 4, Xoffset);

				Xoffset += 1;
			} else if (srt.charAt(k) == 'o') {

				TempArr = AddToArr(TempArr, OLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'p') {

				TempArr = AddToArr(TempArr, PLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'q') {

				TempArr = AddToArr(TempArr, QLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'r') {

				TempArr = AddToArr(TempArr, RLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 's') {

				TempArr = AddToArr(TempArr, SLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 't') {

				TempArr = AddToArr(TempArr, TLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'u') {

				TempArr = AddToArr(TempArr, ULetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'v') {

				TempArr = AddToArr(TempArr, VLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'w') {

				TempArr = AddToArr(TempArr, WLetter, 5, Xoffset);

				Xoffset += 2;
			} else if (srt.charAt(k) == 'x') {

				TempArr = AddToArr(TempArr, XLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'y') {

				TempArr = AddToArr(TempArr, YLetter, 3, Xoffset);

			} else if (srt.charAt(k) == 'z') {

				TempArr = AddToArr(TempArr, ZLetter, 4, Xoffset);

				Xoffset += 1;
			} else if (srt.charAt(k) == ' ') {
				Xoffset -= 2;
				// space is too big number so I just sub 2 from offset

			} else if (srt.charAt(k) == '-') {

				TempArr = AddToArr(TempArr, DashLetter, 3, Xoffset);

			} else if (srt.charAt(k) == ':') {

				TempArr = AddToArr(TempArr, ColonLetter, 3, Xoffset);

			}

			Xoffset += 4;
		}
		return TempArr;
	}
}
