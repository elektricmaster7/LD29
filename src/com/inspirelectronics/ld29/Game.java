package com.inspirelectronics.ld29;

public class Game {
	
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final String TITLE = "LD29";

	public Game(){
		
	}
	
	public synchronized void start(){
		
	}
	
	public synchronized void stop(){
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}
