package SWENmonopoly.monopoly.square;

import SWENmonopoly.monopoly.Player;

public class GoSquare extends Square {
	public static final int SALARY = 200;

	public GoSquare(String name, int index) {
		super(name, index);
	}

	@Override
	public void landedOn(Player p) {
		p.addCash(SALARY);
		
		//add net worth calculation, not included in the figures in the book
		p.addNetWorth(SALARY);
		
		System.out.println(p.getName()+" passes Go and receive $"+SALARY);
	}

}
