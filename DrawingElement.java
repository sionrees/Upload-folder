package collaberativeDrawingEnvironment;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class DrawingElement extends JComponent{
	private static final long serialVersionUID = 1L;
	public abstract boolean isDrawable();
	public abstract boolean isVisible();
	public abstract void draw(Graphics g);
}
