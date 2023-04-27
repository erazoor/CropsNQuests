package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.ScreenUtils;
import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.views.Drawable;
import fr.supdevinci.game.player.views.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter {
	private final Player player;
  	private final List<Drawable> drawables;
  	private SpriteBatch batch;

  	//SpriteBatch batch;
	  Texture img;
	  GameBoard gameBoard;
	  private Texture txGround;

	  public Main() {
		  this.player = new Player();
		  this.drawables = new ArrayList<>();
		  this.drawables.add(new PlayerView(this.player));
	  }


	  @Override
	  public void create () {
		  txGround = new Texture("game-assets/tilesets/GroundTiles/NewTiles/DarkerGrassHillTiles.png");
		  gameBoard = new GameBoard();
		  gameBoard.create();

		  this.drawables.forEach(Drawable::create);
		  this.batch = new SpriteBatch();
	  }

	  @Override
	  public void render () {
		  /*if(player.isOnBorder()) {
				player.reset();
			}*/
		  float delta = Gdx.graphics.getDeltaTime();

		  ScreenUtils.clear(0, 20, 100, 1);
		  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		  batch.begin();
		  gameBoard.draw(batch); // TODO : Change it to a drawables list
		  drawables.forEach(drawable -> drawable.render(batch, delta));
		  batch.end();
	  }


	  @Override
	  public void dispose () {
		  batch.dispose();
		  drawables.forEach(Drawable::dispose);
	  }
}



