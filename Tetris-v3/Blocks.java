import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Blocks {

	public int BlockPosition[][] = new int[4][4];

	public static int offsetX = 2;
	public static int offsetY = 0;

	public static int[][] LShape = { { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] L2Shape = { { 0, 2, 0, 0 }, { 0, 2, 0, 0 }, { 2, 2, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] SShape = { { 3, 0, 0, 0 }, { 3, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] ZShape = { { 0, 4, 0, 0 }, { 4, 4, 0, 0 }, { 4, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] IShape = { { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 } };

	public static int[][] SquShape = { { 6, 6, 0, 0 }, { 6, 6, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] TShape = { { 7, 0, 0, 0 }, { 7, 7, 0, 0 }, { 7, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public static int CurrentShape = 0;

	public static int[][] SpriteShape = new int[4][4];

	public static int CurrentSymbol = 0;

	public static int[][] GameMatrix = new int[20][10];

	private static int[] BlockQueue = new int[7];

	private static int[] BlockQueueNeg = { -1, -1, -1, -1, -1, -1, -1 };

	private static int BlockQueuePlace = 0;

	private static int CurrentRotation = 0;

	// Returns current shape
	public static int[][] GetCurrent() {

		if (CurrentShape == 0) {

			return LShape;
		} else if (CurrentShape == 1) {

			return L2Shape;
		} else if (CurrentShape == 2) {

			return SShape;
		} else if (CurrentShape == 3) {

			return ZShape;
		} else if (CurrentShape == 4) {

			return IShape;
		} else if (CurrentShape == 5) {

			return SquShape;
		} else if (CurrentShape == 6) {

			return TShape;
		}

		return LShape;
	}

	// I don't know how yet but stop it from rotating into wall
	// return true; if it can rotate
	// return false; if it can't rotate
	public static Boolean BlockHandler(String rotation) {
		// Handles Block rotations

		int temp = 0;
		int temp2 = 0;

		int[][] CurrentShapeTemp = new int[4][4];

		CurrentShapeTemp = GetCurrent();

		int[][] SpriteShapeTemp = new int[4][4];

		SpriteShape = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				// System.out.print(CurrentShapeTemp[i][j]);

			}
			// System.out.println();
		}

		// rotation = "U";
		// rotation = "D";
		// rotation = "L";
		// rotation = "R";
		// [up][right]

		if (rotation == "U") {
			// works
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (CurrentShapeTemp[i][j] != 0) {

						if (j == 1)
							temp = 0;

						if (j == 0)
							temp = 1;
						CurrentSymbol = CurrentShapeTemp[i][j];

						SpriteShapeTemp[temp][i] = CurrentSymbol;

					}
				}
			}

		} else if (rotation == "D") {

			// works
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (CurrentShapeTemp[i][j] != 0) {

						if (i == 0) {
							temp = 3;
						}
						if (i == 1) {
							temp = 2;
						}
						if (i == 2) {
							temp = 1;
						}
						if (i == 3) {
							temp = 0;
						}
						CurrentSymbol = CurrentShapeTemp[i][j];
						SpriteShapeTemp[j][temp] = CurrentSymbol;

					}
				}
			}
		} else if (rotation == "L") {

			SpriteShapeTemp = GetCurrent();

		} else if (rotation == "R") {
			// Works
			for (int i = 0; i < 4; i++) {

				for (int j = 0; j < 2; j++) {

					if (CurrentShapeTemp[i][j] != 0) {

						if (j == 0) {
							temp2 = 1;
						}
						if (j == 1) {
							temp2 = 0;
						}

						if (i == 0) {
							temp = 3;
						}
						if (i == 1) {
							temp = 2;
						}
						if (i == 2) {
							temp = 1;
						}
						if (i == 3) {
							temp = 0;
						}
						CurrentSymbol = CurrentShapeTemp[i][j];
						SpriteShapeTemp[temp][temp2] = CurrentSymbol;

					}

				}
			}

		}

		SpriteShape = SpriteShapeTemp;

		return true;
	}

//returns true if can move left
	public static Boolean CanLeft() {

		ArrayList<Integer> LowestPointsY = new ArrayList<>();
		ArrayList<Integer> LowestPointsX = new ArrayList<>();

		int temp;
		int temp2;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					temp = i + Blocks.offsetY;
					temp2 = j + Blocks.offsetX;

					System.out.println(offsetX + " " + offsetY);
					System.out.println(temp2 + " " + temp);

					LowestPointsY.add(temp);
					LowestPointsX.add(temp2);

					if (temp2 == 0) {
						return false;
					}

				}
			}
		}

		// This part is broken and I don't know why

		for (int k = 0; k < LowestPointsY.size(); k++) {

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (Blocks.SpriteShape[i][j] != 0) {
						if (i + offsetY != LowestPointsY.get(k) && j + offsetX != LowestPointsX.get(k) - 1) {

							if (GameMatrix[LowestPointsY.get(k)][LowestPointsX.get(k) - 1] > 0) {

								// return false;
							}
						}

					}
				}
			}
		}

		return true;
	}

	// returns true if can move right
	public static Boolean CanRight() {

		ArrayList<Integer> LowestPointsY = new ArrayList<>();
		ArrayList<Integer> LowestPointsX = new ArrayList<>();

		int temp;
		int temp2;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					temp = i + Blocks.offsetY;
					temp2 = j + Blocks.offsetX;

					System.out.println(offsetX + " " + offsetY);
					System.out.println(temp2 + " " + temp);

					LowestPointsY.add(temp);
					LowestPointsX.add(temp2);

					if (temp2 == 9) {
						return false;
					}

				}
			}
		}

		// This part is broken and I don't know why
		for (int k = 0; k < LowestPointsY.size(); k++) {

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (Blocks.SpriteShape[i][j] != 0) {
						if (i + offsetY != LowestPointsY.get(k) && j + offsetX != LowestPointsX.get(k) + 1) {

							if (GameMatrix[LowestPointsY.get(k)][LowestPointsX.get(k) + 1] > 0) {

								// return false;
							}
						}

					}
				}
			}
		}
		return true;
	}

	// returns false if can move down
	public static Boolean WhereFloor() {

		ArrayList<Integer> LowestPointsY = new ArrayList<>();
		ArrayList<Integer> LowestPointsX = new ArrayList<>();

		int temp;
		int temp2;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					temp = i + Blocks.offsetY;
					temp2 = j + Blocks.offsetX;

					System.out.println(offsetX + " " + offsetY);
					System.out.println(temp2 + " " + temp);

					LowestPointsY.add(temp);
					LowestPointsX.add(temp2);

					if (temp > 18) {
						return true;
					}

				}
			}
		}

		// There is a bug where it reconises it's self as a floor

		for (int k = 0; k < LowestPointsY.size(); k++) {

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (Blocks.SpriteShape[i][j] != 0) {
						if (i + offsetY != LowestPointsY.get(k) + 1 && j + offsetX != LowestPointsX.get(k)) {

							if (GameMatrix[LowestPointsY.get(k) + 1][LowestPointsX.get(k)] > 0) {

								return true;
							}
						}

					}
				}
			}

		}

		return false;
	}

	// Updates the matrix to new position of sprite
	public static void UpdateMatrix() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					GameMatrix[i + offsetY][j + offsetX] = SpriteShape[i][j];
				}
			}
		}

	}

	// prints the game matrix to screen
	public static void PrintMatrix() {

		System.out.println();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(GameMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 0's out game matrix
	public static void ResetMatrix() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				GameMatrix[i][j] = 0;
			}
		}
	}

	// removes the sprite from the Game matrix
	public static void DeleteLastPos() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					GameMatrix[i + offsetY][j + offsetX] = 0;
				}
			}
		}
	}

	// Makes the sprite fall
	public static void Gravity() {

		if (!WhereFloor()) {
			System.out.println("Went");

			DeleteLastPos();

			offsetY++;
			UpdateMatrix();
		} else {
			System.out.println("Cant go");
		}

	}

	// Makes the sprite go Right
	public static void GoRight() {

		if (CanRight()) {
			System.out.println("Went");

			DeleteLastPos();

			offsetX++;
			UpdateMatrix();
		} else {
			System.out.println("Cant go");
		}
	}

	// Makes the sprite go left
	public static void GoLeft() {

		if (CanLeft()) {
			System.out.println("Went");

			DeleteLastPos();

			offsetX--;
			UpdateMatrix();
		} else {
			System.out.println("Cant go");
		}
	}

	// Reverts the action done by block handler
	public static void PreviousRotation() {

		DeleteLastPos();

		if (CurrentRotation == 0) {
			if (BlockHandler("U")) {

				System.out.println("Rotate");

				UpdateMatrix();
			}
		} else if (CurrentRotation == 1) {

			if (BlockHandler("R")) {

				System.out.println("Rotate");

				UpdateMatrix();
			}

		} else if (CurrentRotation == 2) {

			if (BlockHandler("D")) {

				System.out.println("Rotate");

				DeleteLastPos();
				UpdateMatrix();
			}

		} else if (CurrentRotation == 3) {

			if (BlockHandler("L")) {

				System.out.println("Rotate");

				UpdateMatrix();
			}

		}

	}

	// makes the sprite rotate clockwise
	public static void ClockRotate() {

		// CurrentRotation

		if (CurrentRotation == 4) {
			CurrentRotation = 0;
		}
		DeleteLastPos();

		if (CurrentRotation == 0) {
			if (BlockHandler("U")) {

				System.out.println("Rotate");

				UpdateMatrix();
				CurrentRotation++;
			} else {
				PreviousRotation();
			}
		} else if (CurrentRotation == 1) {

			if (BlockHandler("R")) {

				System.out.println("Rotate");

				UpdateMatrix();
				CurrentRotation++;
			} else {
				PreviousRotation();
			}

		} else if (CurrentRotation == 2) {

			if (BlockHandler("D")) {

				System.out.println("Rotate");

				DeleteLastPos();
				UpdateMatrix();
				CurrentRotation++;
			} else {
				PreviousRotation();
			}

		} else if (CurrentRotation == 3) {

			if (BlockHandler("L")) {

				System.out.println("Rotate");

				UpdateMatrix();
				CurrentRotation++;
			} else {
				PreviousRotation();
			}

		}

	}

	// makes the sprite rotate counter clockwise
	public static void CounterClockRotate() {

		// CurrentRotation

		if (CurrentRotation == -1) {
			CurrentRotation = 3;
		}
		DeleteLastPos();

		if (CurrentRotation == 0) {
			if (BlockHandler("U")) {

				System.out.println("Rotate");

				UpdateMatrix();
				CurrentRotation--;
			} else {
				PreviousRotation();
			}
		} else if (CurrentRotation == 1) {

			if (BlockHandler("R")) {

				System.out.println("Rotate");

				UpdateMatrix();
				CurrentRotation--;
			} else {
				PreviousRotation();
			}

		} else if (CurrentRotation == 2) {

			if (BlockHandler("D")) {

				System.out.println("Rotate");

				DeleteLastPos();
				UpdateMatrix();
				CurrentRotation--;
			} else {
				PreviousRotation();
			}

		} else if (CurrentRotation == 3) {

			if (BlockHandler("L")) {

				System.out.println("Rotate");

				UpdateMatrix();
				CurrentRotation--;
			} else {
				PreviousRotation();
			}

		}

	}

	// Creates Random Queue for the blocks
	public static void MakeBlockQueue() {

		BlockQueue = BlockQueueNeg;

		Random rand = new Random();

		int TryWhere = 0;

		Boolean Temp = false;

		for (int i = 0; i < 7; i++) {

			do {
				Temp = false;

				TryWhere = rand.nextInt(7);

				for (int j = 0; j < 7; j++) {

					if (TryWhere == BlockQueue[j] && BlockQueue[j] == -1) {
						Temp = true;
					}
				}

				for (int k = 0; k < 7; k++) {
					System.out.print(BlockQueue[k] + " ");
				}
				System.out.println();

			} while (Temp);

			if (Temp == false) {
				BlockQueue[i] = TryWhere;
			}

		}

		for (int i = 0; i < 7; i++) {
			System.out.print(BlockQueue[i] + " ");
		}
		System.out.println();

	}

	// changes the Sprite to a new shape
	public static void NextBlock() {

		CurrentShape = BlockQueue[BlockQueuePlace];

		SpriteShape = GetCurrent();

	}

}
