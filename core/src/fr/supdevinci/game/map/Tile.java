package fr.supdevinci.game.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.supdevinci.game.map.entity.Entity;
import fr.supdevinci.game.map.entity.Ground;

public class Tile {
    private Ground ground = null;
    private Entity object;

    char groundType;
    public final static int WIDTH = 16;
    public final static int HEIGHT = 16;

    public Tile(Ground ground, Entity object, char groundType) {
        if(groundType != '0')
            this.ground = ground;
        this.object = object;
        this.groundType = groundType;
    }

    public void drawGround(SpriteBatch batch, int x, int y) {
        if (ground != null)
            batch.draw(ground.getTexture(this.groundType), x * WIDTH, y * HEIGHT, ground.width, ground.height);

    }

    public void drawObject(SpriteBatch batch, int x, int y) {
        if (object != null)
            batch.draw(object.getTexture(), x * WIDTH - (object.width / 2) + (WIDTH / 2), y * HEIGHT - (object.height / 2) + (HEIGHT / 2), object.width, object.height);
    }
}
