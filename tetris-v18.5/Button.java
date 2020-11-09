
public class Button {

	public static Boolean isButtonHover(int x, int y, int buttonx, int buttony, int buttonWidth, int buttonHeight) {

		if (x > buttonx && x < buttonWidth) {

			if (y > buttony && y < buttonHeight) {
				return true;
			}
		}

		return false;
	}

}
