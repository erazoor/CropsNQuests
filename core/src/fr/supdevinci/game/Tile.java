package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import fr.supdevinci.game.Entity.Entity;
import fr.supdevinci.game.Entity.Ground;

import java.util.HashMap;

public class Tile {
    private Ground ground;
    private Entity object;

    private char groundType;
    public final static int WIDTH = 16;
    public final static int HEIGHT = 16;

    public Tile(Ground ground, Entity Object, char groundType) {
        this.ground = ground;
        this.object = Object;
        this.groundType = groundType;
    }

    public void drawGround(SpriteBatch batch, int x, int y) {
        batch.draw(ground.getTexture(this.groundType), x * WIDTH, y * HEIGHT, ground.width, ground.height);
    }

    public void drawObject(SpriteBatch batch, int x, int y) {
        if(object != null)
            batch.draw(object.getTexture(), x*WIDTH, y*HEIGHT, object.width, object.height);
    }

}
