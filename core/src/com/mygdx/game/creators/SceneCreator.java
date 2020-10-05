package com.mygdx.game.creators;


import com.mygdx.game.scenes.GameScene;
import com.mygdx.game.scenes.Menu;
import com.mygdx.game.scenes.Scene;

public class SceneCreator {
    public SceneCreator(){

    }

    public Scene createScene(String sceneName){
        switch (sceneName){
            case ("menu") : return new Menu();
            case ("gameScene") : return new GameScene();
            default: return null;
        }
    }
}
