package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Ship;

import java.util.ArrayList;

public class GameScene extends Scene {
    ArrayList<GameObject> shipList;

    @Override
    public void create(GameManager gameManager, SceneManager sceneManager) {
        super.create(gameManager, sceneManager);

        shipList = new ArrayList<>();
        shipList.add(new Ship());

        Lists.add(shipList);

        for(ArrayList<GameObject> array : Lists){
            for (GameObject gameObject : array){
                gameObject.create(gameManager, new Vector3(140, 400, 0));
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
