package fr.supdevinci.game.player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private final Vector2 position;
    private final Vector2 velocity;
    private final float speed;
    private float stateTime;

    public Player(float x, float y, float speed, TextureRegion spriteSheet) {
        position = new Vector2(x, y);
        velocity = new Vector2();
        this.speed = speed;
        stateTime = 0f;
    }

    public void update(float delta) {
        stateTime += delta;
        position.add(velocity.cpy().scl(delta));
    }

    public void render(SpriteBatch batch) {

    }

    public void move(float x, float y) {
        velocity.set(x * speed, y * speed);
    }

    public void dispose() {
        // Dispose of resources when no longer needed
    }
}
