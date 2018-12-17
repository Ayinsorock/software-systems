package ss.week5;


import ss.week4.tictactoe.Game;
import ss.week4.tictactoe.Mark;

import java.util.Arrays;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 *
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        Game game;

        if(Arrays.asList(args).contains("-N")) {
            game = new Game(
                    new HumanPlayer("X-Humanplay", Mark.XX),
                    new ComputerPlayer(Mark.OO)
            );
        } else if(Arrays.asList(args).contains("-S")) {
            game = new Game(
                    new HumanPlayer("X-Humanplay", Mark.XX),
                    new ComputerPlayer(Mark.OO, new SmartStrategy())
            );
        } else {
            game = new Game(new HumanPlayer(args[0], Mark.XX), new HumanPlayer(args[1], Mark.OO));
        }

        game.start();
    }

}
