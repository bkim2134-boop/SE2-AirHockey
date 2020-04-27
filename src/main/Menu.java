package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;

import game.gfx.ImageLoader;


public class Menu extends JFrame{
	
	private Dimension screenDimensions;
	private int WIDTH;
	
	public Rectangle playButton;
	public Rectangle exitButton;
	private JFrame gameFrame;
	private BufferedImage testImage;
	private JButton enter;
	
	public Menu(Dimension screenDimensions) {
		testImage = ImageLoader.loadImage("/texture/rink.png");
		screenDimensions = new Dimension(testImage.getWidth(), testImage.getHeight());
		this.WIDTH = screenDimensions.width;
		gameFrame = new JFrame("AirHockey Game");
		enter = new JButton("Enter");
		enter.setLocation(10, 10);
		
		
		playButton = new Rectangle(50, 300, 200, 100);
		exitButton = new Rectangle(50, 500, 200, 100);
	}
	public void startMenu() {
		gameFrame.setVisible(true);
		gameFrame.add(enter);
	}

		
	
	
	
	
	public void renderMainMenu(Graphics g) {
		
//		g.setColor(Color.darkGray);
//		g.drawRect(0, 0, screenDimensions.width, screenDimensions.height);
//		
//		Font font1 = new Font("arial", Font.BOLD, 100);
//		g.setFont(font1);
//		g.setColor(Color.gray);
//		g.drawString("AIR HOCKEY", 50, 140);
//		
//		Font font2 = new Font("arial", Font.BOLD, 70);
//		g.setFont(font2);
//		g.drawString("PLAY", playButton.x + (playButton.width-g.getFontMetrics().stringWidth("PLAY"))/2, playButton.y + 75);
//		g.drawString("EXIT", exitButton.x + (exitButton.width-g.getFontMetrics().stringWidth("EXIT"))/2, exitButton.y + 75);
//		g.drawRoundRect(playButton.x, playButton.y, playButton.width, playButton.height, 20, 20);
//		g.drawRoundRect(exitButton.x, exitButton.y, exitButton.width, exitButton.height, 20, 20);
		
	}
	
	
	
	
}
