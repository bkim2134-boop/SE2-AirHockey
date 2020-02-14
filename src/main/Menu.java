package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class Menu {
	
	private Dimension screenDimensions;
	private int WIDTH;
	
	public Rectangle playButton;
	public Rectangle exitButton;
	
	public Menu(Dimension screenDimensions) {
		this.screenDimensions = screenDimensions;
		this.WIDTH = screenDimensions.width;
		
		playButton = new Rectangle(50, 300, 200, 100);
		exitButton = new Rectangle(50, 500, 200, 100);
	}
	
	public void renderMainMenu(Graphics g) {
		
		g.setColor(Color.darkGray);
		g.drawRect(0, 0, screenDimensions.width, screenDimensions.height);
		
		Font font1 = new Font("arial", Font.BOLD, 100);
		g.setFont(font1);
		g.setColor(Color.gray);
		g.drawString("AIR HOCKEY", 50, 140);
		
		Font font2 = new Font("arial", Font.BOLD, 70);
		g.setFont(font2);
		g.drawString("PLAY", playButton.x + (playButton.width-g.getFontMetrics().stringWidth("PLAY"))/2, playButton.y + 75);
		g.drawString("EXIT", exitButton.x + (exitButton.width-g.getFontMetrics().stringWidth("EXIT"))/2, exitButton.y + 75);
		g.drawRoundRect(playButton.x, playButton.y, playButton.width, playButton.height, 20, 20);
		g.drawRoundRect(exitButton.x, exitButton.y, exitButton.width, exitButton.height, 20, 20);
		
	}
	
	
	
	
}
