package com.inspirelectronics.ld29.level.tiles;

import com.inspirelectronics.ld29.graphics.Art;
import com.inspirelectronics.ld29.level.Level;

public class FloorTile extends Tile {

	public FloorTile(int x, int y, Level level) {
		super(x, y, level);
		this.sprite = Art.getInstance().tiles.getSprite(0, 0);
	}

}
