package com.mygdx.game;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Laser;
import com.mygdx.game.objects.Ship;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class LaserGenerator {

    private Ship ship;
    ArrayList<GameObject> laserList;
    GameManager gameManager;

    private Random random;

    public LaserGenerator(Ship ship, GameManager gameManager) {
        this.ship = ship;
        laserList = new ArrayList<>();
        random = new Random();
        this.gameManager = gameManager;
    }


    private float currentDt = 0.0f;

    public void update() {
        if (currentDt >= 1) {
            Vector3 shipPosition = ship.getPosition();
            laserList.clear();
            for (int i = 0; i < random.nextInt(); i++) {
                Vector3 position = new Vector3(shipPosition.x + random.nextInt(200) - 100,
                        shipPosition.y + random.nextInt(200) - 100, 0);
                Laser laser = new Laser(position);
                laser.create(gameManager);
                laserList.add(laser);
            }
            currentDt = 0.0f;
        }
        else {
            currentDt += gameManager.getDt();
        }
    }

    public ArrayList<GameObject> getLaserList() {
        return laserList;
    }
}
