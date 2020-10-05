package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;

public class MyGdxGame extends ApplicationAdapter {
	GameManager gameManager;
	SpriteBatch batch;
	Texture ship;
	
	@Override
	public void create () {
		gameManager  = new GameManager();
		batch = new SpriteBatch();
		ship = gameManager.getTextureManager().;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(ship, 0, 0);
		batch.end();
	}

	public void update(){

	}


	@Override
	public void dispose () {
		batch.dispose();
		ship.dispose();
	}
}
