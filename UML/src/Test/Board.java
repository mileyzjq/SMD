package Test;


import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 40;
    private List<Square> squares = new ArrayList<>(SIZE);

    public Board() {
        buildSquares();
    }

    public void buildSquares() {
        for(int i=0; i<SIZE; i++) {
            Square s = new Square(i, "hello");
        }
    }
}
