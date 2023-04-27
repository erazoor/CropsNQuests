package fr.supdevinci.game.Entity;

import com.badlogic.gdx.graphics.Texture;
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

    /*public TextureRegion getTexture(char c) {
        return getTextureByPosition(posByType.get(c));
    }*/

    public TextureRegion getTexture() {
        return txRegion;
    }

   /* private TextureRegion getTextureByPosition(Vector2 position) {
        TextureRegion objectTexture;
        if (position == null){
            objectTexture= null;
        }else {
            objectTexture = txRegions[(int) position.x][(int) position.y];
        }
        return objectTexture;
    }*/

}
