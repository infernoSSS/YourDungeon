package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.managers.SceneManager;

public class PlayButton extends GameObject {
    private Rectangle hitbox;
    private SceneManager sceneManager;

    public PlayButton(SceneManager sceneManager, Vector3 position){
        super(position);
        this.position = position;
        this.sceneManager = sceneManager;
    }

    @Override
    public void create(GameManager gameManager) {
        super.create(gameManager);
        this.position = position;
        hitbox = new Rectangle(position.x, position.y, gameManager.getTextureManager().getTexture("play").getWidth(),
                gameManager.getTextureManager().getTexture("play").getHeight());

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(gameManager.getTextureManager().getTexture("play"), position.x, position.y);
    }

    @Override
    public void update() {
        super.update();
        checkTap();
    }

    public void checkTap(){
        if(gameManager.getController().isTouched()){
            if (hitbox.contains(gameManager.getController().generateMousePositionVector().x, gameManager.getController().generateMousePositionVector().y)){
                sceneManager.changeScene("gameScene");
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
