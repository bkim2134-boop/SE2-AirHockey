package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Entity;
import main.Handler;

//if puck collides with goal it should reset to the middle of the screen 

public class Goal extends Entity{
	private int width, height;
	private boolean raised;

	
	public Goal(Handler handler, float x, float y, int width, int height, boolean raised) {
		super(handler, x, y);
		this.width = width;
		this.height = height;
		this.raised = raised;
		//goal hitbox
		this.hitBox = new Rectangle((int)x, (int)y, width,height);
		
	}
    //could be made as left and right sides of the screen for first launch and resized in later launches :)

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	
	}
	


	@Override
	public void render(Graphics g) {
		g.draw3DRect((int)x, (int)y, width, height, raised);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return this.hitBox;
	}
	
	
}
