package SWENmonopoly.monopoly.square;

import SWENmonopoly.monopoly.Player;

public abstract class Square {
	protected String name;
	protected int index;
	
	public Square(String name, int index) {
		this.name = name; 
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}
	
	public abstract void landedOn(Player p);
}
