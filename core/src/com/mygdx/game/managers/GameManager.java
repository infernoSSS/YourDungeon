package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.creators.SceneCreator;

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

    // -- Debug block
    public void update(Batch batch) {
        update();
        BitmapFont debuggingText = new BitmapFont();
        batch.begin();
        Vector3 vector = new Vector3();
        Vector3 cursor = new Vector3();
        try {
            vector = controller.generateMotionVector();
            cursor = controller.generateMousePositionVector();
        } catch (Exception e) {
            // Nothing)
        }
        String keyStatuses = "horizontalMotion  = " + vector.x + ";\nverticalMotion = " + vector.y + ";\n\n";
        keyStatuses += "isTouched = " + controller.isTouched() + ";\n";
        keyStatuses += "touchXPos = " + cursor.x + ";\ntouchYPos = " + cursor.y + ";\n";
        debuggingText.draw(batch, keyStatuses, 0, Gdx.graphics.getHeight());
        batch.end();
    }
    // -- Debug block Ends

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
