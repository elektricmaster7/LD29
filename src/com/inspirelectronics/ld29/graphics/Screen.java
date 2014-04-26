package com.inspirelectronics.ld29.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {

	public int width, height;
	public float scale;
	public int[] buffer, image_pixels;
	
	private BufferedImage image;
	
	public Screen(int width, int height, float scale) {
		this.width = (int) (width / scale);
		this.height = (int) (height / scale);
		this.scale = scale;
		buffer = new int[this.width * this.height];
		image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		image_pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}
	
	public void render(Bitmap bitmap, int x, int y){
		for (int yy = 0; yy < bitmap.getHeight(); yy++) {
			int yp = yy + y;
			for (int xx = 0; xx < bitmap.getWidth(); xx++) {
				int xp = xx + x;
				if (xp < 0 || xp >= width || yp < 0 || yp >= height) continue;
				buffer[xp + yp * width] = bitmap.pixels[xx + yy * bitmap.getWidth()];
			}
		}
	}
	
	public void flip(){
		for(int i = 0; i < width * height; i++){
			image_pixels[i] = buffer[i];
		}
	}
	
	public void clear(Color color){
		for(int i = 0; i < width * height; i++){
			buffer[i] = color.getColor();
		}
	}
	
	public void clear(){
		clear(Color.BLACK);
	}
	
	public void fillRect(int x, int y, int width, int height, Color color) {
		for (int yy = y; yy < y + height; yy++) {
			for (int xx = x; xx < x + width; xx++) {
				if (xx < 0 || xx >= this.width || yy < 0 || yy >= this.height) continue;
				buffer[xx + yy * this.width] = color.getColor();
			}
		}
	}
	
	public BufferedImage getImage(){
		return image;
	}

}
