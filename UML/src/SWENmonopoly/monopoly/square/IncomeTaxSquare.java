package SWENmonopoly.monopoly.square;

import SWENmonopoly.monopoly.Player;

public class IncomeTaxSquare extends Square {
	public static final int MAX_TAX = 200;
	public static final int TAX_PERCENTAGE = 10;
	
	public IncomeTaxSquare(String name, int index) {
		super(name, index);
	}

	@Override
	public void landedOn(Player p) {
		int w = p.getNetWorth();
		int tax = java.lang.Math.min(MAX_TAX,w*100/TAX_PERCENTAGE);
		p.reduceCash(tax);
		
		System.out.println(p.getName()+" pay income tax $"+tax);
	}

}
