import java.awt.Color;
import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;

public class RandomCircles extends GraphicsProgram{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void run() {
		/* Creates 10 random circles */
		for(int i = 0 ; i < 10 ; i++) {
			createRandomCircle(); 
		}
	}
	/**
	 * Creates a random circle of size between 50 and 300 px
	 * @Creates a random circle of size between 50 and 300 px
	 */
	private void createRandomCircle() {
		/* Creates a random circle */
		double diameter = rgen.nextDouble(SMALLEST_DIAMETER, LARGEST_DIAMETER);
		GOval circle = new GOval(diameter, diameter);
		Color color = rgen.nextColor();
		/* Get another random color if white was returned */
		while(true) {
			if(color != Color.WHITE) break;
			color = rgen.nextColor(); 
		}
		circle.setColor(color);
		circle.setFilled(true);
		
		/* Create a random coordinates set */
		double x = rgen.nextDouble(0, getWidth() - diameter);
		double y = rgen.nextDouble(0, getHeight() - diameter);
		
		add(circle, x, y);
	}
	
	private static final RandomGenerator rgen = new RandomGenerator();
	private static final double SMALLEST_DIAMETER = 10;
	private static final double LARGEST_DIAMETER = 250;
}
