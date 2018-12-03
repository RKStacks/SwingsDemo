
package com.drawing.api;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingPaintDemo1 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());
		JFrame f = new JFrame("Swing Paint Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(250, 250);
		f.add(new MyPanel());
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}

class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private int					squareX				= 50;
	private int					squareY				= 50;
	private int					squareW				= 20;
	private int					squareH				= 20;
	Connection					connection;

	public MyPanel() {
		if (connection == null)
		{
			//connection = DBConnection.getconnection();
		}
		setBorder(BorderFactory.createLineBorder(Color.black));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println("Mouse Pressed " + e.getPoint().x + " " + e.getPoint().y);
				moveSquare(e.getX(), e.getY());
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.err.println("Mouse Dragged " + e.getX() + " " + e.getY());
				moveSquare(e.getX(), e.getY());
			}
		});

	}

	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if ((squareX != x) || (squareY != y))
		{
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x;
			squareY = y;
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(250, 200);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw Text
		g.drawString("This is my custom Panel!", 10, 20);
		g.setColor(Color.RED);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
}
