package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;

public abstract class GameObject {
    protected GameManager gameManager;
    protected Vector3 position;

    public void create(GameManager gameManager, Vector3 position){
        this.gameManager=gameManager;
        this.position = position;
    }

    public void draw(SpriteBatch batch){

    }

    public void update(){

    }

    public void dispose(){

    }
}
