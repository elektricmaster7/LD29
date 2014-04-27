package com.inspirelectronics.ld29.level;

import java.util.Random;

public class Dungeon {
	
	public Random rand;
	public long seed;

	public int width, height;
	private int[] dungeon_map;
	
	private final int clear = 0;
	private final int floor = 1;
	private final int wall = 2;
	
	public Dungeon(int width, int height){
		this.width = width;
		this.height = height;
		this.seed = System.currentTimeMillis();
		this.rand = new Random(this.seed);
		
		this.dungeon_map = new int[width * height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				dungeon_map[x + y * width] = clear;
			}
		}
		makeRoom(10, 10);
	}
	
	public void setCell(int x, int y, int celltype){
		dungeon_map[x + y * width] = celltype;
	}
	
	public int getCell(int x, int y){
		return dungeon_map[x + y * width];
	}
	
	public boolean makeRoom(int x, int y){
		for(int yy = 0; yy < 8; yy++ ){
			int yt = yy + y;
			for(int xx = 0; xx < 10; xx++ ){
				int xt = xx + x;
				if(yy == 0){
					System.out.print("0");
					dungeon_map[xt + yt * width] = wall;
				}else{
					System.out.print(".");
					dungeon_map[xt + yt * width] = floor;
				}
			}
			System.out.print("\n");
		}
		
		return true;
	}
}
