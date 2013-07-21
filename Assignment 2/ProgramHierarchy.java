/*
 * File: ProgramHierarchy.java
 * Name:
 * Section Leader:
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
//import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	public void run() {
		
		drawProgramBox();
		drawGraphicsProgramBox();
		drawConsoleProgramBox();
		drawDialogProgramBox();
		drawLines();

	}
	
	private void drawProgramBox() {
		GLabel label = new GLabel("Program"); // To get the label properties 
		double labelWidth = label.getWidth();
		double labelAscent = label.getAscent();
		double labelBoxOriginX = (getWidth() - BOXWIDTH) / 2;
		double labelBoxOriginY = (getHeight() / 2) - (BOXHEIGHT + OFFSET_Y);
		GRect labelBox = new GRect(labelBoxOriginX, labelBoxOriginY, BOXWIDTH, BOXHEIGHT);
		GLabel labelText = new GLabel("Program", (labelBoxOriginX + (BOXWIDTH - labelWidth) / 2), (labelBoxOriginY + (BOXHEIGHT + labelAscent) / 2));
		
		add(labelBox);
		add(labelText);
	}
	
	private void drawGraphicsProgramBox() {
		GLabel label = new GLabel("GraphicsProgram"); // To get the label properties 
		double labelWidth = label.getWidth();
		double labelAscent = label.getAscent();
		double labelBoxOriginX = (getWidth() - BOXWIDTH) / 2;
		double labelBoxOriginY = (getHeight() / 2) + OFFSET_Y;
		GRect labelBox = new GRect(labelBoxOriginX, labelBoxOriginY, BOXWIDTH, BOXHEIGHT);
		GLabel labelText = new GLabel("GraphicsProgram", (labelBoxOriginX + (BOXWIDTH - labelWidth) / 2), (labelBoxOriginY + (BOXHEIGHT + labelAscent) / 2));
		
		add(labelBox);
		add(labelText);
	}
	
	private void drawConsoleProgramBox() {
		GLabel label = new GLabel("ConsoleProgram"); // To get the label properties 
		double labelWidth = label.getWidth();
		double labelAscent = label.getAscent();
		double labelBoxOriginX = ((getWidth() - BOXWIDTH) / 2) - (BOXWIDTH + OFFSET_X);
		double labelBoxOriginY = (getHeight() / 2) + OFFSET_Y;
		GRect labelBox = new GRect(labelBoxOriginX, labelBoxOriginY, BOXWIDTH, BOXHEIGHT);
		GLabel labelText = new GLabel("ConsoleProgram", (labelBoxOriginX + (BOXWIDTH - labelWidth) / 2), (labelBoxOriginY + (BOXHEIGHT + labelAscent) / 2));
		
		add(labelBox);
		add(labelText);
	}
	
	private void drawDialogProgramBox() {
		GLabel label = new GLabel("DialogProgram"); // To get the label properties
		double labelWidth = label.getWidth();
		double labelAscent = label.getAscent();
		double labelBoxOriginX = ((getWidth() - BOXWIDTH) / 2) + (BOXWIDTH + OFFSET_X);
		double labelBoxOriginY = (getHeight() / 2) + OFFSET_Y;
		GRect labelBox = new GRect(labelBoxOriginX, labelBoxOriginY, BOXWIDTH, BOXHEIGHT);
		GLabel labelText = new GLabel("DialogProgram", (labelBoxOriginX + (BOXWIDTH - labelWidth) / 2), (labelBoxOriginY + (BOXHEIGHT + labelAscent) / 2));
		
		add(labelBox);
		add(labelText);
	}
	
	private void drawLines() {
		GLine centreLine = new GLine(getWidth() / 2, (getHeight() / 2) - OFFSET_Y, getWidth() / 2, (getHeight() / 2) + OFFSET_Y);
		GLine leftLine = new GLine(getWidth() / 2, (getHeight() / 2) - OFFSET_Y, getWidth() / 2 - (BOXWIDTH + OFFSET_X), (getHeight() / 2) + OFFSET_Y);
		GLine rightLine = new GLine(getWidth() / 2, (getHeight() / 2) - OFFSET_Y, getWidth() / 2 + (BOXWIDTH + OFFSET_X), (getHeight() / 2) + OFFSET_Y);
		add(centreLine);
		add(leftLine);
		add(rightLine);
	}

	
	private static final int BOXWIDTH = 150;
	private static final int BOXHEIGHT = 40;
	private static final int OFFSET_X = 60;
	private static final int OFFSET_Y = 25;
}

