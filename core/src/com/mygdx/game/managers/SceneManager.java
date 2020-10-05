package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.scenes.Scene;


public class SceneManager {
    private Scene scene;
    private GameManager gameManager;

    private Music main_theme = Gdx.audio.newMusic(Gdx.files.internal("music/main_theme.mp3"));

    public SceneManager(GameManager gameManager){
        this.gameManager = gameManager;
        scene = gameManager.getSceneCreator().createScene("menu");
        scene.create(gameManager);
        main_theme.play();
    }

    public void draw(SpriteBatch batch){
        scene.draw(batch);
    }

    public void update(){
        scene.update();
    }

    public void dispose(){
        scene.dispose();
        main_theme.dispose();
    }
}
