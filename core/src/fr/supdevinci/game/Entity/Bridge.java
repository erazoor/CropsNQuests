package fr.supdevinci.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bridge extends Entity {
    private final static int TX_TILE_HEIGHT = 48;
    private final static int TX_TILE_WIDTH = 16;

    private final static int BRIDGE_HEIGHT = 48;
    private final static int BRIDGE_WIDTH = 16;

    public Bridge() {
        Texture tx = new Texture("game-assets/tilesets/BuildingParts/WoodBridgeV2.png");
        txRegions = TextureRegion.split(tx, TX_TILE_WIDTH, TX_TILE_HEIGHT);
        txRegion = txRegions[0][0];
        height = BRIDGE_HEIGHT;
        width = BRIDGE_WIDTH;
    }

    @Override
    public void makeMove() {

    }
}
