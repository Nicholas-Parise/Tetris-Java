package Tetris;
import java.util.Random;
import java.util.ArrayList;

/***************************
 * Nicholas Parise, 
 * Sile Keenan, 
 * ICS4U, 
 * Tetris
 ****************************/


// This class deals with all functionality with the board and the blocks
// biggest class very poorly documented
public class Blocks {

	// Shapes
	// could be in assetmanager but are only accesed here so here they are
	private final int[][] LShape = { { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 0 } };

	private final int[][] L2Shape = { { 0, 2, 0, 0 }, { 0, 2, 0, 0 }, { 2, 2, 0, 0 }, { 0, 0, 0, 0 } };

	private final int[][] SShape = { { 3, 0, 0, 0 }, { 3, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } };

	private final int[][] ZShape = { { 0, 4, 0, 0 }, { 4, 4, 0, 0 }, { 4, 0, 0, 0 }, { 0, 0, 0, 0 } };

	private final int[][] IShape = { { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 }, { 0, 5, 0, 0 } };

	private final int[][] SquShape = { { 6, 6, 0, 0 }, { 6, 6, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	private final int[][] TShape = { { 7, 0, 0, 0 }, { 7, 7, 0, 0 }, { 7, 0, 0, 0 }, { 0, 0, 0, 0 } };

	// private Variables

	private int[][] SpriteShape = new int[4][4];

	private int[][] OldSpriteShape = new int[4][4];

	private int[][] TempGameMatrix = new int[20][10];

	private int[] BlockQueueNeg = { -1, -1, -1, -1, -1, -1, -1 };

	private int CurrentShape = 0;

	private int CurrentSymbol = 0;

	private int CurrentRotation = 0;

	private int fallTimer = 0;

	private int floorTimer = 0;

	private Boolean CanNextLevel = false;

	// public Variables

	public int[][] GameMatrix = new int[20][10];

	public int[][] FuturePosition = new int[20][10];

	public int[] BlockQueue = new int[7];

	public int offsetX = 2;

	public int offsetY = 0;

	public Boolean CanMove = true;

	public int BlockQueuePlace = 0;

	public int Fallen = 0;

	public int level = 1;

	// --------------------------------------

	ScoreManager sm;
	GameStateManager gsm;

	public Blocks(ScoreManager s, GameStateManager g){

		sm = s;
		gsm = g;

		ResetGame();
	}


	// Returns current shape
	public int[][] GetCurrent(int Shape) {

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
	private Boolean BlockHandler(int rotation) {

		// return true; if it can rotate
		// return false; if it can't rotate

		int temp = 0;
		int temp2 = 0;

		int[][] CurrentShapeTemp = GetCurrent(CurrentShape);

		int[][] SpriteShapeTemp = new int[4][4];

		OldSpriteShape = SpriteShape;

		// uses the magic of for loops and if statments to switch values in the origonal
		// matrix
		// into a new temp matrix

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

			System.out.println("-Right-");

		} else if (rotation == 0) {
			// Up Rotation
			SpriteShapeTemp = GetCurrent(CurrentShape);

			// just sets the sprite to the origional shape

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

	private Boolean CanLeft() {
		// returns false if can't
		// returns true if can move left
		ArrayList<Integer> LowestPointsY = new ArrayList<>();
		ArrayList<Integer> LowestPointsX = new ArrayList<>();

		int temp;
		int temp2;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					temp = i + offsetY;
					temp2 = j + offsetX;

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

							// tests if the game matrix cell to the left is empty or full
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

	private Boolean CanRight() {
		// returns false if can't
		// returns true if can move right

		ArrayList<Integer> LowestPointsY = new ArrayList<>();
		ArrayList<Integer> LowestPointsX = new ArrayList<>();

		int temp;
		int temp2;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					temp = i + offsetY;
					temp2 = j + offsetX;

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
							// tests if the game matrix cell to the right is empty or full
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
	public Boolean WhereFloor(int ShapeOffsetx, int ShapeOffsety) {

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
							// tests if the game matrix cell on the bottow is empty or full
							return true;
						}

					}
				}
			}
		}
		return false;
	}

	// Updates the matrix to new position of sprite
	private void UpdateMatrix() {
		
		CanNextLevel = true;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {

					if (GameMatrix[i + offsetY][j + offsetX] > 0 && offsetY < 1) {
						// if a shape is in another shape and the height is less than 1
						// game over
						System.out.println("Game over");

						gsm.StartEnd();
						CanNextLevel = false;
					}

					GameMatrix[i + offsetY][j + offsetX] = SpriteShape[i][j];
					TempGameMatrix[i + offsetY][j + offsetX] = SpriteShape[i][j];
				}
			}
		}

	}

	// prints the game matrix to screen
	// this is more of a debug thing
	public void PrintMatrix() {

		System.out.println();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(GameMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 0's out all game matrix's
	private void ResetMatrix() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				GameMatrix[i][j] = 0;
				TempGameMatrix[i][j] = 0;
			}
		}
	}

	// Showes the future position of the shape
	private void ShowFuture() {

		int tempOffY = offsetY;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				FuturePosition[i][j] = 0;
				// 0 out future position array
			}
		}

		while (!WhereFloor(offsetX, tempOffY) && tempOffY < 20) {
			// while there is no floor keep going down
			tempOffY++;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				if (SpriteShape[i][j] != 0) {
					// put the future position with the down offset calculated in it's own array
					FuturePosition[i + tempOffY][j + offsetX] = SpriteShape[i][j];
				}
			}
		}
	}

	// removes the sprite from the Game matrix
	private void DeleteLastPos() {

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
	private void Gravity() {

		System.out.println("Went Down");

		DeleteLastPos();

		offsetY++;
		UpdateMatrix();
	}

	// Makes the sprite go Right
	public void GoRight() {

		if (CanRight() && CanMove) {
			System.out.println("Went Right");

			DeleteLastPos();

			offsetX++;
			UpdateMatrix();
		}
	}

	// Makes the sprite go left
	public void GoLeft() {

		if (CanLeft() && CanMove) {
			System.out.println("Went Left");

			DeleteLastPos();

			offsetX--;
			UpdateMatrix();
		}
	}

	// makes the sprite rotate clockwise
	public void ClockRotate() {

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
	public void CounterClockRotate() {

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
	private void MakeBlockQueue() {

		BlockQueue = BlockQueueNeg;

		Random rand = new Random();

		int TryWhere;
		boolean Temp;

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

			if (!Temp) {
				BlockQueue[i] = TryWhere;
			}
		}
	}

	// Tests if the row is full
	private void FullRow() {

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
					sm.setScore(sm.getScore()+100);
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
	private void NextBlock() {

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

	private void BlockOnFloor() {
		// When the block is on a floor
		Fallen++;

		FullRow();
		NextBlock();
		TryNext();

		sm.setScore(sm.getScore()+30);
	}

	private void TryNext() {
		// Tests if can change level
		if (Fallen > 30 && CanNextLevel) {
			Fallen = 0;
			gsm.StartNextLevel();
			CanMove = false;
		}
	}

	public void NextLevel() {
		// instantly changes level
		ResetMatrix();
		MakeBlockQueue();
		NextBlock();
		CanMove = true;
		level++;
	}

	public void Delta(int time) {
		// Delta time for falling and how long you can move on the floor

		fallTimer += time;
		floorTimer += time;
	}

	public void WaitOnFloor() {
		// when the block is on the ground
		// it waits
		fallTimer = 0;
		if (floorTimer > 800) {

			CanMove = false;
			// if the floor timer is less than 800 the block can still move

			if (floorTimer > 1000) {
				floorTimer = 0;
				// if the floor timer is past 1000 the block is really on the floor
				// so it calls
				BlockOnFloor();
			}
		}
	}

	public void NotonFloor() {
		// if the block is in the air
		floorTimer = 0;

		int FallTemp = 510 - (10 * level);

		if (FallTemp < 150) {
			FallTemp = 150;
		}

		if (fallTimer > FallTemp) {

			Gravity();
			fallTimer = 0;
		}

		// Shows the future position of the blocks
		ShowFuture();
	}

	public void FastFall() {
		// if the enter key is pressed instantly teleport the block to the bottom
		if (gsm.CurrentState == "Game" && CanMove) {
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

			BlockOnFloor();
		}
	}

	// resets game for next time
	public void ResetGame() {

		ResetMatrix();
		MakeBlockQueue();
		NextBlock();
		CanMove = true;
		level = 1;
		Fallen = 0;
		sm.setScore(0);
	}

}
