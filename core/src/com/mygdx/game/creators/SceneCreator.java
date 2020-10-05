package com.mygdx.game.creators;


import com.mygdx.game.scenes.Menu;
import com.mygdx.game.scenes.Scene;

public class SceneCreator {
    public SceneCreator(){

    }

    public Scene createScene(String sceneName){
        switch (sceneName){
            case ("menu") : return new Menu();
            default: return null;
        }
    }
}
