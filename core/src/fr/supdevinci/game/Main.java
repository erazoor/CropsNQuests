package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import fr.supdevinci.game.npc.Npc;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	private Npc cow;

	@Override
	public void create () {
		batch = new SpriteBatch();
		cow = new Npc();
	}

	@Override
	public void render () {

		ScreenUtils.clear(1, 0, 0, 1);
		cow.update();
		batch.begin();
		cow.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
