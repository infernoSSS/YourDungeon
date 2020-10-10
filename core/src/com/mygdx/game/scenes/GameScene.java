package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MeteorCreator;
import com.mygdx.game.LaserGenerator;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Laser;
import com.mygdx.game.objects.Meteors;
import com.mygdx.game.objects.Ship;

import java.util.ArrayList;

public class GameScene extends Scene {
    private ArrayList<GameObject> meteorList;
    private LaserGenerator laserGenerator;
    private MeteorCreator meteorCreator;
    private Ship ship;

    @Override
    public void create(GameManager gameManager, SceneManager sceneManager) {
        super.create(gameManager, sceneManager);

        meteorCreator = new MeteorCreator(gameManager);

        // list 1-meteors, 2-lasers, 3 - BlackHole, 4 - ship, 5 UI
        ship = new Ship(new Vector3(140, 400, 0));
        ship.create(gameManager);


        meteorList = meteorCreator.generateMeteors();

        Lists.add(meteorList);

        laserGenerator = new LaserGenerator(ship, gameManager);


    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);

        if (ship.isAlive())
        ship.draw(batch);
    }

    @Override
    public void update() {
        super.update();
        laserGenerator.update();
        Lists.add(laserGenerator.getLaserList());

        meteorCreator.update(Lists.get(0));

        if (ship.isAlive()){
        ship.update();
        ship.checkAlive(Lists);}

    }

    @Override
    public void dispose() {
        super.dispose();
        ship.dispose();
    }
}
