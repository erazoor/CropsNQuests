package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.supdevinci.game.player.Player;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private TextureRegion playerTexture;
    private Player player;


    @Override
    public void create () {
        batch = new SpriteBatch();
        player = new Player(new TextureRegion(new Texture("game-assets/characters/PremiumCharakterSpritesheet.png")));
        player.setPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        player.setSize(128f, 128f);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            player.moveUp();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            player.moveLeft();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            player.moveDown();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            player.moveRight();
        }

        player.update(Gdx.graphics.getDeltaTime()); // update the animation
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
