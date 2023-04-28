package fr.supdevinci.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import fr.supdevinci.game.ui.settings.Settings;

public class SettingsView implements Drawable, InputProcessor {
    public final static int SETT_BG_X_POS = 228;
    public final static int SETT_BG_Y_POS = 255;
    public final static int SETT_BG_WIDTH = 270;
    public final static int SETT_BG_HEIGHT = 320;
    public final static String SETTINGS = "SETTINGS";
    public final static String QUIT = "QUIT";

    private BitmapFont font;
    private Texture txSettingsBg, txResumeBox, txSettingBox, txQuitBox;
    private TextureRegion settingsBg;
    private TextureRegion[][] resumeBox, settingBox, quitBox;
    private boolean settingsVisible = false;
    private boolean resumeClicked = false;
    private boolean settingsClicked = false;
    private boolean quitClicked = false;
    private boolean inventoryVisible = false;
    private final Settings settings;
    public SettingsView(Settings settings) { this.settings = settings; }

    @Override
    public void create() {
        txSettingsBg = new Texture(".././assets/game-assets/gui/Setting menu.png");
        settingsBg = new TextureRegion(txSettingsBg, 0,0, txSettingsBg.getWidth()/2, txSettingsBg.getHeight());

        txResumeBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
        resumeBox = TextureRegion.split(txResumeBox, txResumeBox.getWidth()/2, txResumeBox.getHeight()/2);

        txSettingBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
        settingBox = TextureRegion.split(txSettingBox, txSettingBox.getWidth()/2, txSettingBox.getHeight()/2);

        txQuitBox = new Texture(".././assets/game-assets/gui/UI Big Play Button.png");
        quitBox = TextureRegion.split(txQuitBox, txQuitBox.getWidth()/2, txQuitBox.getHeight()/2);

        this.font = new BitmapFont();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            settingsVisible = !settingsVisible;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) { return false; }

    @Override
    public boolean keyTyped(char character) { return false; }

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
    public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }

    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }

    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }

    @Override
    public void render(SpriteBatch batch) {
		if(settingsVisible) {
			inventoryVisible = false;

			batch.draw(settingsBg, (float) (txSettingsBg.getWidth() / 1.35), (float) (txSettingsBg.getHeight() / 1.5), 270, 320);
			batch.draw(resumeBox[1][resumeClicked ? 1:0], SETT_BG_X_POS, SETT_BG_Y_POS, 192, 64);
			batch.draw(settingBox[0][settingsClicked ? 1:0], SETT_BG_X_POS, SETT_BG_Y_POS - 63, 192, 64);
			font.draw(batch, SETTINGS, SETT_BG_X_POS + 60, SETT_BG_Y_POS -22);
			batch.draw(quitBox[0][quitClicked ? 1:0], SETT_BG_X_POS, SETT_BG_Y_POS - 126, 192, 64);
			font.draw(batch, QUIT, SETT_BG_X_POS + 75, SETT_BG_Y_POS - 85);
		}
    }

    @Override
    public void dispose() {
        txSettingsBg.dispose();
        txResumeBox.dispose();
        txSettingBox.dispose();
        txQuitBox.dispose();
    }
}