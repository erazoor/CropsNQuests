package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.views.Drawable;
import fr.supdevinci.game.player.views.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter {

    private final Player player;
    private final List<Drawable> drawables;
    private SpriteBatch batch;

    public Main() {
        this.player = new Player();
        this.drawables = new ArrayList<>();

        this.drawables.add(new PlayerView(this.player));
    }

    @Override
    public void create() {
        this.drawables.forEach(Drawable::create);
        this.batch = new SpriteBatch();
    }

    @Override
    public void render() {
        /*if(player.isOnBorder()) {
            player.reset();
        }*/

        float delta = Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        drawables.forEach(drawable -> drawable.render(batch, delta));
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        drawables.forEach(Drawable::dispose);
    }
}