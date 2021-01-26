/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 *
 * @author Andrew Stone
 */

import java.util.*;

public class Game {
	private Board board = new Board();
	private GameStatus status;
	private AI ai;

	// Additional members
	private char winnerIs;          // holds Winner (X or O)

	// push char's from each cell onto stack, if stack.pop() is same char 3 times, char ___ wins
	Stack<Character> winStack = new Stack<>();


	/**
	 * Construct a new Game according to the given parameters.
	 */
	public Game(boolean playerIsX, boolean challenging) {
		status = GameStatus.IN_PROGRESS;
		/*
		 * TODO: Implement Game(boolean playerIsX, boolean challenging)
		 */
	}

	/**
	 * Return a copy of the board's current contents.
	 */
	public Board getBoard() { return this.board; }

	/**
	 * Get the game's status.
	 */
	public GameStatus getStatus() {
		return status;
	}

	// check horizontals
	public void checkWin_horizontal() {
		// TODO: Implement checkWin_horizontal()
	}

	// check verticals
	public void checkWin_vertical() {
		// TODO: Implement checkWin_vertical()
	}

	/* check primary diagonal:
	 * nothing special here
	 * */
	public void checkWin_primaryDiagonal() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (row == col) {
					winStack.push(board.get(row, col));
				}
			}
		}
	}

	/* check secondary diagonal:
	 * for any square matrix of size n, elements of secondary diagonal
	 * occur when ( i + j ) == ( n - 1)
	 */
	public void checkWin_secondaryDiagonal() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if ((row + col) == (3 - 1)) {
					winStack.push(board.get(row, col));
				}
			}
		}
	}

	/**
	 * Place a piece for the player on the board.
	 *
	 * @param i i-coordinate of desired position.
	 * @param j j-coordinate of desired position
	 * @return true only if the coordinates of the desired position are in
	 * range and the corresponding cell is empty.
	 * @precondition status == IN_PROGRESS
	 */
	public boolean placePlayerPiece(int i, int j) {
		// TODO: check precondition

		// check if cell is empty
		if (board.get(i, j) != ' ')
			return false;

		// check is desired move is in range
		return 0 <= i && i < 3 && 0 <= j && j < 3;

	}

	/**
	 * @precondition status == IN_PROGRESS
	 */
	public void aiPlacePiece() {
		/*
		 * TODO: Implement aiPlacePiece()
		 */
	}

	// checkForWinner() updates GameStatus status
	private void checkForWinner() {
		if (winStack.size() == 3) {
			char firstChar, secondChar, thirdChar;

			firstChar = winStack.pop();
//			System.out.println("firstChar: " + firstChar);

			secondChar = winStack.pop();
//			System.out.println("secondChar: " + secondChar);

			thirdChar = winStack.pop();
//			System.out.println("thirdChar: " + thirdChar);

			if (firstChar == secondChar && secondChar == thirdChar) {
				winnerIs = firstChar;
				if (winnerIs == 'X') {
					status = GameStatus.X_WON;
				} else if (winnerIs == 'O') {
					status = GameStatus.O_WON;
				}
			}
			declareWinner();
		}
	}

	private void declareWinner() {
		if (status == GameStatus.X_WON) {
			System.out.println("'X' has won");
		} else if (status == GameStatus.O_WON) {
			System.out.println("'O' has won");
		}
	}
}

