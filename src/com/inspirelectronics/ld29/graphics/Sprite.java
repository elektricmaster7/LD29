package com.inspirelectronics.ld29.graphics;

public class Sprite {
	
	public Bitmap bitmap;
	public int offsetX = 0, offsetY = 0;
	
	public Sprite(){
		
	}
	
	public Sprite(Bitmap bitmap){
		this.bitmap = bitmap;
	}
	
	public void render(int x, int y, Screen screen){
		screen.render(bitmap, x+offsetX, y+offsetY);
	}
	
	public int getWidth(){
		return bitmap.getWidth();
	}
	
	public int getHeight(){
		return bitmap.getHeight();
	}
}
