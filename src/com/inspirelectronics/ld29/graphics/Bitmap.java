package com.inspirelectronics.ld29.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Bitmap {
	
	public int w, h;
	public int[] pixels;
	
	public Bitmap(int w, int h){
		this.w = w;
		this.h = h;
		this.pixels = new int[w * h];
	}
	
	public Bitmap(Bitmap bitmap){
		this.w = bitmap.w;
		this.h = bitmap.h;
		this.pixels = bitmap.pixels;
	}
	
	public Bitmap(BufferedImage image){
		this.w = image.getWidth();
		this.h = image.getHeight();
		this.pixels = new int[w * h];
		image.getRGB(0, 0, w, h, pixels, 0, w);
	}
	
	public int getWidth(){
		return w;
	}
	
	public int getHeight(){
		return h;
	}
}
