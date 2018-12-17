package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;
import java.util.List;

public class NaiveStrategy implements Strategy {
    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public int determineMove(Board b, Mark m) {
        List<Integer> emptyFields = new ArrayList<>();

        // Extract the emtpy Fields
        for(int i = 0; i < Board.DIM * Board.DIM; i++) {
            if(b.isEmptyField(i)) {
                emptyFields.add(i);
            }
        }

        return emptyFields.get((int) (Math.random() * emptyFields.size()));
    }
}
