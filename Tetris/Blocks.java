import java.util.Random;
import java.util.ArrayList;

public class Blocks {

	// Shapes

	public static int[][] LShape = { { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 0 } };

	private static int[][] L2Shape = { { 0, 2, 0, 0 }, { 0, 2, 0, 0 }, { 2, 2, 0, 0 }, { 0, 0, 0, 0 } };

	private static int[][] SShape = { { 3, 0, 0, 0 }, { 3, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } };

	private static int[][] ZShape = { { 0, 4, 0, 0 }, { 4, 4, 0, 0 }, { 4, 0, 0, 0 }, { 0, 0, 0, 0 } };

	private static int[][] IShape = { { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 } };

	private static int[][] SquShape = { { 6, 6, 0, 0 }, { 6, 6, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	private static int[][] TShape = { { 7, 0, 0, 0 }, { 7, 7, 0, 0 }, { 7, 0, 0, 0 }, { 0, 0, 0, 0 } };

	// private Variables

	private static int[][] SpriteShape = new int[4][4];

	private static int[][] OldSpriteShape = new int[4][4];

	private static int[][] TempGameMatrix = new int[20][10];

	private static int[] BlockQueueNeg = { -1, -1, -1, -1, -1, -1, -1 };

	private static int CurrentShape = 0;

	private static int CurrentSymbol = 0;

	private static int CurrentRotation = 0;

	private static int fallTimer = 0;

	private static int floorTimer = 0;

	// public Variables

	public static int[][] GameMatrix = new int[20][10];

	public static int[][] FuturePosition = new int[20][10];

	public static int[] BlockQueue = new int[7];

	public static int offsetX = 2;

	public static int offsetY = 0;

	public static Boolean CanMove = true;

	public static int BlockQueuePlace = 0;

	public static int Fallen = 0;

	public static int level = 1;

	// --------------------------------------

	// Returns current shape
	public static int[][] GetCurrent(int Shape) {

		if (Shape == 0) {

			return LShape;
		} else if (Shape == 1) {

			return L2Shape;
		} else if (Shape == 2) {

			return SShape;
		} else if (Shape == 3) {

			return ZShape;
		} else if (Shape == 4) {

			return IShape;
		} else if (Shape == 5) {

			return SquShape;
		} else if (Shape == 6) {

			return TShape;
		}

		return LShape;
	}

	// Handles Block rotations
	private static Boolean BlockHandler(int rotation) {

		// return true; if it can rotate
		// return false; if it can't rotate

		int temp = 0;
		int temp2 = 0;

		int[][] CurrentShapeTemp = GetCurrent(CurrentShape);

		int[][] SpriteShapeTemp = new int[4][4];

		OldSpriteShape = SpriteShape;

		if (rotation == 3) {
			// Left Rotation
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (CurrentShapeTemp[i][j] != 0) {

						if (j + offsetY > 19 || i + offsetX > 9 || i + offsetX < 0) {
							return false;
						}

						if (j == 1)
							temp = 0;

						if (j == 0)
							temp = 1;

						CurrentSymbol = CurrentShapeTemp[i][j];

						SpriteShapeTemp[temp][i] = CurrentSymbol;
					}
				}
			}

			System.out.println("-Left-");

		} else if (rotation == 1) {

			// right Rotation
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (CurrentShapeTemp[i][j] != 0) {

						if (j + offsetY > 19 || i + offsetX > 9 || i + offsetX < 0) {
							return false;
						}

						if (CurrentShape != 4) {

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

						} else {

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

						}

						CurrentSymbol = CurrentShapeTemp[i][j];
						SpriteShapeTemp[j][temp] = CurrentSymbol;
					}
				}
			}

			System.out.println("-Rigth-");

		} else if (rotation == 0) {
			// Up Rotation
			SpriteShapeTemp = GetCurrent(CurrentShape);

			System.out.println("-Up-");

		} else if (rotation == 2) {
			// down Rotation
			for (int i = 0; i < 4; i++) {

				for (int j = 0; j < 4; j++) {

					if (j + offsetY > 19 || i + offsetX > 9 || i + offsetX < 0) {
						return false;
					}

					if (CurrentShapeTemp[i][j] != 0) {

						if (j == 0) {
							temp2 = 1;
						}
						if (j == 1) {
							temp2 = 0;
						}

						if (CurrentShape != 4) {

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

						} else {

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

						}

						CurrentSymbol = CurrentShapeTemp[i][j];
						SpriteShapeTemp[temp][temp2] = CurrentSymbol;
					}
				}
			}

			System.out.println("-Down-");
		}

		// test if rotates into another block
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShapeTemp[i][j] != 0) {

					// if it does return false
					if (GameMatrix[i + offsetY][j + offsetX] > 0) {

						return false;
					}
				}
			}
		}

		// if it passes all the other tests reset sprite shape and make it equal to
		// sprite shape temp

		SpriteShape = SpriteShapeTemp;

		return true;
	}

	// returns true if can move left
	public static Boolean CanLeft() {
		// returns false if can't
		// returns true if can
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

					// make sure it's not going into wall
					if (temp2 == 0) {
						return false;
					}
				}
			}
		}

		// Tests if it will go through a shape
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
		// returns false if can't
		// returns true if can

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
					// make sure it's not going into wall
					if (temp2 == 9) {
						return false;
					}
				}
			}
		}

		// Tests if it will go through a shape
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
	public static Boolean WhereFloor(int ShapeOffsetx, int ShapeOffsety) {

		ArrayList<Integer> LowestPointsY = new ArrayList<>();
		ArrayList<Integer> LowestPointsX = new ArrayList<>();

		int temp;
		int temp2;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					temp = i + ShapeOffsety;
					temp2 = j + ShapeOffsetx;

					LowestPointsY.add(temp);
					LowestPointsX.add(temp2);
					// tests if on floor
					if (temp > 18) {
						return true;
					}
				}
			}
		}
		// Tests if it will go through a shape
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
	private static void UpdateMatrix() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					if (GameMatrix[i + offsetY][j + offsetX] > 0 && offsetY < 2) {
						// if a shape is in another shape and the height is less than 2
						// game over
						System.out.println("Game over");

						GameStateManager.StartEnd();
					}

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
	private static void ResetMatrix() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				GameMatrix[i][j] = 0;
				TempGameMatrix[i][j] = 0;
			}
		}
	}

	// Showes the future position of the shape
	public static void ShowFuture() {

		int tempOffY = offsetY;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				FuturePosition[i][j] = 0;
			}
		}

		while (!WhereFloor(offsetX, tempOffY) && tempOffY < 20) {

			tempOffY++;
			// finds floor
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					FuturePosition[i + tempOffY][j + offsetX] = SpriteShape[i][j];
				}
			}
		}
	}

	// removes the sprite from the Game matrix
	private static void DeleteLastPos() {

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

		if (!WhereFloor(offsetX, offsetY)) {
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

		if (CanRight() && CanMove) {
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

		if (CanLeft() && CanMove) {
			System.out.println("Went Left");

			DeleteLastPos();

			offsetX--;
			UpdateMatrix();
		} else {
			System.out.println("Cant go left");
		}
	}

	// makes the sprite rotate clockwise
	public static void ClockRotate() {

		if (CanMove) {

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
				// if can rotate rotate
				System.out.println("Rotate");

				if (CurrentShape != 5) {
					CurrentRotation++;
				}

			} else {
				// if can't rotate revert
				SpriteShape = OldSpriteShape;
				System.out.println("Previous Rot");
			}

			UpdateMatrix();
		}

	}

	// makes the sprite rotate counter clockwise
	public static void CounterClockRotate() {

		if (CanMove) {

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
				// if can rotate rotate
				if (CurrentShape != 5) {
					CurrentRotation--;
				}
			} else {
				// if can't rotate revert
				System.out.println("Previous Rot");
				SpriteShape = OldSpriteShape;
			}

			UpdateMatrix();
		}

	}

	// Creates Random Queue for the blocks
	private static void MakeBlockQueue() {

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

			} while (Temp);

			if (Temp == false) {
				BlockQueue[i] = TryWhere;
			}
		}
	}

	// Tests if the row is full
	public static void FullRow() {

		Boolean fullRown = false;

		for (int i = 0; i < 20; i++) {
			fullRown = true;
			for (int j = 0; j < 10; j++) {

				if (GameMatrix[i][j] == 0) {

					fullRown = false;
				}
			}

			if (fullRown) {

				for (int j = 0; j < 10; j++) {
					GameMatrix[i][j] = 0;
					ScoreManager.score += 100;
				}

				for (int k = i; k > 0; k--) {

					for (int l = 0; l < 10; l++) {
						// moves the blocks above the full row down
						GameMatrix[k][l] = GameMatrix[k - 1][l];
					}
				}
			}
		}
	}

	// changes the Sprite to a new shape
	public static void NextBlock() {

		CurrentRotation = 0;

		CanMove = true;

		CurrentShape = BlockQueue[BlockQueuePlace];

		SpriteShape = GetCurrent(CurrentShape);

		BlockQueuePlace++;

		if (BlockQueuePlace == 7) {
			BlockQueuePlace = 0;
			MakeBlockQueue();
		}

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				TempGameMatrix[i][j] = 0;
			}
		}

		offsetX = 4;
		offsetY = 0;

		UpdateMatrix();
	}

	public static void OnFloor() {

		Fallen++;

		FullRow();
		NextBlock();
		TryNext();

		System.out.println(Fallen);
		ScoreManager.score += 30;
	}

	private static void TryNext() {

		if (Fallen > 30) {
			Fallen = 0;
			GameStateManager.NextLevel();
			CanMove = false;
		}
	}

	public static void NextLevel() {

		ResetMatrix();
		MakeBlockQueue();
		NextBlock();
		CanMove = true;
		level++;
	}

	public static void Delta(int time) {

		fallTimer += time;
		floorTimer += time;
	}

	public static void onFloor() {

		fallTimer = 0;

		if (floorTimer > 800) {

			CanMove = false;

			if (floorTimer > 1000) {
				floorTimer = 0;

				OnFloor();
			}
		}

	}

	public static void NotonFloor() {

		floorTimer = 0;

		int FallTemp = 510 - (10 * level);

		if (FallTemp < 150) {
			FallTemp = 150;
		}

		if (fallTimer > FallTemp) {

			Gravity();
			fallTimer = 0;
		}
	}

	public static void FastFall() {

		if (GameStateManager.CurrentState == "Game" && CanMove) {
			DeleteLastPos();
			int tempOffY = offsetY;

			while (!WhereFloor(offsetX, tempOffY) && tempOffY < 20) {

				tempOffY++;
				// finds floor
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (SpriteShape[i][j] != 0) {

						GameMatrix[i + tempOffY][j + offsetX] = SpriteShape[i][j];
					}
				}
			}

			OnFloor();
		}

	}

	// resets game for next time
	public static void ResetGame() {

		ResetMatrix();
		MakeBlockQueue();
		NextBlock();
		CanMove = true;
		level = 1;
		Fallen = 0;
		ScoreManager.score = 0;
	}

}
