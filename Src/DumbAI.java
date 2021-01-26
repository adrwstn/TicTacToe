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
        }
        else piece = 'O';
    }

    public Move chooseMove(Board board) {

        int I = random.nextInt() % 2;
        int J = random.nextInt() % 2;

        return new Move(I, J, piece);
    }
}
