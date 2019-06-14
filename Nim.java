/**
  CST8110 Introduction to Computer Programming 
  Author: Marconi Fonseca
  section:330 lab teacher:Anissa Shaddy 
  Assignment #3: Date:Nov 15 2018 
 **/
import java.util.Random;
import java.util.Scanner;

public class Nim {

	private Pile pileA; // First pile
	private Pile pileB; // Second pile
	private Pile pileC;// Third pile
	private Random rnd = new Random(); // Random number generator
	private Scanner input = new Scanner(System.in);

	// ----------------------------------------------------------------
	public Nim() { // Default constructor, constructs the three piles
		pileA = new Pile();
		pileB = new Pile();
		pileC = new Pile();
	}

	public boolean PlayerMove() {// All the rules to handle user input
		System.out.print("\nSelect a pile: ");
		String pile = input.next();
		Boolean move = false;
		boolean check;
		do {
			check = false;
			if (pile.equalsIgnoreCase("a") && pileA.getSize() == 0) {
				System.out.print("\nPile A is empty, pick another : ");
				pile = input.next();

			} else if (pile.equalsIgnoreCase("b") && pileB.getSize() == 0) {
				System.out.print("\nPile B is empty, pick another : ");
				pile = input.next();
			} else if (pile.equalsIgnoreCase("c") && pileC.getSize() == 0) {
				System.out.print("\nPile C is empty, pick another: ");
				pile = input.next();
			} else {
				check = true;
			}
		} while (!check);

		while (!pile.equalsIgnoreCase("a") && !pile.equalsIgnoreCase("b") && !pile.equalsIgnoreCase("c")) {
			System.out.print("Invalid pile letter, select a, b or c\n");
			System.out.print("\nSelect a pile: ");
			pile = input.next();
		}

		System.out.print("How many do you want to remove? ");
		while (!input.hasNextInt())
			System.out.print(input.next() + " is a invalid input, please insert a valid value: ");
		int remove = input.nextInt();

		while (pile.equalsIgnoreCase("a") && (remove > pileA.getSize()) || (remove < 1)) {
			System.out.print("Pick a number between 1 and " + pileA.getSize() + ": ");
			remove = input.nextInt();
		}

		if (pile.equalsIgnoreCase("a")) {
			pileA.remove(remove);
			move = true;

		}

		while (pile.equalsIgnoreCase("b") && (remove > pileB.getSize()) || (remove < 1)) {
			System.out.print("Pick a number between 1 and " + pileB.getSize() + "\r\n");
			remove = input.nextInt();

		}

		if (pile.equalsIgnoreCase("b")) {
			pileB.remove(remove);
			move = true;
		}
		while (pile.equalsIgnoreCase("c") && (remove > pileC.getSize()) || (remove < 1)) {
			System.out.print("Pick a number between 1 and " + pileC.getSize() + "\r\n");
			remove = input.nextInt();
		}

		if (pile.equalsIgnoreCase("c")) {
			pileC.remove(remove);
			move = true;
		}
		if (done() == true) {
			System.out.println("Sorry, you lose");
		}

		return move;

	}

	public void computerRandomMove() {// Computer move if done randomly, is computerMove() in non-bonus version
		Pile compPile;
		boolean truecomp;
		char select;
		do {
			int pileRnd = rnd.nextInt(3);
			switch (pileRnd) {
			case 0:
				compPile = pileA;
				select = 'A';
				break;
			case 1:
				compPile = pileB;
				select = 'B';
				break;
			default:
				compPile = pileC;
				select = 'C';
				break;
			}
			if (compPile.getSize() == 0) {
				truecomp = false;
			} else {
				truecomp = true;
				int size = rnd.nextInt(compPile.getSize()) + 1;
				compPile.remove(size);
				System.out.println("Computer takes " + size + " from pile " + select);
			}

		} while (!truecomp);

		if (done() == true) {
			System.out.println("Congrats, you win");
		}

	}

	public void computerMove() { // All the rules to handle computer move
		

     }
	public boolean done() {
		if (pileA.getSize() == 0 && pileB.getSize() == 0 && pileC.getSize() == 0)
			return true;
		else
			return false;
	}

	public void printPiles() {// Print the current state of the piles

		System.out.println("\tA\tB\tC");
		System.out.println("\t" + pileA.getSize() + "\t" + pileB.getSize() + "\t" + pileC.getSize());
	}

}
