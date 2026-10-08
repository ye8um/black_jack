import java.util.Scanner;

public class black_jack 
{
	private final Scanner scanner = new Scanner(System.in);
	private int p1, p2, d1, d2;

	public static void main(String[] args) 
	{
		black_jack game = new black_jack();
		game.playGame();
	}

	private void playGame() 
	{
		System.out.println("Welcome to Blackjack!");

		// TODO: Create and shuffle a deck, then deal cards to the player and dealer.
		shuffle();
		playerTurn();
		System.out.println(randomCard());
		dealerTurn();
		determineWinner();
	}

	private static int randomCard()
	{
		int n = (int)(Math.random()*13) +1;
		return n;
	}
	private void shuffle()
	{
		p1 = randomCard();
		p2 = randomCard();
		d1 = randomCard();
		d2 = randomCard();
	}
	private static String card(int n)
	{
		String ans = n;
		if(n == 1)
			ans = "Ace";
		if(n == 11)
			ans = "Jack";
		if(n == 12)
			ans = "Queen";
		if(n == 13)
			ans = "King";
		return ans;
	}
	private void playerTurn() 
	{
		String fc = card(p1);
		String sc = card(p2);

		System.out.println(fc);
		System.out.println(sc);
	}

	private void dealerTurn() 
	{
		// TODO: Make the dealer draw cards until reaching the required score.
	}

	private void determineWinner() 
	{
		// TODO: Compare hand scores and announce the result.
	}
}