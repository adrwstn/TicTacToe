/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author Andrew Stone
 */

import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX = false;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /*
     * TBD: Create additional private members if useful.
     */
    private boolean playSmartAI = false;
    private char playerChar = 'O';


    /**
     * Constructor
     */
    public ConsoleRunner() {    
        /*
         * TBD
         *
         * Use the 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
        prompt_playAsX();
        if (scanner.nextLine().equals("Y"))
            playerIsX = true;
        playerChar = 'X';


        prompt_playSmartAI();
        if (scanner.nextLine().equals("Y"))
            playSmartAI = true;

        Board start = new Board();
        System.out.println(start.toString());

        int holder_x, holder_y;
        prompt_coordinates_x();
        holder_x = scanner.nextInt();
        prompt_coordinates_y();
        holder_y = scanner.nextInt();
        Move player_move = new Move(holder_x, holder_y, playerChar);

        Board next = new Board(start,player_move);
        System.out.println(next.toString());
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        /*
         * TBD
         *
         * Use the 'nextInt' method of Scanner class to read user responses as
         * integers.
         *
         * There is enough work to do here that you may want to introduce
         * private methods (i.e. helper methods).
         */
    }

    private void prompt_playAsX() {
        System.out.println("Do you want to play as X (Y/N):");
    }

    private void prompt_playSmartAI() {
        System.out.println("Do you want a challenge (Y/N):");
    }

    private void prompt_coordinates_x() {
        System.out.println("Enter desired x-coordinate:");
    }

    private void prompt_coordinates_y() {
        System.out.println("Enter desired y-coordinate:");
    }

}
