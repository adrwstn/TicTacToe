/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 *
 * @author Andrew Stone
 */

public class Board {

	private char[][] board = new char[3][3];

	/*
	 * Each row_ is 7 char.
	 * row_separator is immutable.
	 * Indices 1,3,5 are mutable (i.e whitespaces are mutable)
	 */
	private char row_separator[] = {'-', '-', '-', '-', '-', '-', '-'};
	private char row_top[] = {'|', board[0][0], '|', board[0][1], '|', board[0][2], '|'};
	private char row_middle[] = {'|', board[1][0], '|', board[1][1], '|', board[1][2], '|'};
	private char row_bottom[] = {'|', board[2][0], '|', board[2][1], '|', board[2][2], '|'};

	/**
	 * Construct an empty board (contains all space char's).
	 */
	public Board() {
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

		Board nextMove = new Board();
		nextMove.board = other.board;
		nextMove.board[move.getJ()][move.getI()] = move.getPiece();
		/*
		 * Board is suppose to be immutable however i'm not sure how to use the 'other' board
		 * as starting point unless I use a copy constructor (maybe i should?)
		 */
	}

	/*
	 *                  [DEAD CODE - PENDING]
	 * maps move input (column) to appropriate whitespace position of char array(1, 3, 5)
	 * i.e. (move input, position) { (0, 1), (1, 3), (2, 5) }
	 */
	private int mapInputToColumn(int moveInput_Column) {
		int  mappedPosition_column = -1;
		switch (moveInput_Column) {
			case 0:
				mappedPosition_column = 1;
			case 1:
				mappedPosition_column = 3;
			case 2:
				mappedPosition_column = 5;
		}
		return mappedPosition_column;
	}

	/*
	 *                  [DEAD CODE - PENDING]
	 * maps move input (row) to appropriate row (top, middle, bottom)
	 * i.e. (move input, position) { (0, top), (1, middle), (2, bottom) }
	 */
	private char[] mapInputToRow(int moveInput_Row) {
		char mappedPosition_row[] = row_top;
		switch (moveInput_Row) {
			case 0:
				mappedPosition_row = row_top;
			case 1:
				mappedPosition_row = row_middle;
			case 2:
				mappedPosition_row = row_middle;
		}
		return mappedPosition_row;
	}

	/**
	 * Convert to a string that shows the board's state.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(64);
		sb.append(row_separator).append('\n').append(row_top).append('\n');
		sb.append(row_separator).append('\n').append(row_middle).append('\n');
		sb.append(row_separator).append('\n').append(row_bottom).append('\n');
		return sb.toString();
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
					return true;
			}
		}
		return false;
	}
}
	//char[rows][columns]