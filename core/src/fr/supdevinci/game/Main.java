package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import fr.supdevinci.game.ui.inventory.Inventory;
import fr.supdevinci.game.views.Drawable;
import fr.supdevinci.game.views.InventoryView;

import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter implements InputProcessor {

	// Graphical data
	private SpriteBatch batch;
	private BitmapFont font;
	private final Inventory inventory;
	private final List<Drawable> drawables;
	private Texture txInventoryBg, txInventoryBox, txSettingsBg, txResumeBox, txSettingBox, txQuitBox;
	private TextureRegion inventoryBg, inventoryBox, settingsBg;
	private TextureRegion[][] resumeBox, settingBox, quitBox;
	private boolean inventoryVisible = false;
	private boolean settingsVisible = false;
	private boolean resumeClicked = false;
	private boolean settingsClicked = false;
	private boolean quitClicked = false;

	public Main() {
		this.inventory = new Inventory();
		this.drawables = new ArrayList<>();
		this.drawables.add(new InventoryView(this.inventory));
	}

	@Override
	public void create () {
		this.drawables.forEach(Drawable::create);
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		Gdx.input.setInputProcessor(this);
	}

//		txInventoryBg = new Texture(".././assets/game-assets/gui/Setting menu.png");
//		inventoryBg = new TextureRegion(txInventoryBg, txInventoryBg.getWidth()/2, 0, txInventoryBg.getWidth()/2, txInventoryBg.getHeight());
//
//		txInventoryBox = new Texture(".././assets/game-assets/gui/buttons/Square Buttons 26x26.png");
//		inventoryBox = new TextureRegion(txInventoryBox, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4);
//
//		txSettingsBg = new Texture(".././assets/game-assets/gui/Setting menu.png");
//		settingsBg = new TextureRegion(txSettingsBg, 0,0, txSettingsBg.getWidth()/2, txSettingsBg.getHeight());
//
//		txResumeBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
//		resumeBox = TextureRegion.split(txResumeBox, txResumeBox.getWidth()/2, txResumeBox.getHeight()/2);
//
//		txSettingBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
//		settingBox = TextureRegion.split(txSettingBox, txSettingBox.getWidth()/2, txSettingBox.getHeight()/2);
//
//		txQuitBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
//		quitBox = TextureRegion.split(txQuitBox, txQuitBox.getWidth()/2, txQuitBox.getHeight()/2);
//
//		font = new BitmapFont();
//		batch = new SpriteBatch();
//		Gdx.input.setInputProcessor(this);
//	}

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

	private boolean isSettingsClicked(int screenX, int screenY) {
		int xPos = 235;
		int yPos = 230;
		int width = 178;
		int height = 50;

		return screenX >= xPos && screenX <= xPos + width && screenY >= yPos && screenY <= yPos + height;
	}

	private boolean isQuitClicked(int screenX, int screenY) {
		int xPos = 235;
		int yPos = 292;
		int width = 178;
		int height = 50;

		return screenX >= xPos && screenX <= xPos + width && screenY >= yPos && screenY <= yPos + height;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(settingsVisible && isResumeClicked(screenX, screenY)) {
			resumeClicked = true;
		}
		if(settingsVisible && isSettingsClicked(screenX, screenY)) {
			settingsClicked = true;
		}
		if(settingsVisible && isQuitClicked(screenX, screenY)) {
			quitClicked = true;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(settingsVisible && isResumeClicked(screenX, screenY)) {
			resumeClicked = false;
			settingsVisible = false;
		}
		if(settingsVisible && isSettingsClicked(screenX, screenY)) {
			settingsClicked = false;
			settingsVisible = false;
		}
		if(settingsVisible && isQuitClicked(screenX, screenY)) {
			quitClicked = false;
			settingsVisible = false;
			Gdx.app.exit();
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

		this.batch.begin();
		this.drawables.forEach(d -> d.render(batch));
		this.batch.end();
//		if(inventoryVisible) {
//			int xPos = 380;
//			int yPos = 235;
//			int width = 65;
//			int height = 65;
//			batch.draw(inventoryBg, 355, 10, 270, 320);
//			for(int i = 0; i < 4; i++) {
//				batch.draw(inventoryBox, xPos, yPos, width, height);
//				for(int j = 0; j < 5; j++) {
//					batch.draw(inventoryBox, xPos, yPos, width, height);
//					yPos -= 50;
//				}
//				yPos = 235;
//				xPos += 50;
//			}
//		}
//
//		if(settingsVisible) {
//			inventoryVisible = false;
//			int xPos = 228;
//			int yPos = 255;
//			String settingsText0 = "SETTINGS";
//			String settingsText1 = "QUIT";
//
//			batch.draw(settingsBg, (float) (txSettingsBg.getWidth() / 1.35), (float) (txSettingsBg.getHeight() / 1.5), 270, 320);
//			batch.draw(resumeBox[1][resumeClicked ? 1:0], xPos, yPos, 192, 64);
//			batch.draw(settingBox[0][settingsClicked ? 1:0], xPos, yPos - 63, 192, 64);
//			font.draw(batch, settingsText0, xPos + 60, yPos -22);
//			batch.draw(quitBox[0][quitClicked ? 1:0], xPos, yPos - 126, 192, 64);
//			font.draw(batch, settingsText1, xPos + 75, yPos - 85);
//		}
//		batch.end();
	}

	@Override
	public void dispose () {
		this.batch.dispose();
		this.drawables.forEach(Drawable::dispose);
//		txInventoryBg.dispose();
//		txInventoryBox.dispose();
//		txSettingsBg.dispose();
//		txResumeBox.dispose();
	}
}