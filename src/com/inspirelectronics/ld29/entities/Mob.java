package com.inspirelectronics.ld29.entities;

import com.inspirelectronics.ld29.graphics.Animation;
import com.inspirelectronics.ld29.graphics.MobAnimation;
import com.inspirelectronics.ld29.graphics.SpriteSheet;

public abstract class Mob extends Entity{

	public int direction = 0; //y axis
	public int steps = 0;
	public Animation animation = null;
	
	public void move(int xa, int ya){
		if(xa != 0 && ya != 0){
			move(xa, 0);
			move(0, ya);
			return;
		}
		if(!collides(xa, ya)){
			x += xa;
			y += ya;
		}
	}
	
	private boolean collides(int xa, int ya){
		if(level != null){
			for(int c = 0; c < 4; c++){
				int xt = (int) (((x + xa) - c % 2 * sprite.getWidth()) / 8);
				int yt = (int) (((y + ya) - c / 2 * sprite.getHeight()) / 8);
				if(level.getTile(xt, yt) == null) continue;
				if(level.getTile(xt, yt).isSolid()){
					return true;
				}
			}
		}
		return false;
	}
	
	public void setAnimation(Animation animation){
		this.animation = animation;
	}

}
