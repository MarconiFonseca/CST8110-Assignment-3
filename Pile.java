/**
  CST8110 Introduction to Computer Programming 
  Author: Marconi Fonseca
  section:330 lab teacher:Anissa Shaddy 
  Assignment #3: Date:Nov 15 2018 
 **/
import java.util.Random;

public class Pile {
	
	private Random rnd = new Random(); // Random number generator
	private int size;  // The current size of pile
	//-----------------------------------------------
	public Pile() {// Default constructor (Non-bonus version)
		
	size = (rnd.nextInt(11) + 10);
	}
	public Pile(int size) { // Initial constructor (Bonus version)
		this.size=size;
	}
	public int getSize() {
		return size;	// get current size of pile
	
	}
	public void remove(int delete) { // remove the amount from pile
		size = size-delete;
		
	}

}
