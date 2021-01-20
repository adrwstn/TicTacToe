/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 *
 * @author Andrew Stone
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        /*
         * TBD
         */
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        /*
         * TBD
         */
        // TODO: Implement
        // NOT TOO SURE ABOUT THIS?
        return this.board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
        /*
         * TBD
         * 3 win scenarios: i) horizontal ii) vertical iii) diagonal
         */

        // if count3 == 3 someone won
        int count3 = 0;

        // does whitespace exists ? IN_PROGRESS : (Winner XOR Draw)

        // check horizontals

        // check verticals

        // check diagonals

        //

    // TODO: IMPLEMENT THIS YOU LAZY BASTARD!
        return null;
    }
    
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) {
        /*
         * TBD
         */

        // check if cell is empty
        if (board.get(i, j) != ' ')
            return false;

        // check is desired move is in range
        if (0 <= i  && i < 3 && 0 <= j  && j < 3)
            return true;
        else return false;

    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        /*
         * TBD
         */
    }
}
