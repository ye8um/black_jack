import java.util.Scanner;
import java.util.zip.ZipEntry;

public class black_jack 
{
	private final Scanner scanner = new Scanner(System.in);
	private int p1, p2, d1, d2, pSum, pSumA1,pSumA2;

	public static void main(String[] args) 
	{
		black_jack game = new black_jack();
		game.playGame();
	}

	private void playGame() 
	{
		System.out.println("Welcome to Blackjack!");

		shuffle();
		playerTurn();
		playerDecision();
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
		pSum = p1+p2;
		if(p1 ==1)
			pSumA1 = 11+p2;
		if(p2 ==1)
			pSumA2 = 11+p1;
		d1 = randomCard();
		d2 = randomCard();
	}
	private static String toCard(int n)
	{
		String ans = ""+n;
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
		String fc = toCard(p1);
		String sc = toCard(p2);
		System.out.println(fc + " " +sc);
	}

	private void playerDecision()
	{
		System.out.println("Hit?");
		if(scanner.next().equals("y"))
		{
			int n= randomCard();
			System.out.println(toCard(n));
			if(n>10)
				pSum = pSum +10;
			else
				pSum = pSum +n;
		
			if(pSum >21)
				System.out.println("You busted!");
			else
				playerDecision();
		}
	}
	private void dealerTurn() 
	{
	}

	private void determineWinner() 
	{
	}
}