import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class DrawFace extends GraphicsProgram {
	private static final double HEAD_WIDTH = 100;
	private static final double HEAD_HEIGHT = 150;
	private static final double EYE_RADIUS = 10;
	private static final double MOUTH_WIDTH = 60;
	private static final double MOUTH_HEIGHT = 20;
	
	public void run() {
		drawFace();	
	}
	
	private void drawFace() {
		double cx, cy; // x and y coordinates of centre of face
		cx = getWidth() / 2;
		cy = getHeight() / 2;
		double x, y; // x and y coordinates of origin of face 
		x = cx - HEAD_WIDTH / 2;
		y = cy - HEAD_HEIGHT / 2;
		
		GRect face = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		face.setColor(Color.BLACK);
		face.setFillColor(Color.GRAY);
		face.setFilled(true);
		
		add(face);
		
		drawMouth(cx - MOUTH_WIDTH / 2, cy + (1 * HEAD_HEIGHT) / 4 - MOUTH_HEIGHT / 2);
		drawEye(cx - HEAD_WIDTH / 4, cy - HEAD_HEIGHT / 4); // left eye
		drawEye(cx + HEAD_WIDTH / 4, cy - HEAD_HEIGHT / 4); // right eye
	}
	/*
	 * cx, cy are coordinates of centre of mouth
	 */
	private void drawMouth( double cx, double cy) {
		GRect mouth = new GRect(cx, cy, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFillColor(Color.WHITE);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		
		add(mouth);
	}
	/*
	 * cx, cy are coordinates of centre of eyes
	 */
	private void drawEye( double cx, double cy) {
		double x = cx - EYE_RADIUS;
		double y = cy - EYE_RADIUS;
		GOval eye = new GOval(x, y, 2 * EYE_RADIUS, 2 * EYE_RADIUS);
		eye.setColor(Color.YELLOW);
		eye.setFilled(true);
		
		add(eye);;
		
	}
	
	
	
	

}
