package TicTacToe;

public class Board {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static final int SIZE = 9;

    private Square[] board = new Square[9];

    public Board() {
        initializeBoard();
    }

    public void initializeBoard() {
        for(int i=0; i<SIZE; i++) {
            Square tmp = new Square('.');
            board[i] = tmp;
        }
    }

    public char getSquareValue(int index) {
        return board[index].getValue();
    }

    public void setSquareValue(int index, char c) {
        board[index].setValue(c);
    }
}
