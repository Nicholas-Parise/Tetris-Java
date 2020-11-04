
public class Button {

	public static Boolean isButtonHover(int x, int y) {

		int buttonx = 140;
		int buttony = 450;
		int buttonWidth = 10 * 19 + 140;
		int buttonHeight = 10 * 9 + 450;

		if (x > buttonx && x < buttonWidth) {

			if (y > buttony && y < buttonHeight) {
				return true;
			}
		}

		return false;

	}

}
