package com.franailin.helper;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.franailin.gamestate.GameWorld;

public class InputHandler implements InputProcessor {
	GameWorld world;
	
	public InputHandler(GameWorld world)
	{
		this.world = world;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.SPACE)
		{
			if (world.getState() == GameWorld.State.PAUSED)
			{
				world.setRunning();
			}
			else if (world.getState() == GameWorld.State.RUNNING)
			{
				world.player.jumped(world.platforms);
			}
		}
		else if (keycode == Input.Keys.P)
		{
			world.setPause();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (world.getState() == GameWorld.State.PAUSED)
		{
			world.setRunning();
			world.judgementDayIntro.play();
		}
		else if (world.getState() == GameWorld.State.RUNNING)
		{
			world.player.jumped(world.platforms);
		}
		else if (world.getState() == GameWorld.State.GAMEOVER)
		{
			world.reset();
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
