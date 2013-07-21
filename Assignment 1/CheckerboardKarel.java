/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		while (leftIsClear()) {
			fillStreet();
			ascendToNextStreet();
		}
		if(leftIsBlocked()) {
			fillStreet();
		}
	}
	/*
	 * Next street available is already checked in run() 
	 */
	private void ascendToNextStreet() {
		turnLeft();
		move();
		turnRight();
	}
	
	private void fillStreet() {
		turnRight();
		/*
		 * Move to last street to check whether is even or odd street.
		 * Presence of beeper at first avenue means last street was odd
		 */
		if(frontIsClear()) {
			move();
			turnAround();
			if(beepersPresent()) {
				move();
				turnRight();
				fillEvenStreet();
			}
			else {
				move();
				turnRight();
				fillOddStreet();
			}
		}
		else {
			turnLeft();
			fillOddStreet(); // fill first street
		}
		goToFirstAvenue();
	}
	/*
	 * Set Karel to go back to 1st avenue facing East
	 */
	private void goToFirstAvenue() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	private void fillOddStreet() {
		putBeeper();
		while(frontIsClear()) {
			move();
			if(frontIsClear()) {
				move();
				putBeeper();
			}		
		}
		
	}
	private void fillEvenStreet() {
		while(frontIsClear()) {
			move();
			putBeeper();
			if(frontIsClear()) {
				move();
			}		
		}
	}
	
}