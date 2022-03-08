package MileyMonopoly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;

class Player {
    private String name;
    private int id;
    private Square position;
    private int balance;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setPosition(Square square) {
        this.position = square;
    }

    public Square getPosition() {
        return position;
    }

    public void purchase(PropertySquare s) {
        if(this.balance > s.getPrice()) {
            this.balance -= s.getPrice();
            s.setOwner(this);
        }
    }

    public void increaseBalance(int rent) {
        this.balance += rent;
    }

    public void decreaseBalance(int rent) {
        this.balance -= rent;
    }
}

class Square {
    private int index;
    private String type;

    public Square(int index, String type) {
        this.index = index;
        this.type = type;
    }

    public void landOn(Player p) {};

    public int getIndex() {
        return this.index;
    }

}

class PropertySquare extends Square {
    private int index;
    private String type;
    private int rent;
    private int price;
    private Player owner;

    public PropertySquare(int index, String type, int price, int rent) {
        super(index, type);
        this.price = price;
        this.rent = rent;
        this.owner = null;
    }

    public void landOn(Player p) {
        if(owner == null) {
            p.purchase(this);
        } else {
            payRent(p);
        }
    }

    public void setOwner(Player p) {
        this.owner = p;
    }

    public void payRent(Player p) {
        p.decreaseBalance(rent);
        owner.increaseBalance(rent);
    }

    public int getPrice() {
        return this.price;
    }
}


class Board {
    private ArrayList<Square> squares = new ArrayList<>();
    private int SIZE = 20;
    public static final int INDEX_Property[] = {2,3,6,12,15,18};

    public Board() {
        initializeBoard();
    }

    public Square getStartSquare(){
        return squares.get(0);
    }

    public void initializeBoard() {
        for(int i = 0; i < SIZE; i++){
            Square s;
            if(contains(INDEX_Property,i)){
                s = new PropertySquare(i,"Utility "+i, 100, 20);
            }else{
                s = new Square(i,"Square "+i);
            }
            squares.add(s);
        }
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    private boolean contains(int list[], int element){
        return IntStream.of(list).anyMatch(x -> x == element);
    }
}


class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private Board board = new Board();

    public Game(int numOfPlayers) {
        for(int i = 0; i < numOfPlayers;i++){
            Player p = new Player("Player " + (i+1), 10000);
            p.setPosition(board.getStartSquare());
            players.add(p);
        }
    }

    public void updatePlayer(Player p, int steps) {
        int id = p.getPosition().getIndex();
        int updateId = id + steps;
        Square currSquare = board.getSquares().get(updateId);
        p.setPosition(currSquare);
    }

    public void playGame(){
        for(int i = 0; i < 5; i++){
            playRound();
        }
    }

    private void playRound(){
        for(Iterator<Player> it = players.iterator(); it.hasNext(); ){
            Player player = (Player) it.next();
            updatePlayer(player, 1);
        }
    }

    public static void main(String[] args) {
        Game game = new Game(3);
        game.playGame();
    }
}
