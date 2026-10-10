import java.util.Scanner;
import java.util.zip.ZipEntry;

public class black_jack 
{
	private final Scanner scanner = new Scanner(System.in);
	private int[] p, d;
	private int pSum, dSum;

	public static void main(String[] args) 
	{
		black_jack game = new black_jack();
		while(true)
		{
			game.playGame();
			System.out.println("Press 'r' to play again.");
			if(!game.scanner.next().equals("r"))
				break;
		}
		
	}

	private void playGame() 
	{
		System.out.println("Welcome to Blackjack!");

		shuffle();
		playerTurn();
		playerDecision(1);
		if(pSum <=21)
		{
			dealerTurn(1);
			determineWinner();
		}
	}

	private static int randomCard()
	{
		int n = (int)(Math.random()*13) +1;
		return n;
	}
	private void shuffle()
	{
		p = new int[21];
		d = new int[21];
		p[0] = randomCard();
		p[1] = randomCard();
		pSum = p[0] + p[1];
		
		d[0] = randomCard();
		d[1] = randomCard();
		dSum = d[0] + d[1];
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
		String fc = toCard(p[0]);
		String sc = toCard(p[1]);
		System.out.println(fc + " " +sc);
	}

	private void playerDecision(int n)
	{
		System.out.println("Hit? (y/n)");
		if(scanner.next().equals("y"))
		{
			int c = randomCard();
			System.out.println(toCard(c));
			if(c>10)
				pSum = pSum +10;
			else
				pSum = pSum +c;
		
			if(pSum >21)
				System.out.println("You busted!");
			else
				playerDecision(n + 1);
		}
	}
	private void dealerTurn(int n) 
	{
		if(d[0] ==1)
			if(dSum +10 <=21 || dSum + 10>=16)
				dSum = dSum +10;
		if(d[1] ==1)
			if(dSum +10 <=21 || dSum + 10>=16)
				dSum = dSum +10;
		if(dSum<16)
			d[n+1] = randomCard();
			if(d[n+1] > 10)
				dSum = dSum + 10;
			else
				dSum = dSum + d[n+1];
			if(dSum < 16)
				dealerTurn(n + 1);
	}

	private void determineWinner() 
	{
		if(dSum>21)
		{
			System.out.println("Dealer busted!");
			System.out.println("You Won!");
			return;
		}
		//System.out.println("Your Total: " +pSum +" --- " +"Dealer's Total: " + dSum);
		System.out.print("Your Cards:");
		for(int i=0; i<21; i++)
			if(p[i]!=0)
				System.out.print(toCard(p[i]) + " ");
			else
				break;
		System.out.println();
		System.out.print("Dealer's Cards: ");
		for(int i=0; i<21; i++)
			if(d[i]!=0)
				System.out.print(toCard(d[i]) + " ");
			else
				break;
		System.out.println();
		if(dSum == pSum)
		{
			System.out.println("It's a tie!");
		}
		else if(pSum>dSum)
			System.out.println("You Won!");
		else
			System.out.println("You Lost!");
	}
}