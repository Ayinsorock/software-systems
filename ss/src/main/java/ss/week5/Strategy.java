package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {
    String getName();
    int determineMove(Board b, Mark m);
}
