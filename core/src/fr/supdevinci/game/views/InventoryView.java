package fr.supdevinci.game.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import fr.supdevinci.game.ui.inventory.Inventory;

public class InventoryView implements Drawable {
    public final static int INVBGXPOS = 370;
    public final static int INVBGYPOS = 0;
    public final static int INVBGWIDTH = 270;
    public final static int INVBGHEIGHT = 320;
    public int invBoxXPos = 0;
    public int invBoxYPos = 0;
    public final static int INVBOXWIDTH = 65;
    public final static int INVBOXHEIGHT = 65;

    private Texture txInventoryBg, txInventoryBox;
    private TextureRegion inventoryBg, inventoryBox;
    private final Inventory inventory;

    public InventoryView(Inventory inventory) { this.inventory = inventory; }

    @Override
    public void create() {
        txInventoryBg = new Texture(".././assets/game-assets/gui/Setting menu.png");
        inventoryBg = new TextureRegion(txInventoryBg, txInventoryBg.getWidth()/2, 0, txInventoryBg.getWidth()/2, txInventoryBg.getHeight());

        txInventoryBox = new Texture(".././assets/game-assets/gui/buttons/Square Buttons 26x26.png");
        inventoryBox = new TextureRegion(txInventoryBox, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4, txInventoryBox.getWidth()/2, txInventoryBox.getHeight()/4);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(inventoryBg, INVBGXPOS, INVBGYPOS, INVBGWIDTH, INVBGHEIGHT);
        for(int i = 0; i < 4; i++) {
            batch.draw(inventoryBox, invBoxXPos, invBoxYPos, INVBOXWIDTH, INVBOXHEIGHT);
            for(int j = 0; j < 5; j++) {
                batch.draw(inventoryBox, invBoxXPos, invBoxYPos, INVBOXWIDTH, INVBOXHEIGHT);
                invBoxYPos -= 50;
            }
            invBoxYPos = 235;
            invBoxXPos += 50;
        }
    }

    @Override
    public void dispose() {
        txInventoryBg.dispose();
        txInventoryBox.dispose();
    }
}
