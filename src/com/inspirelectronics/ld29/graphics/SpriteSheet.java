package com.inspirelectronics.ld29.graphics;

public class SpriteSheet {
	
	public Bitmap bitmap;
	public int sw, sh;
	
	public SpriteSheet(Bitmap bitmap, int sw, int sh){
		this.bitmap = bitmap;
		this.sw = sw;
		this.sh = sh;
	}
	
	public Sprite getSprite(int sx, int sy){
		Bitmap buffer = new Bitmap(sw, sh); 
		int x = sx * sw;
		int y = sy * sh;
		for (int yy = 0; yy < sh; yy++) {
			int yp = yy + y;
			for(int xx = 0; xx < sw; xx++){
				int xp = xx + x;
				if (xp < 0 || xp >= bitmap.getWidth() || yp < 0 || yp >= bitmap.getHeight()) continue;
				buffer.pixels[xx + yy * buffer.getWidth()] = bitmap.pixels[xp + yp * bitmap.getWidth()];
			}
		}
		return new Sprite(buffer);
	}
}
