/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run()
	{
		repairColumn();
		while (frontIsClear()) {
			moveToNextColumn();
			repairColumn();
		}
	}
	
	/*
	 * Assuming that all columns are 4 avenues apart
	 */
	private void moveToNextColumn() {
		move();
		move();
		move();
		move();
	}
	
	/*
	 * Pre-condition: Robot is facing east along street 1
	 * Post-condition: Ronot is facing east along street 1
	 */
	private void repairColumn() {
		turnLeft();
		workOnColumn();
		descendColumn();
		turnLeft();
	}
	
	/*
	 * Pre-condition: Robot facing north
	 * Post-condition: Robot facing south
	 * Robot moves down after completed repairing column
	 */
	private void descendColumn() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
	}
	
	/*
	 * Robot already facing north. Will drop beeper if 
	 * no beeper is present at corner
	 */
	private void workOnColumn() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		/*
		 * Work on highest street below column
		 */
		if (noBeepersPresent()) {
			putBeeper();
		}
	}

}
