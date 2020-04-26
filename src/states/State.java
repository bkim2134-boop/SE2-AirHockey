package states;

import main.Handler;

import java.awt.*;

public abstract class State{
    //which state we want to tick and render
    //state manager logic part 11 of the video series, with this setup we may need to build a menu state
    private static State currentState = null;
    private boolean switchState;
    
    protected Handler handler;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }
    
    public State(Handler handler){
        this.handler = handler;
    }
    public boolean getSwitchState() {
    	return this.switchState;
    }
    public abstract void tick();

    public abstract void render(Graphics g);


}