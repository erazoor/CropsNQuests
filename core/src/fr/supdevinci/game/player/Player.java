package fr.supdevinci.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private float speed;
    private TextureRegion sprite;

    public Player(float x, float y, float speed, TextureRegion sprite) {
        position = new Vector2(x, y);
        velocity = new Vector2();
        this.speed = speed;
        this.sprite = sprite;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
    }

    public void render(SpriteBatch batch) {
        batch.draw(sprite, position.x, position.y);
    }

    public void move(float x, float y) {
        velocity.set(x, y).nor().scl(speed);
    }

    public void dispose() {
        sprite.getTexture().dispose();
    }
}
