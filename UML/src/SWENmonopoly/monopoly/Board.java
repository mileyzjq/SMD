package SWENmonopoly.monopoly;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import SWENmonopoly.monopoly.square.GoSquare;
import SWENmonopoly.monopoly.square.GoToJailSquare;
import SWENmonopoly.monopoly.square.IncomeTaxSquare;
import SWENmonopoly.monopoly.square.LotSquare;
import SWENmonopoly.monopoly.square.RRSquare;
import SWENmonopoly.monopoly.square.RegularSquare;
import SWENmonopoly.monopoly.square.Square;
import SWENmonopoly.monopoly.square.UtilitySquare;

public class Board {
	public static final int SIZE = 40;
	
	public static final int INDEX_GO = 0;
	public static final int INDEX_INCOME_TAX = 4;
	public static final int INDEX_JAIL = 10;
	public static final int INDEX_GO_TO_JAIL = 30;
	public static final int INDEX_RR[] = {5,15,25,35}; // Sorted
	public static final int INDEX_UTILITY[] = {12,28}; // Sorted
	public static final int INDEX_LOT[] = {2,17,33};   // Sorted
	
	public static final int PRICE_RR = 300;
	public static final int PRICE_LOT = 200;
	public static final int PRICE_UTILITY = 200;
	
	// ArrayList is used here as per the textbook.
	// Since the size is fixed, an array could have been used.
	private List<Square> squares = new ArrayList<Square>(SIZE);
	
	public Board(){
		buildSquares();
	}
	
	public Square getSquare(Square start, int distance){
		int endIndex = (start.getIndex() + distance) % SIZE;
		return squares.get(endIndex);
	}
	
	public Square getStartSquare(){
		return squares.get(INDEX_GO);
	}
	
	private void buildSquares(){
		for(int i = 0; i < SIZE; i++){
			Square s;
			if(INDEX_GO == i){
				s = new GoSquare("GO",i);
			}else if(INDEX_INCOME_TAX == i){
				s = new IncomeTaxSquare("Income Tax",i);
			}else if(INDEX_GO_TO_JAIL == i){
				s = new GoToJailSquare("Go to jail",i);
			}else if(INDEX_JAIL == i){
				s = new RegularSquare("Jail",i);
			}else if(contains(INDEX_UTILITY,i)){
				s = new UtilitySquare("Utility",i,PRICE_UTILITY);
			}else if(contains(INDEX_LOT,i)){
				s = new LotSquare("Lot",i,PRICE_LOT);
			}else if(contains(INDEX_RR,i)){
				s = new RRSquare("Railroad",i,PRICE_RR);
			}else{
				s = new RegularSquare("Square "+i,i);
			}
			squares.add(s);
		}
		//set jail square
		((GoToJailSquare)squares.get(INDEX_GO_TO_JAIL)).setJail(squares.get(INDEX_JAIL));
	}
	
	private boolean contains(int list[], int element){
		return IntStream.of(list).anyMatch(x -> x == element);
	}

}
