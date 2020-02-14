package game;

import java.awt.Color;
import java.awt.Graphics;
import main.Handler;
import main.Entity;

//needs logic for when it collides with a side's goal
//we will make the collision just the wall
public class Puck extends Entity {
    //since the puck is technically drawn from a rectangle, the collision will work from four sides, top, right, bottom, left
    private int left,right,top,bottom;
    public Puck(Handler handler, float x, float y) {
        super(handler, x, y);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        move();
    }

    @Override
    public void render(Graphics g) {
        //determines size of puck will have to change from hardcode to screen proportions
    	g.setColor(new Color(0, 0, 0));
        g.fillOval((int)x, (int)y, 25,25);
        // TODO Auto-generated method stub

    }

    public void move(){
		x -= 0.01;

	}

}
