package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.objects.GameObject;


import java.util.ArrayList;

public abstract class Scene {
    protected GameManager gameManager;
    protected SceneManager sceneManager;
    protected ArrayList<ArrayList<GameObject>> Lists;

    public void create(GameManager gameManager, SceneManager sceneManager){
        this.gameManager = gameManager;
        this.sceneManager = sceneManager;
        Lists = new ArrayList<>();
    }

    public void draw(SpriteBatch batch){
        batch.draw(gameManager.getTextureManager().getTexture("back"), 0 ,0);
        for(ArrayList<GameObject> array : Lists){
            for (GameObject gameObject : array){
                if(gameObject!=null)
                gameObject.draw(batch);
            }
        }
    }

    public void update() {
        for(ArrayList<GameObject> array : Lists){
            for (GameObject gameObject : array){
                gameObject.update();
            }
        }
    }

    public void dispose(){
        for(ArrayList<GameObject> array : Lists){
            for (GameObject gameObject : array){
                gameObject.dispose();
            }
        }
    }
}
