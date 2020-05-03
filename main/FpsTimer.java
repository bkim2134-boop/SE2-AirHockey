package main;

public class FpsTimer {
	
	private double timePerTick;
	private double delta;
	private long now;
	private long lastTime;
	private int ticks;
	private long timer;

	public FpsTimer(int fps) {
		
		 timePerTick = 1e9 / fps;
		 delta = 0;
		 lastTime = System.nanoTime();
		
	}
	
	public boolean check() {
		now = System.nanoTime();
		delta = (now - lastTime) / timePerTick;
		
		if(timer >= 1e9) {
			System.out.println("Ticks and Frames: " + ticks);
			ticks = 0;
			timer = 0;
		}
		
		if (delta >= 1) {
			timer += now - lastTime;
			lastTime = now;
			ticks++;
	   		return true;
	  	} else {
	  		return false;
	  	}
	}
	
}
