/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 *
 * @author Andrew Stone
 */

public class Board {

	private char[][] board = new char[3][3];

	/**
	 * Construct an empty board (contains all space char's).
	 */
	public Board() {
//		System.out.println("Board()");
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				board[row][col] = ' ';
			}
		}
	}

	/**
	 * Given the 'other' board as a starting condition, apply the given
	 * 'move' to generate this board's state.
	 */
	public Board(Board other, Move move) {

		 /* iterate through 'other' board, using get() to create copy of 'other' board
		  * apply move to the new copied board
		  */

		for (int row = 0; row < other.board.length; row++)
		{
			for (int col = 0; col < other.board[row].length; col++)
			{
				board[row][col] = other.get(row,col);
			}
		}
		// apply 'move' to copied board
		board[move.getJ()][move.getI()] = move.getPiece();
	}

	/**
	 * Convert to a string that shows the board's state.
	 */
	public String toString() {

		char row_separator[] = {'-', '-', '-', '-', '-', '-', '-'};
		char row_top[] = {'|', board[0][0], '|', board[0][1], '|', board[0][2], '|'};
		char row_middle[] = {'|', board[1][0], '|', board[1][1], '|', board[1][2], '|'};
		char row_bottom[] = {'|', board[2][0], '|', board[2][1], '|', board[2][2], '|'};

		return String.valueOf(row_separator) + '\n' + String.valueOf(row_top) + '\n' +
				String.valueOf(row_separator) + '\n' + String.valueOf(row_middle) + '\n' +
				String.valueOf(row_separator) + '\n' + String.valueOf(row_bottom) + '\n';
	}

	/**
	 * Get the entry of the board at column i, row j.  Both indices should
	 * be in the range [0, 2].
	 */
	public char get(int i, int j) {
		return board[i][j];
	}

	/**
	 * @return true if there remain no empty spots on the board.
	 */
	public boolean isFull() {
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				if (board[row][col] == ' ')
					return false;
			}
		}
		return true;
	}
}