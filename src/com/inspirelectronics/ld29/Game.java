package com.inspirelectronics.ld29;

import java.awt.event.KeyEvent;

import com.inspirelectronics.ld29.entities.Player;
import com.inspirelectronics.ld29.graphics.Art;
import com.inspirelectronics.ld29.graphics.Color;
import com.inspirelectronics.ld29.graphics.Display;
import com.inspirelectronics.ld29.graphics.Screen;
import com.inspirelectronics.ld29.graphics.Window;
import com.inspirelectronics.ld29.input.Keyboard;
import com.inspirelectronics.ld29.input.Mouse;
import com.inspirelectronics.ld29.level.Level;

public class Game implements Runnable{
	
	public static final int WIDTH = 1280/2;
	public static final int HEIGHT = 720/2;
	public static final float SCALE = 2.0f;
	public static final String TITLE = "LD29";
	
	//Logic
	private boolean running;
	private Thread thread;
	
	//Graphics
	public int framerate = 60;
	public Screen screen;
	private Display display;
	
	public int position_x = 0;
	public int position_y = 0;
	
	public int mx, my;
	
	public Level level;
	public Player player;
	
	public void init(){
		//Setup Window
		display = new Display(new Window(TITLE, WIDTH, HEIGHT), SCALE);
		screen = new Screen(WIDTH, HEIGHT, SCALE);
		
		Art.getInstance();
		
		level = new Level(16, 10);
		player = new Player(8, 8);
		level.add(player);
	}
	
	public void run() {
		init();
		long lt = System.nanoTime();
		double dt = 0;
		double ns = 1000000000.0 / framerate;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		while(running){
			long now = System.nanoTime();
			dt += (now - lt) / ns;
			lt = now;
			if(dt >= 1){
				update();
				updates++;
				dt--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(frames+"fps, "+updates+"ups");
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public void render(){
		screen.clear();
		
		//level.setOffset(-position_x, -position_y);
		level.render(screen);
		
		//screen.fillRect(position_x, position_y, 8, 8, Color.GREEN);
		
		if(Mouse.buttonDown(Mouse.LEFT_BUTTON)){
			screen.fillRect(mx, my, 10, 10, Color.GREEN);
		}
		
		show();
	}
	
	public void update(){
		mx = Mouse.getX();
		my = Mouse.getY();
		
		level.update();
		
	}
	
	public void show(){
		screen.flip();
		display.draw(screen.getImage());
		display.show();
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
