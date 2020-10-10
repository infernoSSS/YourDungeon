package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MeteorCreator;
import com.mygdx.game.MeteorGenerator;
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
    MeteorCreator meteorCreator;
    //MeteorGenerator meteorGenerator;

    @Override
    public void create(GameManager gameManager, SceneManager sceneManager) {
        super.create(gameManager, sceneManager);

        meteorCreator = new MeteorCreator(gameManager);

        // list 1-meteors, 2-lasers, 3 - BlackHole, 4 - ship, 5 UI
        shipList = new ArrayList<>();
        Ship ship = new Ship(new Vector3(140, 400, 0));
        shipList.add(ship);


        meteorList = meteorCreator.generateMeteors();
        //meteorList = meteorGenerator.generateMeteors(meteorList);



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

        meteorCreator.update(Lists.get(0));

        //meteorGenerator.update(Lists.get(0));

        //meteor.update();

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
