package com.inspirelectronics.ld29.graphics;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.inspirelectronics.ld29.input.Keyboard;
import com.inspirelectronics.ld29.input.Mouse;

public class Display {
	
	private Window window;
	private float scale = 1.0f;
	private Graphics g;
	private BufferStrategy bs;
	
	public Display(Window window){
		this.window = window;
		window.createBufferStrategy(3);
		bs = window.getBufferStrategy();
		g = bs.getDrawGraphics();
	}
	
	public Display(Window window, float scale){
		this.window = window;
		this.scale = scale;
		window.createBufferStrategy(3);
		bs = window.getBufferStrategy();
		g = bs.getDrawGraphics();
		setupInput();
	}
	
	public void setScale(float scale){
		this.scale = scale;
	}
	
	private void setupInput(){
		window.addKeyListener(new Keyboard());
		window.addMouseListener(new Mouse(scale));
		window.addMouseMotionListener(new Mouse(scale));
	}
	
	public Graphics getGraphics() throws Exception{
		if(g == null){
			throw new Exception("Graphics are not defined!");
		}
		return g;
	}
	
	public void draw(BufferedImage image){
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, (int) (window.getWidth() * scale), (int) (window.getHeight() * scale), null);
	}
	
	public void show(){
		g.dispose();
		bs.show();
	}
	
}
