package SWENmonopoly.monopoly.square;

import SWENmonopoly.monopoly.Player;

public class GoToJailSquare extends Square {
	private Square jail;
	
	public GoToJailSquare(String name, int index) {
		super(name, index);
	}
	
	public void setJail(Square jail){
		this.jail = jail;
	}

	@Override
	public void landedOn(Player p) {
		p.setLocation(jail);
		System.out.println(p.getName()+" Goes to jail!");
	}

}
