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

	/*
	 * TBD: Create additional private members if useful.
	 */

	// push char's from each cell onto stack, if stack.pop() is same char 3 times, char ___ wins
	private Stack<Character> winStack = new Stack<>();
	private char firstChar, secondChar, thirdChar;

    //	only to be called AFTER 3 calls to winStack.push() have been made;
	private void winStack_pop() {
		firstChar = winStack.pop();
		secondChar = winStack.pop();
		thirdChar = winStack.pop();
	}

	private boolean winStack_winner() {
		return firstChar == secondChar && secondChar == thirdChar;
		// TODO: figure out how i'm going to determine if X or O won
	}


	/**
	 * Construct a new Game according to the given parameters.
	 */
	public Game(boolean playerIsX, boolean challenging) {
		/*
		 * TBD
		 * TODO: Implement Game(boolean playerIsX, boolean challenging)
		 */
	}

	/**
	 * Return a copy of the board's current contents.
	 */
	public Board getBoard() {
		/*
		 * TBD
		 */
		// TODO: Implement getBoard()
		// NOT TOO SURE ABOUT THIS?
		return this.board;
	}

	/**
	 * Get the game's status.
	 */
	public GameStatus getStatus() {
		/*
		 * TBD
		 * TODO: getStatus()
		 */

		// does whitespace exists ? IN_PROGRESS : (Winner XOR Draw)

		// TODO: IMPLEMENT THIS YOU LAZY BASTARD!
		return null;
	}
	// check horizontals
	public boolean checkWin_horizontal() {
		// TODO: Implement checkWin_horizontal()
		return false;
	}

	// check verticals
	public boolean checkWin_vertical() {
		// TODO: Implement checkWin_vertical()
		return false;
	}

	public boolean checkWin_diagonal() {

		/* check primary diagonal:
		 * nothing special here
		 * */
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (row == col) {
					winStack.push(board.get(row, col));
				}

			}
		}
		winStack_pop();
		if (winStack_winner())
			return true;


		/* check secondary diagonal:
		 * for any square matrix of size n, elements of secondary diagonal
		 * occur when ( i + j ) == ( n - 1)
		 */
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if ((row + col) == (3 - 1)) {
					winStack.push(board.get(row, col));
				}
			}
		}
		winStack_pop();
		return winStack_winner();

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
		// TODO: deal with precondition

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
		 * TBD
		 * TODO: Implement aiPlacePiece()
		 */
	}
}
