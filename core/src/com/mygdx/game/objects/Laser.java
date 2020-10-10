package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.managers.GameManager;


import java.util.ArrayList;
import java.util.Random;

public class Laser extends GameObject {

    private GameManager gameManager;
    private Controller controller;
    private Vector3 motionVector;
    private final int SPEED_CONSTANT = 200;
    private ArrayList<Texture> textures;

    private boolean isCreated = false;

    private float rotation;

    public Laser(Vector3 position) {
        super(position);
    }

    @Override
    public void create(GameManager gameManager) {
        super.create(gameManager);

        isCreated = true;
        rotation = random.nextInt(360);

        this.gameManager = gameManager;

        textures = new ArrayList<>();
        textures.add(gameManager.getTextureManager().getTexture("laser1"));
        textures.add(gameManager.getTextureManager().getTexture("laser2"));

        texture = textures.get(random.nextInt(2));
    }

    private Random random = new Random();
    private Texture texture;

    float currentDT = 0.0f;

    private float currentAlpha = 0.0f;
    private boolean alphaChangeable = true;

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);

        if (isCreated) {
            if (currentDT >= 5.0f) {
                Color color = batch.getColor();
                float bup = color.a;
                color.a = currentAlpha;
                if (alphaChangeable) {
                    currentAlpha += 0.01f;
                    if (currentAlpha > 1.0f) {
                        currentAlpha = 0.0f;
                        alphaChangeable = false;
                    }
                }
                batch.setColor(color);
                batch.draw(new TextureRegion(texture), position.x - texture.getWidth() / 2, position.y - texture.getHeight() / 2,
                        texture.getWidth() / 2, texture.getHeight() / 2,
                        texture.getWidth(), texture.getHeight(),
                        0.4f, 2.0f, rotation);
                color.a = bup;
                batch.setColor(color);
                currentDT = 0.0f;
            }
            else {
                currentDT += gameManager.getDt();
            }
        }

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
