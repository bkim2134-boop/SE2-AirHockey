package main;

import states.*;
import input.MouseManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import game.Table;
import game.gfx.ImageLoader;
import java.awt.event.*;


public class Game implements Runnable {

	private boolean running = false;
	
	private Thread thread;
	private Display display;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;
	private State gameState;
	private State menuState;

	private Handler handler;
	
	private MouseManager mouseManager;
	private Menu menu;
	
	public static enum STATE{
		MENU,
		GAME
	};
	
	public static STATE state = STATE.MENU;
	
	public Game() {
		mouseManager = new MouseManager();
	}

	private void init() {
		
		display = new Display();
		display.canvas.createBufferStrategy(3);
		testImage = ImageLoader.loadImage("/texture/rink.png");
		
		
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		handler = new Handler(this);
		menu = new Menu(display.screenDimensions);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		State.setState(gameState);
		
	}

	private void tick() {
		
		mouseManager.tick();
		if(State.getState() != null){
			State.getState().tick();
			if(State.getState().getSwitchState() && State.getState() == menuState) {
				State.setState(gameState);
			}
			else if(State.getState().getSwitchState() && State.getState() == gameState) {
				State.setState(menuState);
				
				
				//this is where pass to get a goal
			}		
			
		}
		//require state switching logic
		
	}
	
	private void render() {
		bs = display.canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, display.screenDimensions.width, display.screenDimensions.height);
		// Draw Here!
		
		if(State.getState() == gameState) {
			
			g.drawImage(testImage, 0, 0, null);
			State.getState().render(g);
			
		}
		else if(State.getState() == menuState) {
			
			g.drawRect(0, 0, testImage.getWidth(), testImage.getHeight());
			State.getState().render(g);
		}
		
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

	public MouseManager getMouseManager(){
		return mouseManager;
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
