
/**
  CST8110 Introduction to Computer Programming 
  Author: Marconi Fonseca
  section:330 lab teacher:Anissa Shaddy 
  Assignment #3: Date:Nov 15 2018 
 **/

public class Assign3 { // Main for the misère NIM game

	public static void main(String[] args) { // Program main
		System.out.print("Welcome to the NIM game\r\n" + "We play by the misère rules \r\n");
		Nim nim = new Nim();
		boolean player;
        do {
	        nim.printPiles();
	        player = nim.PlayerMove();
	        if(player && !nim.done()) {
		        nim.printPiles();
	            nim.computerRandomMove();}
	        }while(!nim.done());
      
	}
}
	   
        

