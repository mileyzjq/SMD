package SWENmonopoly.monopoly;

public class Die {
	public static final int MAX = 6;
	private int faceValue;
	
	public Die(){
		roll();
	}
	
	public void roll(){
		faceValue = (int)((Math.random()*MAX)+1);
	}
	
	public int getFaceValue() {
		return faceValue;
	}
}
