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

    // -- Debug block
    private Controller controller;
    // -- Debug block Ends

    public GameManager(){
        textureManager = new TextureManager();
        sceneCreator = new SceneCreator();
        dt = 0;

        // -- Debug block
        controller = new Controller();
        // -- Debug block Ends

    }

    public TextureManager getTextureManager() {
        return textureManager;
    }

    public void update(Batch batch) {
        dt += Gdx.graphics.getDeltaTime();

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
        String keyStatuses = "horizontalMotion  = " + vector.x + ";\nverticalMotion = " + vector.y + ";\n\n";
        keyStatuses += "mouseXPos = " + cursor.x + ";\nmouseYPos = " + cursor.y + ";";
        debuggingText.draw(batch, keyStatuses, 0, Gdx.graphics.getHeight());
        batch.end();
        // -- Debug block Ends
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
