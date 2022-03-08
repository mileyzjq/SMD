package SWENmonopoly.monopoly.square;

public class RRSquare extends PropertySquare {
	
	public static final int RR_BASE_FEE = 25;

	public RRSquare(String name, int index, int price) {
		super(name, index, price);
	}

	@Override
	public int getRent() {
		int count = owner.getRRCount();
		return count*RR_BASE_FEE;
	}

}
