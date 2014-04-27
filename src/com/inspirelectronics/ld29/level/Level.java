package com.inspirelectronics.ld29.level;

import java.util.ArrayList;
import java.util.List;

import com.inspirelectronics.ld29.entities.Entity;
import com.inspirelectronics.ld29.graphics.Screen;
import com.inspirelectronics.ld29.level.tiles.FloorTile;
import com.inspirelectronics.ld29.level.tiles.Tile;
import com.inspirelectronics.ld29.level.tiles.VoidTile;
import com.inspirelectronics.ld29.level.tiles.WallTile;

public class Level {
	
	public int width, height;
	public int xOffset, yOffset;
	public Tile[] tiles;
	
	protected List<Entity> entities = new ArrayList<Entity>();
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width * height];
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x + y * width] = new FloorTile(x, y, this);
			}
		}
		
		tiles[8 + 4 * width] = new WallTile(8, 4, this);
		
		Dungeon dungeon = new Dungeon(100, 100);
	}
	
	public void render(Screen screen){
		renderTiles(screen);
		renderEntities(screen);
	}
	
	
	public void renderTiles(Screen screen){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x + y * width].render(screen);
			}
		}
	}
	
	public void renderEntities(Screen screen){
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}
	
	public void update(){
		updateEntities();
	}
	
	public void updateEntities(){
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}
	
	public void add(Entity e){
		e.init(this);
		entities.add(e);
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public Tile getTile(int x, int y){
		if (x < 0 || x >= width || y < 0 || y >= height) return new VoidTile(x, y, this);
		return tiles[x + y * width];
	}
}
