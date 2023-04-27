package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Tile {
    private final TextureRegion ground;
    private final TextureRegion object;

    private final int groundType;

    public final static int WIDTH = 16;
    public final static int HEIGHT = 16;

    /*public Tile(HashMap<Character, Vector2> groundPosByType, TextureRegion[][] groundTiles, char groundType, int objectType) {
        this.groundType = groundType;
        Vector2 tilePos = groundPosByType.get(groundType);
        this.ground = groundTiles[(int)tilePos.x][(int)tilePos.y];
        this.object = null;
    }*/

    public Tile(TextureRegion ground, TextureRegion Object) {
        this.ground = ground;
        this.object = Object;
        groundType = 0;
    }

    /*public Tile(HashMap<Character, Vector2> groundPosByType, TextureRegion[][] groundTiles, char groundType) {
       this(groundPosByType, groundTiles, groundType, -1);
    }*/
    public void draw(SpriteBatch batch, int x, int y) {
        batch.draw(ground, x*WIDTH, y*HEIGHT, WIDTH, HEIGHT);
        if(object != null)
            batch.draw(object, x*WIDTH, y*HEIGHT, WIDTH, HEIGHT);
    }

}
