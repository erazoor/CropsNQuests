package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion spritesheet;
	TextureRegion[][] frames;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(".././assets/game-assets/gui/base free.png");
		int frameWidth = spritesheet.getRegionWidth() / 8;
		int frameHeight = spritesheet.getRegionHeight() / 24;
		frames = spritesheet.split(frameWidth, frameHeight);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0, 300,300);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}