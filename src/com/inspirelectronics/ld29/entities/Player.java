package com.inspirelectronics.ld29.entities;

import java.awt.event.KeyEvent;

import com.inspirelectronics.ld29.Game;
import com.inspirelectronics.ld29.graphics.Art;
import com.inspirelectronics.ld29.graphics.MobAnimation;
import com.inspirelectronics.ld29.graphics.Screen;
import com.inspirelectronics.ld29.input.Keyboard;

public class Player extends Mob{

	public Player(int x, int y){
		this.x = x;
		this.y = y;
		this.sprite = Art.getInstance().player.getSprite(0, 1);
		this.setAnimation(new MobAnimation(this, Art.getInstance().player, 0, 0));
	}
	
	public void render(Screen screen) {
		if(animation != null){
			animation.render(screen, (int) (screen.width/2)/2 - 4, (int) (screen.height/2)/2 - 4);
		}else{
			screen.render(sprite, (int) (screen.width/2)/2 - 4, (int) (screen.height/2)/2 - 4);
		}
		
	}

	public void update() {
		int xa = 0, ya = 0;
		if(Keyboard.keyPressed(KeyEvent.VK_UP) || Keyboard.keyPressed(KeyEvent.VK_DOWN) || Keyboard.keyPressed(KeyEvent.VK_LEFT) || Keyboard.keyPressed(KeyEvent.VK_RIGHT)){
			steps++;
		}else{
			steps = 0;
		}
		if (Keyboard.keyPressed(KeyEvent.VK_UP)) {
			ya--;
			direction = 2;
		}
		if (Keyboard.keyPressed(KeyEvent.VK_DOWN)) {
			ya++;
			direction = 0;
		}
		if (Keyboard.keyPressed(KeyEvent.VK_LEFT)) {
			xa--;
			direction = 3;
		}
		if (Keyboard.keyPressed(KeyEvent.VK_RIGHT)) {
			xa++;
			direction = 1;
		}
		if (xa != 0 || ya != 0) move(xa, ya);
		
		level.setOffset((int) -(this.x - ((Game.WIDTH/Game.SCALE)/2)/2)+4, (int) -(this.y - ((Game.HEIGHT/Game.SCALE)/2)/2)+4);
	}

}
