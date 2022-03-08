package TicTacToe;

public class Player {
    // name of player
    private String name;
    // position
    private int id;

    private char symbol;

    public Player(String name, int id, char symbol) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public char getSymbol() {
        return symbol;
    }
}
