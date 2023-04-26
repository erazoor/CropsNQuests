package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter implements InputProcessor {

	// Graphical data
	private SpriteBatch batch;
	private Texture txInventoryBg, txInventoryBox, txSettingsBg, txSettingsBox, txResumeBox;
	private TextureRegion inventoryBg, inventoryBox, settingsBg, settingsBox;
	private TextureRegion[][] resumeBox;
	private boolean inventoryVisible = false;
	private boolean settingsVisible = true;
	private boolean resumeClicked = false;

	@Override
	public void create () {

		txInventoryBg = new Texture(".././assets/game-assets/gui/Setting menu.png");
		inventoryBg = new TextureRegion(txInventoryBg, txInventoryBg.getWidth()/2, 0, txInventoryBg.getWidth()/2, txInventoryBg.getHeight());

		txInventoryBox = new Texture(".././assets/game-assets/gui/buttons/Square Buttons 26x26.png");
		inventoryBox = new TextureRegion(txInventoryBox, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4);

		txSettingsBg = new Texture(".././assets/game-assets/gui/Setting menu.png");
		settingsBg = new TextureRegion(txSettingsBg, 0,0, txSettingsBg.getWidth()/2, txSettingsBg.getHeight());

		txResumeBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
		resumeBox = TextureRegion.split(txResumeBox, txResumeBox.getWidth()/2, txResumeBox.getHeight()/2);

		txSettingsBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
		settingsBox = new TextureRegion(txSettingsBox, 0,0, txSettingsBox.getWidth()/2, txSettingsBox.getHeight()/2);

		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.I || keycode == Input.Keys.E) {
			inventoryVisible = !inventoryVisible;
			return true;
		}
		if (keycode == Input.Keys.ESCAPE) {
			settingsVisible = !settingsVisible;
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	private boolean isResumeClicked(int screenX, int screenY) {
		int xPos = 235;
		int yPos = 168;
		int width = 178;
		int height = 50;

		return screenX >= xPos && screenX <= xPos + width && screenY >= yPos && screenY <= yPos + height;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(settingsVisible && isResumeClicked(screenX, screenY)) {
			resumeClicked = true;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(settingsVisible) {
			if(resumeClicked && isResumeClicked(screenX, screenY)) {
				resumeClicked = false;
				settingsVisible = false;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 120, 0.7f, 0);

		batch.begin();
		if(inventoryVisible) {
			int xPos = 380;
			int yPos = 235;
			int width = 65;
			int height = 65;
			batch.draw(inventoryBg, 355, 10, 270, 320);
			for(int i = 0; i < 4; i++) {
				batch.draw(inventoryBox, xPos, yPos, width, height);
				for(int j = 0; j < 5; j++) {
					batch.draw(inventoryBox, xPos, yPos, width, height);
					yPos -= 50;
				}
				yPos = 235;
				xPos += 50;
			}
		}

		if(settingsVisible) {
			int xPos = 228;
			int yPos = 255;
			batch.draw(settingsBg, (float) (txSettingsBg.getWidth() /1.35), (float) (txSettingsBg.getHeight() /1.5), 270, 320);
			batch.draw(resumeBox[1][resumeClicked ? 1:0], xPos, yPos, 192, 64);
			yPos -= 63;
			for(int i = 0; i < 2 ; i++) {
				batch.draw(settingsBox, xPos, yPos, txSettingsBox.getWidth(), txSettingsBox.getHeight());
				yPos -= 63;
			}
		}
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		txInventoryBg.dispose();
		txInventoryBox.dispose();
		txSettingsBg.dispose();
		txSettingsBox.dispose();
		txResumeBox.dispose();
	}
}