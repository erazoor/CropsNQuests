package fr.supdevinci.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import fr.supdevinci.game.ui.inventory.Inventory;

public class InventoryView implements Drawable, InputProcessor{
    public final static int INV_BG_X_POS = 370;
    public final static int INV_BG_Y_POS = 0;
    public final static int INV_BG_WIDTH = 270;
    public final static int INV_BG_HEIGHT = 320;
    public final static int INV_BOX_X_POS = 50;
    public final static int INV_BOX_Y_POS = 50;
    public final static int INV_BOX_WIDTH = 65;
    public final static int INV_BOX_HEIGHT = 65;
    public final static float INV_BOX_OFFSET = 26.6f;

    private Texture txInventoryBg, txInventoryBox, txInventoryItems;
    private TextureRegion inventoryBg, inventoryBox;
    private TextureRegion[][] inventoryItems;
    private static boolean inventoryVisible = false;
    private final Inventory inventory;

    public InventoryView(Inventory inventory) { this.inventory = inventory; }

    @Override
    public void create() {
        txInventoryBg = new Texture(".././assets/game-assets/gui/Setting menu.png");
        inventoryBg = new TextureRegion(txInventoryBg, txInventoryBg.getWidth()/2, 0, txInventoryBg.getWidth()/2, txInventoryBg.getHeight());

        txInventoryBox = new Texture(".././assets/game-assets/gui/buttons/Square Buttons 26x26.png");
        inventoryBox = new TextureRegion(txInventoryBox, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4);

        txInventoryItems = new Texture(".././assets/game-assets/items/All items.png");
        inventoryItems = TextureRegion.split(txInventoryItems, txInventoryItems.getWidth()/8, txInventoryItems.getHeight()/15);

        Gdx.input.setInputProcessor(this);
    }

   @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown");
        if (keycode == Input.Keys.I) {
            inventoryVisible = !inventoryVisible;
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

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
    public void render(SpriteBatch batch) {
        if(inventoryVisible) {
            batch.draw(inventoryBg, INV_BG_X_POS, INV_BG_Y_POS, INV_BG_WIDTH, INV_BG_HEIGHT);
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 5; j++) {
                    batch.draw(inventoryBox, INV_BOX_X_POS * i + INV_BG_X_POS + INV_BOX_OFFSET, INV_BOX_Y_POS * j + INV_BG_Y_POS + INV_BOX_OFFSET, INV_BOX_WIDTH, INV_BOX_HEIGHT);
                }
            }
            batch.draw(inventoryItems[0][2], INV_BOX_X_POS-33 + INV_BG_X_POS + INV_BOX_OFFSET, INV_BOX_Y_POS+168 + INV_BG_Y_POS + INV_BOX_OFFSET, INV_BOX_WIDTH-35, INV_BOX_HEIGHT-35);
            batch.draw(inventoryItems[0][3], INV_BOX_X_POS+17 + INV_BG_X_POS + INV_BOX_OFFSET, INV_BOX_Y_POS+168 + INV_BG_Y_POS + INV_BOX_OFFSET, INV_BOX_WIDTH-35, INV_BOX_HEIGHT-35);
            batch.draw(inventoryItems[1][2], INV_BOX_X_POS+68 + INV_BG_X_POS + INV_BOX_OFFSET, INV_BOX_Y_POS+170 + INV_BG_Y_POS + INV_BOX_OFFSET, INV_BOX_WIDTH-35, INV_BOX_HEIGHT-35);
        }
    }

    @Override
    public void dispose() {
        txInventoryBg.dispose();
        txInventoryBox.dispose();
    }
}