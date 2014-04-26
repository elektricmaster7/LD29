package com.inspirelectronics.ld29.graphics;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	
	public static Bitmap load(String path){
		Bitmap loadedFile = null;
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			loadedFile = new Bitmap(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loadedFile;
	}
	
	public int getWidth(){
		return w;
	}
	
	public int getHeight(){
		return h;
	}
}
