package main;

import states.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private boolean running = false;
	
	private Thread thread;
	private Display display;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;

	private Handler handler;
	public Game() {
		
	}

	private void init() {
		
		display = new Display();
		display.canvas.createBufferStrategy(3);
		//declared as state but initialized as a GameState
		gameState = new GameState();
		State.setState(gameState);
		handler = new Handler(this);
		
	}
	
	private void tick() {
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, display.screenDimensions.width, display.screenDimensions.height);
		// Draw Here!
		
		
		
		//if state == null there will be an error thrwon 
		if(State.getState() != null){
			State.getState().render(g);
		}
		//commented out as it interfered with running tests on States
		//g.fillRect(0, 0, display.screenDimensions.width, display.screenDimensions.height);
		// End Drawing!
		bs.show();
		g.dispose();
	}
	

	@Override
	public void run() {

		init();
		
		FpsTimer timer = new FpsTimer(120);

		while(running) {
			if(timer.check()) {
				tick();
				render();
			}
		}
		
		stop();
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
