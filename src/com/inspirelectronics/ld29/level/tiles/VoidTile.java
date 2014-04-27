package com.inspirelectronics.ld29.level.tiles;

import com.inspirelectronics.ld29.graphics.Art;
import com.inspirelectronics.ld29.level.Level;

public class VoidTile extends Tile{

	public VoidTile(int x, int y, Level level) {
		super(x, y, level);
		this.sprite = Art.getInstance().tiles.getSprite(2, 0);
	}

	public boolean isSolid(){
		return true;
	}
}
