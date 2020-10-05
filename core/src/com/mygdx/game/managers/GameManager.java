package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.creators.SceneCreator;
import com.mygdx.game.objects.Ship;

public class GameManager {
    private TextureManager textureManager;
    private SceneCreator sceneCreator;
    private float dt;
    private Controller controller;

    public GameManager(){
        controller = new Controller();
        textureManager = new TextureManager();
        sceneCreator = new SceneCreator();
        dt = 0;


        controller = new Controller();


    }

    public TextureManager getTextureManager() {
        return textureManager;
    }

    public void update() {
        dt = Gdx.graphics.getDeltaTime();
    }

    public float getDt() {
        return dt;
    }

    public Controller getController() {
        return controller;
    }

    public SceneCreator getSceneCreator() {
        return sceneCreator;
    }

    public void dispose(){
        textureManager.dispose();
    }
}
