package Test;

public class Player {
    private static final int INITIAL_CASH = 10000;
    private int id;
    private String name;
    private Square location;
    private int cash;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.cash = INITIAL_CASH;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Square getLocation() {
        return location;
    }

}
