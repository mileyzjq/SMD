package Test;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Board board = new Board();
    private int numPlayers;

    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
        players = new ArrayList<>();
        for(int i=0; i<numPlayers; i++) {
            Player p = new Player(1, "aaa");
            players.add(p);
        }
    }
}
