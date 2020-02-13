package game;

import java.awt.Graphics;
import main.Handler;
import main.Entity;

//needs logic for when it collides with a side's goal
//we will make the collision just the wall
public class Puck extends Entity {
    private int left,right,top,bottom;
    public Puck(Handler handler, float x, float y) {
        super(handler, x, y);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Graphics g) {
        //determines size of puck will have to change from hardcode to screen proportions
        g.fillOval((int)x, (int)y, 25,25);
        // TODO Auto-generated method stub

    }
   
}
