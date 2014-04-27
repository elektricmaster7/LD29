package com.inspirelectronics.ld29.level.tiles;

import com.inspirelectronics.ld29.graphics.Art;
import com.inspirelectronics.ld29.level.Level;

public class WallTile extends Tile{
	
	public WallTile(int x, int y, Level level) {
		super(x, y, level);
		this.sprite = Art.getInstance().tiles.getSprite(1, 0);
	}
	
	public boolean isSolid(){
		return true;
	}
}
