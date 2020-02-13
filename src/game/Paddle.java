package game;

import java.awt.Graphics;

import main.Entity;
import main.Game;
import main.Handler;

public class Paddle extends Entity {
   
    public Paddle(Handler handler, float x,float y){
        super(handler, x, y);
        
    }
    

    @Override
    public void tick() {
        if(handler.getGame().getMouseManager().isLeftPressed()){
            y-=3;
        }
        // TODO Auto-generated method stub

    }

    @Override
	public void render(Graphics g) {
        //determines size of paddle will have to change from hardcode to screen proportions
		g.fillOval((int)x,(int) y, 55,55);
		
	}

  

    

    
    
}
