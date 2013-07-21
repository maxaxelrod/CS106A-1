/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;

import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board
 *  Should not be used directly (use getWidth()/getHeight() instead).
 *  * */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		setup();
		while(life > 0) {
			addMouseListeners();
			addKeyListeners();
			waitForClick();
			startGame();
		}
		displayEndGame();	
	}
	
	private void displayEndGame() {
		removeAll();
		GLabel endMessage = new GLabel("Thank you for playing.");
		endMessage.setLocation((WIDTH - endMessage.getWidth()) / 2, (HEIGHT - endMessage.getAscent()) / 2);
		endMessage.setFont("sans serif-16");
		add(endMessage);
	}
	
	/**
	 * Creates the ball in the centre of the board and starts the ball rolling downwards.
	 */
	private void startGame() {
		// ball = new GOval((WIDTH - BALL_RADIUS) / 2, (HEIGHT - BALL_RADIUS) / 2, BALL_RADIUS * 2, BALL_RADIUS * 2 ); 
		ball.setFilled(true);
		ball.setColor(Color.BLACK);
		add(ball);
		
		/* Start ball rolling */
		vx = rgen.nextDouble(1.0, 3.0);
		if(rgen.nextBoolean(0.5)) vx = -vx;
		vy = rgen.nextDouble(2.0, 6.0);
		while(true) {
			if(ball.getX() <= 0 || ball.getX() >= WIDTH - BALL_RADIUS * 2) {
				vx = -vx;
			}
			if(ball.getY() >= HEIGHT - BALL_RADIUS * 2 || ball.getY() <= 0) {
				vy = -vy;
			}
			ball.move(vx, vy);
			if(ball.getY() > paddle.getY()) {
				life--;
				break;
			} else {
				if(bricks_num == 0) {
					break;
				}
			}
			pause(PAUSE_TIME);
			bounceAfterCollision();
		}
	}
	/**
	 * Check what object the ball collided with.
	 * If paddle, ball is reflected.
	 * If brick, ball is reflected and brick is removed.
	 */
	private void bounceAfterCollision() {
		GObject collider = getCollidingObject();
		if(collider != null) {
			if(collider == paddle) {
				vy = -vy;
			} else {
				vy = -vy;
				remove(collider);
				bricks_num--;
			}
		}
	}
	
	private GObject getCollidingObject() {
		GPoint collidingPoint1 = new GPoint(ball.getX(), ball.getY());
		GPoint collidingPoint2 = new GPoint(ball.getX() + 2 * BALL_RADIUS, ball.getY());
		GPoint collidingPoint3 = new GPoint(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
		GPoint collidingPoint4 = new GPoint(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
		GObject collider = null;
		if(getElementAt(collidingPoint1.getX(), collidingPoint1.getY()) != null) {
			collider = getElementAt(collidingPoint1.getX(), collidingPoint1.getY());
		} else {
			if(getElementAt(collidingPoint2.getX(), collidingPoint2.getY()) != null) {
				collider = getElementAt(collidingPoint2.getX(), collidingPoint2.getY());
			} else {
				if(getElementAt(collidingPoint3.getX(), collidingPoint3.getY()) != null) {
					collider = getElementAt(collidingPoint3.getX(), collidingPoint3.getY());
				} else {
					if(getElementAt(collidingPoint4.getX(), collidingPoint4.getY()) != null) {
						collider = getElementAt(collidingPoint1.getX(), collidingPoint1.getY());
					}
				}
			}
		}
		return collider;
	}

	/**
	 * Setup the bricks and the paddle
	 */
	private void setup() {
		if(ball != null) remove(ball); // remove ball after one life loss
		setupBricks();
		setupPaddle();
	}
	/**
	 * Setup the bricks	
	 */
	private void setupBricks() {
		for(int i = 0 ; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				int brickOffsetY = BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP);
				int firstOffsetX = (WIDTH - ((NBRICKS_PER_ROW * BRICK_WIDTH) + (NBRICKS_PER_ROW - 1) * BRICK_SEP)) / 2;
				int brickOffsetX = firstOffsetX + j * (BRICK_WIDTH + BRICK_SEP);
				GRect brick = new GRect(brickOffsetX, brickOffsetY, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				/* Set brick color*/
				switch(i) {
				case 0:
				case 1: brick.setColor(Color.RED); break;
				case 2:
				case 3: brick.setColor(Color.ORANGE); break;
				case 4:
				case 5: brick.setColor(Color.YELLOW); break;
				case 6:
				case 7: brick.setColor(Color.GREEN); break;
				case 8:
				case 9: brick.setColor(Color.CYAN); break;
				default: break;
				}
				add(brick);
			}
		}
	}
	/**
	 * Setup the paddle	
	 */
	private void setupPaddle() {
		paddle = new GRect((WIDTH - PADDLE_WIDTH) / 2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setColor(Color.BLACK);
		paddle.setFilled(true);
		add(paddle);
	}
	/**
	 * 
	 */
	public void mouseMoved(MouseEvent e) {
		if(e.getX() > WIDTH - PADDLE_WIDTH) {
			paddle.setLocation(WIDTH - PADDLE_WIDTH , HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		} else {
			paddle.setLocation(e.getX() , HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}		
	}
	
	private GRect paddle;
	private GOval ball = new GOval((WIDTH - BALL_RADIUS) / 2, (HEIGHT - BALL_RADIUS) / 2, BALL_RADIUS * 2, BALL_RADIUS * 2 ); 
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int PAUSE_TIME = 20;
	private int life = NTURNS;
	private int bricks_num = 100;
}
