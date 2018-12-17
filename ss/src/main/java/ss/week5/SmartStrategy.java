package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartStrategy extends NaiveStrategy {
    @Override
    public String getName() {
        return "Smart";
    }

    @Override
    public int determineMove(Board b, Mark m) {
        List<Mark> boardCopy = new ArrayList<>();
        for (int i = 0; i < Board.DIM * Board.DIM; i++) {
            boardCopy.add(b.getField(i));
        }

        // Self win
        System.out.println("Checking self...");
        if (hasWinningPotential(boardCopy, m) != -1) {
            return hasWinningPotential(boardCopy, m);
        }

        // Forced block
        System.out.println("Checking oponent...");
        if (hasWinningPotential(boardCopy, m.other()) != -1) {
            return hasWinningPotential(boardCopy, m.other());
        }

        // Middle always fun
        if (boardCopy.get(4) == Mark.EMPTY) {
            System.out.println("Middle seems like a good idea...");
            return 4;
        }

        // Just do the naive strategy for the lack of a better idea
        System.out.println("Going YOLO");
        return super.determineMove(b, m);
    }

    private int hasWinningPotential(List<Mark> board, Mark mark) {
        // Rows and columns
        for (int i = 0; i < Board.DIM; i++) {
            if (checkRowCouldWinForMark(board, mark, i) != -1) {
                return checkRowCouldWinForMark(board, mark, i);
            }

            if (checkColumnCouldWinForMark(board, mark, i) != -1) {
                return checkColumnCouldWinForMark(board, mark, i);
            }
        }

        // Diagonals
        if (checkDiagonalCouldWinForMark(board, mark, false) != -1) {
            return checkDiagonalCouldWinForMark(board, mark, false);
        }

        if (checkDiagonalCouldWinForMark(board, mark, true) != -1) {
            return checkDiagonalCouldWinForMark(board, mark, true);
        }

        return -1;
    }

    /**
     * returns the field which could end the game or -1 if there is none.
     */
    private int checkRowCouldWinForMark(List<Mark> board, Mark mark, int row) {
        List<Mark> rowCopy = board.subList(row, row + 3);

        System.out.println("Row " + row + ": " + rowCopy);

        if (
            Collections.frequency(rowCopy, mark) == 2 &&
            Collections.frequency(rowCopy, Mark.EMPTY) == 1
        ) {
            System.out.println("Winning row detected for mark:" + mark.toString());
            return rowCopy.indexOf(Mark.EMPTY);
        }

        return -1;
    }

    /**
     * returns the field which could end the game or -1 if there is none.
     */
    private int checkColumnCouldWinForMark(List<Mark> board, Mark mark, int column) {
        List<Mark> columnCopy = new ArrayList<>();
        for (int i = column; i < Board.DIM * Board.DIM; i += Board.DIM) {
            columnCopy.add(board.get(i));
        }

        if (
            Collections.frequency(columnCopy, mark) == 2 &&
            Collections.frequency(columnCopy, Mark.EMPTY) ==1
        ) {
            System.out.println("Winning column detected for mark:" + mark.toString());
            return column + columnCopy.indexOf(Mark.EMPTY) * (Board.DIM );
        }

        return -1;
    }

    /**
     * returns the field which could end the game or -1 if there is none.
     */
    private int checkDiagonalCouldWinForMark (List<Mark> board, Mark mark, boolean lowerDiagonal) {
        List<Mark> diagonalCopy = new ArrayList<>();

        for (int i = 0; i < Board.DIM; i++) {
            diagonalCopy.add(board.get(Board.index(i, lowerDiagonal ? Board.DIM - 1 - i : i)));
        }

        if(
            Collections.frequency(diagonalCopy, mark) == 2 &&
            Collections.frequency(diagonalCopy, Mark.EMPTY) == 1
        ) {
            int i = diagonalCopy.indexOf(Mark.EMPTY);
            return Board.index(i, lowerDiagonal ? Board.DIM - 1 - i : i);
        }

        return -1;
    }

}
