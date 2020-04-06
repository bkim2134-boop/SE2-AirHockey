package game;



import java.awt.*;
import java.awt.image.BufferedImage;

import game.gfx.ImageLoader;
import main.Entity;
import main.Handler;
//needs logic for when it collides with a side's goal
//we will make the collision just the wall
public class Puck extends Entity {
    //since the puck is technically drawn from a rectangle, the collision will work from four sides, top, right, bottom, left
    
    int width,height;
    Dimension screenDimensions;
    BufferedImage testImage;
    private double dx, dy;
    private boolean collided;
    public Puck(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y);
        this.width = width;
        this.height = height;
        this.dx = -3;
        this.dy = 1;
        //screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        testImage = ImageLoader.loadImage("/texture/rink.png");
		screenDimensions = new Dimension(testImage.getWidth(), testImage.getHeight());
        
        //puck hitbox
        this.hitBox = new Rectangle((int)x,(int)y,width,height);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void tick() {
    	
    	
        // TODO Auto-generated method stub
    	move();
    }

    @Override
    public void render(Graphics g) {
        //determines size of puck will have to change from hardcode to screen proportions
    	g.setColor(new Color(0, 0, 0));
        g.fillOval((int)x-12, (int)y-12, width,height);
       
        // TODO Auto-generated method stub

    }
    
   public void collision(Rectangle otherEntity) {
	   //in GameState you can see that I have passed the hitbox of the other entity
	   //does not differentiate between top and bottom collision.
	 
	  if(this.hitBox.intersects(otherEntity)) {
		  this.dx = dx * -1;
		  this.dy = dy * 1;
	  } 
   }
   public void collision2(Rectangle otherEntity) {
	   //in GameState you can see that I have passed the hitbox of the other entity
	   //does not differentiate between top and bottom collision.
	 
	  if(this.hitBox.intersects(otherEntity)) {
		  this.dx = dx * 1;
		  this.dy = dy * -1;
	  } 
   }
 
 
   
    public void move(){
    	
    	//since they are variables they can be changed, should really be 0 on initialization and just added and flipped when collided
    	this.x += dx;
    	this.y += dy;
    	this.hitBox.setRect(this.x, this.y, width, height);
    	
    	
    	
		
		
	}
    
    public void reset() {
    	this.x = this.initialX;
    	this.y = this.initialY;
    }

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return this.hitBox;
	}

}
