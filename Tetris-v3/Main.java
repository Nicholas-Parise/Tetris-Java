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
		frame.setTitle("PaintRepaint Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 600);
		frame.setVisible(true);

		frame.repaint();

		KeyBoard keyboard = new KeyBoard();

		keyboard.addKeyListener(keyboard);
		keyboard.setFocusable(true);
		frame.add(keyboard);
		frame.getKeyListeners();

		Blocks.ResetMatrix();

		// [Y][X]

		// Blocks.SpriteShape = Blocks.LShape;
		// Blocks.CurrentShape = 0;

		Blocks.MakeBlockQueue();
		Blocks.NextBlock();

		// Blocks.CurrentSymbol = 8;

		System.out.println();
		Blocks.BlockHandler("U");

		Blocks.UpdateMatrix();

		// Blocks.PrintMatrix();

		Boolean Test = false;

		int ran = 0;

		Blocks.MakeBlockQueue();

		try {
			TimeUnit.SECONDS.sleep(2);
			Test = true;
		} catch (Exception e) {

		}

		do {
			ran++;

			Blocks.Gravity();

			// Blocks.PrintMatrix();

			try {
				frame.validate();
				frame.repaint();
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (Exception e) {
				System.out.println("Failed To draw");
			}

		} while (Test);

	}

	public void update() {

		validate();
		repaint();
	}

//Renders stuff
	public void paint(Graphics g) {

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
