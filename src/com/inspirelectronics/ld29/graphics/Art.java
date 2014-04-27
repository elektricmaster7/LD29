package com.inspirelectronics.ld29.graphics;

public class Art {
	private static Art instance = null;
	
	public SpriteSheet tiles;
	public SpriteSheet player;
	
	protected Art(){
		//Initialize ART
		tiles = new SpriteSheet(Bitmap.load("res/spritesheets/sheet1.png"), 8, 8);
		player = new SpriteSheet(Bitmap.load("res/spritesheets/player.png"), 8, 8);
		
		System.out.println("Art loaded!");
	}
	
	public static Art getInstance(){
		if(instance == null){
			instance = new Art();
		}
		return instance;
	}
}
