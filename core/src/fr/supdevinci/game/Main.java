package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.ScreenUtils;
import fr.supdevinci.game.map.GameBoard;
import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.views.Drawable;
import fr.supdevinci.game.player.views.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter {
	private final Player player;
	private GameBoard map;
	private final List<Drawable> drawables;
	private SpriteBatch batch;

	public Main() {
		this.map = new GameBoard();
		this.player = new Player(map);
		this.drawables = new ArrayList<>();
		this.drawables.add(new PlayerView(this.player));
	}


	@Override
	public void create () {
		map.create();

		this.drawables.forEach(Drawable::create);
		this.batch = new SpriteBatch();
	}

	@Override
	public void render () {
		if(player.isOnWater()) {
			player.reset();
		}
		if(player.isOutOfBound()){
			player.reset();
		}

		float delta = Gdx.graphics.getDeltaTime();

		ScreenUtils.clear(0, 20, 100, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		map.draw(batch); // TODO : Change it to a drawables list => change the map to a drawable
		drawables.forEach(drawable -> drawable.render(batch, delta));
		batch.end();
	}


	@Override
	public void dispose () {
		batch.dispose();
		drawables.forEach(Drawable::dispose);
	}
}



