package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;

public abstract class GameObject {
    protected GameManager gameManager;
    protected Vector3 position;

    public GameObject(Vector3 position){
        this.position = position;
    }

    public void create(GameManager gameManager){
        this.gameManager=gameManager;
    }

    public void draw(SpriteBatch batch){

    }

    public void update() {

    }

    public boolean isDeleted(){
        return false;
    }

    public void dispose(){

    }

    public Vector3 getPosition() {
        return position;
    }
}
