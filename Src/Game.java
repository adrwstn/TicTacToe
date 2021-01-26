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

	// Additional field(s)
	char personPiece;

	/**
	 * Construct a new Game according to the given parameters.
	 */
	public Game(boolean playerIsX, boolean challenging) {
		status = GameStatus.IN_PROGRESS;
		boolean aiIsX;

		if (playerIsX) {
			aiIsX = false;
			personPiece = 'X';
		} else {
			aiIsX = true;
			personPiece = 'O';
		}

		// TODO: ARE WE NOT SUPPOSE TO IMPLEMENT SMARTAI() ?
		if (challenging) {
//			ai = new SmartAI(aiIsX);
			ai = new DumbAI(aiIsX);
		} else ai = new DumbAI(aiIsX);
	}

	/**
	 * Return a copy of the board's current contents.
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * Get the game's status.
	 */
	public GameStatus getStatus() {
		return this.status;
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

		Move personMove = new Move(i, j, personPiece);
		// check if cell is empty
		if (board.get(i, j) != ' ')
			return false;

		board = new Board(this.getBoard(),personMove);

		// check is desired move is in range
		return ( (0 <= i && i < 3) && (0 <= j && j < 3));
	}

	/**
	 * @precondition status == IN_PROGRESS
	 */
	public void aiPlacePiece() {
		Move aiMove = ai.chooseMove(board);
		while (!placePlayerPiece(aiMove.getI(),aiMove.getJ())) {
			aiMove = ai.chooseMove(board);
		}

		board = new Board(board, ai.chooseMove(board));

	}

	// Checks for winner and updates game status if there's a winner
	public void checkWin_all(Board board) {
		checkWin_horizontal(board);
		checkWin_vertical(board);
		checkWin_primaryDiagonal(board);
		checkWin_secondaryDiagonal(board);
		declareWinner();
	}

	// -- Win condition below --

	// check horizontals
	private void checkWin_horizontal(Board board) {
		for (int col = 0; col < 3; col++) {
			if (board.get(0, col) == board.get(1, col) && board.get(1, col) == board.get(2, col)) {
				if (board.get(0, col) == 'X') {
					status = GameStatus.X_WON;
				}
				if (board.get(0, col) == 'O') {
					status = GameStatus.O_WON;
				}
			}
		}
	}

	// check verticals
	private void checkWin_vertical(Board board) {
		for (int row = 0; row < 3; row++) {
			if (board.get(row, 0) == board.get(row, 1) && board.get(row, 1) == board.get(row, 2)) {
				if (board.get(row, 0) == 'X') {
					status = GameStatus.X_WON;
				}
				if (board.get(row, 0) == 'O') {
					status = GameStatus.O_WON;
				}
			}
		}
	}

	/* check primary diagonal:
	 * nothing special here
	 * */
	private void checkWin_primaryDiagonal(Board board) {
		char tmp = ' ';
		if (board.get(0, 0) == board.get(1, 1) && board.get(1, 1) == board.get(2, 2))
			tmp = board.get(0, 0);
		if (tmp == 'X') {
			status = GameStatus.X_WON;
		}
		if (tmp == 'O') {
			status = GameStatus.O_WON;
		}
	}

	/* check secondary diagonal:
	 * for any square matrix of size n, elements of secondary diagonal
	 * occur when ( i + j ) == ( n - 1)
	 */
	private void checkWin_secondaryDiagonal(Board board) {
		char tmp = ' ';
		if (board.get(0, 2) == board.get(1, 1) && board.get(1, 1) == board.get(2, 0))
			tmp = board.get(0, 2);
		if (tmp == 'X') {
			status = GameStatus.X_WON;
		}
		if (tmp == 'O') {
			status = GameStatus.O_WON;
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

