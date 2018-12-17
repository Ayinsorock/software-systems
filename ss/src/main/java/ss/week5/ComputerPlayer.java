package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class ComputerPlayer extends HumanPlayer {
    private Strategy strategy;

    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + "-" + mark.toString(), mark);

        this.strategy = strategy;
    }

    public ComputerPlayer(Mark mark) {
        this(mark, new NaiveStrategy());
    }

    @Override
    public int determineMove(Board board) {
        return this.strategy.determineMove(board, this.mark);
    }

}
