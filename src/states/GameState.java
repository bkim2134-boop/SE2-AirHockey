package states;

import main.*;
import java.awt.*;
import game.*;

public class GameState extends State{
    private Dimension screenDimensions;
    private Paddle paddleLeft, paddleRight;
    private Puck puck;
    private Goal goalLeft, goalRight;
    int initialLeftWidth;
   
    public GameState(Handler handler){
        super(handler);
        
        screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        initialLeftWidth = screenDimensions.width/5;
        
        paddleLeft = new Paddle(handler,initialLeftWidth,screenDimensions.height/2,100, 100,true,false);
        paddleRight = new Paddle(handler,initialLeftWidth * 4, screenDimensions.height/2,100,100,false,true);
        puck = new Puck(handler,screenDimensions.width/2, screenDimensions.height/2,50,50);
        goalLeft = new Goal(handler, 0, screenDimensions.height/2 - 125, 50,300,true);
        goalRight = new Goal(handler, screenDimensions.width-50, screenDimensions.height/2 - 125, 50 ,300,true);
    }
    
    public void collision() {
    	//maybe I should check for collision up here.
    	if(puck.getHitBox().intersects(goalLeft.getHitBox())) {
    		goalLeft.updateScore();
    		
    		puck.reset();
    	
    	}
    	else if(puck.getHitBox().intersects(goalRight.getHitBox())){
    		goalRight.updateScore();
    		
    		puck.reset();
    	
    	}
    	else if(puck.getHitBox().intersects(paddleLeft.getHitBox())) {
    		puck.collision(paddleLeft.getHitBox());
    		
    	}
    }
    
    public void tick(){
    	collision();
        paddleLeft.tick();
        paddleRight.tick();
        //could just add collision logic in the tick method for gamestate so that it has access to all three entities
        //eventually goal will also be added to the game state.
        puck.tick();
        
        
    }
    public void render(Graphics g){
        //paddle rendering
        paddleLeft.render(g);
        paddleRight.render(g);
        //puck rendering
        puck.render(g);
        goalLeft.render(g);
        goalRight.render(g);
       

    }
}