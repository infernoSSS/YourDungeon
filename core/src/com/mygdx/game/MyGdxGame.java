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

	// -- Debug block
	private Controller controller;
	// -- Debug block

	@Override
	public void create () {
		gameManager  = new GameManager();
		batch = new SpriteBatch();


		// -- Debug block
		controller = new Controller();
		ship = gameManager.getTextureManager().getTexture("ship");
		new SceneManager(gameManager);
		// -- Debug block Ends
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
		gameManager.update();

		// -- Debug block
		BitmapFont debuggingText = new BitmapFont();
		batch.begin();
		Vector3 vector = new Vector3();
		Vector3 cursor = new Vector3();
		try {
			vector = controller.generateMotionVector();
			cursor = controller.generateMousePositionVector();
		} catch (Exception e) {

		}
		String keyStatuses = "horizontalMotion  = " + vector.x + "; y = " + vector.y + ";\n";
		keyStatuses += "mouseXPos = " + cursor.x + "; mouseYPos = " + cursor.y + ";";
		debuggingText.draw(batch, keyStatuses, 100,100);
		batch.end();
		// -- Debug block Ends
	}


	@Override
	public void dispose () {
		gameManager.dispose();
		batch.dispose();
		ship.dispose();
	}
}
