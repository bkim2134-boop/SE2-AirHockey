package game;

import java.awt.*;

import main.Entity;
import main.Game;
import main.Handler;

public class Paddle extends Entity {
   private Dimension mousePosition, paddlePosition;


    public Paddle(Handler handler, float x,float y){
        super(handler, x, y);
        
    }
    

    @Override
    public void tick() {
        //make a square around the mouse and see if it collides with the left paddle, then if left is pressed, change its x and y according
        //to mouse position
        mousePosition = new Dimension(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY());
        paddlePosition = new Dimension((int)x,(int)y);
        if(handler.getGame().getMouseManager().isLeftPressed()&&mousePosition == paddlePosition){
            //x = handler.getMouseManager().getMouseX();
            //y = handler.getMouseManager().getMouseY();
            
        }
        // TODO Auto-generated method stub

    }

    @Override
	public void render(Graphics g) {
        
        //g.fillOval((int)x,(int) y, 55,55);
        //this code is here to show mouse functionality with animation
        g.setColor(Color.black);
        g.fillOval(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),55,55);
		
	}

  

    

    
    
}
