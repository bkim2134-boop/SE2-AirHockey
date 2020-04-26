package states;

import main.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import game.*;
import game.gfx.ImageLoader;

public class GameState extends State{
    private Dimension screenDimensions;
    private BufferedImage testImage;
    private Player currentPlayer;
    private boolean switchState;

    private Paddle paddleLeft;
    private AIPaddle aipaddle;

    private Puck puck;
    private Goal goalLeft, goalRight;
    private Table table;
    private Table2 table2;
    private Table3 table3;
    private Table4 table4;
    int initialLeftWidth;
   
    public GameState(Handler handler){
        super(handler);
        this.switchState = false;
        
        testImage = ImageLoader.loadImage("/texture/rink.png");
		screenDimensions = new Dimension(testImage.getWidth(), testImage.getHeight());
        
        //screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        initialLeftWidth = screenDimensions.width/5;
        
        //always create a new player object, will simply just change the constructor input source depending on the 
        //prior existence of the player eg. from text or from menu state that had stored user input

        puck = new Puck(handler,screenDimensions.width/2, screenDimensions.height/2,24,24);
        currentPlayer = new Player("TestName");
        paddleLeft = new Paddle(handler,initialLeftWidth,screenDimensions.height/2,50, 50,true,false);
        aipaddle = new AIPaddle(handler,initialLeftWidth * 4, screenDimensions.height/2,50,50,false,true,puck);
        

        goalLeft = new Goal(handler, 43, 212, 53,116,true);
        goalRight = new Goal(handler, 862, 212, 53,116,true);
        table = new Table(handler, initialLeftWidth, initialLeftWidth);
        table2 = new Table2(handler, initialLeftWidth, initialLeftWidth);
        table3 = new Table3(handler, initialLeftWidth, initialLeftWidth);
        table4 = new Table4(handler, initialLeftWidth, initialLeftWidth);
    }
    
    public void collision() {
    	
    	if(puck.getHitBox().intersects(goalLeft.getHitBox())) {
    		goalLeft.updateScore();
    		puck.reset();
    		aipaddle.reset();

    	}
    	else if(puck.getHitBox().intersects(goalRight.getHitBox())){
    		goalRight.updateScore();
    		puck.reset();
    		aipaddle.reset();

    	}
    	else if(puck.getHitBox().intersects(table.getHitBox())) {
    		puck.collision(table.getHitBox());
    	}
    	else if(puck.getHitBox().intersects(table2.getHitBox())) {
    		puck.collision2(table2.getHitBox());
    	}
    	else if(puck.getHitBox().intersects(table3.getHitBox())) {
    		puck.collision(table3.getHitBox());
    	}
    	else if(puck.getHitBox().intersects(table4.getHitBox())) {
    		puck.collision2(table4.getHitBox());
    	}
    	puck.collisionPaddle(paddleLeft);
    	puck.AIcollisionPaddle(aipaddle);
    		
    }
    
    public void switchStateUpdate() {
    	if(goalRight.getScore() >= 1) {
    		this.switchState = true;
    	}
    }
    
    public boolean getSwitchState() {
    	return this.switchState;
    }
    
    public void tick(){
    	collision();
        paddleLeft.tick();
        
        //could just add collision logic in the tick method for gamestate so that it has access to all three entities
        //eventually goal will also be added to the game state.
        puck.tick();
        aipaddle.tick();
        switchStateUpdate();   
    }
    public void render(Graphics g){
        //paddle rendering
        paddleLeft.render(g);
        aipaddle.render(g);
        //puck rendering
        puck.render(g);
        goalLeft.render(g);
        goalRight.render(g);
       

    }
}