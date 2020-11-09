import java.awt.*;
import javax.swing.*;

//This class deals with rendering

public class Render extends JPanel {

	// colors
	private Color colors[] = { new Color(80, 80, 80), new Color(255, 255, 255), new Color(255, 50, 50),
			new Color(50, 255, 50), new Color(50, 50, 255), new Color(225, 225, 50), new Color(225, 50, 225),
			new Color(50, 225, 225), new Color(250, 170, 0), new Color(255, 50, 50, 50), new Color(50, 255, 50, 50),
			new Color(50, 50, 255, 50), new Color(225, 225, 50, 50), new Color(225, 50, 225, 50),
			new Color(50, 225, 225, 50), new Color(250, 170, 0, 50) };
	// Normal: black0,white1,red2,green3,blue4,yellow5,purple6,cyan7,orange8,
	// Lighter: red9,green10,blue11,yellow12,purple13,cyan14,orange15,

	private static int DeltaTitle = 0;
	private static int SplashFall = 0;

	private int[] ColorWave = new int[6];

	private int[] ColorWave1 = { 2, 3, 4, 5, 6, 7 };
	private int[] ColorWave2 = { 7, 2, 3, 4, 5, 6 };
	private int[] ColorWave3 = { 6, 7, 2, 3, 4, 5 };
	private int[] ColorWave4 = { 5, 6, 7, 2, 3, 4 };
	private int[] ColorWave5 = { 4, 5, 6, 7, 2, 3 };
	private int[] ColorWave6 = { 3, 4, 5, 6, 7, 2 };

	private int[][] TempMatrix = new int[5][3];

	public static JFrame frame = new JFrame();
	public static KeyBoard keyboard = new KeyBoard();
	public static Mouse mouse = new Mouse();

	public static void construc() {
		// inits variables

		frame.getContentPane().add(new Render());

		frame.setTitle("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.red);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 600);
		frame.setVisible(true);

		keyboard.addKeyListener(keyboard);
		keyboard.setFocusable(true);

		mouse.addMouseListener(mouse);
		mouse.addMouseMotionListener(mouse);
		mouse.setFocusable(true);

		frame.add(keyboard);
		frame.add(mouse);
		frame.getKeyListeners();

	}

	private void ArrayBuilder(Graphics g, int xOff, int yOff, int blockSize, int color, int colors2, int color3,
			int[][] arr) {
		// Takes nessisary variables and draws an array

		int numberOfColumns = arr[0].length;
		int numberOfRows = arr.length;

		for (int j = 0; j < numberOfColumns; j++) {
			for (int i = 0; i < numberOfRows; i++) {

				int x = blockSize * j + xOff;
				int y = blockSize * i + yOff;

				if (arr[i][j] == 1) {
					g.setColor(colors[color]);
				} else if (arr[i][j] == 2) {
					g.setColor(colors[colors2]);
				} else if (arr[i][j] == 0) {
					g.setColor(colors[color3]);
				}

				g.fillRect(x, y, blockSize, blockSize);
			}
		}
	}

	private void WireBox(Graphics g, int xOff, int yOff, int Width, int Height, int color) {

		g.setColor(colors[color]);

		g.drawLine(xOff, yOff + Width - 1, xOff, yOff);
		g.drawLine(xOff, yOff, xOff + Height - 1, yOff);
		g.drawLine(xOff + 1, yOff + Width - 1, xOff + Height - 1, yOff + Width - 1);
		g.drawLine(xOff + Height - 1, yOff + Width - 1, xOff + Height - 1, yOff + 1);

	}

	public static void Delta(int time) {
		// uses delta-time to add to the falling and title

		if (DeltaTitle > 2400) {
			DeltaTitle = 0;
		}

		DeltaTitle += time;
		SplashFall += time;
	}

	public void paint(Graphics g) {

		if (SplashFall < 400) {
			TempMatrix = AssetManager.SplashMatrix;
		} else if (SplashFall > 400 && SplashFall < 800) {
			TempMatrix = AssetManager.SplashMatrix1;
		} else if (SplashFall > 800 && SplashFall < 1200) {
			TempMatrix = AssetManager.SplashMatrix2;
		} else if (SplashFall > 1200 && SplashFall < 1600) {
			TempMatrix = AssetManager.SplashMatrix3;
		} else if (SplashFall > 1600) {
			TempMatrix = AssetManager.SplashMatrix4;
		}

		// -------------

		// background
		g.setColor(colors[0]);
		g.fillRect(0, 0, 1000, 1000);

		if (GameStateManager.CurrentState != "GameOver") {

			if (GameStateManager.CurrentState == "Game" || GameStateManager.CurrentState == "Pause") {

				// Game matrix

				for (int i = 0; i < 20; i++) {
					for (int j = 0; j < 10; j++) {

						int x = 25 * j + (j + 25);
						int y = 25 * i + (i + 25);
						int width = 25;
						int height = 25;

						var color = colors[0];

						if (Blocks.GameMatrix[i][j] != 0) {

							if (Blocks.GameMatrix[i][j] == 1) {

								color = colors[2];
							} else if (Blocks.GameMatrix[i][j] == 2) {
								color = colors[3];
							} else if (Blocks.GameMatrix[i][j] == 3) {
								color = colors[4];
							} else if (Blocks.GameMatrix[i][j] == 4) {
								color = colors[5];
							} else if (Blocks.GameMatrix[i][j] == 5) {
								color = colors[6];
							} else if (Blocks.GameMatrix[i][j] == 6) {
								color = colors[7];
							} else if (Blocks.GameMatrix[i][j] == 7) {
								color = colors[8];
							}

						} else {

							if (Blocks.FuturePosition[i][j] == 1) {
								color = colors[9];
							} else if (Blocks.FuturePosition[i][j] == 2) {
								color = colors[10];
							} else if (Blocks.FuturePosition[i][j] == 3) {
								color = colors[11];
							} else if (Blocks.FuturePosition[i][j] == 4) {
								color = colors[12];
							} else if (Blocks.FuturePosition[i][j] == 5) {
								color = colors[13];
							} else if (Blocks.FuturePosition[i][j] == 6) {
								color = colors[14];
							} else if (Blocks.FuturePosition[i][j] == 7) {
								color = colors[15];
							} else {
								color = colors[1];
							}

						}
						g.setColor(color);
						g.fillRect(x, y, width, height);

					}
				}

				/////

				// score and high score
				String HighscoreString = Integer.toString(ScoreManager.Highscore);
				String ScoreString = Integer.toString(ScoreManager.score);

				int[][] ScoreArr = AssetManager.AssetCreater(ScoreString);
				int[][] HighScoreArr = AssetManager.AssetCreater(HighscoreString);

				ArrayBuilder(g, 300, 250, 5, 1, 0, 0, ScoreArr);

				ArrayBuilder(g, 300, 400, 5, 1, 0, 0, HighScoreArr);

				ArrayBuilder(g, 288, 20, 5, 1, 0, 0, AssetManager.NextPieceText);

				ArrayBuilder(g, 288, 200, 5, 2, 0, 0, AssetManager.ScoreText);

				ArrayBuilder(g, 288, 350, 5, 2, 0, 0, AssetManager.HighScoreText);

				// Box

				WireBox(g, 300, 50, 100, 100, 1);

				// Next block
				for (int j = 0; j < 4; j++) {
					for (int i = 0; i < 4; i++) {

						int x = 20 * j + (j + 310);
						int y = 20 * i + (i + 60);
						int width = 20;
						int height = 20;

						var color = colors[0];

						if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] != 0) {

							if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 1) {

								color = colors[2];
							} else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 2) {
								color = colors[3];
							} else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 3) {
								color = colors[4];
							} else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 4) {
								color = colors[5];
							} else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 5) {
								color = colors[6];
							} else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 6) {
								color = colors[7];
							} else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 7) {
								color = colors[8];
							}

							g.setColor(color);
							g.fillRect(x, y, width, height);
						}
					}
				}
				// ------------

				if (GameStateManager.CurrentState == "Pause") {

					// pause blocks

					for (int j = 0; j < 6; j++) {
						for (int i = 0; i < 4; i++) {

							int x = 25 * j + (j + 25 + 50 + 2);
							int y = 25 * i + (i + 25 + 150 + 6);
							int width = 25;
							int height = 25;

							if (AssetManager.Pause[i][j] != 0) {

								g.setColor(colors[0]);
								g.fillRect(x, y, width, height);
							}
						}
					}

				}

			} else if (GameStateManager.CurrentState == "Menu") {

				if (DeltaTitle > 2000) {
					ColorWave = ColorWave6;
				} else if (DeltaTitle > 1600) {
					ColorWave = ColorWave5;
				} else if (DeltaTitle > 1200) {
					ColorWave = ColorWave4;
				} else if (DeltaTitle > 800) {
					ColorWave = ColorWave3;
				} else if (DeltaTitle > 400) {
					ColorWave = ColorWave2;
				} else {
					ColorWave = ColorWave1;
				}

				// Title screen
				for (int j = 0; j < 23; j++) {
					for (int i = 0; i < 5; i++) {

						int x = 20 * j + 10;
						int y = 20 * i + 100;
						int width = 20;
						int height = 20;

						var color = colors[2];

						if (j < 3) {
							color = colors[ColorWave[0]];
						} else if (j > 3 && j < 7) {
							color = colors[ColorWave[1]];
						} else if (j > 6 && j < 11) {
							color = colors[ColorWave[2]];
						} else if (j > 11 && j < 16) {
							color = colors[ColorWave[3]];
						} else if (j > 15 && j < 20) {
							color = colors[ColorWave[4]];
						} else if (j > 19) {
							color = colors[ColorWave[5]];
						}

						if (AssetManager.Title[i][j] != 0) {

							g.setColor(color);
							g.fillRect(x, y, width, height);
						}
					}
				}

				// ArrayBuilder(g, 35, 300, 10, ColorWave[0], 0, 0, AssetManager.PressStart);

				// start Button
				if (Button.isButtonHover(mouse.x, mouse.y, 120, 280, 350, 370)) {

					ArrayBuilder(g, 120, 280, 10, ColorWave[0], 1, ColorWave[0], AssetManager.StartButton);
				} else {
					ArrayBuilder(g, 120, 280, 10, ColorWave[0], 1, 0, AssetManager.StartButton);
				}

				// Help Button
				if (Button.isButtonHover(mouse.x, mouse.y, 140, 450, 350, 540)) {

					ArrayBuilder(g, 140, 450, 10, 4, 1, 4, AssetManager.HelpButton);
				} else {
					ArrayBuilder(g, 140, 450, 10, 4, 1, 0, AssetManager.HelpButton);
				}

				// ---------------------------

			} else if (GameStateManager.CurrentState == "Help") {
				// Help

				// Back Button
				if (Button.isButtonHover(mouse.x, mouse.y, 140, 450, 350, 540)) {

					ArrayBuilder(g, 140, 450, 10, 4, 1, 4, AssetManager.BackButton);
				} else {
					ArrayBuilder(g, 140, 450, 10, 4, 1, 0, AssetManager.BackButton);
				}

				// prints the Key bindings

				//// ------------

				ArrayBuilder(g, 5, 20, 10, ColorWave[0], 0, 0, AssetManager.KeyBindings);

				/// -------------

				ArrayBuilder(g, 30, 100, 5, 1, 0, 0, AssetManager.Arrow);
				ArrayBuilder(g, 100, 110, 5, ColorWave[0], 0, 0, AssetManager.TextCRotation);

				/// -------------

				ArrayBuilder(g, 30, 150, 5, 1, 0, 0, AssetManager.ArrowDown);
				ArrayBuilder(g, 100, 160, 5, ColorWave[0], 0, 0, AssetManager.TextRotation);

				/// --------------

				ArrayBuilder(g, 30, 200, 5, 1, 0, 0, AssetManager.ArrowLeft);
				ArrayBuilder(g, 100, 210, 5, ColorWave[0], 0, 0, AssetManager.LeftText);

				/// -------------
				ArrayBuilder(g, 30, 250, 5, 1, 0, 0, AssetManager.ArrowRight);
				ArrayBuilder(g, 100, 260, 5, ColorWave[0], 0, 0, AssetManager.RightText);
				// ----------

				ArrayBuilder(g, 30, 300, 5, 1, 0, 0, AssetManager.Enter);
				ArrayBuilder(g, 150, 310, 5, ColorWave[0], 0, 0, AssetManager.DownText);
				// --------------

				ArrayBuilder(g, 30, 350, 5, 1, 0, 0, AssetManager.Esc);
				ArrayBuilder(g, 120, 360, 5, ColorWave[0], 0, 0, AssetManager.PauseText);
				// --------------

			} else if (GameStateManager.CurrentState == "Splash") {
				// splash screen

				// credits and company name
				ArrayBuilder(g, 50, 450, 10, 4, 0, 0, AssetManager.CreditNick);

				ArrayBuilder(g, 300, 450, 10, 1, 0, 0, AssetManager.CreditSile);

				ArrayBuilder(g, 5, 250, 5, 1, 0, 0, AssetManager.Company);

				// falling animation

				for (int j = 0; j < 3; j++) {
					for (int i = 0; i < 5; i++) {

						int x = 30 * j + 200;
						int y = 30 * i + 80;
						int height = 30;

						if (TempMatrix[i][j] == 0) {
							g.setColor(colors[1]);
						} else if (TempMatrix[i][j] == 1) {
							g.setColor(colors[2]);
						} else if (TempMatrix[i][j] == 2) {
							g.setColor(colors[3]);
						}

						g.drawLine(x, y + height - 1, x, y);
						g.drawLine(x, y, x + height - 1, y);
						g.drawLine(x + 1, y + height - 1, x + height - 1, y + height - 1);
						g.drawLine(x + height - 1, y + height - 1, x + height - 1, y + 1);
					}
				}

				// ----------

			} else if (GameStateManager.CurrentState == "Next") {

				ArrayBuilder(g, 50, 200, 10, 1, 0, 0, AssetManager.NextLevel);

				// level
				String Level = Integer.toString(Blocks.level);

				int[][] LevelArr = AssetManager.AssetCreater(Level);

				ArrayBuilder(g, 150, 300, 10, 1, 0, 0, LevelArr);
				// -------------
			}

		} else {
			// Game Over

			ArrayBuilder(g, 13, 150, 13, 2, 0, 0, AssetManager.GameOverText);
			// say game over
			if (ScoreManager.NewHighScore) {
				// if there is a new high score
				// say there is a new high score

				ArrayBuilder(g, 25, 250, 8, 2, 0, 0, AssetManager.NewHighScoreText);

				ArrayBuilder(g, 50, 350, 8, 2, 0, 0, AssetManager.EnterName);

				ArrayBuilder(g, 50, 500, 5, 2, 0, 0, AssetManager.EnterToEnd);

				int[][] InputArr = AssetManager.AssetCreater(ScoreManager.InputString);

				ArrayBuilder(g, 50, 400, 10, 1, 0, 0, InputArr);

				String str = ScoreManager.InputString.substring(0, ScoreManager.CurrentLetter + 1);

				String str2 = ScoreManager.InputString.substring(0, ScoreManager.CurrentLetter);

				int Temp1 = AssetManager.ArrLength(str);

				int Temp2 = AssetManager.ArrLength(str2);

				int Temp3 = Temp1 - Temp2;

				WireBox(g, ((Temp2 * 10) + 50), 400, 53, Temp3 * 10 - 10, 4);

			}

		}
	}

	public static void Update() {
		// updates the render window
		frame.validate();
		frame.repaint();

	}

}