package com.inspirelectronics.ld29.graphics;

import java.awt.event.KeyEvent;

import com.inspirelectronics.ld29.entities.Mob;
import com.inspirelectronics.ld29.input.Keyboard;

public class MobAnimation extends Animation{
	
	public Mob mob;
	public Sprite[][] animation_sheet;
	public int start_x, start_y;
	
	private int[] anim = {1, 0, 1, 2};
	
	public MobAnimation(Mob mob, SpriteSheet sheet, int start_x, int start_y){
		this.mob = mob;
		this.start_x = start_x;
		this.start_y = start_y;
		this.animation_sheet = buildAnimation(sheet);
	}
	
	public void render(Screen screen, int x, int y){
		int frame = mob.steps / 15 % anim.length;
		screen.render(animation_sheet[anim[frame]][mob.direction], x, y);
	}
	
	public void update(){
	}
	
	private Sprite[][] buildAnimation(SpriteSheet sheet){
		Sprite[][] sprites = new Sprite[3][4];
		for(int y = 0; y < 4; y++){
			int a_y = start_y + y;
			for(int x = 0; x < 3; x++){
				int a_x = start_x + x;
				sprites[x][y] = sheet.getSprite(a_x, a_y);
			}
		}
		return sprites;
	}
	
}
