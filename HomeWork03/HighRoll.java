//Timothy Girvin 
//CMSI186
//Yahtzee.java

/*
Finally, make public class file HighRoll.java which uses your dice set to play the game. 
You will need to have a main that constructs the dice set, has rolls, and displays scores from each roll. 
The rules are as follows:

Implement a Textual User Interface (TUI) on the command line. This will display a list of options to the user, 
and will prompt for input. Based on that input your program will do what the user selected, 
then will display the results, a blank line or two, and then re-display the options.
Option 1 in the list must be: ROLL ALL THE DICE
Option 2 in the list must be: ROLL A SINGLE DIE
Option 3 in the list must be: CALCULATE THE SCORE FOR THIS SET
Option 4 in the list must be: SAVE THIS SCORE AS HIGH SCORE
Option 5 in the list must be: DISPLAY THE HIGH SCORE
Option 6 in the list must be: ENTER 'Q' TO QUIT THE PROGRAM
For option 2, you may present a second prompt to get the number of the die to roll, or you may handle 
it as two numbers on the entry. An example of the first method would be to enter a '2' at the prompt, 
then display a new prompt such as "which die?" and read the user input. An example of the second method 
would be to read "2 5" to re-roll only die number 5; this method means you must parse the input to get 
the die index.
See the notes below.
*/
import java.util.Scanner;
import java.io.*;
import java.util.*;


public class HighRoll {
	private HighRoll highRoll;
	private Scanner myScanner;

	/*
	public void main( String args[] ) {
		




		menu(); // holds all the options
		execute(); //gives the commands for each option
		rollAll(); //Rolls all the dice 
		rollSingle(); //Rolls a single die 
		calculateScore(); //calculates the score for this set 
		saveScore(); //saves the score as high score 
		displayScore(); //displays the high score 
		quitProgram(); //Quits the program 

	}
	*/


	public HighRoll() {
	    myScanner = new Scanner(System.in);
	    HighRoll highRoll = new HighRoll();
	}

	public void menu() {
	    int command;
	    boolean running = true;

	    while(running) {
	        displayMenu();
	        command = getCommand();
	        execute(command);
	    }
	}



	public void displayMenu() {
		System.out.println("Option 1: ROLL ALL THE DICE");
		System.out.println("Option 2: ROLL A SINGLE DIE");
		System.out.println("Option 3: CALCULATE THE SCORE FOR THIS SET");
		System.out.println("Option 4: SAVE THIS SCORE AS HIGH SCORE");
		System.out.println("Option 5: DISPLAY THE HIGH SCORE");
		System.out.println("Option 6: ENTER 'Q' TO QUIT THE PROGRAM");
	}


	public void execute(int command) {
		if (command == 1) {
			rollAll();
		}
		else if (command == 2) {
			rollSingle();
		}
		else if (command == 3) {
			calculateScore();
		}
		else if (command == 4) {
			saveScore();
		}
		else if (command == 5) {
			displayScore();
		}
		else if (command == 6) {
			quitProgram();
		}
		else {
			System.out.println("Command doesnt EXIST! Try again!");
		}
	}

	private int getCommand() {
    	System.out.print ("Enter command: ");
    	int command = myScanner.nextInt();
    	myScanner.nextLine(); 
    	return command;
	}

	public void rollAll() {
		System.out.println("Here are the numbers you rolled:");
		System.out.println(toString());

	}

	public void rollSingle() {
		System.out.println("Here is the number you rolled:");
		return ds[dieIndex].roll();
	}

	public void calculateScore() {

	}

	public void saveScore() {

	}

	public void displayScore() {

	}

	public void quitProgram() {
		int command = myScanner.nextInt();
		System.out.println("You Quit the Game!");
		System.exit("Q");
	}

}

