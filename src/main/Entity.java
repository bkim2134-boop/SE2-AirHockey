package main;

import main.Handler;
import java.awt.*;
public abstract class Entity{
    //floats allow for fluid movement, the calculations are not integer
    //starting position of entity
    protected float x, y;
    protected Handler handler;

    public Entity(Handler handler,float x, float y){
        this.x = x;
        this.y = y;
        this.handler = handler;

    }

    public abstract void tick();

    public abstract void render(Graphics g);
}