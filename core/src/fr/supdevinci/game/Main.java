package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import fr.supdevinci.game.player.Player;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Player player;

    @Override
    public void create () {
        batch = new SpriteBatch();
        player = new Player(100, 100, 200, new TextureRegion(new Texture("game-assets/characters/PremiumCharakterSpritesheet.png")));
    }

    @Override
    public void render () {
        // Render player
        batch.begin();
        player.render(batch);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        player.dispose();
    }
}
