/**
 * Realization of AI interface using simplistic random placement strategy.
 *
 * @author Andrew Stone
 */

import java.util.Random;

public class DumbAI implements AI {

	private Random random = new Random();

	/*
	 * TBD: Create additional private members if useful.
	 */
	char piece;

	/**
	 * Construct a DumbAI.
	 *
	 * @param aiIsX Indicates whether the AI player's piece is
	 *              the 'X'.
	 */
	public DumbAI(boolean aiIsX) {
		if (aiIsX) {
			piece = 'X';
		} else piece = 'O';
	}

	public Move chooseMove(Board board) {
	// TODO: investigate issue
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				if (board.get(col, row) == ' ') {
					System.out.println("ai placed " + piece + " at " + row + ", " + col);
					return new Move(row, col, piece);
				}
			}
		}
		// TODO: deal with this, should never happen but still not good
		return new Move(-1, -1, piece);
	}
}
