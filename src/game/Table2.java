package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.gfx.ImageLoader;
import main.Entity;
import main.Handler;

public class Table2 extends Entity{
	
	private double dx, dy;
	private BufferedImage testImage;
	
	public Table2(Handler handler, float x, float y) {
		super(handler, x, y);
		
		testImage = ImageLoader.loadImage("/texture/rink.png");
		//this.hitBox = new Rectangle(0,0,2,2000);
		this.hitBox = new Rectangle(0,0,testImage.getWidth(),1);
		//this.hitBox = new Rectangle(testImage.getWidth(),0,1,testImage.getHeight());
		//this.hitBox = new Rectangle(0,0,2000,1);
		// TODO Auto-generated constructor stub
	}
	

public void collision(Rectangle otherEntity) {
	   //in GameState you can see that I have passed the hitbox of the other entity
	   //does not differentiate between top and bottom collision.
	 
	
	  
}
@Override
public void tick() {
	// TODO Auto-generated method stub
	
}
@Override
public void render(Graphics g) {
	// TODO Auto-generated method stub
	
}
@Override
public Rectangle getHitBox() {
	// TODO Auto-generated method stub
	return this.hitBox;
}
}
 