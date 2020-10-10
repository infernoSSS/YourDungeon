package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.scenes.GameScene;

public class Meteors extends GameObject {
    private Vector3 mouthenVector;
    private int speed;
    private int rotationSpeed;
    private float rotation;
    private boolean deleted;
    private TextureRegion textureRegion;
    private Circle hitBox;

    public Meteors(Vector3 position){
        super(position);
    }

    @Override
    public void create(GameManager gameManager) {
        super.create(gameManager);
        speed = (int)(Math.random()*50) + 150;
        rotationSpeed = (int)(Math.random()*1000*(Math.random()-0.5));
        rotation = 0;
        textureRegion = new TextureRegion(gameManager.getTextureManager().getTexture("meteor4"));
        deleted = false;
        hitBox = new Circle(position.x+gameManager.getTextureManager().getTexture("meteor4").getWidth()/2,
                position.y+gameManager.getTextureManager().getTexture("meteor4").getHeight()/2,
                gameManager.getTextureManager().getTexture("meteor4").getWidth()/2);
//                30);

        //System.out.println("x : " + hitBox.x + " y : " + hitBox.y + " rad : " + hitBox.radius);
    }

    public void setMouthenVector(Vector3 mouthenVector){
        this.mouthenVector = mouthenVector;
    }

    @Override
    public void draw(SpriteBatch batch) {
            batch.draw(textureRegion,
                    position.x, position.y,
                    gameManager.getTextureManager().getTexture("meteor4").getWidth() / 2,
                    gameManager.getTextureManager().getTexture("meteor4").getHeight() / 2,
                    gameManager.getTextureManager().getTexture("meteor4").getWidth(),
                    gameManager.getTextureManager().getTexture("meteor4").getHeight(),
                    1,
                    1,
                    rotation);
        update();
    }

    @Override
    public void update() {
        super.update();
        position.x += speed*mouthenVector.x*gameManager.getDt();
        position.y += speed*mouthenVector.y*gameManager.getDt();
        rotation += rotationSpeed*gameManager.getDt();
        if(checkDelete()){
            dispose();
            deleted = true;
        }
        hitBox.x = position.x;
        hitBox.y = position.y;
    }

    private boolean checkDelete(){
        if(position.x < -100 || position.x > Gdx.graphics.getWidth()+100 || position.y < -100 || position.y > Gdx.graphics.getHeight()+100){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Circle box) {

        if (this.hitBox.overlaps(box)){
        System.out.println("da");
        }

        return this.hitBox.overlaps(box);
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
