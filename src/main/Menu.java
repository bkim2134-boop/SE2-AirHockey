package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class Menu {
	
	public Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
	int WIDTH = screenDimensions.width;
	
	public Rectangle playButton = new Rectangle((WIDTH/2)-45, 600, 200, 100);
	public Rectangle exitButton = new Rectangle((WIDTH/2)-45, 800, 200, 100);
	
	public void renderMenu1(Graphics g) {
	
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font font1 = new Font("arial", Font.BOLD, 100);
		g.setFont(font1);
		g.setColor(Color.black);
		g.drawString("AIR HOCKEY", (WIDTH/2)-230, 400);
		
		Font font2 = new Font("arial", Font.BOLD, 70);
		g.setFont(font2);
		g.drawString("PLAY", playButton.x + 5, playButton.y + 70);
		g.drawString("EXIT", exitButton.x + 20, exitButton.y + 70);
		g2d.draw(playButton);
		g2d.draw(exitButton);
	
		
	}
	
	
	
	
}
