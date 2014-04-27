package com.inspirelectronics.ld29.entities;

import com.inspirelectronics.ld29.graphics.Screen;
import com.inspirelectronics.ld29.graphics.Sprite;
import com.inspirelectronics.ld29.level.Level;

public abstract class Entity {
	
	protected Level level;
	
	private boolean removed = false;
	protected double x, y;
	protected Sprite sprite;
	
	public void init(Level level){
		this.level = level;
	}
	
	public abstract void render(Screen screen);
	public abstract void update();
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void remove(){
		this.removed = true;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public Sprite getSprite(){
		return this.sprite;
	}

}
