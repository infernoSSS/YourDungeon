package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.managers.GameManager;

import java.util.concurrent.Exchanger;

public class Ship extends GameObject {

    private float speed = 1.0f;

    private GameManager gameManager;
    private Controller controller;
    private Vector3 motionVector;
    private final int SPEED_CONSTANT = 200;
    private Texture texture;

    @Override
    public void create(GameManager gameManager, Vector3 position) {
        super.create(gameManager, position);
        this.gameManager = gameManager;
        this.controller = gameManager.getController();
        texture = gameManager.getTextureManager().getTexture("ship");
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        batch.draw(texture, position.x, position.y);
    }

    private float xChanger;
    private float yChanger;

    @Override
    public void update() {
        super.update();
        motionVector = controller.generateMotionVector();

        xChanger = motionVector.x * speed * SPEED_CONSTANT * gameManager.getDt();
        yChanger = motionVector.y * speed * SPEED_CONSTANT * gameManager.getDt();

        if (motionVector.x != 0.0f && motionVector.y != 0.0f) {
            xChanger *= Math.sqrt(2) / 2;
            yChanger *= Math.sqrt(2) / 2;
        }

        if (position.x + xChanger > Gdx.graphics.getWidth() - texture.getWidth()) {
            xChanger = Gdx.graphics.getWidth() - texture.getWidth() - position.x;
        }
        else if (position.x + xChanger < 0.0f) {
            xChanger = -position.x;
        }
        if (position.y + yChanger > Gdx.graphics.getHeight() - texture.getHeight()){
            yChanger = Gdx.graphics.getHeight() - texture.getHeight() - position.y;
        }
        /*else if (position.y + yChanger < 0.0f) {
            yChanger = -position.y;
        }*/
        else if (position.y + yChanger < -10.0f) {
            yChanger = -position.y - 10.0f;
        }

        position.x += xChanger;
        position.y += yChanger;

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
