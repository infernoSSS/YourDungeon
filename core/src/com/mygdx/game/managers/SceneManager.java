package com.mygdx.game.managers;

import javafx.scene.Scene;

public class SceneManager {
    private Scene scene;
    private GameManager gameManager;

    public SceneManager(GameManager gameManager){
        this.gameManager = gameManager;
        scene = gameManager.getSceneCreator().createScene("menu");
    }
}
