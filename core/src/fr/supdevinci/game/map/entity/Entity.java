package fr.supdevinci.game.map.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public abstract class Entity {
    public TextureRegion[][] txRegions;
    public int height = 16;
    public int width = 16;
    public TextureRegion txRegion;
    public HashMap<Character, Vector2> posByType = new HashMap<>();

    public abstract void makeMove();

    public TextureRegion getTexture() {
        return txRegion;
    }

}
