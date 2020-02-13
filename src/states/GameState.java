package states;

import main.*;
import java.awt.*;
import game.*;

public class GameState extends State{
    private Dimension screenDimensions;
    private Paddle paddleLeft, paddleRight;
    private Puck puck;
    int initialLeftWidth;
   
    public GameState(Handler handler){
        super(handler);
        //this logic helps locate relative to screen size during the GameState render separately from the display class
        //have to change from get screensize to thomas' png for the display
        screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        initialLeftWidth = screenDimensions.width/5;
        paddleLeft = new Paddle(handler,initialLeftWidth,screenDimensions.height/2);
        paddleRight = new Paddle(handler,initialLeftWidth * 4, screenDimensions.height/2);
        puck = new Puck(handler,screenDimensions.width/2, screenDimensions.height/2);
    }
    public void tick(){
        paddleLeft.tick();
        paddleRight.tick();
        //test code to see if mouse position is being tracked
        System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
    }
    public void render(Graphics g){
        //paddle rendering
        paddleLeft.render(g);
        paddleRight.render(g);
        //puck rendering
        puck.render(g);
        g.setColor(Color.RED);

    }
}