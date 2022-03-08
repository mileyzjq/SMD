package TicTacToe;

import java.util.Scanner;

public class Game {
    Player p1 = new Player("Amy", 0, 'O');
    Player p2 = new Player("Tom", 1, 'X');
    Board board = new Board();
    Scanner sc = new Scanner(System.in);

    public void playGame() {
        int counter = 0;
        Player p;
        while(true) {
            if(counter % 2 == 0) {
                p = p1;
            } else {
                p = p2;
            }
            System.out.println(String.format("It's %s's turn, please enter position", p.getName()));
            int row = sc.nextInt();
            int col = sc.nextInt();
            board.setSquareValue(row*3+col, p.getSymbol());
            if(checkWinner(p.getSymbol())) {
                System.out.println(String.format("%s wins! Game Over", p.getName()));
                return;
            }
            counter++;
        }
    }

    public boolean checkWinner(char c) {
        for(int i=0; i<3; i++) {
            if(board.getSquareValue(i) == c && board.getSquareValue(i+3) == c &&
                    board.getSquareValue(i+6) == c) {
                return true;
            }
            if(board.getSquareValue(i*3) == c && board.getSquareValue(i*3+1) == c &&
                    board.getSquareValue(i*3+2) == c) {
                return true;
            }
        }
        if(board.getSquareValue(4) == c && board.getSquareValue(0) == c &&
                board.getSquareValue(8) == c) {
            return true;
        }
        if(board.getSquareValue(4) == c && board.getSquareValue(2) == c &&
                board.getSquareValue(6) == c) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
