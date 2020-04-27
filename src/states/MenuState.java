package states;

import main.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import game.*;
import game.gfx.ImageLoader;
public class MenuState extends State{
	private boolean switchState;
	JButton button;
	private Dimension screenDimensions;
    private BufferedImage testImage; 
	
	public MenuState (Handler handler) {
		super(handler);
		this.switchState = false;
		JButton button = new JButton("Submit");
		button.setBounds(0,0,25,25);
		button.setEnabled(true);
		
		testImage = ImageLoader.loadImage("/texture/rink.png");
		screenDimensions = new Dimension(testImage.getWidth(), testImage.getHeight());
	}
	
	public boolean getSwitchState() {
		return this.switchState;
	}
	//require button actionlistener, on event e we have to run our search. but for now we can implement a the switch back to 
	//game state
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("AIR HOCKEY", screenDimensions.width/2 -15, 15);
		g.drawString("I Am BUTTON", 25,25);
	}
}
