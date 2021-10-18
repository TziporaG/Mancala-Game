package Moncala;

public class Hollows {
	private int marbleCount;
	
	//all hollows have 4 initial marbles in it
	public Hollows() {
		
		marbleCount = 4;
	}
	
	public void setMarbleCount(int marbleCount) {
		
		if(marbleCount < 0) {
			throw new IllegalArgumentException("Marble count can not be less than 0.");
		}
		
		this.marbleCount = marbleCount;
	}
	
	public int getMarbleCount() {
		
		return this.marbleCount;
	}
	
	public void addMarble() {
		
		marbleCount++;
	}
	
	public void clearHollow() {
		
		this.marbleCount = 0;
	}

	}


