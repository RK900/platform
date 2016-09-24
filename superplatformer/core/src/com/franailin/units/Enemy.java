package com.franailin.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.franailin.gamestate.GameWorld;
import com.franailin.helper.AssetInitialize;

public class Enemy extends Unit
{
	public GameWorld gameworld;
	public Sprite worm1, worm2, worm3, worm4;
	private static Texture texture1, texture2, texture3, texture4;
	int animationCount = 0;
	static
	{
		texture1 = new Texture(Gdx.files.internal("data/sprite_enemy1.png"));
		texture2 = new Texture(Gdx.files.internal("data/sprite_enemy2.png"));
		texture3 = new Texture(Gdx.files.internal("data/sprite_enemy3.png"));
		texture4 = new Texture(Gdx.files.internal("data/sprite_enemy4.png"));
	}
	
	public Enemy (float x, float y, float width, float height, GameWorld world)
	{
		super(x, y, width, height);
		
		worm1 = new Sprite(texture1, texture1.getWidth(), texture1.getHeight());
		worm2 = new Sprite(texture2, texture2.getWidth(), texture2.getHeight());
		worm3 = new Sprite(texture3, texture3.getWidth(), texture3.getHeight());
		worm4 = new Sprite(texture4, texture4.getWidth(), texture4.getHeight());
		
		animation.add(new Sprite(worm1));
		animation.add(new Sprite(worm2));
		animation.add(new Sprite(worm3));
		animation.add(new Sprite(worm4));
		
		position = new Vector2(x, y);
		velocity = new Vector2(-100, 0);
		acceleration = new Vector2(0, 0);
	}
	
	public void render(SpriteBatch batcher)
	{
		batcher.draw(animation.get(animationCount), x, y, getWidth(), getHeight());
		if (animationCount != 3)
		{
			animationCount++;
		}
		else
		{
			animationCount = 0;
		}
	}
	
	/**
	 * Updates position in world, and checks to see if it moves off screen.
	 * @return True if moves off left side of screen, false if not.
	 */
	public boolean updateAndRemoveIfTrue(float delta)
	{
		velocity.add(acceleration.cpy().scl(delta));
		position.add(velocity.cpy().scl(delta));
		x = position.x;
		y = position.y;
		return x + width < 0;
	}
}
