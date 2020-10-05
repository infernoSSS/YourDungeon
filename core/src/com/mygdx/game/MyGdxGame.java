package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;

public class MyGdxGame extends ApplicationAdapter {
	GameManager gameManager;
	SpriteBatch batch;
	Texture ship;

	@Override
	public void create () {
		gameManager  = new GameManager();
		batch = new SpriteBatch();
		ship = gameManager.getTextureManager().getTexture("ship");
		new SceneManager(gameManager);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();
		batch.begin();
		batch.draw(ship, 0, 0);
		batch.end();
	}

	public void update(){
		gameManager.update(batch);
	}


	@Override
	public void dispose () {
		gameManager.dispose();
		batch.dispose();
		ship.dispose();
	}
}
