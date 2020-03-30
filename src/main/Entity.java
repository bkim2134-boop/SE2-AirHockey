package main;

import main.Handler;
import java.awt.*;
public abstract class Entity{
    //floats allow for fluid movement, the calculations are not integer
    //starting position of entity
    protected float x, y;
    protected Handler handler;
    protected Rectangle hitBox;

    public Entity(Handler handler,float x, float y){
        this.x = x;
        this.y = y;
        this.handler = handler;
        //instantiates the hitbox at the starting position of the entity.
        

    }

    public abstract void tick();

    public abstract void render(Graphics g);
    
    public abstract Rectangle getHitBox();
    
}