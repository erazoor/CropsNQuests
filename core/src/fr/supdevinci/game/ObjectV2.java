package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public abstract class ObjectV2 {

    public Texture tx;

    public TextureRegion[][] txRegions;

    public int height = 16;

    public int width = 16;

    public HashMap<Character, Vector2> posByType = new HashMap<>();

    public abstract void makeMove();

    public TextureRegion getTexture(char c) {
        System.out.println("object v2 test : " + txRegions.length);
        System.out.println("x " + posByType.get(c).x + "y : " + posByType.get(c).y);
        return getTextureByPosition(posByType.get(c));
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
