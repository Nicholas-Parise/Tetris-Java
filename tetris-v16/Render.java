import java.awt.*;
import javax.swing.*;

//This game deals with rendering

public class Render extends JPanel {

	public static JFrame frame = new JFrame();
	public static KeyBoard keyboard = new KeyBoard();
	public static Mouse mouse = new Mouse();

	public static int DeltaTitle = 0;

	private int[] ColorWave = new int[6];
	// colors
	private Color colors[] = { new Color(80, 80, 80), new Color(255, 255, 255), new Color(255, 50, 50),
			new Color(50, 255, 50), new Color(50, 50, 255), new Color(225, 225, 50), new Color(225, 50, 225),
			new Color(50, 225, 225), new Color(250, 170, 0), new Color(255, 50, 50, 50), new Color(50, 255, 50, 50),
			new Color(50, 50, 255, 50), new Color(225, 225, 50, 50), new Color(225, 50, 225, 50),
			new Color(50, 225, 225, 50), new Color(250, 170, 0, 50) };
	// Normal: black0,white1,red2,green3,blue4,yellow5,purple6,cyan7,orange8,
	// Lighter: red9,green10,blue11,yellow12,purple13,cyan14,orange15,

	private int[] ColorWave1 = { 2, 3, 4, 5, 6, 7 };
	private int[] ColorWave2 = { 7, 2, 3, 4, 5, 6 };
	private int[] ColorWave3 = { 6, 7, 2, 3, 4, 5 };
	private int[] ColorWave4 = { 5, 6, 7, 2, 3, 4 };
	private int[] ColorWave5 = { 4, 5, 6, 7, 2, 3 };
	private int[] ColorWave6 = { 3, 4, 5, 6, 7, 2 };

	public static void construc() {

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

	private void ArrayBuilder(Graphics g, int xOff, int yOff, int blockSize, int color, int[][] arr) {

		int numberOfColumns = arr[0].length;
		int numberOfRows = arr.length;

		for (int j = 0; j < numberOfColumns; j++) {
			for (int i = 0; i < numberOfRows; i++) {

				int x = blockSize * j + xOff;
				int y = blockSize * i + yOff;

				if (arr[i][j] != 0) {

					g.setColor(colors[color]);
					g.fillRect(x, y, blockSize, blockSize);
				}
			}
		}

	}

	public void paint(Graphics g) {

		g.setColor(colors[0]);
		g.fillRect(0, 0, 1000, 1000);

		if (GameStateManager.CurrentState != "GameOver") {

			if (GameStateManager.CurrentState == "Game" || GameStateManager.CurrentState == "Pause") {

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

				String HighscoreString = Integer.toString(ScoreManager.Highscore);
				String ScoreString = Integer.toString(ScoreManager.score);

				int[][] ScoreArr = AssetManager.AssetCreater(ScoreString);

				int[][] HighScoreArr = AssetManager.AssetCreater(HighscoreString);

				ArrayBuilder(g, 300, 250, 5, 1, ScoreArr);

				ArrayBuilder(g, 300, 400, 5, 1, HighScoreArr);

				ArrayBuilder(g, 300, 20, 5, 1, AssetManager.NextPieceText);

				// Box
				int xx = 300;
				int yy = 50;

				g.setColor(colors[1]);
				g.drawLine(xx, yy + 100 - 1, xx, yy);
				g.drawLine(xx, yy, xx + 100 - 1, yy);
				g.drawLine(xx + 1, yy + 100 - 1, xx + 100 - 1, yy + 100 - 1);
				g.drawLine(xx + 100 - 1, yy + 100 - 1, xx + 100 - 1, yy + 1);

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

				ArrayBuilder(g, 300, 200, 5, 2, AssetManager.ScoreText);

				ArrayBuilder(g, 300, 350, 5, 2, AssetManager.HighScoreText);

				if (GameStateManager.CurrentState == "Pause") {

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
				// Titele screen

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

				ArrayBuilder(g, 35, 300, 10, ColorWave[0], AssetManager.PressStart);

				////

				for (int j = 0; j < 19; j++) {
					for (int i = 0; i < 9; i++) {

						int x = 10 * j + 140;
						int y = 10 * i + 450;
						int width = 10;
						int height = 10;

						if (AssetManager.HelpButton[i][j] == 0) {

							if (Button.isButtonHover(Render.mouse.x, Render.mouse.y)) {
								g.setColor(colors[4]);

							} else {

								g.setColor(colors[0]);
							}
							g.fillRect(x, y, width, height);
						}

						if (AssetManager.HelpButton[i][j] == 1) {

							g.setColor(colors[4]);
							g.fillRect(x, y, width, height);
						}
						if (AssetManager.HelpButton[i][j] == 2) {

							g.setColor(colors[1]);
							g.fillRect(x, y, width, height);
						}

					}
				}

			} else if (GameStateManager.CurrentState == "Help") {
				// Help

				for (int j = 0; j < 19; j++) {
					for (int i = 0; i < 9; i++) {

						int x = 10 * j + 140;
						int y = 10 * i + 450;
						int width = 10;
						int height = 10;

						if (AssetManager.BackButton[i][j] == 0) {
//Back Button
							if (Button.isButtonHover(Render.mouse.x, Render.mouse.y)) {
								g.setColor(colors[4]);

							} else {

								g.setColor(colors[0]);
							}
							g.fillRect(x, y, width, height);
						}

						if (AssetManager.BackButton[i][j] == 1) {

							g.setColor(colors[4]);
							g.fillRect(x, y, width, height);
						}
						if (AssetManager.BackButton[i][j] == 2) {

							g.setColor(colors[1]);
							g.fillRect(x, y, width, height);
						}

					}
				}
				//// ------------

				ArrayBuilder(g, 30, 20, 10, ColorWave[0], AssetManager.KeyBindings);

				/// -------------

				ArrayBuilder(g, 30, 100, 5, 1, AssetManager.Arrow);

				ArrayBuilder(g, 100, 110, 5, ColorWave[0], AssetManager.TextCRotation);

				/// -------------
				for (int j = 0; j < 9; j++) {
					for (int i = 0; i < 9; i++) {
						// Down Arrow

						int x = 5 * j + 30;
						int y = 5 * i + 150;
						int width = 5;
						int height = 5;

						int temp = 0;

						if (i == 8) {
							temp = 0;
						} else if (i == 7) {
							temp = 1;
						} else if (i == 6) {
							temp = 2;
						} else if (i == 5) {
							temp = 3;
						} else if (i == 4) {
							temp = 4;
						} else if (i == 3) {
							temp = 5;
						} else if (i == 2) {
							temp = 6;
						} else if (i == 1) {
							temp = 7;
						} else if (i == 0) {
							temp = 8;
						}

						if (AssetManager.Arrow[temp][j] != 0) {

							g.setColor(colors[1]);
							g.fillRect(x, y, width, height);
						}
					}
				}

				ArrayBuilder(g, 100, 160, 5, ColorWave[0], AssetManager.TextRotation);

				/// --------------

				for (int j = 0; j < 9; j++) {
					for (int i = 0; i < 9; i++) {
						// left Arrow
						int x = 5 * j + 30;
						int y = 5 * i + 200;
						int width = 5;
						int height = 5;

						if (AssetManager.Arrow[j][i] != 0) {

							g.setColor(colors[1]);
							g.fillRect(x, y, width, height);
						}
					}
				}

				ArrayBuilder(g, 100, 210, 5, ColorWave[0], AssetManager.LeftText);

				/// -------------

				for (int j = 0; j < 9; j++) {
					for (int i = 0; i < 9; i++) {
						// Right Arrow

						int x = 5 * j + 30;
						int y = 5 * i + 250;
						int width = 5;
						int height = 5;

						int temp = 0;

						if (j == 8) {
							temp = 0;
						} else if (j == 7) {
							temp = 1;
						} else if (j == 6) {
							temp = 2;
						} else if (j == 5) {
							temp = 3;
						} else if (j == 4) {
							temp = 4;
						} else if (j == 3) {
							temp = 5;
						} else if (j == 2) {
							temp = 6;
						} else if (j == 1) {
							temp = 7;
						} else if (j == 0) {
							temp = 8;
						}

						if (AssetManager.Arrow[temp][i] != 0) {

							g.setColor(colors[1]);
							g.fillRect(x, y, width, height);
						}
					}
				}

				ArrayBuilder(g, 100, 260, 5, ColorWave[0], AssetManager.RightText);
				// ----------

				ArrayBuilder(g, 30, 300, 5, 1, AssetManager.Enter);

				ArrayBuilder(g, 150, 310, 5, ColorWave[0], AssetManager.DownText);
				// --------------

				ArrayBuilder(g, 30, 350, 5, 1, AssetManager.Esc);

				ArrayBuilder(g, 120, 360, 5, ColorWave[0], AssetManager.PauseText);
				// --------------

			} else if (GameStateManager.CurrentState == "Splash") {
				// splash screen

				ArrayBuilder(g, 50, 450, 10, 4, AssetManager.CreditNick);

				ArrayBuilder(g, 300, 450, 10, 1, AssetManager.CreditSile);

				ArrayBuilder(g, 5, 250, 5, 1, AssetManager.Company);

				int[][] SplashMatrix = { { 0, 2, 0 }, { 1, 2, 2 }, { 1, 0, 2 }, { 1, 1, 0 } };

				int[][] SplashMatrix2 = { { 0, 0, 0 }, { 1, 2, 0 }, { 1, 2, 2 }, { 1, 1, 2 } };

				// ArrayBuilder(g, 200, 50, 40, 2, Blocks.LShape);

				for (int j = 0; j < 3; j++) {
					for (int i = 0; i < 4; i++) {

						int x = 30 * j + 220;
						int y = 30 * i + 120;
						int width = 30;
						int height = 30;

						if (SplashMatrix[i][j] == 0) {
							g.setColor(colors[1]);
						} else if (SplashMatrix[i][j] == 1) {
							g.setColor(colors[2]);
						} else if (SplashMatrix[i][j] == 2) {
							g.setColor(colors[3]);
						}

						g.drawLine(x, y + height - 1, x, y);
						g.drawLine(x, y, x + height - 1, y);
						g.drawLine(x + 1, y + height - 1, x + height - 1, y + height - 1);
						g.drawLine(x + height - 1, y + height - 1, x + height - 1, y + 1);

					}
				}
			}

		} else {

			// Game Over

			ArrayBuilder(g, 13, 150, 13, 2, AssetManager.GameOverText);

			if (ScoreManager.NewHighScore) {

				ArrayBuilder(g, 40, 250, 8, 2, AssetManager.NewHighScoreText);

			}

		}

		// g.drawString("Hello to JavaTutorial.net", 10, 10);

		// https://javatutorial.net/display-text-and-graphics-java-jframe

	}

	public static void Update() {

		frame.validate();
		frame.repaint();

	}

}