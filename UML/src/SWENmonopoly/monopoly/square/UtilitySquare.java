package SWENmonopoly.monopoly.square;

import SWENmonopoly.monopoly.Cup;

public class UtilitySquare extends PropertySquare {
	public static final int UTILILY_RATE = 4;

	public UtilitySquare(String name, int index, int price) {
		super(name, index, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRent() {
		int total = Cup.getTotal();
		return total * UTILILY_RATE;
	}

}
