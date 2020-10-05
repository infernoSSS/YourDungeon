package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.managers.GameManager;

public class Ship extends GameObject {

    private float verticalSpeed = 1.0f;
    private float horizontalSpeed = 1.0f;

    private GameManager gameManager;
    private Controller controller;
    private Vector3 motionVector;
    private final int SPEED_CONSTANT = 50;


    @Override
    public void create(GameManager gameManager, Vector3 position) {
        super.create(gameManager, position);
        this.gameManager = gameManager;
        this.controller = gameManager.getController();
        motionVector = new Vector3();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void update() {
        super.update();
        motionVector = controller.generateMotionVector();
        super.position.x += motionVector.y * verticalSpeed * SPEED_CONSTANT;
        super.position.y += -motionVector.x * horizontalSpeed * SPEED_CONSTANT;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
