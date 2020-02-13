package states;
import java.awt.*;

public abstract class State{
    //which state we want to tick and render
    //state manager logic part 11 of the video series, with this setup we may need to build a menu state
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }
    
    public abstract void tick();

    public abstract void render(Graphics g);


}