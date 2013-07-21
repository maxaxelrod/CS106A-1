/*
 * File: FindRange.java
 * Name:
 * Section Leader:
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		println("This program finds the largest and smallest numbers.");
		/*
		 * Initialize the first userInput and set maximum and minimum to this value
		 */
		int userInput = readInt("?");
		int maximum = userInput;
		int minimum = userInput;
		
		/*
		 * loop to receive userInput and set maximum and minimum when necessary
		 * Exit loop when userInput equals SENTINEL
		 */
		while( userInput != SENTINEL) {
			userInput = readInt("?");
			if (userInput == SENTINEL) break;
			if (userInput > maximum) { 
				maximum = userInput;
			} else if (userInput < minimum) {
				minimum = userInput;
			}
		}
		
		/*
		 * Print the appropriate outputs.
		 */
		if ( maximum == 0 && minimum == 0) {
			println("No numbers were entered.");
		} else {
			println("smallest: " + minimum);
			println("largest: " + maximum);
		}
	}
	
	private static final int SENTINEL = 0;
}

