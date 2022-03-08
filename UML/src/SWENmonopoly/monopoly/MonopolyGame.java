package SWENmonopoly.monopoly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;


public class MonopolyGame {
	public final int ROUNDS_TOTAL;
	public static final int MIN_NUM_OF_PLAYER = 2;
	public static final int MAX_NUM_OF_PLAYER = 8;
	public static final int NUM_OF_DICE = 2;
	
	private List<Player> players;
	private Board board = new Board();

	public MonopolyGame(int numOfPlayers, int numOfRounds){
		Cup.initialize(NUM_OF_DICE);
		players = new ArrayList<Player>(numOfPlayers);
		ROUNDS_TOTAL = numOfRounds;
		for(int i = 0; i < numOfPlayers;i++){
			Player p;
			p = new Player("Player " + (i+1), board);
			players.add(p);
		}
	}

	public void playGame(){
		for(int i = 0; i < ROUNDS_TOTAL; i++){
			playRound();
		}
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	private void playRound(){
		for(Iterator<Player> it = players.iterator(); it.hasNext(); ){
			Player player = (Player) it.next();
			player.takeTurn();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Properties monopolyProperties = new Properties();
		monopolyProperties.setProperty("Number_of_Players", "2");
		monopolyProperties.setProperty("Number_of_Rounds", "20");

		FileReader inStream = null;
		
		try {
			inStream = new FileReader("src/monopolyProperties.txt");
			monopolyProperties.load(inStream);
		} finally {
			 if (inStream != null) {
	                inStream.close();
	            }
		}
		int numberOfPlayers = Integer.parseInt(monopolyProperties.getProperty("Number_of_Players"));
		if (numberOfPlayers > MAX_NUM_OF_PLAYER || numberOfPlayers < MIN_NUM_OF_PLAYER){
			System.err.print("Number of player outside acceptable range");
			System.exit(1);
		}
		int numberOfRounds = Integer.parseInt(monopolyProperties.getProperty("Number_of_Rounds"));
		MonopolyGame game = new MonopolyGame(numberOfPlayers, numberOfRounds);
		game.playGame();
	}
}
