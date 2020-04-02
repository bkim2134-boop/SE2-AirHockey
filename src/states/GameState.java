package states;

import main.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import game.*;
import game.gfx.ImageLoader;

public class GameState extends State{
    private Dimension screenDimensions;
    private BufferedImage testImage;
    private Paddle paddleLeft, paddleRight;
    private Puck puck;
    private Goal goalLeft, goalRight;
    int initialLeftWidth;
   
    public GameState(Handler handler){
        super(handler);
        
        testImage = ImageLoader.loadImage("/texture/rink.png");
		screenDimensions = new Dimension(testImage.getWidth(), testImage.getHeight());
        
        //screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        initialLeftWidth = screenDimensions.width/5;
        
        paddleLeft = new Paddle(handler,initialLeftWidth,screenDimensions.height/2,50, 50,true,false);
        paddleRight = new Paddle(handler,initialLeftWidth * 4, screenDimensions.height/2,50,50,false,true);
        puck = new Puck(handler,screenDimensions.width/2, screenDimensions.height/2,25,25);
        goalLeft = new Goal(handler, 43, 212, 53,116,true);
        goalRight = new Goal(handler, 862, 212, 53,116,true);
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
    	else if(puck.getHitBox().intersects(paddleRight.getHitBox())) {
    		puck.collision(paddleRight.getHitBox());
    		
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