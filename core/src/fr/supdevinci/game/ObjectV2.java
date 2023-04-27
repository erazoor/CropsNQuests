package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public abstract class ObjectV2 {
    private int txTitleHeight;
    private int txTitleWidth;

    private Texture tx;

    private TextureRegion[][] txRegions;

    private static final HashMap<Character, Vector2> objectPosByType = new HashMap<>();

    public void create() {

    }

    public void makeMove() {

    }

    public TextureRegion getTexture(char c) {
        return getTextureByPosition(objectPosByType.get(c));
    }

    private TextureRegion getTextureByPosition(Vector2 position) {
        TextureRegion objectTexture;
        if (position == null){
            objectTexture= null;
        }else {
            objectTexture = txRegions[(int) position.x][(int) position.y];
        }
        return objectTexture;
    }
}
