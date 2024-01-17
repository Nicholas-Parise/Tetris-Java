import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Blocks {

	public static int[][] LShape = { { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] L2Shape = { { 0, 2, 0, 0 }, { 0, 2, 0, 0 }, { 2, 2, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] SShape = { { 3, 0, 0, 0 }, { 3, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] ZShape = { { 0, 4, 0, 0 }, { 4, 4, 0, 0 }, { 4, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] IShape = { { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 } };

	public static int[][] SquShape = { { 6, 6, 0, 0 }, { 6, 6, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] TShape = { { 7, 0, 0, 0 }, { 7, 7, 0, 0 }, { 7, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public static int[][] SpriteShape = new int[4][4];

	public static int BlockPosition[][] = new int[4][4];

	public static int[][] GameMatrix = new int[20][10];

	public static int[][] TempGameMatrix = new int[20][10];

	private static int[] BlockQueue = new int[7];

	private static int[] BlockQueueNeg = { -1, -1, -1, -1, -1, -1, -1 };

	public static int CurrentShape = 0;

	public static int offsetX = 2;

	public static int offsetY = 0;

	public static int CurrentSymbol = 0;

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
	public static Boolean BlockHandler(int rotation) {
		// Handles Block rotations

		int temp = 0;
		int temp2 = 0;

		int[][] CurrentShapeTemp = new int[4][4];

		CurrentShapeTemp = GetCurrent();

		int[][] SpriteShapeTemp = new int[4][4];

		SpriteShape = new int[4][4];

		// rotation = "U";
		// rotation = "D";
		// rotation = "L";
		// rotation = "R";
		// [up][right]

		if (rotation == 0) {
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

			System.out.println("-Up-");

		} else if (rotation == 1) {

			// works
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (CurrentShapeTemp[i][j] != 0) {

						if (i == 0) {
							temp = 2;
						}
						if (i == 1) {
							temp = 1;
						}
						if (i == 2) {
							temp = 0;
						}
						if (i == 3) {
							temp = 0;
						}
						CurrentSymbol = CurrentShapeTemp[i][j];
						SpriteShapeTemp[j][temp] = CurrentSymbol;

					}
				}
			}

			System.out.println("-Down-");

		} else if (rotation == 2) {

			SpriteShapeTemp = GetCurrent();

			System.out.println("-Rigth-");

		} else if (rotation == 3) {
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
							temp = 2;
						}
						if (i == 1) {
							temp = 1;
						}
						if (i == 2) {
							temp = 0;
						}
						if (i == 3) {
							temp = 0;
						}
						CurrentSymbol = CurrentShapeTemp[i][j];
						SpriteShapeTemp[temp][temp2] = CurrentSymbol;

					}

				}
			}

			System.out.println("-Left-");

		}

		SpriteShape = SpriteShapeTemp;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				System.out.print(SpriteShape[i][j]);

			}
			System.out.println();
		}

		return true;
	}

	// returns true if can move left
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
					if (SpriteShape[i][j] != 0) {
						if (i + offsetY != LowestPointsY.get(k) && j + offsetX != LowestPointsX.get(k) - 1) {

							if (GameMatrix[LowestPointsY.get(k)][LowestPointsX.get(k) - 1] > 0
									&& TempGameMatrix[LowestPointsY.get(k)][LowestPointsX.get(k) - 1] == 0) {

								return false;
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

					if (SpriteShape[i][j] != 0) {
						if (i + offsetY != LowestPointsY.get(k) && j + offsetX != LowestPointsX.get(k) + 1
								&& TempGameMatrix[LowestPointsY.get(k)][LowestPointsX.get(k) + 1] == 0) {

							if (GameMatrix[LowestPointsY.get(k)][LowestPointsX.get(k) + 1] > 0) {

								return false;
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

					// System.out.println(offsetX + " " + offsetY);
					// System.out.println(temp2 + " " + temp);

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

					if (SpriteShape[i][j] != 0) {

						if (GameMatrix[LowestPointsY.get(k) + 1][LowestPointsX.get(k)] > 0
								&& TempGameMatrix[LowestPointsY.get(k) + 1][LowestPointsX.get(k)] == 0) {

							return true;
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
					TempGameMatrix[i + offsetY][j + offsetX] = SpriteShape[i][j];
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
				TempGameMatrix[i][j] = 0;
			}
		}
	}

	// removes the sprite from the Game matrix
	public static void DeleteLastPos() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					GameMatrix[i + offsetY][j + offsetX] = 0;
					TempGameMatrix[i + offsetY][j + offsetX] = 0;
				}
			}
		}
	}

	// Makes the sprite fall
	public static void Gravity() {

		if (!WhereFloor()) {
			System.out.println("Went Down");

			DeleteLastPos();

			offsetY++;
			UpdateMatrix();
		} else {
			System.out.println("Cant go down");
		}

	}

	// Makes the sprite go Right
	public static void GoRight() {

		if (CanRight()) {
			System.out.println("Went Right");

			DeleteLastPos();

			offsetX++;
			UpdateMatrix();
		} else {
			System.out.println("Cant go right");
		}
	}

	// Makes the sprite go left
	public static void GoLeft() {

		if (CanLeft()) {
			System.out.println("Went Left");

			DeleteLastPos();

			offsetX--;
			UpdateMatrix();
		} else {
			System.out.println("Cant go left");
		}
	}

	// Reverts the action done by block handler
	public static void PreviousRotation() {

		DeleteLastPos();

		if (BlockHandler(CurrentRotation)) {

			System.out.println("Rotate");

			UpdateMatrix();
		}

	}

	// makes the sprite rotate clockwise
	public static void ClockRotate() {

		// CurrentRotation

		if (CurrentShape != 5) {
			if (CurrentShape == 0 || CurrentShape == 1 || CurrentShape == 6) {

				if (CurrentRotation > 3) {
					CurrentRotation = 0;
				}
			} else {
				if (CurrentRotation > 1) {
					CurrentRotation = 0;
				}
			}
		}
		DeleteLastPos();

		if (BlockHandler(CurrentRotation)) {

			System.out.println("Rotate");

			UpdateMatrix();
			CurrentRotation++;
		} else {
			PreviousRotation();
		}

	}

	// makes the sprite rotate counter clockwise
	public static void CounterClockRotate() {

		// CurrentRotation
		if (CurrentShape != 5) {
			if (CurrentShape == 0 || CurrentShape == 1 || CurrentShape == 6) {

				if (CurrentRotation < 0) {
					CurrentRotation = 3;
				}
			} else {
				if (CurrentRotation < 0) {
					CurrentRotation = 1;
				}
			}
		}

		DeleteLastPos();

		if (BlockHandler(CurrentRotation)) {

			System.out.println("Rotate");

			UpdateMatrix();
			CurrentRotation--;
		} else {
			PreviousRotation();
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

					if (TryWhere == BlockQueue[j]) {

						Temp = true;
					}
				}

				if (BlockQueue[6] != -1) {
					break;
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

		if (BlockQueuePlace == 7) {
			BlockQueuePlace = 0;
		}

		CurrentShape = BlockQueue[BlockQueuePlace];

		SpriteShape = GetCurrent();

		BlockQueuePlace++;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				TempGameMatrix[i][j] = 0;
			}
		}

		offsetX = 2;
		offsetY = 0;
	}

}
