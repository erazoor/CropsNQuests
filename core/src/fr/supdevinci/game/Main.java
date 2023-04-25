package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.handler.InputHandler;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private TextureRegion playerTexture;
    private InputMultiplexer inputMultiplexer;
    private Player player;

    @Override
    public void create () {
        batch = new SpriteBatch();
        playerTexture = new TextureRegion(new Texture("game-assets/characters/PremiumCharakterSpritesheet.png"));
        player = new Player(playerTexture);
        player.setPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        player.setSize(128f, 128f);

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(new InputHandler(player));
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(Gdx.graphics.getDeltaTime()); // update the animation
        batch.begin();
        player.render(batch);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        player.dispose();
        playerTexture.getTexture().dispose();
        inputMultiplexer.clear();
        inputMultiplexer = null;
    }
}
