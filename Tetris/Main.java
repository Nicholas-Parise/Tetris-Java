import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Due Nov 11

public class Main extends JPanel {

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
			TimeUnit.SECONDS.sleep(2);
			Test = true;
		} catch (Exception e) {

		}

		do {

			Blocks.Gravity();

			// Blocks.PrintMatrix();


		if(Blocks.WhereFloor()){

			Blocks.NextBlock();
		}



			try {

				frame.validate();
				frame.repaint();

				TimeUnit.MILLISECONDS.sleep(100);
			} catch (Exception e) {
				System.out.println("Failed To draw");
			}

		} while (Test);

	}

	public void paint(Graphics g) {
		System.out.println("y");
		// colors

		Color colors[] = { new Color(0, 0, 0), new Color(255, 50, 50), new Color(50, 255, 50), new Color(50, 50, 255),
				new Color(225, 225, 50), new Color(225, 50, 225), new Color(50, 225, 225), new Color(250, 170, 0),
				new Color(255, 255, 255) };

		// black0,red1,green2,blue3,yellow4,purple5,cyan6,orange7,white8

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {

				int x = 20 * j + j + 100;
				int y = 20 * i + i;
				int width = 20;
				int height = 20;

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
				g.fillRect(x + 1, y + 1, width - 2, height - 2);

			}
		}

	}

}
