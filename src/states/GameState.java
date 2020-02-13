package states;
import main.*;
import java.awt.*;

public class GameState extends State{
    private Dimension screenDimensions;
    public GameState(){
        //this logic helps locate relative to screen size during the GameState render separately from the display class
        screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
    }
    public void tick(){

    }
    public void render(Graphics g){
        //this is test code, it just draws 2 ovals relative to the screensize
        g.fillOval(screenDimensions.width/4, screenDimensions.height/4, 45, 45);
        g.fillOval(screenDimensions.width/2, screenDimensions.height/2, 45, 45);
    }
}