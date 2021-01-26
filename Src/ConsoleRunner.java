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

    // Additional Members:
    private boolean playSmartAI = false;
    private char playerChar = 'O';

    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor
     */
    public ConsoleRunner() {    
        /*
         * Use the 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
        game = new Game(prompt_playAsX(),prompt_playSmartAI());

    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        Board start = new Board();
        System.out.println(start.toString());
        Board next = new Board(start,promptMove_player());
        System.out.println(next.toString());

        while (game.getStatus() == GameStatus.IN_PROGRESS)
        {
        //  TODO: undo the mess I made of this and getStatus()
            next = new Board(next,promptMove_player());
            System.out.println(next.toString());
            game.getStatus();

        }

    }

    // Self-explanatory
    private boolean prompt_playAsX() {
        System.out.println("Do you want to play as X (Y/N):");
        if (scanner.nextLine().equals("Y")) {
            playerIsX = true;
            playerChar = 'X';
            return true;
        }
        return false;
    }

    // Self-explanatory
    private boolean prompt_playSmartAI() {
        System.out.println("Do you want a challenge (Y/N):");
        if (scanner.nextLine().equals("Y")) {
            playSmartAI = true;
            return true;
        }
        return false;
    }

     /* Wrapper for receiving player input (move)
      * Assumes move is valid
      * @return a Move instance
      * */
    private Move promptMove_player() {
        int holder_x, holder_y;
        System.out.println("Enter desired x-coordinate:");
        holder_x = scanner.nextInt();
        System.out.println("Enter desired y-coordinate:");
        holder_y = scanner.nextInt();
        return new Move(holder_x, holder_y, playerChar);
    }
}
