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
        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Handle player movement
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.move(-1, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.move(1, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.move(0, 1);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.move(0, -1);
        } else {
            player.move(0, 0);
        }

        // Update player position
        player.update(Gdx.graphics.getDeltaTime());

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
