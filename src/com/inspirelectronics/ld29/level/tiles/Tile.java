package com.inspirelectronics.ld29.level.tiles;

import com.inspirelectronics.ld29.graphics.Screen;
import com.inspirelectronics.ld29.graphics.Sprite;
import com.inspirelectronics.ld29.level.Level;

public class Tile {
	
	public Level level;
	public Sprite sprite;
	public int x, y;
	
	public Tile(int x, int y, Level level){
		this.x = x;
		this.y = y;
		this.level = level;
	}
	
	public void render(Screen screen){
		screen.render(sprite, (x * sprite.getWidth()) + level.xOffset, (y * sprite.getHeight()) + level.yOffset);
	}
	
	public boolean isSolid(){
		return false;
	}
}
