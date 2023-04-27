package fr.supdevinci.game.player.views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Drawable {
    void create();
    void render(SpriteBatch batch, float delta);
    void dispose();
}
