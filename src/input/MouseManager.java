package input;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

//maybe make mouse an entity?????
public class MouseManager implements MouseInputListener {
  
    private boolean leftPressed;
    private int mouseX, mouseY;

    public boolean up;

    public MouseManager(){
    
    }
    public void tick(){
     
    }
    public boolean isLeftPressed(){
        return leftPressed;
    }

    public int getMouseX(){
        return mouseX;
    }

    public int getMouseY(){
        return mouseY;
    }

  

    @Override
    public void mouseClicked(MouseEvent e) {
        
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //only listening to left button
        if(e.getButton()==MouseEvent.BUTTON1){
            leftPressed = true;
        }
        
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            leftPressed = false;
        }
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //position of mouse at a given time
        mouseX = e.getX();
        mouseY = e.getY();
        // TODO Auto-generated method stub

    }
    
    
}