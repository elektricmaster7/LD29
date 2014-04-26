package com.inspirelectronics.ld29;

import com.inspirelectronics.ld29.graphics.Window;

public class Game implements Runnable{
	
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final String TITLE = "LD29";
	
	private boolean running;
	private Thread thread;
	private Window window;
	
	public void init(){
		//Setup Window
		window = new Window("LD29", 260, 160);
	}
	
	public void run() {
		init();
		System.out.println("ADAD");
	}
	
	public void render(){
		
	}
	
	public void update(){
		
	}
	
	public synchronized void start(){
		this.running = true;
		this.thread = new Thread(this, "Game Thread");
		this.thread.start();
	}
	
	public synchronized void stop(){
		this.running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
