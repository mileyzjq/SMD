package SWENmonopoly.monopoly.square;

public class LotSquare extends PropertySquare {

	public LotSquare(String name, int index, int price) {
		super(name, index, price);
	}

	@Override
	public int getRent() {
		return index;
	}

}
