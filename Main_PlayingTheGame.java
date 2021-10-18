package Moncala;

import java.util.*;

public class Main_PlayingTheGame {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Moncala!");
		System.out.println("The game moves counter-clockwise");
		System.out.println("Each players moncala is to his right.");
		System.out.println("Enjoy!");
		System.out.println("------------------------------------------");

		// Initialize two player objects
		System.out.print("Enter the name of the first player: ");
		Player player1 = new Player(input.nextLine());

		System.out.print("Enter the name of the second player: ");
		Player player2 = new Player(input.nextLine());

		// Initialize MoncalaGame object
		MoncalaGame game = new MoncalaGame(player1, player2);

		Player currentPlayer = player1;
		Player otherPlayer = player2;
		
		//play until one side has empty hollows
		while (!player1.areAllHollowsEmpty() && !player1.areAllHollowsEmpty()) {

			displayBoard(player1, player2);

			System.out.println("\n\n" + currentPlayer.getName()
					+ ", pick a hollow (1-6) to begin your turn.");
			System.out.print("Choice: ");

			int choice = input.nextInt();

			while (choice < 1 || choice > 6) {
				System.out.println("Error! Choice must be between 1 and 6");
				System.out.println("Choice: ");
				choice = input.nextInt();
			}

			while (currentPlayer.getPlayerSide()[choice - 1].getMarbleCount() == 0) {
				System.out.println("Error! Can not pick a hollow that has no marbles in it");
				System.out.println("Choice: ");
				choice = input.nextInt();
			}
			
			//call the takeAturn method
			//If the return is false, the current player goes again. Otherwise, switch players
			boolean switchTurns = game.takeATurn(choice, currentPlayer, otherPlayer);

			if (switchTurns) {
				Player temp = currentPlayer;

				currentPlayer = otherPlayer;
				otherPlayer = temp;
			}


		}

		displayBoard(player1, player2);
		System.out.print("\n\nGame over! Winner: " + game.determineWinner());

	}

	public static void displayBoard(Player player1, Player player2) {
		
		//player 1 hollows must be printed backwards
		System.out.print("\t\t\t" + player1.getName() + "\n");
		System.out.print("  ------------------------------------------------------\n\t");
		for (int i = player1.getPlayerSide().length - 1; i >= 0; i--) {

			System.out.print(player1.getPlayerSide()[i].getMarbleCount() + "\t");
		}

		System.out.println("\n  " + player1.getMoncala().getMarbleCount() +  "  |" 
				+ "\t\t\t\t\t\t   " + "|  " + player2.getMoncala().getMarbleCount());

		System.out.print("\t");
		for (int i = 0; i < player2.getPlayerSide().length; i++) {

			System.out.print(player2.getPlayerSide()[i].getMarbleCount() + "\t");
		}
		
		System.out.println("\n  ------------------------------------------------------");
		System.out.print("\t\t\t" + player2.getName());
					
		
	}
}
