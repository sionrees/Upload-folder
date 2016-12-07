package collaberativeDrawingEnvironment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class StraightLine extends DrawingElement {
	private static final long serialVersionUID = 1L;
	private final Point START_POINT;
	private final Point END_POINT;
	private final Color COLOR;
	
	public StraightLine(Point start, Point end, Color BLACK) {
		this.START_POINT = start;
		this.END_POINT = end;		
		this.COLOR = BLACK;
	}

/*	public void addLine(Point START_POINT, Point END_POINT, Color color) {
	    LINES.add(new StraightLine(START_POINT, END_POINT, color));        
	    DrawingGUI.class.canvas.repaint();
	}*/

	
	public boolean isDrawable() {
		return true;		
	}

	public boolean isVisible() {
		return true;
		
	}

	public void draw(Graphics g) {
		super.paintComponent(g);
		g.setColor(COLOR);
	    g.drawLine((int) START_POINT.getX(), (int) START_POINT.getY(), (int) END_POINT.getX(), (int) END_POINT.getY());
	}
}

	

