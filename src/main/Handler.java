package main;
import game.Table;

public class Handler{
    //is now a part of state class
    // in the example there is a World class which is responsible  for each
    // map we only have one map so we will instead just use the table class
    private Game game;
    //table will be render with a backdrop of a picture of an air hockey table
    //so we will just need to figure out what spots on the table we need to detect collision
    private Table table;
    public Handler(Game game){
        this.game = game;
    }
    public Game getGame(){
        return game;
    }
    public void setGame(Game game){
        this.game = game;
    }
    public Table getTable(){
        return table;
    }
}