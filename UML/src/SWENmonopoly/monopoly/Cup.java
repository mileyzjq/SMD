package SWENmonopoly.monopoly;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cup {
	
	private static List<Die> dice;
	private static int total;
	
	private static FileWriter outStream = null;
	
	public static void initialize(int numOfDice) {
		dice = new ArrayList<Die>(numOfDice);
		for (int i = 0; i < numOfDice; i++ ){
			dice.add(new Die());
		}
		try {
			outStream = new FileWriter("monopolyRollsOut.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void roll(){
		try {
			total = 0;
			for (Die die:dice){
				die.roll();
				total += die.getFaceValue();
				outStream.write(Integer.toString(die.getFaceValue()));
				outStream.append('\n');
			}
			outStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static int getTotal(){
		return total;
	}

}
