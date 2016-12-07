package collaberativeDrawingEnvironment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class DrawingGUI extends JFrame{
	private JFrame m_drawingFrame;
	private static final long serialVersionUID = 1L;
	private static final String FRAME_TITLE = "Collabrative Drawing Environment";
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private static final int CANVAS_WIDTH = 750;
	private static final int CANVAS_HEIGHT = 730;
	private boolean m_drawType;
	
	public DrawingGUI() {
		initializeCDE();
	}
	
	public void initializeCDE() {
		m_drawingFrame = new JFrame();
		m_drawingFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		m_drawingFrame.setTitle(FRAME_TITLE);
		m_drawingFrame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
				
		
		JPanel drawingTools = new JPanel();
		m_drawingFrame.add(drawingTools);
				
		JButton straightLine = new JButton("Straight Line");
		//straightLine.setForeground(SystemColor.textHighlight);
		//straightLine.setBackground(new Color(81, 18, 18));
		straightLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m_drawType = true;
			}
		});
		
		JButton particleTrace = new JButton("Particle Trace");
		//particleTrace.setForeground(SystemColor.textHighlight);
		//particleTrace.setBackground(new Color(81, 18, 18));
		particleTrace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m_drawType = false;
			}
		});
		
		JButton updateCanvas = new JButton("Update Canvas");
		//particleTrace.setForeground(SystemColor.textHighlight);
		//particleTrace.setBackground(new Color(81, 18, 18));
		updateCanvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JButton saveCanvas = new JButton("Save Canvas");
		//particleTrace.setForeground(SystemColor.textHighlight);
		//particleTrace.setBackground(new Color(81, 18, 18));
		saveCanvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton clearCanvas = new JButton("Clear");
		//particleTrace.setForeground(SystemColor.textHighlight);
		//particleTrace.setBackground(new Color(81, 18, 18));
		clearCanvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_drawingFrame.repaint();
			}
		});
		
		drawingTools.setLayout(new FlowLayout());
		
		JPanel canvas = new JPanel();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		canvas.setBackground(new Color(255,255,255));
		
		canvas.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				/*final int X_COORDINATE = e.getX();
				final int Y_COORDINATE = e.getY();
				final Rectangle CANVAS_AREA = canvas.getBounds();
				
				if (CANVAS_AREA != null && CANVAS_AREA.contains(X_COORDINATE, Y_COORDINATE)) {
					Cursor crosshairCursor = new Cursor(CROSSHAIR_CURSOR);
					canvas.setCursor(crosshairCursor);
				}
				else {
					Cursor defaultCursor = new Cursor(DEFAULT_CURSOR);
					canvas.setCursor(defaultCursor);
				}*/
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if (m_drawType == true) {
					Point start = new Point(e.getX(), e.getY());
					Point end = new Point((e.getX()), (e.getY()));
					Color color = new Color(0,0,0);
					StraightLine newLine = new StraightLine(start, end, color);
					canvas.add(newLine);
					Graphics g = canvas.getGraphics();
					newLine.draw(g);
				} 
			}
		});
		
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor crosshairCursor = new Cursor(CROSSHAIR_CURSOR);
				canvas.setCursor(crosshairCursor);
			}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {}
			
		});
		
		drawingTools.add(canvas);
		drawingTools.add(straightLine);
		drawingTools.add(particleTrace);
		drawingTools.add(updateCanvas);
		drawingTools.add(saveCanvas);
		drawingTools.add(clearCanvas);
		
		m_drawingFrame.setResizable(false);
		m_drawingFrame.setVisible(true);
	}
}
