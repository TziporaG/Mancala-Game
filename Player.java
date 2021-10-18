package Moncala;

public class Player {
	
	private String name;
	private Hollows[] playerSide = new Hollows[6];
	private Moncala moncala;
	
	public Player(String name) {
		
		this.name = name;
		
		for(int i = 0; i < playerSide.length; i++) {
			
			playerSide[i] = new Hollows(); 
		}
		
		moncala = new Moncala();
	}
	
	public Player() {

	}
	
	public Hollows[] getPlayerSide() {
		
		Hollows[] arrayCopy = new Hollows[this.playerSide.length];
		
		for(int i = 0; i < this.playerSide.length; i++) {
			
			arrayCopy[i] = this.playerSide[i];
			
		}
		return arrayCopy;
	}
	
	public void setPlayerSide(Hollows [] updatedPlayerSide) {
		
		for(int i = 0; i < this.playerSide.length; i++) {
			
			this.playerSide[i] = updatedPlayerSide[i];
			
		}
		
	}
	
	public Moncala getMoncala() {
		
		return this.moncala;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	//check if hollows are empty
	public boolean areAllHollowsEmpty() {
		
		for(int i = 0; i < playerSide.length; i ++) {
			
			if(playerSide[i].getMarbleCount() != 0) {
				return false;
			}
		}
		return true;
	}
}
