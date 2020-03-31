package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Entity;
import main.Handler;



public class Goal extends Entity{
	private int width, height, score;
	private boolean raised;

	
	public Goal(Handler handler, float x, float y, int width, int height, boolean raised) {
		super(handler, x, y);
		this.width = width;
		this.height = height;
		this.raised = raised;
		
		this.score = 0;
		//goal hitbox
		this.hitBox = new Rectangle((int)x, (int)y, width,height);
		
	}
    

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
	
	public void updateScore() {
		this.score +=1;
	}
	
	public int getScore() {
		return this.score;
	}
	
	
}
