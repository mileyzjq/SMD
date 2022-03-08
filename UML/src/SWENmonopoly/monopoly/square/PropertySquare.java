package SWENmonopoly.monopoly.square;

import SWENmonopoly.monopoly.Player;

public abstract class PropertySquare extends Square {
	protected Player owner;
	protected int price;
	
	public PropertySquare(String name, int index, int price) {
		super(name, index);
		this.price = price;
		owner = null;
	}

	/**
	 * behaviour based on Figure 36.25
	 * @param p player landed on the square
	 */
	@Override
	public void landedOn(Player p) {
		if (null == owner){
			p.attempPurchase(this);
		}else if (!owner.equals(p)){
			payRent(p);
		}
	}
	
	/**
	 * behaviour based on Figure 36.27
	 * @param p player landed on the square
	 */
	private void payRent(Player p){
		int rent = getRent();
		owner.addCash(rent);
		p.reduceCash(rent);
		
		//add net worth calculation, not included in the figures in the book
		owner.addNetWorth(rent);
		p.reduceNetWorth(rent);
		
		System.out.println(p.getName()+" pays $"+rent+" to "+owner.getName());
	}
	
	
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public abstract int getRent();

	
}
