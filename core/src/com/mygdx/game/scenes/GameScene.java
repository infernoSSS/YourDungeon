package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.LaserGenerator;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Laser;
import com.mygdx.game.objects.Meteors;
import com.mygdx.game.objects.Ship;

import java.util.ArrayList;

public class GameScene extends Scene {
    ArrayList<GameObject> shipList;
    ArrayList<GameObject> meteorList;
    Meteors meteor;
    LaserGenerator laserGenerator;

    @Override
    public void create(GameManager gameManager, SceneManager sceneManager) {
        super.create(gameManager, sceneManager);
        // list 1-meteors, 2-lasers, 4 - BlackHole, 4 - ship, 5 UI
        shipList = new ArrayList<>();
        Ship ship = new Ship(new Vector3(140, 400, 0));
        shipList.add(ship);

        meteorList = new ArrayList<>();
        meteor = new Meteors(new Vector3(240, 400, 0));
        meteor.setMouthenVector(new Vector3(1,1, 0));
        meteorList.add(meteor);

        Lists.add(meteorList);
        Lists.add(shipList);

        laserGenerator = new LaserGenerator(ship, gameManager);

        for(ArrayList<GameObject> array : Lists){
            for (GameObject gameObject : array){
                gameObject.create(gameManager);
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
        laserGenerator.update();
        Lists.add(laserGenerator.getLaserList());
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
