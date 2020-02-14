package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Display {

	private static final long serialVersionUID = 952862544727287473L;

	private JFrame frame;
	public Canvas canvas;
	public Dimension screenDimensions;
	
	public Display() {
		
		screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame("Air Hockey");
		frame.setSize(screenDimensions.width, screenDimensions.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// Close on Escape
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent key) {
				if(key.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
		});
		
		canvas = new Canvas();
		canvas.setPreferredSize(screenDimensions);
		canvas.setMaximumSize(screenDimensions);
		canvas.setMinimumSize(screenDimensions);
		
		
		frame.add(canvas);
		frame.pack();
		
	}

	public JFrame getFrame(){
		return frame;
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
}
