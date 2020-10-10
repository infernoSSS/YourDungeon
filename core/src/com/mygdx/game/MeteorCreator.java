package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Meteors;

import java.util.ArrayList;


import static com.mygdx.game.myUtils.MyUtils.randomPlusOrMinus;

public class MeteorCreator {
    GameManager gameManager;
    float meteorsSpawnDt;
    int meteorsNumb;
    int maxMeteorNumb;
    Meteors meteor;
    int spawnPosition;

    public MeteorCreator(GameManager gameManager){
        this.gameManager = gameManager;
        float meteorsSpawnDt = 1f;
        meteorsNumb = 0;
        maxMeteorNumb = 7;
    }

    public ArrayList<GameObject> generateMeteors(){
        return generateMeteors(new ArrayList<GameObject>());
    }

    public ArrayList<GameObject> generateMeteors(ArrayList<GameObject> meteorsList){
        if(meteorsSpawnDt>1f){
            if(checkMeteorSpawn()) {
                meteorsList.add(spawnMeteor(new Vector3(100, 100, 0), new Vector3(-0.3f, 0.3f, 0)));
            }
        }

        return meteorsList;
    }

    private Meteors spawnMeteor(Vector3 position, Vector3 mothionVector){
        meteor = randomMeteor();
        meteorsSpawnDt = 0f;
        meteorsNumb++;
        return meteor;
    }

    private Meteors randomMeteor(){
        Meteors newMeteor;
        newMeteor = new Meteors(randomPosition());
        newMeteor.create(gameManager);
        newMeteor.setMouthenVector(randomMothionVector());
        
        return newMeteor;
    }

    private Vector3 randomPosition(){
        Vector3 position = new Vector3();
        spawnPosition = (int)(Math.random()*4);
        switch (spawnPosition){
            case    (0) :
                position.x = -80;
                position.y = (float) (Gdx.graphics.getHeight())*(float) Math.random() + 100f;
                if(position.y > Gdx.graphics.getHeight()){
                    position.y-=100f;
                }
                break;
            case    (1) :
                position.x = (float) (Gdx.graphics.getWidth())*(float) Math.random() + 100f;
                position.y = (float) (Gdx.graphics.getHeight()) + 80f;
                if(position.x > Gdx.graphics.getWidth()){
                    position.x-=100f;
                }
                break;
            case    (2) :
                position.x = (float) (Gdx.graphics.getWidth()) + 80f;;
                position.y = (float) (Gdx.graphics.getHeight())*(float) Math.random()+100f;
                if(position.y > Gdx.graphics.getHeight()){
                    position.y-=100f;
                }
                break;
            case    (3) :
                position.x = (float) (Gdx.graphics.getWidth())*(float) Math.random()+100f;
                position.y = -80f;
                if(position.x > Gdx.graphics.getWidth()){
                    position.x-=100f;
                }
                break;
        }
        return position;
    }
    
    private Vector3 randomMothionVector(){
        Vector3 mothionVector = new Vector3();
        switch (spawnPosition){
            case    (0) :
                mothionVector.x = (float) Math.random();
                mothionVector.y = (float) (Math.random() * randomPlusOrMinus());
                break;
            case    (1) :
                mothionVector.x = (float) (Math.random() * randomPlusOrMinus());
                mothionVector.y =  - (float) Math.random();
                break;
            case    (2) :
                mothionVector.x = - (float) Math.random();
                mothionVector.y = (float) (Math.random() * randomPlusOrMinus());
                break;
            case    (3) :
                mothionVector.x = (float) (Math.random() * randomPlusOrMinus());
                mothionVector.y = (float) Math.random();
                break;
        }
        return mothionVector;
    }

    private boolean checkMeteorSpawn(){
        float val = ((7-(float)meteorsNumb)/7)-(float) (Math.random());
        return val>0f;
    }

    private void remuveMeteor(ArrayList<GameObject> meteorsList){
        ArrayList<GameObject> deleted = new ArrayList<>();
        for(GameObject meteors : meteorsList){
            if(((Meteors)meteors).isDeleted()){
                deleted.add(meteors);
                meteorsNumb--;
            }
        }
        for(GameObject cur : deleted){
            meteorsList.remove(cur);
        }
    }

    public void update(ArrayList<GameObject> meteorsList){
        meteorsSpawnDt += gameManager.getDt();
        remuveMeteor(meteorsList);
        meteorsList = generateMeteors(meteorsList);
    }

}
