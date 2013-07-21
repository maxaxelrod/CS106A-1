/*
 * File: Pyramid.java
 * Name:
 * Section Leader:
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

	public void run() {
		int rowCount = BRICKS_IN_BASE;
		double x_coordinate;
		double y_coordinate;
		
		while( rowCount > 0 ) {
			for ( int i = 0 ; i < rowCount ; i++) {
				x_coordinate = (getWidth() / 2) - ((rowCount / 2.0) * BRICK_WIDTH) + (i * BRICK_WIDTH);
				y_coordinate = (getHeight() - ((BRICKS_IN_BASE - rowCount + 1) * BRICK_HEIGHT));
				GRect brick = new GRect(x_coordinate, y_coordinate, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick);
			}
			rowCount--;
		}
	}
	
	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
}

