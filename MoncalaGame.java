package Moncala;

//TO DO: Display board and winner class
public class MoncalaGame {
	private Player player1;
	private Player player2;
	
	public MoncalaGame(Player player1, Player player2) {
		
		this.player1 = player1;
		this.player2 = player2;
	}
	
	
	
	public boolean takeATurn(int currentHollow, Player currentPlayer, Player otherPlayer) {
		
		if(currentHollow < 1 || currentHollow > 6) {
			 throw new IllegalArgumentException("Please choose a number between 1-6");
		}
		
		currentHollow--;
		
		//get the hollows array of the current player
		Hollows [] currentPlayerSide = currentPlayer.getPlayerSide();
		
		if(currentPlayerSide[currentHollow].getMarbleCount() == 0) {
			throw new IllegalArgumentException("Please choose a hollow with at least one marble.");
			
		}
		
		boolean goAgain = true;
		
		//get the amount of marbles in the starting hollow and clear the marbles
		int marblesToDrop = currentPlayerSide[currentHollow].getMarbleCount();
		currentPlayerSide[currentHollow].clearHollow();
		
		//drop the marbles in a for loop
		for(; marblesToDrop > 0; marblesToDrop--) {
			
			if(currentHollow < 5) {
			currentHollow++;
			currentPlayerSide[currentHollow].addMarble();
			}
			
			//if you reach your own Moncala, increase its count by 1
			else if(currentHollow == 5 && marblesToDrop > 0) {
				
				marblesToDrop--;
				currentPlayer.getMoncala().addMarble();
				
				//if there you landed the last marble in the moncala, go again
				if(marblesToDrop == 0) {
					currentPlayer.setPlayerSide(currentPlayerSide);
						return false;
				}
				
				//otherwise, continue dropping marbles on the other player's side
				else {
				marblesToDrop = moveToOtherPlayer(marblesToDrop, otherPlayer);
					if(marblesToDrop == 0) {
						currentPlayer.setPlayerSide(currentPlayerSide);
						return true;
					}
					
					//if you loop back around to the current player's side, start dropping marbles again from hollow 0
					else {
						currentHollow = 0;
					}
				}
				
			}
			
			
		}
		
		//if you land in an empty hollow (so now there is one marble in it), get your own last marble and the opposite
		//side's marble in the corresponding hollow
		if(currentPlayerSide[currentHollow].getMarbleCount() == 1 && marblesToDrop == 0) {

			int oppositeHollow = 0;
			
			Hollows [] otherPlayerSide = otherPlayer.getPlayerSide();
			
			switch (currentHollow) {
				case 0:
					oppositeHollow = 5;
					break;
				case 1:
					oppositeHollow = 4;
					break;
				case 2:
					oppositeHollow = 3;
					break;
				case 3:
					oppositeHollow = 2;
					break;
				case 4:
					oppositeHollow = 1;
					break;
				case 5:
					oppositeHollow = 0;
					break;
			}
		
			//add the marbles and clear the appropriate hollows
			currentPlayer.getMoncala().addMarbles(otherPlayerSide[oppositeHollow].getMarbleCount() + 1);
			otherPlayerSide[oppositeHollow].clearHollow();
			currentPlayerSide[currentHollow].clearHollow();
			
		}
		
		currentPlayer.setPlayerSide(currentPlayerSide);
		return true;
	}
	
	//method to move to the other player's hollows
	public int moveToOtherPlayer(int marblesToDrop, Player otherPlayer) {
		
		Hollows [] otherPlayerSide = otherPlayer.getPlayerSide();
		
		int currentHollow = 0;

		//drop the marbles in a for loop
		for(; marblesToDrop > 0; marblesToDrop--) {
			
			otherPlayerSide[currentHollow].addMarble();
			
			if(currentHollow == 5) {
				otherPlayer.setPlayerSide(otherPlayerSide);
				return marblesToDrop;
			}
			
			currentHollow++;
			
		}
		
		otherPlayer.setPlayerSide(otherPlayerSide);
		
		return 0;
	}
	
	public String determineWinner() {
		
		if(this.player1.getMoncala().getMarbleCount() > this.player2.getMoncala().getMarbleCount()) {
			return this.player1.getName();
		}
		
		else if (this.player1.getMoncala().getMarbleCount() == this.player2.getMoncala().getMarbleCount()){
		return "Its a Tie!";
		}
		
		else {
			return this.player2.getName();
		}
	}
		
	public Player getPlayer1() {
		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
}

