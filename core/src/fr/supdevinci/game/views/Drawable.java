package fr.supdevinci.game.views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Drawable {
    void create();
    void render(SpriteBatch batch);
    void dispose();
}
