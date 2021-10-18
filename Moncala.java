package Moncala;

public class Moncala extends Hollows{

	public Moncala() {
		
		super();
		this.setMarbleCount(0);
	}
	
	public void addMarbles(int marbles) {
		
		int currentMarbles = this.getMarbleCount();
		
		this.setMarbleCount(currentMarbles + marbles);
		
	}
	
}
