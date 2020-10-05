package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.managers.GameManager;

public class Ship extends GameObject {

    private float speed = 1.0f;

    private GameManager gameManager;
    private Controller controller;
    private Vector3 motionVector;
    private final int SPEED_CONSTANT = 200;


    @Override
    public void create(GameManager gameManager, Vector3 position) {
        super.create(gameManager, position);
        this.gameManager = gameManager;
        this.controller = gameManager.getController();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        batch.draw(gameManager.getTextureManager().getTexture("ship"), position.x, position.y);
    }

    @Override
    public void update() {
        super.update();
        motionVector = controller.generateMotionVector();

        if (motionVector.x != 0.0f && motionVector.y != 0.0f) {
            this.position.x += motionVector.x * Math.sqrt(2) / 2 * speed * SPEED_CONSTANT * gameManager.getDt();
            this.position.y += motionVector.y * Math.sqrt(2) / 2 * speed * SPEED_CONSTANT * gameManager.getDt();
        }
        else {
            this.position.x += motionVector.x * speed * SPEED_CONSTANT * gameManager.getDt();
            this.position.y += motionVector.y * speed * SPEED_CONSTANT * gameManager.getDt();
        }

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
