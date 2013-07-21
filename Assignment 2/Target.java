/*
 * File: Target.java
 * Name:
 * Section Leader:
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		int circle_diameter; // diameter of largest circle 
		int circle_origin_x;
		int circle_origin_y;
		/*
		 * Draw 3 circles from largest to smallest
		 */
		for(int i = 3 ; i > 0 ; i--){
			circle_diameter = 24 * i;
			circle_origin_x = (getWidth() - circle_diameter) / 2;
			circle_origin_y = (getHeight() - circle_diameter) / 2;
			GOval circle = new GOval( circle_origin_x , circle_origin_y , circle_diameter, circle_diameter);
			circle.setFilled(true);
			if(i % 2 != 0){
				circle.setColor(Color.RED);
			} else {
				circle.setColor(Color.WHITE);
			}
			add(circle);
		}	
	}
}
