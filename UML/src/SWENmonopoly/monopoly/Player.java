package SWENmonopoly.monopoly;

import java.util.ArrayList;
import java.util.List;

import SWENmonopoly.monopoly.square.PropertySquare;
import SWENmonopoly.monopoly.square.RRSquare;
import SWENmonopoly.monopoly.square.Square;

public class Player {
	public static final int INIT_CASH = 1000;
	
	private String name;
	private Square location;
	private Board board;
	private int cash;
	private int netWorth;

	private int RRCount = 0;
	
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		location = board.getStartSquare();
		cash = INIT_CASH;
		netWorth = 0;
	}
	

	public void takeTurn() {
		//roll dice
		Cup.roll();
		int fvTot = Cup.getTotal();
		location = board.getSquare(location, fvTot);
		System.out.println(name+": dice total = "+fvTot+" move to "+location.getName());
		location.landedOn(this);
	}
	
	public void attempPurchase(PropertySquare property){
		int price = property.getPrice();
		if (cash >= price){
			property.setOwner(this);
			reduceCash(price);
			if (property instanceof RRSquare){
				RRCount++;
			}
			System.out.println(getName()+" buy "+property.getName());
		}
	}
	
	public Square getLocation(){
		return location;
	}
	
	public void setLocation(Square location){
		this.location = location;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCash(){
		return cash;
	}
	
	public int getNetWorth(){
		return netWorth;
	}
	
	public void addCash(int c){
		cash+=c;
	}
	
	public void reduceCash(int c){
		cash-=c;
	}
	
	public void addNetWorth(int c){
		netWorth+=c;
	}
	
	public void reduceNetWorth(int c){
		netWorth-=c;
	}
	
	public int getRRCount(){
		return RRCount;
	}
}
