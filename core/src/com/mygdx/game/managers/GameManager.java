package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.creators.SceneCreator;

public class GameManager {
    private TextureManager textureManager;
    private SceneCreator sceneCreator;
    private float dt;

    public GameManager(){
        textureManager = new TextureManager();
        sceneCreator = new SceneCreator();
        dt = 0;
    }

    public TextureManager getTextureManager() {
        return textureManager;
    }

    public void update() {
        dt += Gdx.graphics.getDeltaTime();
    }

    public float getDt() {
        return dt;
    }

    public SceneCreator getSceneCreator() {
        return sceneCreator;
    }

    public void dispose(){
        textureManager.dispose();
    }
}
