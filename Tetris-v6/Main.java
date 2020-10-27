import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

// Due Nov 11

public class Main extends JPanel {

	
	public static int score = 0;


	public static ArrayList<ArrayList<Integer>> ScreBlocks = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.getContentPane().add(new Main());

		frame.setTitle("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.red);

		frame.setLocationRelativeTo(null);
		frame.setSize(500, 600);
		frame.setVisible(true);

		KeyBoard keyboard = new KeyBoard();

		keyboard.addKeyListener(keyboard);
		keyboard.setFocusable(true);
		frame.add(keyboard);
		frame.getKeyListeners();

		frame.validate();
		frame.repaint();

		Blocks.ResetMatrix();

		// [Y][X]

		Blocks.MakeBlockQueue();
		Blocks.NextBlock();

		System.out.println();
		Blocks.BlockHandler(0);

		Blocks.UpdateMatrix();

		// Blocks.PrintMatrix();

		Boolean Test = false;

		Blocks.MakeBlockQueue();

		try {
			TimeUnit.SECONDS.sleep(1);
			Test = true;
		} catch (Exception e) {

		}

		// int[][] ScoreArr = AssetManager.AssetCreater("915616846531");

		// AssetManager.AssetCreater("915616846531");

		int fallTimer = 0;
		int floorTimer = 0;

		long last_time = System.nanoTime();
		long time = 0;
		int delta_time = 0;
		do {

			time = System.nanoTime();
			delta_time = (int) ((time - last_time) / 1000000);
			last_time = time;

			if (fallTimer > 500) {
				Blocks.Gravity();
				fallTimer = 0;
			} else {
				fallTimer += delta_time;
			}

			// Blocks.PrintMatrix();

			if (Blocks.WhereFloor()) {

				if (floorTimer > 500) {

					GameLogic.FullRow();

					Blocks.CanMove = false;

					if (floorTimer > 800) {
						Blocks.NextBlock();
						floorTimer = 0;
						Blocks.CanMove = true;
						score +=10;
					} else {
						floorTimer += delta_time;
					}

				} else {
					floorTimer += delta_time;
				}

			} else {
				floorTimer = 0;
			}

			try {

				frame.validate();
				frame.repaint();

				TimeUnit.MILLISECONDS.sleep(10);
			} catch (Exception e) {
				System.out.println("Failed To draw");
			}

		} while (Test);

	}

	public void paint(Graphics g) {
		// colors

		Color colors[] = { new Color(80, 80, 80), new Color(255, 50, 50), new Color(50, 255, 50),
				new Color(50, 50, 255), new Color(225, 225, 50), new Color(225, 50, 225), new Color(50, 225, 225),
				new Color(250, 170, 0), new Color(255, 255, 255) };

		// black0,red1,green2,blue3,yellow4,purple5,cyan6,orange7,white8

		g.setColor(colors[0]);
		g.fillRect(0, 0, 1000, 1000);

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {

				int x = 25 * j + (j + 25);
				int y = 25 * i + (i+25);
				int width = 25;
				int height = 25;

				var color = colors[0];

				if (Blocks.GameMatrix[i][j] != 0) {

					if (Blocks.GameMatrix[i][j] == 1) {

						color = colors[1];
					} else if (Blocks.GameMatrix[i][j] == 2) {
						color = colors[2];
					} else if (Blocks.GameMatrix[i][j] == 3) {
						color = colors[3];
					} else if (Blocks.GameMatrix[i][j] == 4) {
						color = colors[4];
					} else if (Blocks.GameMatrix[i][j] == 5) {
						color = colors[5];
					} else if (Blocks.GameMatrix[i][j] == 6) {
						color = colors[6];
					} else if (Blocks.GameMatrix[i][j] == 7) {
						color = colors[7];
					}

				} else {

					color = colors[8];
				}
				g.setColor(color);
				g.fillRect(x, y, width, height);

			}
		}

		/////

		
		String ScoreString= Integer.toString(score);


		int[][] ScoreArr = AssetManager.AssetCreater(ScoreString);

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < ScoreString.length()+(ScoreString.length()*3); i++) {

				int x = 5 * j + 200;
				int y = 5 * i + 350;
				int width = 5;
				int height = 5;

				var color = colors[1];

				if (ScoreArr[i][j] != 0) {

					g.setColor(color);
					g.fillRect(y, x, width, height);

				}
			}
		}

		g.drawString("Hello to JavaTutorial.net", 10, 10);

		// https://javatutorial.net/display-text-and-graphics-java-jframe

	}

}
