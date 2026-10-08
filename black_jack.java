import java.util.Scanner;

public class black_jack {
	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		black_jack game = new black_jack();
		game.playGame();
	}

	private void playGame() {
		System.out.println("Welcome to Blackjack!");

		// TODO: Create and shuffle a deck, then deal cards to the player and dealer.
		playerTurn();
		dealerTurn();
		determineWinner();
	}

	private void playerTurn() {
		// TODO: Ask the player to hit or stand and update their hand.
	}

	private void dealerTurn() {
		// TODO: Make the dealer draw cards until reaching the required score.
	}

	private void determineWinner() {
		// TODO: Compare hand scores and announce the result.
	}
}