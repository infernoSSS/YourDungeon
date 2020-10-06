package com.mygdx.game.managers;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class TextureManager {
    private HashMap<String, Texture> textures;

    public TextureManager(){
        textures = new HashMap<>();
        textures.put("ship", new Texture("ship/starship.png"));
        textures.put("play", new Texture("buttons/Play.png"));
        textures.put("laser1", new Texture("lasers/laser1.png"));
        textures.put("laser2", new Texture("lasers/laser2.png"));
        textures.put("meteor1", new Texture("meteors/meteor1.png"));
        textures.put("meteor2", new Texture("meteors/meteor2.png"));
        textures.put("meteor3", new Texture("meteors/meteor3.png"));
        textures.put("meteor4", new Texture("meteors/meteor4.png"));
    }

    public Texture getTexture(String textureName) {
        return textures.get(textureName);
    }

    public void dispose(){
        for(Texture texture : textures.values()){
            texture.dispose();
        }
    }
}
