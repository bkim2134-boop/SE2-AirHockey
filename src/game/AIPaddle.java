package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import game.gfx.ImageLoader;
import main.Entity;
import main.Game;
import main.Handler;

public class AIPaddle extends Entity {
   private Dimension mousePosition, paddlePosition, screenDimensions;
   int width;
   int height;
   private boolean isLeft, isRight;
   private BufferedImage testImage;
   public Puck puck;
   public double dx, dy;

   

    public AIPaddle(Handler handler, float x,float y,int width,int height, boolean isLeft, boolean isRight, Puck p){
        super(handler, x, y);
        this.isLeft = isLeft;
        this.isRight = isRight;
        this.width = width;
        this.height = height;
        this.puck = p;
        dx = puck.getX();
		dy = puck.getY();

        
        
        //screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        testImage = ImageLoader.loadImage("/texture/rink.png");
        screenDimensions = new Dimension(testImage.getWidth(), testImage.getHeight());


        
        
        //paddle hitbox
        this.hitBox = new Rectangle((int)x,(int)y,25,25);
        
    }
    
    

    @Override
    public void tick() {
    	if(dx != puck.getX() && dy != puck.getY()) {
			if(puck.getX() < this.x) {
				this.x -= 2;
			}
			else {
				this.x += 2;
			}
			if(puck.getY() < this.y) {
				this.y -= 2;
			}
			else {
				this.y += 2;
			}
		}   
    	
    }

    @Override
	public void render(Graphics g) {
        
        //g.fillOval((int)x,(int) y, 55,55);
        //this code is here to show mouse functionality with animation
        g.setColor(Color.black);
        g.fillOval((int)x-25,(int)y-25,width,height);
		
	}


	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return this.hitBox;
	}
	
	
	public void reset() {
		this.x = this.initialX;
    	this.y = this.initialY;
    	this.dx = 0;
    	this.dy = 0;
	}    

    
    
}
