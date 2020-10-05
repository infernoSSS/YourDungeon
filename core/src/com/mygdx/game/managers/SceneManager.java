package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import javafx.scene.Scene;

public class SceneManager {
    private Scene scene;
    private GameManager gameManager;

    private Music main_theme = Gdx.audio.newMusic(Gdx.files.internal("music/main_theme.mp3"));

    public SceneManager(GameManager gameManager){
        this.gameManager = gameManager;
        scene = gameManager.getSceneCreator().createScene("menu");
        main_theme.play();
    }
}
