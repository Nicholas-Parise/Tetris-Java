import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.util.Scanner;

public class Main extends Canvas {

	public static int[][] GameMatrix = new int[20][10];

	public static void main(String[] args) {

		JFrame frame = new JFrame("My Drawing");
		Canvas canvas = new Main();
		canvas.setSize(500, 500);
		canvas.setBackground(new Color(80, 80, 80));

		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

		frame.repaint();

		String Input;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				GameMatrix[i][j] = 0;
			}
		}

		// [Y][X]

		Blocks.SpriteShape = Blocks.LShape;

		Blocks.CurrentShape = 0;

		Blocks.CurrentSymbol = 8;

		System.out.println();
		Blocks.BlockHandler("U");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (Blocks.SpriteShape[i][j] != 0) {

					GameMatrix[i + Blocks.offsetY][j + Blocks.offsetX] = Blocks.SpriteShape[i][j];
				}
			}
		}

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(GameMatrix[i][j] + " ");
			}
			System.out.println();
		}

		frame.repaint();
		frame.revalidate();

		GameMatrix[0][8] = 2;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(GameMatrix[i][j] + " ");
			}
			System.out.println();
		}

		Boolean Test = true;

		GameMatrix[5][8] = 2;

		int ran = 0;

		do {
			ran++;

			if (ran > 100) {
				System.out.println("It worked");
				GameMatrix[9][8] = 2;

			}

			frame.validate();
			frame.repaint();
			



		} while (Test);

	}

	public void update(){
    
        validate();
        repaint();
	}





	public int jesus = 0;

	public void paint(Graphics g) {
		jesus++;
		System.out.println(jesus);

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

				if (GameMatrix[i][j] != 0) {

					color = colors[6];
				} else {

					color = colors[8];
				}

				g.setColor(color);
				g.fillRect(x + 1, y + 1, width - 2, height - 2);

			}
		}

	}

}
