package game;

public class Player {
	private String name;
	private int highscore;
	private float quickest_goal;
	
	public Player(String name) {
		this.name = name;
		this.highscore = 0;
		this.quickest_goal = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHighscore() {
		return this.highscore;
	}
	
	public float quickest_goal() {
		return this.quickest_goal;
	}
	
	public void setHighscore(int newHighscore) {
		this.highscore = newHighscore;
	}
	
}
