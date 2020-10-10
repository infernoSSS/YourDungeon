package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.managers.GameManager;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Meteors;

import java.util.ArrayList;
import java.util.Random;

public class MeteorGenerator {
    private GameManager gameManager;
    private Meteors meteor;
    private int meteorsNumb;
    private final int METEOR_MAX_NUMBER = 30;
    private float meteorSpawnDeltaTime;
    private Vector3 position;
    private int zone;

    public MeteorGenerator(GameManager gameManager){
        this.gameManager = gameManager;
        meteorsNumb = 0;
        meteorSpawnDeltaTime = 1;
    }

    public ArrayList<GameObject> generateMeteors(ArrayList<GameObject> meteorsList){
        if(meteorSpawnDeltaTime >= 0.05f){
            if(randomMeteor()){
                meteor = new Meteors(randomDeploymentPosition());
                meteor.create(gameManager);
                meteor.setMouthenVector(randomMothenVector());
                meteorsList.add(meteor);
                meteorsNumb++;
            }
            meteorSpawnDeltaTime = 0;
        }
        return meteorsList;
    }

    private boolean randomMeteor(){
        if((METEOR_MAX_NUMBER - meteorsNumb)/METEOR_MAX_NUMBER-Math.random()>0)
        {
            return true;
        }else{
            return false;
        }
    }

    private int randomDeploymentZone(){
        return (int)(Math.random()*4);
    }

    private Vector3 randomDeploymentPosition(){
        Vector3 position = new Vector3();
        zone = randomDeploymentZone();
        switch (zone){
            case (0)    :
                position.x = (float) (Math.random()* Gdx.graphics.getWidth());
                position.y = -90;
            case (1)    :
                position.x = -90;
                position.y = (float) (Math.random()* Gdx.graphics.getHeight());
            case (2)    :
                position.x = (float) (Math.random()* Gdx.graphics.getWidth());
                position.y = Gdx.graphics.getHeight()+90;
            case (3)    :
                position.x = Gdx.graphics.getWidth()+90;
                position.y = (float) (Math.random()* Gdx.graphics.getHeight());
            default:
        }
        return position;
    }

    private Vector3 randomMothenVector(){
        switch (zone){
            case (0)    :
                return new Vector3((float)(Math.random()*(Math.random()-0.5f)), (float)Math.random(), 0);
            case(1) :
                return new Vector3((float)Math.random(), (float)(Math.random()*(Math.random()-0.5f)), 0);
            case (2)    :
                return new Vector3((float)(Math.random()*(Math.random()-0.5f)), -(float)Math.random(), 0);
            case(3) :
                return new Vector3(-(float)Math.random(), (float)(Math.random()*(Math.random()-0.5f)), 0);
            default:
                return new Vector3((float)(Math.random()*(Math.random()-0.5f))-0, (float)Math.random(), 0);
        }
    }

    private void checkMeteors(ArrayList<GameObject> meteorsList){
        boolean flag = false;
        for(GameObject meteors : meteorsList){
            if(meteors.isDeleted()){
                meteors = null;
                flag = true;
                meteorsNumb--;
            }
        }
        if(flag){
            ArrayList<GameObject> newMeteorsList = new ArrayList<>();
            for(GameObject meteors : meteorsList){
                if (meteors!=null){
                    newMeteorsList.add(meteors);
                }
            }
            meteorsList = newMeteorsList;
        }
    }

    public void update(ArrayList<GameObject> meteorsList){
        checkMeteors(meteorsList);
        meteorsList = generateMeteors(meteorsList);
        meteorSpawnDeltaTime += gameManager.getDt();
    }
}
