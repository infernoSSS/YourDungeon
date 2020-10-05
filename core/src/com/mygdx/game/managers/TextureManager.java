package com.mygdx.game.managers;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class TextureManager {
    private HashMap<String, Texture> textures;

    public TextureManager(){
        textures.put("ship", new Texture("ship/starship.png"));

    }

    public Texture getTexture(String textureName) {
        return textures.get();
    }
}
